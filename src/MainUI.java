import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {
    private final JLabel balanceLabel;
    private static final int INITIAL_BALANCE = 100000;
    private static final int TRANSFER_AMOUNT = 1000000;

    public MainUI() {
        setTitle("Data Inconsistency");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        BankAccount account = new BankAccount(INITIAL_BALANCE);

        // Labels
        JLabel fatherLabel = new JLabel("<html><center>Deposit Amount:<br>" + TRANSFER_AMOUNT + "</center></html>", SwingConstants.CENTER);
        JLabel sonLabel = new JLabel("<html><center>Withdraw Amount:<br>" + TRANSFER_AMOUNT + "</center></html>", SwingConstants.CENTER);
        balanceLabel = new JLabel(String.valueOf(INITIAL_BALANCE), SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 24));
        balanceLabel.setOpaque(true);
        balanceLabel.setBackground(Color.decode("#6495ED"));
        balanceLabel.setForeground(Color.WHITE);

        // Panels
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        leftPanel.add(fatherLabel);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        rightPanel.add(sonLabel);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(balanceLabel);

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);

        // Launch both threads
        Father father = new Father(account, TRANSFER_AMOUNT, this);
        Son son = new Son(account, TRANSFER_AMOUNT, this);

        father.start();
        son.start();
    }

    public void updateBalance(int newBalance) {
        SwingUtilities.invokeLater(() -> balanceLabel.setText(String.valueOf(newBalance)));
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
