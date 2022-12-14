package model;

import java.time.LocalDateTime;

public class Transaction extends AbstractBaseEntity{

    private Integer id;

    private final Integer userId;

    private final Integer account_from;

    private final Integer account_to;

    private final String currency_shortname;

    private final Double sum;

    private final String expense_category;

    private final LocalDateTime datetime;

    private boolean limit_exceeded;

    //    public Transaction(Integer userId, Integer account_from, Integer account_to, String currency_shortname, Double sum, String expense_category, LocalDateTime datetime){
//        this(null, userId, account_from, account_to, currency_shortname, sum, expense_category, datetime);
//    }
    public Transaction(Integer userId, Integer account_from, Integer account_to, String currency_shortname, Double sum, String expense_category, LocalDateTime datetime) {
//        super(id);
        this.userId = userId;
        this.account_from = account_from;
        this.account_to = account_to;
        this.currency_shortname = currency_shortname;
        this.sum = sum;
        this.expense_category = expense_category;
        this.datetime = datetime;
    }

    public Integer getAccount_from() {
        return account_from;
    }

    public Integer getAccount_to() {
        return account_to;
    }

    public String getCurrency_shortname() {
        return currency_shortname;
    }

    public Double getSum() {
        return sum;
    }

    public String getExpense_category() {
        return expense_category;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public boolean isLimit_exceeded() {
        return limit_exceeded;
    }

    public void setLimit_exceeded(boolean limit_exceeded) {
        this.limit_exceeded = limit_exceeded;
    }

    public Integer getUserId() {
        return userId;
    }
}
