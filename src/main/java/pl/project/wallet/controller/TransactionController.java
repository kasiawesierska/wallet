package pl.project.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.wallet.model.Transaction;
import pl.project.wallet.service.TransactionService;
import pl.project.wallet.exception.UserException;
import pl.project.wallet.exception.TransactionException;
import pl.project.wallet.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;

    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Kontroluj wydatki!");
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long Id) throws TransactionException {
        Optional<Transaction> byId = transactionService.findById(Id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) throws TransactionException{
        return ResponseEntity.ok(transactionService.save(transaction));
    }
    @PutMapping
    public ResponseEntity<Transaction> update(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.update(transaction));
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<List<Transaction>> findByName(@PathVariable String name){
        Optional<List<Transaction>> transactions  = transactionService.findByName(name);
        if(transactions.isPresent()) {
            return ResponseEntity.ok(transactions.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long Id) throws TransactionException{
        transactionService.deleteById(Id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<List<Transaction>> deleteAll() throws TransactionException {
        transactionService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("findbybalance/{amount}")
    public ResponseEntity<List<Transaction>> findByAmount (@PathVariable String amount) throws TransactionException{
        Optional<List<Transaction>> transactions = transactionService.findByAmount(amount);
        if(transactions.isPresent()) {
            return ResponseEntity.ok(transactions.get());
        }
        else {
            throw new TransactionException ("Nie znaleziono");
        }
    }
}
