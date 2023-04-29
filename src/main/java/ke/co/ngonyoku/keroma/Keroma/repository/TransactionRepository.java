package ke.co.ngonyoku.keroma.Keroma.repository;

import ke.co.ngonyoku.keroma.Keroma.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
