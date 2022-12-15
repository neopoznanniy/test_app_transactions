package repository;

import model.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 Класс InMemoryTransactionsRepository в этом макете представляет собой обращение к БД,
 в которой хранятся все транзкции.
 */
public class InMemoryTransactionsRepository {
    Map<Integer, Transaction> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public Transaction save(Transaction transaction, Integer userId){
        if(transaction.isNew()){
            transaction.setId(counter.incrementAndGet());
            repository.put(transaction.getId(), transaction);
            return transaction;
        }
        return repository.computeIfPresent(transaction.getId(), (id, oldTransaction) -> transaction);
    }

    public Transaction get(int id, int userId){
        return repository.get(id);
    }

    public Collection<Transaction> getAll(Integer userId){
        return repository.values().stream()
                .filter(transaction -> transaction.getUserId().equals(userId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Collection<Transaction> getWithExceeded(Integer userId){
        return repository.values().stream()
                .filter(Transaction::isLimit_exceeded)
                .collect(Collectors.toList());
    }
}
