package app.transaction.repository;

import app.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findAllByOwnerIdOrderByCreatedOnDesc(UUID ownerId);

    List<Transaction> findAllBySenderOrReceiverOrderByCreatedOnDesc(String sender, String receiver);
}
