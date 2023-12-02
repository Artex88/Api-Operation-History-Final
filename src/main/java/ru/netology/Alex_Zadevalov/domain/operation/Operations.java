
package ru.netology.Alex_Zadevalov.domain.operation;


import ru.netology.Alex_Zadevalov.domain.ConsolePrintable;

import java.util.Objects;


public class Operations extends BaseOperation implements ConsolePrintable {
    private OperationCreditType operationCreditType;
    private double sum;
    private Currency currency;
    private String merchant;
    private int customerId;

    public Operations(){

    }

    public void printToConsole(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Operations{" +
                "operationCreditType=" + operationCreditType +
                ", sum=" + sum +
                ", currency=" + currency +
                ", merchant='" + merchant + '\'' +
                ", customerId=" + customerId +
                '}';
    }

    public Operations(OperationCreditType operationCreditType, double sum, Currency currency, String merchant, int customerId) {
        this.operationCreditType = operationCreditType;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
        this.customerId = customerId;
    }

    public OperationCreditType getOperationCreditType() {
        return operationCreditType;
    }

    public void setOperationCreditType(OperationCreditType operationCreditType) {
        this.operationCreditType = operationCreditType;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operations that = (Operations) o;

        if (Double.compare(sum, that.sum) != 0) return false;
        if (customerId != that.customerId) return false;
        if (operationCreditType != that.operationCreditType) return false;
        if (currency != that.currency) return false;
        return Objects.equals(merchant, that.merchant);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = operationCreditType != null ? operationCreditType.hashCode() : 0;
        temp = Double.doubleToLongBits(sum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (merchant != null ? merchant.hashCode() : 0);
        result = 31 * result + customerId;
        return result;
    }

}

