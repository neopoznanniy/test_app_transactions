package model;

public class Transaction {
    private final Integer account_from;

    private final Double sum;

    private final String currency_shortname;

    private final boolean limit_exceeded;

    public Transaction(Integer account_from, Double sum, String currency_shortname, boolean limit_exceeded) {
        this.account_from = account_from;
        this.sum = sum;
        this.currency_shortname = currency_shortname;
        this.limit_exceeded = limit_exceeded;
    }

    public Integer getAccount_from() {
        return account_from;
    }

    public Double getSum() {
        return sum;
    }

    public String getCurrency_shortname() {
        return currency_shortname;
    }
}
