public class Son extends Thread {
    private final BankAccount account;
    private final int withdraw;
    private final MainUI ui;

    public Son(BankAccount account, int withdraw, MainUI ui) {
        this.account = account;
        this.withdraw = withdraw;
        this.ui = ui;
    }

    @Override
    public void run() {
        account.withdraw(withdraw, 1); // Son is thread 1
        ui.updateBalance(account.getBalance());
    }
}