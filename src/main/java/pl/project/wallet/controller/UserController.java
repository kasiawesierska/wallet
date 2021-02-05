package pl.project.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.wallet.exception.UserException;
import pl.project.wallet.model.User;
import pl.project.wallet.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/user")
public class UserController {

    private UserService userService; // wstrzykiwanie zaleznosci

    public UserController(UserService userService) { // wstrzykiwanie zaleznosci
        this.userService = userService;
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Witaj w Wallet");
    }

    @GetMapping
    public ResponseEntity<List<User>>findAll() throws UserException {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long Id) {
        Optional<User> optionalUser = userService.findByID((Id));
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long Id) {
        userService.deleteById(Id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/addtransaction/{userId}/{transactionId}")
    public ResponseEntity<User> addTransaction(@PathVariable Long userId, @PathVariable Long transactionId){
        return ResponseEntity.ok(userService.addTransaction(userId,transactionId));
    }
    /*

    @GetMapping("/balance")
    public ResponseEntity<User> startBalance (@PathVariable Double balance) {
        Optional<User> user =userService.startBalance(user);

    } */
}

