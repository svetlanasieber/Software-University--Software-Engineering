package app.wallet.repository;

import app.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    List<Wallet> findAllByOwnerId(UUID ownerId);

    List<Wallet> findAllByOwnerUsername(String username);
}
