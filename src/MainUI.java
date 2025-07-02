import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {
    private JLabel balanceValueLabel;
    private static final int INITIAL_BALANCE = 100000;
    private static final int TRANSFER_AMOUNT = 1000000;

    public MainUI() {
        setTitle("Data Inconsistency");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        BankAccount account = new BankAccount(INITIAL_BALANCE);

        JPanel fatherPanel = createLabeledPanel("Father", "Deposit Amount:<br>" + TRANSFER_AMOUNT, false);
        JPanel sonPanel = createLabeledPanel("Son", "Withdraw Amount:<br>" + TRANSFER_AMOUNT, false);
        JPanel balancePanel = createLabeledPanel("Balance", String.valueOf(INITIAL_BALANCE), true);

        add(fatherPanel, BorderLayout.WEST);
        add(balancePanel, BorderLayout.CENTER);
        add(sonPanel, BorderLayout.EAST);

        setVisible(true);

        Father father = new Father(account, TRANSFER_AMOUNT, this);
        Son son = new Son(account, TRANSFER_AMOUNT, this);

        father.start();
        son.start();
    }

    private JPanel createLabeledPanel(String title, String content, boolean isBalancePanel) {
        JPanel panel = new JPanel(new BorderLayout());

        if (!isBalancePanel) {
            panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel contentLabel = new JLabel("<html><center>" + content + "</center></html>", SwingConstants.CENTER);

        if (isBalancePanel) {
            contentLabel.setFont(new Font("Arial", Font.BOLD, 28));
            contentLabel.setOpaque(true);
            contentLabel.setBackground(new Color(100, 149, 237));
            contentLabel.setForeground(Color.WHITE);
            this.balanceValueLabel = contentLabel;
        }

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(contentLabel, BorderLayout.CENTER);

        return panel;
    }

    public void updateBalance(int newBalance) {
        SwingUtilities.invokeLater(() -> balanceValueLabel.setText(String.valueOf(newBalance)));
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
