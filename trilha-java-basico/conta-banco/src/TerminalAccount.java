public class TerminalAccount {
    private int number;
    private String agency;
    private String customerName;
    private double balance;

    protected int getNumber() {
        return number;
    }

    protected void setNumber(int number) {
        this.number = number;
    }

    protected String getAgency() {
        return agency;
    }

    protected void setAgency(String agency) {
        this.agency = agency;
    }

    protected String getCustomerName() {
        return customerName;
    }

    protected void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
