package pl.project.wallet.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id //oznacza klucz glowny
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generowanie id
    private Long Id;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
    private double balance;

    @OneToMany
    private List<Transaction> transactions;

    public User (Long Id, String name, String surname, Date birthDate, String email, Double balance) {
        this.Id=Id;
        this.name=name;
        this.surname=surname;
        this.birthDate = birthDate;
        this.email = email;
        this.balance = balance;

    }
    public User ( String name, String surname, Date birthDate, String email, Double balance) {
        this.name=name;
        this.surname=surname;
        this.birthDate = birthDate;
        this.email = email;
        this.balance = balance;
    }

    public User() { }

    public Long getId() { return Id; }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransations() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

}

