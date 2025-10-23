package main.service;

import main.exception.InsufficientSpellsException;
import main.exception.SpellAlreadyLearnedException;
import main.model.Spell;
import main.model.SpellAlignment;
import main.model.SpellCategory;
import main.model.Wizard;
import main.model.WizardAlignment;
import main.property.SpellsProperties;
import main.repository.SpellRepository;
import main.repository.WizardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class SpellService {

    private final SpellRepository spellRepository;
    private final WizardRepository wizardRepository;
    private final SpellsProperties spellsProperties;
    private final Random random;

    public SpellService(SpellRepository spellRepository,
                       WizardRepository wizardRepository,
                       SpellsProperties spellsProperties) {
        this.spellRepository = spellRepository;
        this.wizardRepository = wizardRepository;
        this.spellsProperties = spellsProperties;
        this.random = new Random();
    }

    @Transactional
    public void learnRandomStarterSpell(Wizard wizard) {
        List<SpellsProperties.SpellData> starterSpells = spellsProperties.getSpells().stream()
                .filter(spell -> spell.getMinLearned() == 0)
                .toList();

        if (starterSpells.isEmpty()) {
            throw new RuntimeException("No starter spells available");
        }

        SpellsProperties.SpellData randomSpell = starterSpells.get(random.nextInt(starterSpells.size()));
        createSpellForWizard(wizard, randomSpell);
    }

    @Transactional
    public Spell learnSpell(Wizard wizard, String spellCode) {

        if (spellRepository.existsByWizardAndCode(wizard, spellCode)) {
            throw new SpellAlreadyLearnedException("Spell already learned: " + spellCode);
        }

        SpellsProperties.SpellData spellData = spellsProperties.getSpells().stream()
                .filter(spell -> spell.getCode().equals(spellCode))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Spell not found: " + spellCode));

        int currentLearnedCount = wizard.getSpells().size();
        if (currentLearnedCount < spellData.getMinLearned()) {
            throw new InsufficientSpellsException(
                "You must learn " + spellData.getMinLearned() + " spells before learning " + spellData.getName()
            );
        }


        Spell spell = createSpellForWizard(wizard, spellData);

        if (wizard.getAlignment() == WizardAlignment.LIGHT && 
            spell.getAlignment() == SpellAlignment.DARK) {
            wizard.setAlignment(WizardAlignment.DARK);
            wizard.setUpdatedOn(LocalDateTime.now());
            wizardRepository.save(wizard);
        }

        return spell;
    }

    private Spell createSpellForWizard(Wizard wizard, SpellsProperties.SpellData spellData) {
        Spell spell = Spell.builder()
                .code(spellData.getCode())
                .name(spellData.getName())
                .description(spellData.getDescription())
                .wizard(wizard)
                .category(SpellCategory.valueOf(spellData.getCategory()))
                .alignment(SpellAlignment.valueOf(spellData.getAlignment()))
                .image(spellData.getImage())
                .power(spellData.getPower())
                .createdOn(LocalDateTime.now())
                .build();

        return spellRepository.save(spell);
    }

    public List<Spell> getLearnedSpells(Wizard wizard) {
        return spellRepository.findAllByWizardOrderByPowerDesc(wizard);
    }

    public List<SpellsProperties.SpellData> getAvailableSpells(Wizard wizard) {
        List<String> learnedSpellCodes = wizard.getSpells().stream()
                .map(Spell::getCode)
                .toList();

        return spellsProperties.getSpells().stream()
                .filter(spell -> !learnedSpellCodes.contains(spell.getCode()))
                .toList();
    }
}



