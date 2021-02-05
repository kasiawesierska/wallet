package pl.project.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;
        import pl.project.wallet.model.Transaction;
        import pl.project.wallet.model.User;

        import java.util.List;
        import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository <User, Long>  {  //z cmd pokazuje implementacje

} //zwracany typ i typ id
