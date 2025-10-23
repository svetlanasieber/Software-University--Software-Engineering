package main.service;

import main.exception.DuplicateUsernameException;
import main.exception.InvalidCredentialsException;
import main.model.House;
import main.model.Wizard;
import main.model.WizardAlignment;
import main.repository.WizardRepository;
import main.web.dto.EditProfileDto;
import main.web.dto.LoginDto;
import main.web.dto.RegisterDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WizardService {

    private final WizardRepository wizardRepository;
    private final PasswordEncoder passwordEncoder;
    private final SpellService spellService;

    public WizardService(WizardRepository wizardRepository, 
                        PasswordEncoder passwordEncoder,
                        SpellService spellService) {
        this.wizardRepository = wizardRepository;
        this.passwordEncoder = passwordEncoder;
        this.spellService = spellService;
    }

    @Transactional
    public Wizard register(RegisterDto registerDto) {
        if (wizardRepository.existsByUsername(registerDto.getUsername())) {
            throw new DuplicateUsernameException("Username already exists: " + registerDto.getUsername());
        }

        Wizard wizard = Wizard.builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .avatarUrl(registerDto.getAvatarUrl())
                .alignment(registerDto.getAlignment())
                .house(registerDto.getHouse())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        wizard = wizardRepository.save(wizard);


        spellService.learnRandomStarterSpell(wizard);

        return wizard;
    }

    public Wizard login(LoginDto loginDto) {
        Wizard wizard = wizardRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if (!passwordEncoder.matches(loginDto.getPassword(), wizard.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return wizard;
    }

    public Wizard findById(UUID id) {
        return wizardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wizard not found with id: " + id));
    }

    @Transactional
    public Wizard updateProfile(UUID wizardId, EditProfileDto editProfileDto) {
        Wizard wizard = findById(wizardId);


        if (!wizard.getUsername().equals(editProfileDto.getUsername()) &&
            wizardRepository.existsByUsername(editProfileDto.getUsername())) {
            throw new DuplicateUsernameException("Username already exists: " + editProfileDto.getUsername());
        }

        wizard.setUsername(editProfileDto.getUsername());
        wizard.setAvatarUrl(editProfileDto.getAvatarUrl());
        wizard.setUpdatedOn(LocalDateTime.now());

        return wizardRepository.save(wizard);
    }

    @Transactional
    public Wizard changeAlignmentToDark(UUID wizardId) {
        Wizard wizard = findById(wizardId);
        wizard.setAlignment(WizardAlignment.DARK);
        wizard.setUpdatedOn(LocalDateTime.now());
        return wizardRepository.save(wizard);
    }

    public List<Wizard> findAllByHouse(House house) {
        return wizardRepository.findAllByHouse(house);
    }

    public int getTotalPower(Wizard wizard) {
        return wizard.getSpells().stream()
                .mapToInt(main.model.Spell::getPower)
                .sum();
    }
}



