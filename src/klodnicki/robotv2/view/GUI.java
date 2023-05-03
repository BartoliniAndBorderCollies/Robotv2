package klodnicki.robotv2.view;

import klodnicki.robotv2.Main2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JLabel welcomeLabel = new JLabel("Welcome to robot command center. You must login to continue.");
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel userLabel = new JLabel("User name:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField textField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton buttonLogin = new JButton("Login");
    private JButton buttonCreateAccount = new JButton("Create account");
    private JCheckBox showPassword = new JCheckBox("Show Password");
    private JLabel successLabel = new JLabel("");


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
        buttonLogin.setBounds(190, 130, 80, 25);
        buttonCreateAccount.setBounds(300, 130, 150, 25);
        textField.setBounds(200, 50, 165, 25);
        passwordField.setBounds(200, 80, 165, 25);
        showPassword.setBounds(225, 100, 150, 30);
    }

    public void addComponents(){
        frame.add(panel);
        panel.add(userLabel);
        panel.add(textField);
        panel.add(welcomeLabel);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(buttonLogin);
        panel.add(buttonCreateAccount);
        panel.add(successLabel);
        panel.add(showPassword);
    }

    public void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.setLayout(null);
    }

    public void showLogin() {


    }

    public void addActionEvent() {
        buttonLogin.addActionListener(this);
        buttonCreateAccount.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonCreateAccount) {
            System.out.println("test");
        }
        if(actionEvent.getSource() == buttonLogin) {
            System.out.println("kapusta");
        }
    }
}
