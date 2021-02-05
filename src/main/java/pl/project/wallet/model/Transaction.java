package pl.project.wallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String describe;
    private String amount;
    private LocalDate dateOfTransaction;
    private Long user;


    public Transaction() {
    }

    public Transaction(Long Id, String name, String describe, String amount,LocalDate dateOfTransaction, Long user ) {
        this.Id=Id;
        this.name = name;
        this.describe = describe;
        this.amount = amount;
        this. dateOfTransaction= dateOfTransaction;
        this.user=user;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public String getAmount() {
        return amount;
    }

    public LocalDate getDateOfTransaction() {  return dateOfTransaction; }

    public Long getUser() { return user; }

    public void setId(Long Id) { this.Id = Id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDateOfTransaction(LocalDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction; }

    public void setUser(Long user) { this.user = user; }

    @Override
    public String toString() {
        return "Transaction{" +
                "Id='" + Id + '\'' +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", amount='" + amount + '\'' +
                ", date='" + dateOfTransaction + '\'' +
                '}';
    }
}
