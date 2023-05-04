package klodnicki.robotv2.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private final JLabel welcomeLabel = new JLabel("Welcome to Robot App. You must login to continue.");
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private final JLabel userLabel = new JLabel("User name:");
    private final JLabel passwordLabel = new JLabel("Password:");
    private final JTextField textField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JButton buttonLogin = new JButton("Login");
    private final JButton buttonReset = new JButton("Reset");
    private final JCheckBox showPassword = new JCheckBox("Show Password");
    private final JLabel successLabel = new JLabel("");
    private final JLabel createAccount = new JLabel("No account? Click below");
    private final JButton buttonCreate = new JButton("Create account");

    public GUI(){
        setupFrame();
        setLocationAndSize();
        addComponents();
        addActionEvent();
    }

    public void setLocationAndSize() {
        frame.setSize(500, 300);
        welcomeLabel.setBounds(50, 20, 500, 25);
        userLabel.setBounds(100, 50, 80, 25);
        passwordLabel.setBounds(100, 80, 80, 25);
        successLabel.setBounds(100, 200, 80, 25);
        buttonLogin.setBounds(175, 160, 80, 25);
        buttonReset.setBounds(275, 160, 80, 25);
        buttonCreate.setBounds(200,230, 120, 25);
        textField.setBounds(200, 50, 165, 25);
        passwordField.setBounds(200, 80, 165, 25);
        showPassword.setBounds(225, 120, 150, 30);
        createAccount.setBounds(190, 200, 400, 25);
    }

    public void addComponents(){
        frame.add(panel);
        panel.add(userLabel);
        panel.add(textField);
        panel.add(passwordField);
        panel.add(welcomeLabel);
        panel.add(passwordLabel);
        panel.add(buttonLogin);
        panel.add(buttonReset);
        panel.add(successLabel);
        panel.add(showPassword);
        panel.add(createAccount);
        panel.add(buttonCreate);
    }

    public void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.setLayout(null);
    }

    public void addActionEvent() {
        buttonLogin.addActionListener(this);
        buttonReset.addActionListener(this);
        showPassword.addActionListener(this);
        buttonCreate.addActionListener(this);
    }

    public static void createAccount() {
        JFrame frameAccount = new JFrame();
        JPanel panelAccount = new JPanel();
        JLabel userAccountLabel = new JLabel("New user name:");
        JLabel passwordAccountLabel = new JLabel("New password:");
        JLabel confirmPasswordAccountLabel = new JLabel("Confirm password");
        JTextField userAccountField = new JTextField();
        JPasswordField passwordAccountField = new JPasswordField();
        JPasswordField confirmPasswordAccountField = new JPasswordField();
        JButton createButton = new JButton("Create account");
        JCheckBox showPasswordAccount = new JCheckBox("Show Password");

        frameAccount.add(panelAccount);
        panelAccount.add(userAccountLabel);
        panelAccount.add(passwordAccountLabel);
        panelAccount.add(confirmPasswordAccountLabel);
        panelAccount.add(userAccountField);
        panelAccount.add(passwordAccountField);
        panelAccount.add(confirmPasswordAccountField);
        panelAccount.add(createButton);
        panelAccount.add(showPasswordAccount);

        frameAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAccount.setVisible(true);
        panelAccount.setLayout(null);

        frameAccount.setSize(500, 500);
        userAccountLabel.setBounds(100, 50, 80, 25);
        passwordAccountLabel.setBounds(100, 80, 80, 25);
        confirmPasswordAccountLabel.setBounds(100, 110, 80, 25);
        userAccountField.setBounds(100, 130, 165, 25);
        passwordAccountField.setBounds(100, 180, 165, 25);
        confirmPasswordAccountField.setBounds(100, 210, 165, 25);
        createButton.setBounds(175, 250, 80, 25);
        showPasswordAccount.setBounds(100, 230,80,25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == buttonLogin) {
            String userText = textField.getText();
            String pwdText = passwordField.getText();
            if(userText.equals("lala") && pwdText.equals("12345")) {
                JOptionPane.showMessageDialog(this, "Login successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid user name or password.");
            }
        }

        if (e.getSource() == buttonReset) {
            textField.setText("");
            passwordField.setText("");
        }

        if(e.getSource() == showPassword) {
            if(showPassword.isSelected()) {
                passwordField.setEchoChar((char)0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

        if(e.getSource() == createAccount) {
            createAccount();
//            if(e.getSource() == createButton) {
//                JOptionPane.showMessageDialog(this, "Account has been successful created.");
//            }
        }

    }
}
