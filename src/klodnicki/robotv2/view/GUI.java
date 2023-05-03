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
        buttonLogin.setBounds(190, 160, 80, 25);
        buttonReset.setBounds(300, 160, 150, 25);
        textField.setBounds(200, 50, 165, 25);
        passwordField.setBounds(200, 80, 165, 25);
        showPassword.setBounds(225, 120, 150, 30);
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
    }
}
