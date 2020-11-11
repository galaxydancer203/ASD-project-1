package org.produce.view;

import org.produce.controller.ViewManager;
import org.produce.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
@SuppressWarnings("serial")
public class ScheduleView extends JPanel implements ActionListener {

    private ViewManager manager;
    private JLabel accountNumberLabel;
    private JLabel accountManagerLabel;
    private JButton logoutButton;
    private JComboBox<?> actionChooser; //not needed

    private JLabel errorMessageLabel;
    private JButton submitButton;


    private static final String[] actions = { ""};

    /**
     * Creates the Transaction view.
     *
     * @param manager - the controller
     */

    public ScheduleView(ViewManager manager) {
        super();
        
        this.manager = manager;

        this.init();
    }

    /**
     * Populates the initial user details.
     * 
     * @param user - the active user
     */

    public void populate(User user) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(true);
//

        accountNumberLabel.setText("User ID : " + user.getAccount().getAccountNumber());
        accountManagerLabel.setText("Name : " + user.getFirstName() + " " + user.getLastName());
//
    }

    /**
     * Sets the error message text for this view.
     *
     */

    private void init() {
        this.setLayout(null);
    }

    private void initAccountNumberLabel() {
        accountNumberLabel = new JLabel("Test ID : ");
        accountNumberLabel.setBounds(10, 10, 490, 35);
        accountNumberLabel.setFont(new Font("DialogInput", Font.BOLD, 14));

        this.add(accountNumberLabel);
    }

    private void initAccountManagerLabel() {
        accountManagerLabel = new JLabel("Manager Name: ");
        accountManagerLabel.setBounds(10, 30, 490, 35);
        accountManagerLabel.setFont(new Font("DialogInput", Font.BOLD, 14));

        JSeparator divider = new JSeparator();
        divider.setBounds(10, 65, 480, 10);

        this.add(accountManagerLabel);
        this.add(divider);
    }

    private void initLogoutButton() {
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(375, 10, 100, 35);
        logoutButton.addActionListener(this);

        this.add(logoutButton);
    }

    private void initQuestionLabel() {
        JLabel label = new JLabel("Schedule", SwingConstants.CENTER);
        label.setBounds(10, 60, 490, 35);
        label.setFont(new Font("DialogInput", Font.PLAIN, 15));
        this.add(label);
    }

    private void initErrorMessageLabel() {
        errorMessageLabel = new JLabel("", SwingConstants.CENTER);
        errorMessageLabel.setBounds(0, 335, 500, 35);
        errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 12));
        errorMessageLabel.setForeground(Color.RED);

        this.add(errorMessageLabel);
    }

    private void initSubmitButton() {
        submitButton = new JButton("Finalize");
        submitButton.setBounds(375, 400, 100, 35);
        submitButton.addActionListener(this);

        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//
    if (source.equals(submitButton)) {
            try {
                switch (actionChooser.getSelectedIndex()) {
//
                }
            } catch (Exception ex) {
            }
        } else if (source.equals(logoutButton)) {
            manager.logout();

        }
    }

}
