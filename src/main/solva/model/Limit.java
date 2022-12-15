package model;

import java.time.LocalDateTime;

/**
 * Объект Limit хранит в себе дату создания, установленный лимит и остаток месячного лимита.
 * remainingMonthlyLimit считаем путем отнимания от limitSum суммы всех транзакций за месяц.
 * Если переменная limitSum не установленна, она будет равна null, используем это при определении
 * флага limit_exceeded в классе Transaction
 */
public class Limit extends AbstractBaseEntity{
    private final LocalDateTime limit_datetime;

    private Integer limitSum;

    private final String limit_currency_shortname;

    private Integer remainingMonthlyLimit;

    protected Limit(Integer id, String limit_currency_shortname) {
        super(id);
        this.limit_datetime = LocalDateTime.now();
        this.limit_currency_shortname = limit_currency_shortname;
    }

    public LocalDateTime getLimit_datetime() {
        return limit_datetime;
    }

    public Integer getLimitSum() {
        return limitSum;
    }

    public Integer getRemainingMonthlyLimit() {
        return remainingMonthlyLimit;
    }

    public void setLimitSum(Integer limitSum) {
        this.limitSum = limitSum;
    }

    public String getLimit_currency_shortname() {
        return limit_currency_shortname;
    }
}
