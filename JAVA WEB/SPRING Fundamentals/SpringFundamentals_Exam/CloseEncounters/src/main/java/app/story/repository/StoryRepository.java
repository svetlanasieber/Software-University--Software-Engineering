package app.story.repository;

import app.story.model.Story;
import app.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {
    List<Story> findAllByAddedBy(User user);
    List<Story> findAllByIsVisibleTrue();
} 