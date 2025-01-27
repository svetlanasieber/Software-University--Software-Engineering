package app.subscription.repository;

import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionStatus;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {

    Optional<Subscription> findByStatusAndOwnerId(SubscriptionStatus status, UUID ownerId);

    List<Subscription> findByOwnerIdOrderByCreatedOnDesc(UUID ownerId);

    List<Subscription> findAllByStatusAndCompletedOnBefore(SubscriptionStatus status, LocalDateTime completedOn);
}
