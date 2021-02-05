package pl.project.wallet.service;

import org.springframework.stereotype.Service;
import pl.project.wallet.exception.UserException;
import pl.project.wallet.model.Transaction;
import pl.project.wallet.model.User;
import pl.project.wallet.repository.TransactionRepository;
import pl.project.wallet.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;

    public UserService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository=transactionRepository;
    }

    public List<User> findAll() throws UserException {
        if (userRepository.findAll().isEmpty()) {
            throw new UserException("Brak użytkowników ");
        }
        return userRepository.findAll();
    }

    public Optional<User> findByID(Long Id) {
        if (Id == 10L) {
            throw new RuntimeException();
        } else {
            return userRepository.findById(Id);
        }
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    public User update(User user) {
        Optional<User> byId = userRepository.findById(user.getId());
        if (byId.isEmpty()) {
            throw new RuntimeException();
        } else {
            return userRepository.save(user);
        }
    }

    public void deleteById(Long Id) {
        userRepository.deleteById(Id);
    }

    public User addTransaction(Long userId, Long transactionId) {
            User byId = findByID(userId).get();
            Transaction transaction = transactionRepository.findById(transactionId).get();
            byId.addTransaction(transaction);
            transaction.setUser(userId);
            return update(byId);
        }


    public User startBalance(User user) {
        if (user.getBalance() == 0.0)
            user.setBalance(5000.00);
        return user;
    }
}
/*
    public User checkNumber (User user) {
        if (user.getPhone()); {
            System.out.println("Musisz zaktualizowac numer telefonu"); }
    }


     public class checkDate (AdultUser adultUser) {
     if (adultUser.getBirthDate()

     SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        do {
            System.out.print("Podaj datę urodzenia  RRRR.MM.DD: ");
            try {
                adultUser.setBirthDate(sdf.parse(getUserInput()));
            } catch (ParseException pe) {
                System.out.println("Błedny format daty! Przykladowa data: 1991.01.05");
            }

     */


