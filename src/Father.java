public class Father extends Thread {
    private BankAccount account;
    private int depositAmount;
    private MainUI ui;

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
