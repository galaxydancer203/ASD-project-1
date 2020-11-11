package org.produce.view;

import org.produce.controller.ViewManager;
import org.produce.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

//import org.produce.model.Account;

@SuppressWarnings("serial")
public class WorkerView extends JPanel implements ActionListener {

    private ViewManager manager;
    private JLabel accountNumberLabel;
    private JLabel accountOwnerLabel;
    private JButton logoutButton;
    private JButton ScheduleButton;

    private JLabel balanceLabel;
    private JComboBox<?> actionChooser;
    private JComboBox<?> mondayactionChooser;
    private JComboBox<?> tuesdayactionChooser;
    private JComboBox<?> wednesdayactionChooser;
    private JComboBox<?> thursdayactionChooser;
    private JComboBox<?> fridayactionChooser;

    private JTextField dollarAmountField;
    private JTextField accountField;
    private JLabel errorMessageLabel;
    private JButton submitButton;

    private static final String[] Mondayactions = { "None", "Shift 1", "Shift 2", "Shift 3" };
    private static final String[] Tuesdayactions = { "None", "Shift 1", "Shift 2", "Shift 3" };
    private static final String[] Wednesdayactions = { "None", "Shift 1", "Shift 2", "Shift 3" };
    private static final String[] Thursdayactions = { "None", "Shift 1", "Shift 2", "Shift 3" };
    private static final String[] Fridayactions = { "None", "Shift 1", "Shift 2", "Shift 3" };

    /**
     * Creates the Transaction view.
     * 
     * @param manager - the controller
     */
    
    public WorkerView(ViewManager manager) {
        super();
        
        this.manager = manager;

        this.init();
    }

    public JTextField getDollarAmountField() {
        return dollarAmountField;
    }

    public JTextField getAccountField() {
        return accountField;
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
        
        accountNumberLabel.setText("User ID : " + user.getAccount().getAccountNumber());
        accountOwnerLabel.setText("Worker Name : " + user.getFirstName() + " " + user.getLastName());


        mondayactionChooser.setSelectedIndex(user.getmondayshift());
        tuesdayactionChooser.setSelectedIndex(user.gettuesdayshift());
        wednesdayactionChooser.setSelectedIndex(user.getwednesdayshift());
        thursdayactionChooser.setSelectedIndex(user.getthursdayshift());
        fridayactionChooser.setSelectedIndex(user.getfridayshift());


    }

    /**
     * Sets the error message text for this view.12
     * 
     * @param errorMessage - the error message to set
     */

    public void showErrorMessage(String errorMessage) {
        errorMessageLabel.setText(errorMessage);
    }


    public void clear() {
//        dollarAmountField.setText("");
        accountField.setText("");
        showErrorMessage("");



    }

    /**
     * Toggles the dollar amount field between enabled and disabled.
     * 
     * @param enable - true to enable, false to disable
     */

//    public void toggleDollarAmountField(boolean enable) {
//        dollarAmountField.setEnabled(enable);
//    }

    /**
     * Toggles the account field between enabled and disabled.
     * 
     * @param enable - true to enable, false to disable
     */

    public void toggleAccountField(boolean enable) {
        accountField.setEnabled(enable);
    }

    private void init() {
        this.setLayout(null);

        initAccountNumberLabel();
        initAccountOwnerLabel();
        initLogoutButton();
        initScheduleButton();

        initQuestionLabel();
        initMondaychoose();
        initTuesdaychoose();
//
        initWednesdaychoose();
//
        initThursdaychoose();
//
        initFridaychoose();

        initErrorMessageLabel();
        initSubmitButton();
    }

    private void initAccountNumberLabel() {
        accountNumberLabel = new JLabel("User ID : ");
        accountNumberLabel.setBounds(10, 10, 490, 35);
        accountNumberLabel.setFont(new Font("DialogInput", Font.BOLD, 14));

        this.add(accountNumberLabel);
    }

    private void initAccountOwnerLabel() {
        accountOwnerLabel = new JLabel("Account Owner : ");
        accountOwnerLabel.setBounds(10, 30, 490, 35);
        accountOwnerLabel.setFont(new Font("DialogInput", Font.BOLD, 14));

        JSeparator divider = new JSeparator();
        divider.setBounds(10, 65, 480, 10);

        this.add(accountOwnerLabel);
        this.add(divider);
    }

    private void initLogoutButton() {
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(375, 10, 100, 35);
        logoutButton.addActionListener(this);

        this.add(logoutButton);
    }
    private void initScheduleButton() {
        ScheduleButton = new JButton("Schedule");
        ScheduleButton.setBounds(10, 375, 100, 35);
        ScheduleButton.addActionListener(this);

        this.add(ScheduleButton);
    }



