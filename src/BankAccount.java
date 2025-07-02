public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        int temp = balance;
        temp += amount;
        try {
            Thread.sleep(100);
        } catch (InterruptedException _) {}
        balance = temp;
    }

    public void withdraw(int amount) {
        int temp = balance;
        temp -= amount;
        try {
            Thread.sleep(100);
        } catch (InterruptedException _) {}
        balance = temp;
    }
}
