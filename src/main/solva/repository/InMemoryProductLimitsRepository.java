package repository;

import model.Limit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Место для хранения лимитов по продуктовым транзакциям. (Создаем в БД 2 таблицы для разных групп лимитов)
 * Связываем таблицу транзакций и лимитов внешним ключом userId.
 * В мапе в качестве ключа используем userId
 */
public class InMemoryProductLimitsRepository {
    Map<Integer, Limit> repository;

    public InMemoryProductLimitsRepository() {
        this.repository = new ConcurrentHashMap<>();
    }
}
