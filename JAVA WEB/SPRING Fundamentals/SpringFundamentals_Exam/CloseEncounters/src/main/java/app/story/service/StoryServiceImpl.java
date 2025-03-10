package app.story.service;

import app.story.model.Story;
import app.story.repository.StoryRepository;
import app.user.model.User;
import app.web.dto.StoryAddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public void addStory(StoryAddDTO storyAddDTO, User user) {
        Story story = new Story();
        story.setTitle(storyAddDTO.getTitle());
        story.setDescription(storyAddDTO.getDescription());
        story.setKind(storyAddDTO.getKind());
        story.setDate(storyAddDTO.getDate());
        story.setAddedOn(LocalDate.now());
        story.setAddedBy(user);
        story.setVisible(false);

        storyRepository.save(story);
    }

    @Override
    public List<Story> getAllStoriesByUser(User user) {
        return storyRepository.findAllByAddedBy(user);
    }

    @Override
    public List<Story> getAllVisibleStories() {
        return storyRepository.findAllByIsVisibleTrue();
    }

    @Override
    public Story findById(UUID id) {
        return storyRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStory(UUID id) {
        storyRepository.deleteById(id);
    }

    @Override
    public void toggleVisibility(UUID id) {
        Optional<Story> storyOptional = storyRepository.findById(id);

        if (storyOptional.isPresent()) {
            Story story = storyOptional.get();
            story.setVisible(true);
            storyRepository.save(story);
        }
    }
} 