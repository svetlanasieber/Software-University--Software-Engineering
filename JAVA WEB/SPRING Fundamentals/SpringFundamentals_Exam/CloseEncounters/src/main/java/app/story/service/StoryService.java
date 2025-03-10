package app.story.service;

import app.story.model.Story;
import app.user.model.User;
import app.web.dto.StoryAddDTO;

import java.util.List;
import java.util.UUID;

public interface StoryService {
    void addStory(StoryAddDTO storyAddDTO, User user);
    List<Story> getAllStoriesByUser(User user);
    List<Story> getAllVisibleStories();
    Story findById(UUID id);
    void deleteStory(UUID id);
    void toggleVisibility(UUID id);
} 