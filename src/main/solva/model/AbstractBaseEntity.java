package model;

/**
 * Наследуем от этого абстрактоного класса все сущности, которые имеют id. Чтобы уменьшить количество
 * повторяющегося кода.
 */
public class AbstractBaseEntity {
    protected Integer id;

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    protected AbstractBaseEntity(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
}
