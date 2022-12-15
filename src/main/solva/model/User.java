package model;

/**
 * Данные о юзере мы получаем из другого микросервиса.
 * Мы сохраняем в этом классе лимиты по 2 категориям
 */
public class User{
    private Integer id;
    private String name;

    private Limit productLimit;

    private Limit serviceLimit;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
