package klodnicki.robotv2.view;

import klodnicki.robotv2.Main2;

import javax.swing.*;

public class GUI {

    public void showLogin() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to robot command center. You must login to continue.");
        JLabel userLabel = new JLabel("User name:");
        JLabel passwordLabel = new JLabel("password:");
        JLabel successLabel = new JLabel("");
        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton button = new JButton("Login");
        JButton buttonCreateAccount = new JButton("Create account");

        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);
        panel.add(userLabel);
        panel.add(textField);
        panel.add(welcomeLabel);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(button);
        panel.add(buttonCreateAccount);
        panel.add(successLabel);

        welcomeLabel.setBounds(50, 20, 500, 25);
        userLabel.setBounds(100, 50, 80, 25);
        passwordLabel.setBounds(100, 80, 80, 25);
        successLabel.setBounds(100, 110, 80, 25);

        button.setBounds(190, 130, 80, 25);
        buttonCreateAccount.setBounds(300, 130, 150, 25);
        button.addActionListener(new Main2());
        buttonCreateAccount.addActionListener(new Main2());

        textField.setBounds(200, 50, 165, 25);
        passwordField.setBounds(200, 80, 165, 25);
    }
}
