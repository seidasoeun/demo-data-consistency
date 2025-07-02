public class Father extends Thread {
    private final BankAccount account;
    private final int depositAmount;
    private final MainUI ui;

    public Father(BankAccount account, int depositAmount, MainUI ui) {
        this.account = account;
        this.depositAmount = depositAmount;
        this.ui = ui;
    }

    @Override
    public void run() {
        account.deposit(depositAmount);
        ui.updateBalance(account.getBalance());
    }
}
