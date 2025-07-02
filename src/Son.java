public class Son extends Thread {
    private BankAccount account;
    private int withdrawAmount;
    private MainUI ui;

    public Son(BankAccount account, int withdrawAmount, MainUI ui) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
        this.ui = ui;
    }

    @Override
    public void run() {
        account.withdraw(withdrawAmount);
        ui.updateBalance(account.getBalance());
    }
}
