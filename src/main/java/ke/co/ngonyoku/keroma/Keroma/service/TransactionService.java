package ke.co.ngonyoku.keroma.Keroma.service;

import jakarta.persistence.EntityNotFoundException;
import ke.co.ngonyoku.keroma.Keroma.model.Transaction;
import ke.co.ngonyoku.keroma.Keroma.model.User;
import ke.co.ngonyoku.keroma.Keroma.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()) {
            throw new EntityNotFoundException("Transaction not found with id " + id);
        }
        return transaction.get();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction, Long userId) {
        User user = userService.getUserById(userId);

        // Validate the input data
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException("Invalid transaction input", violations);
        }

        transaction.setUser(user);
        transaction.setTimestamp(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent()) {
            throw new EntityNotFoundException("Transaction not found with id " + id);
        }
        Transaction existingTransaction = optionalTransaction.get();
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setUser(transaction.getUser());
        existingTransaction.setTimestamp(transaction.getTimestamp());
        return transactionRepository.save(existingTransaction);
    }

    public void deleteTransaction(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (!transaction.isPresent()) {
            throw new EntityNotFoundException("Transaction not found with id " + id);
        }
        transactionRepository.deleteById(id);
    }
}

