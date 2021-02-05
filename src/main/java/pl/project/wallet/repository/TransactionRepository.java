package pl.project.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.project.wallet.model.Transaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long > {

    @Query("SELECT p from Transaction p where p.name = : name")
    Optional<List<Transaction>> getTransactionByName(String name);

    Optional<List<Transaction>> findByAmount(String amount);

}
