package repository;

import model.Transaction;

import java.util.Collection;

public interface TransactionRepository {
    Transaction save(Transaction transaction, Integer userId);

//    boolean delete(int id, int userId);

    Transaction get(int id, int userId);

    Collection<Transaction> getAll(Integer userId);

    Collection<Transaction> getWithExceeded(Integer userId);
}
