package org.produce.view;

import org.produce.controller.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")

public class LoginView extends JPanel {

    private ViewManager manager;
    private JTextField accountField;
    private JPasswordField pinField;
    private JButton loginButton;
    private JLabel errorMessageLabel;

    
    public LoginView(ViewManager manager) {
        super();
        
        this.manager = manager;

        this.init();
    }

    public void toggleErrorMessage(boolean show) {
        if (show) {
            errorMessageLabel.setText("Invalid account number and/or PIN.");
        } else {
            errorMessageLabel.setText("");
        }
    }

    public void clear() {
        accountField.setText("");
        pinField.setText("");
        toggleErrorMessage(false);
    }

    /*
     * Initializes all components of this view.
     */

    private void init() {
        this.setLayout(null);

        initTitle();
        initErrorMessageLabel();
        initAccountField();
        initPinField();
        initLoginButton();
    }

    private void initTitle() {
        JLabel label = new JLabel("Walwa SuperStore Shift Scheduler 5.0", SwingConstants.CENTER);
        label.setBounds(0, 20, 500, 35);
        label.setFont(new Font("DialogInput", Font.BOLD, 21));
        this.add(label);
    }

    private void initErrorMessageLabel() {
        errorMessageLabel = new JLabel("", SwingConstants.CENTER);
        errorMessageLabel.setBounds(0, 110, 500, 35);
        errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 12));
        errorMessageLabel.setForeground(Color.RED);
        this.add(errorMessageLabel);
    }

    private void initAccountField() {
        JLabel label = new JLabel("User ID :", SwingConstants.RIGHT);
        label.setBounds(100, 160, 95, 35);
        label.setLabelFor(accountField);
        label.setFont(new Font("DialogInput", Font.BOLD, 14));

        accountField = new JTextField(20);
        accountField.setBounds(205, 160, 200, 35);

        accountField.addKeyListener(new KeyAdapter() {

            /*
             * Respond when the user types a character into the Account field. Restrict
             * input to eight numeric values, ignoring everything else.
             */

            @Override
            public void keyTyped(KeyEvent e) {
                if (accountField.getText().length() >= 8) {
                    e.consume();
                } else if (e.getKeyChar() < 48 || e.getKeyChar() > 57) {
                    e.consume();
                }
            }
        });

        this.add(label);
        this.add(accountField);
    }

    private void initPinField() {
        JLabel label = new JLabel("Password :", SwingConstants.RIGHT);
        label.setBounds(100, 200, 95, 35);
        label.setLabelFor(pinField);
        label.setFont(new Font("DialogInput", Font.BOLD, 14));

        pinField = new JPasswordField(20);
        pinField.setBounds(205, 200, 200, 35);

        pinField.addKeyListener(new KeyAdapter() {

            /*
             * Respond when the user types a character into the PIN field. Restrict input to
             * four numeric values, ignoring everything else.
             */

            @Override
            public void keyTyped(KeyEvent e) {
                if (pinField.getPassword().length >= 4) {
                    e.consume();
                } else if (e.getKeyChar() < 48 || e.getKeyChar() > 57) {
                    e.consume();
                }
            }
        });

        this.add(label);
        this.add(pinField);
    }

    private void initLoginButton() {
        loginButton = new JButton("Login");
        loginButton.setBounds(205, 260, 200, 35);

        loginButton.addActionListener(new ActionListener() {

            /*
             * Responds when the user clicks the Login button.
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();

                if (source.equals(loginButton)) {
                    String accountNumber = accountField.getText();
                    char[] pin = pinField.getPassword();
                    
                    manager.login(accountNumber, pin);
                }
            }
        });

        this.add(loginButton);
    }
}
