package pl.project.wallet.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import pl.project.wallet.exception.TransactionException;
import pl.project.wallet.model.Transaction;
import pl.project.wallet.model.User;
import pl.project.wallet.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private  TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long Id) throws TransactionException {
        if (Id == 10L) {
            throw new TransactionException("Nie ma transakcji o takim ID");
        } else {
            return transactionRepository.findById(Id);
        }
    }


    public Transaction save(Transaction transaction) throws TransactionException {
        if (transactionRepository.findByAmount(transaction.getAmount()).isEmpty()) {
            throw new TransactionException("Nie możesz dodac transakcji bez kwoty");
        } else {
            return transactionRepository.save(transaction);
        }
    }
    public Transaction update(Transaction transaction) {
        Optional<Transaction> byId = transactionRepository.findById(transaction.getId());
        if (byId.isEmpty()) {
            throw new RuntimeException();
        } else {
            return transactionRepository.save(transaction);
        }
    }
    public Optional<List<Transaction>> findByName (String name) {
            return transactionRepository.getTransactionByName(name);
    }
    public void deleteById(Long id) throws TransactionException{
        if (transactionRepository.findById(id).get().getUser() != null) {
            throw new TransactionException("Nie ma transakcji o takiej nazwie");
        }
        transactionRepository.deleteById(id);
    }

    public void deleteAll() throws TransactionException {
        if (transactionRepository.findAll().isEmpty()) {
            throw new TransactionException("Brak transakcji");
        } else {
            transactionRepository.deleteAll();
        }
    }

    public Optional<List<Transaction>> findByAmount (String amount) throws TransactionException {
        if (transactionRepository.findByAmount(amount).isPresent()) {
            return transactionRepository.findByAmount(amount);
        } else {
            throw new TransactionException("Nie było takiej kwoty");
        }
    }
}
