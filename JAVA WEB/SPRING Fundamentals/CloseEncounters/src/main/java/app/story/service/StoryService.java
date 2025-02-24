package app.story.service;

import app.story.model.Story;
import app.story.repository.StoryRepository;
import app.user.model.User;
import app.web.dto.CreateNewStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void create(CreateNewStory createNewStory, User user) {

        Story story = Story.builder()
                .title(createNewStory.getTitle())
                .description(createNewStory.getDescription())
                .kind(createNewStory.getKind())
                .date(createNewStory.getDate())
                .addedOn(LocalDate.now())
                .addedBy(user)
                .isVisible(false)
                .build();

        storyRepository.save(story);
    }

    public List<Story> getAll() {

        return storyRepository.findAll();
    }

    public void deleteStoryById(UUID id) {

        storyRepository.deleteById(id);
    }

    public Story getById(UUID id) {

        return storyRepository.findById(id).orElseThrow(() -> new RuntimeException("Story with id [%s] does not exist.".formatted(id)));
    }
    public void share(UUID id, User user) {

        Story story = getById(id);

        story.setVisible(true);

        storyRepository.save(story);
    }
}
