public class Father extends Thread {
    private final BankAccount account;
    private final int deposit;
    private final MainUI ui;

    public Father(BankAccount account, int deposit, MainUI ui) {
        this.account = account;
        this.deposit = deposit;
        this.ui = ui;
    }

    @Override
    public void run() {
        account.deposit(deposit, 0); // Father is thread 0
        ui.updateBalance(account.getBalance());
    }
}