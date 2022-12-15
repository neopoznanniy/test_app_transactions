package repository;

import model.Limit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Место для хранения лимитов по транзакциям, связанным с услугами. (Создаем в БД 2 таблицы для разных групп лимитов)
 * Связываем таблицу транзакций и лимитов внешним ключом userId.
 * В мапе в качестве ключа используем userId
 */
public class InMemoryServiceLimitsRepository {
    Map<Integer, Limit> repository;

    public InMemoryServiceLimitsRepository() {
        this.repository = new ConcurrentHashMap<>();
    }
}