    private void initQuestionLabel() {
        JLabel label = new JLabel("When can you work?", SwingConstants.CENTER);
        label.setBounds(10, 60, 490, 35);
        label.setFont(new Font("DialogInput", Font.PLAIN, 15));
        this.add(label);
    }

    private void initMondaychoose() {
        JLabel label = new JLabel("Monday :", SwingConstants.RIGHT);
        label.setBounds(10, 95, 90, 25);
//        label.setLabelFor(actionChooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        mondayactionChooser = new JComboBox<String>(Mondayactions);
        mondayactionChooser.setBounds(135, 100, 150, 20);
        mondayactionChooser.addActionListener(this);

        this.add(label);
        this.add(mondayactionChooser);
    }
    private void initTuesdaychoose() {
        JLabel label = new JLabel("Tuesday :", SwingConstants.RIGHT);
        label.setBounds(10,150, 90, 25);
        label.setLabelFor(tuesdayactionChooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        tuesdayactionChooser = new JComboBox<String>(Tuesdayactions);
        tuesdayactionChooser.setBounds(135, 155, 150, 20);
        tuesdayactionChooser.addActionListener(this);

        this.add(label);
        this.add(tuesdayactionChooser);
    }
    private void initWednesdaychoose() {
        JLabel label = new JLabel("Wednesday :", SwingConstants.RIGHT);
        label.setBounds(10,205, 90, 25);
        label.setLabelFor(wednesdayactionChooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        wednesdayactionChooser = new JComboBox<String>(Wednesdayactions);
        wednesdayactionChooser.setBounds(135, 210, 150, 20);
        wednesdayactionChooser.addActionListener(this);

        this.add(label);
        this.add(wednesdayactionChooser);
    }
    private void initThursdaychoose() {
        JLabel label = new JLabel("Thursday :", SwingConstants.RIGHT);
        label.setBounds(10,255, 90, 25);
        label.setLabelFor(thursdayactionChooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        thursdayactionChooser = new JComboBox<String>(Thursdayactions);
        thursdayactionChooser.setBounds(135, 260, 150, 20);
        thursdayactionChooser.addActionListener(this);

        this.add(label);
        this.add(thursdayactionChooser);
    }
    private void initFridaychoose() {
        JLabel label = new JLabel("Friday :", SwingConstants.RIGHT);
        label.setBounds(10,310, 90, 25);
        label.setLabelFor(fridayactionChooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        fridayactionChooser = new JComboBox<String>(Fridayactions);
        fridayactionChooser.setBounds(135, 315, 150, 20);
        fridayactionChooser.addActionListener(this);

        this.add(label);
        this.add(fridayactionChooser);
    }


    private void initErrorMessageLabel() {
        errorMessageLabel = new JLabel("", SwingConstants.CENTER);
        errorMessageLabel.setBounds(0, 335, 500, 35);
        errorMessageLabel.setFont(new Font("DialogInput", Font.ITALIC, 12));
        errorMessageLabel.setForeground(Color.RED);

        this.add(errorMessageLabel);
    }

    private void initSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.setBounds(375, 400, 100, 35);
        submitButton.addActionListener(this);

        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source.equals(mondayactionChooser)) {
             manager.setmondayshift(mondayactionChooser.getSelectedIndex());
        }
        else if (source.equals(tuesdayactionChooser)) {
             manager.settuesdayshift(tuesdayactionChooser.getSelectedIndex());
        }
        else if (source.equals(wednesdayactionChooser)) {
             manager.setwednesdayshift(wednesdayactionChooser.getSelectedIndex());
        }
        else if (source.equals(thursdayactionChooser)) {
             manager.setthursdayshift(thursdayactionChooser.getSelectedIndex());
        }
        else if (source.equals(fridayactionChooser)) {
             manager.setfridayshift(fridayactionChooser.getSelectedIndex());
        }



        else if (source.equals(submitButton)) {
            try {

            } catch (Exception ex) {
                showErrorMessage("Account number and/or amount improperly formatted.");
            }
        } else if (source.equals(logoutButton)) {
            manager.logout();


            clear();
            fridayactionChooser.setSelectedIndex(0);

            mondayactionChooser.setSelectedIndex(0);
            tuesdayactionChooser.setSelectedIndex(0);
            wednesdayactionChooser.setSelectedIndex(0);
            thursdayactionChooser.setSelectedIndex(0);

        }
        else if(source.equals(ScheduleButton)){
            manager.viewschedule();
        }
    }

    private void toggleDollarAmountField(boolean b) {
    }
}
