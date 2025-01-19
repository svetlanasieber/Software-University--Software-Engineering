package app.transaction.service;

import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.transaction.repository.TransactionRepository;
import app.user.model.User;
import app.wallet.model.Wallet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {

        this.repository = repository;
    }

    public Transaction createNewTransaction(User owner, String from, String to, BigDecimal amount,
            BigDecimal balanceLeft, Currency currency, TransactionStatus transactionStatus,
            TransactionType transactionType, String description, String failureReason) {

        Transaction transaction = Transaction.builder()
                .id(UUID.randomUUID())
                .owner(owner)
                .sender(from)
                .receiver(to)
                .amount(amount)
                .type(transactionType)
                .balanceLeft(balanceLeft)
                .currency(currency)
                .status(transactionStatus)
                .description(description)
                .failureReason(failureReason)
                .createdOn(LocalDateTime.now())
                .build();

        return repository.save(transaction);
    }

    public List<Transaction> getLastFourTransactions(Wallet wallet) {

        return repository.findAllBySenderOrReceiverOrderByCreatedOnDesc(wallet.getId().toString(), wallet.getId().toString())
                .stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCEEDED)
                .filter(t -> t.getOwner().getId().equals(wallet.getOwner().getId()))
                .limit(4)
                .toList();
    }

    public List<Transaction> getAllTransactionsByOwnerId(UUID userId) {

        return repository.findAllByOwnerIdOrderByCreatedOnDesc(userId);
    }

    public List<Transaction> getAllTransactions() {

        return repository.findAll();
    }
}
