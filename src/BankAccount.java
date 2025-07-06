public class BankAccount {
    private int balance;
    private final Peterson lock = new Peterson();

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount, int threadId) {
        lock.lock(threadId);
        try {
            int temp = balance;
            temp += amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException _) {}
            balance = temp;
        } finally {
            lock.unlock(threadId);
        }
    }

    public void withdraw(int amount, int threadId) {
        lock.lock(threadId);
        try {
            int temp = balance;
            temp -= amount;
            try {
                Thread.sleep(100);
            } catch (InterruptedException _) {}
            balance = temp;
        } finally {
            lock.unlock(threadId);
        }
    }
}
