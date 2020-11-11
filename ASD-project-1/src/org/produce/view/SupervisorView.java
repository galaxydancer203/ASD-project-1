package org.produce.view;

import org.produce.ShiftScheduler;
import org.produce.controller.ViewManager;
import org.produce.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


@SuppressWarnings("serial")
public class SupervisorView extends JPanel implements ActionListener {

    private ViewManager manager;
    private JLabel accountNumberLabel;
    private JLabel accountManagerLabel;
    private JButton logoutButton;
    private JButton ScheduleButton;
    private JLabel balanceLabel;
    private JComboBox<?> actionChooser; //not needed
    private JComboBox<String> monday1Chooser;
    private JComboBox<String> monday2Chooser;
    private JComboBox<String> monday3Chooser;
    private JComboBox<String> tuesday1Chooser;
    private JComboBox<String> tuesday2Chooser;
    private JComboBox<String> tuesday3Chooser;
    private JComboBox<String> wednesday1Chooser;
    private JComboBox<String> wednesday2Chooser;
    private JComboBox<String> wednesday3Chooser;
    private JComboBox<String> thursday1Chooser;
    private JComboBox<String> thursday2Chooser;
    private JComboBox<String> thursday3Chooser;
    private JComboBox<String> friday1Chooser;
    private JComboBox<String> friday2Chooser;
    private JComboBox<String> friday3Chooser;
    //    private JComboBox<?> monday3Chooser;
    private JTextField dollarAmountField;
    private JTextField accountField;
    private JLabel errorMessageLabel;
    private JButton submitButton;


    private static final String[] actions = { ""};

    /**
     * Creates the Transaction view.
     *
     * @param manager - the controller
     */

    public SupervisorView(ViewManager manager) {
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
    

    public void populate(User user) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(true);
        int tmpj;
        int shift_tmp;
        int current_shift;
        boolean boolean_tmp;

        accountNumberLabel.setText("User ID : " + user.getAccount().getAccountNumber());
        accountManagerLabel.setText("Supervisor Name : " + user.getFirstName() + " " + user.getLastName());

        monday1Chooser.removeAllItems();
        current_shift = 1;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getmondayshift();
                if (shift_tmp == current_shift)
                     monday1Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        monday2Chooser.removeAllItems();
        current_shift = 2;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getmondayshift();
                if (shift_tmp == current_shift)
                    monday2Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        monday3Chooser.removeAllItems();
        current_shift = 3;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getmondayshift();
                if (shift_tmp == current_shift)
                    monday3Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        tuesday1Chooser.removeAllItems();
        current_shift = 1;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).gettuesdayshift();
                if (shift_tmp == current_shift)
                    tuesday1Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        tuesday2Chooser.removeAllItems();
        current_shift = 2;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).gettuesdayshift();
                if (shift_tmp == current_shift)
                    tuesday2Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        tuesday3Chooser.removeAllItems();
        current_shift = 3;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).gettuesdayshift();
                if (shift_tmp == current_shift)
                    tuesday3Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        wednesday1Chooser.removeAllItems();
        current_shift = 1;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getwednesdayshift();
                if (shift_tmp == current_shift)
                    wednesday1Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        wednesday2Chooser.removeAllItems();
        current_shift = 2;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getwednesdayshift();
                if (shift_tmp == current_shift)
                    wednesday2Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        wednesday3Chooser.removeAllItems();
        current_shift = 3;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getwednesdayshift();
                if (shift_tmp == current_shift)
                    wednesday3Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        thursday1Chooser.removeAllItems();
        current_shift = 1;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getthursdayshift();
                if (shift_tmp == current_shift)
                    thursday1Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        thursday2Chooser.removeAllItems();
        current_shift = 2;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getthursdayshift();
                if (shift_tmp == current_shift)
                    thursday2Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        thursday3Chooser.removeAllItems();
        current_shift = 3;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getthursdayshift();
                if (shift_tmp == current_shift)
                    thursday3Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }

        friday1Chooser.removeAllItems();
        current_shift = 1;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getfridayshift();
                if (shift_tmp == current_shift)
                    friday1Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        friday2Chooser.removeAllItems();
        current_shift = 2;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getfridayshift();
                if (shift_tmp == current_shift)
                    friday2Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }
        friday3Chooser.removeAllItems();
        current_shift = 3;
        for (int i=0; i<ShiftScheduler.users.size(); i++) {
            System.out.println(i);
            boolean_tmp = ShiftScheduler.users.get(i).isSupervisor();
            if (!boolean_tmp) {
                shift_tmp = ShiftScheduler.users.get(i).getfridayshift();
                if (shift_tmp == current_shift)
                    friday3Chooser.addItem(ShiftScheduler.users.get(i).getFirstName());
            }
        }

    }

    public void toggleAccountField(boolean enable) {
        accountField.setEnabled(enable);
    }

    private void init() {
        this.setLayout(null);

        initAccountNumberLabel();
        initAccountManagerLabel();
        initLogoutButton();
        initScheduleButton();
//        initBalanceLabel();
        initQuestionLabel();

        initMonday1choose();
        initMonday2choose();
        initMonday3choose();
        initTuesday1choose();
        initTuesday2choose();
        initTuesday3choose();

//
        initWednesday1choose();
        initWednesday2choose();
        initWednesday3choose();
//
        initThursday1choose();
        initThursday2choose();
        initThursday3choose();
//
        initFriday1choose();
        initFriday2choose();
        initFriday3choose();
//        initActionChoosers();
//        initDollarAmountField();
//        initAccountField();
        initErrorMessageLabel();
        initSubmitButton();
    }

    private void initAccountNumberLabel() {
        accountNumberLabel = new JLabel("User ID : ");
        accountNumberLabel.setBounds(10, 10, 490, 35);
        accountNumberLabel.setFont(new Font("DialogInput", Font.BOLD, 14));

        this.add(accountNumberLabel);
    }

    private void initAccountManagerLabel() {
        accountManagerLabel = new JLabel("Manager Namejeff: ");
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

    private void initScheduleButton() {
        ScheduleButton = new JButton("Schedule");
        ScheduleButton.setBounds(10, 375, 100, 35);
        ScheduleButton.addActionListener(this);

        this.add(ScheduleButton);
    }


    private void initQuestionLabel() {
        JLabel label = new JLabel("Who will work when?", SwingConstants.CENTER);
        label.setBounds(10, 60, 490, 35);
        label.setFont(new Font("DialogInput", Font.PLAIN, 15));
        this.add(label);
    }

    private void initMonday1choose() {

        JLabel label = new JLabel("Monday :", SwingConstants.RIGHT);
        label.setBounds(10, 95, 90, 25);
        label.setLabelFor(monday1Chooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        monday1Chooser = new JComboBox<String>(actions);
        monday1Chooser.setBounds(135, 100, 75, 20);
        monday1Chooser.addActionListener(this);

        this.add(label);
        this.add(monday1Chooser);
    }
    private void initMonday2choose() {

        monday2Chooser = new JComboBox<String>(actions);
        monday2Chooser.setBounds(225, 100, 75, 20);
        monday2Chooser.addActionListener(this);


        this.add(monday2Chooser);
    }
    private void initMonday3choose() {

        monday3Chooser = new JComboBox<String>(actions);
        monday3Chooser.setBounds(315, 100, 75, 20);
        monday3Chooser.addActionListener(this);

        this.add(monday3Chooser);
    }

    private void initTuesday1choose() {
        JLabel label = new JLabel("Tuesday :", SwingConstants.RIGHT);
        label.setBounds(10,150, 90, 25);
        label.setLabelFor(tuesday1Chooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        tuesday1Chooser = new JComboBox<String>(actions);
        tuesday1Chooser.setBounds(135, 155, 75, 20);
        tuesday1Chooser.addActionListener(this);

        this.add(label);
        this.add(tuesday1Chooser);
    }
    private void initTuesday2choose() {

        tuesday2Chooser = new JComboBox<String>(actions);
        tuesday2Chooser.setBounds(225, 155, 75, 20);
        tuesday2Chooser.addActionListener(this);

        this.add(tuesday2Chooser);
    }
    private void initTuesday3choose() {

        tuesday3Chooser = new JComboBox<String>(actions);
        tuesday3Chooser.setBounds(315, 155, 75, 20);
        tuesday3Chooser.addActionListener(this);

//        this.add(label);
        this.add(tuesday3Chooser);
    }

    private void initWednesday1choose() {
        JLabel label = new JLabel("Wednesday :", SwingConstants.RIGHT);
        label.setBounds(10,205, 90, 25);
        label.setLabelFor(wednesday1Chooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        wednesday1Chooser = new JComboBox<String>(actions);
        wednesday1Chooser.setBounds(135, 210, 75, 20);
        wednesday1Chooser.addActionListener(this);

        this.add(label);
        this.add(wednesday1Chooser);
    }
    private void initWednesday2choose() {

        wednesday2Chooser = new JComboBox<String>(actions);
        wednesday2Chooser.setBounds(225, 210, 75, 20);
        wednesday2Chooser.addActionListener(this);

        this.add(wednesday2Chooser);
    }
    private void initWednesday3choose() {

        wednesday3Chooser = new JComboBox<String>(actions);
        wednesday3Chooser.setBounds(315, 210, 75, 20);
        wednesday3Chooser.addActionListener(this);

        this.add(wednesday3Chooser);
    }


    private void initThursday1choose() {
        JLabel label = new JLabel("Thursday :", SwingConstants.RIGHT);
        label.setBounds(10,255, 90, 25);
        label.setLabelFor(thursday1Chooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

       thursday1Chooser = new JComboBox<String>(actions);
        thursday1Chooser.setBounds(135, 260, 75, 20);
        thursday1Chooser.addActionListener(this);

        this.add(label);
        this.add(thursday1Chooser);
    }

    private void initThursday2choose() {

        thursday2Chooser = new JComboBox<String>(actions);
        thursday2Chooser.setBounds(225, 260, 75, 20);
        thursday2Chooser.addActionListener(this);

        this.add(thursday2Chooser);
    }
    private void initThursday3choose() {

        thursday3Chooser = new JComboBox<String>(actions);
        thursday3Chooser.setBounds(315, 260, 75, 20);
        thursday3Chooser.addActionListener(this);

        this.add(thursday3Chooser);
    }

    private void initFriday1choose() {
        JLabel label = new JLabel("Friday :", SwingConstants.RIGHT);
        label.setBounds(10,310, 90, 25);
        label.setLabelFor(friday1Chooser);
        label.setFont(new Font("DialogInput", Font.BOLD, 12));

        friday1Chooser = new JComboBox<String>(actions);
        friday1Chooser.setBounds(135, 315, 75, 20);
        friday1Chooser.addActionListener(this);

        this.add(label);
        this.add(friday1Chooser);
    }
    private void initFriday2choose() {

        friday2Chooser = new JComboBox<String>(actions);
        friday2Chooser.setBounds(225, 315, 75, 20);
        friday2Chooser.addActionListener(this);

        this.add(friday2Chooser);
    }
    private void initFriday3choose() {

        friday3Chooser = new JComboBox<String>(actions);
        friday3Chooser.setBounds(315, 315, 75, 20);
        friday3Chooser.addActionListener(this);

        this.add(friday3Chooser);
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
//
    if (source.equals(submitButton)) {
            try {
             ShiftScheduler.theschedule[0][0] = (String) monday1Chooser.getSelectedItem();
                ShiftScheduler.theschedule[0][1] = (String) monday2Chooser.getSelectedItem();
                ShiftScheduler.theschedule[0][2] = (String) monday3Chooser.getSelectedItem();

                ShiftScheduler.theschedule[1][0] = (String) tuesday1Chooser.getSelectedItem();
                ShiftScheduler.theschedule[1][1] = (String) tuesday2Chooser.getSelectedItem();
                ShiftScheduler.theschedule[1][2] = (String) tuesday3Chooser.getSelectedItem();

                ShiftScheduler.theschedule[2][0] = (String) wednesday1Chooser.getSelectedItem();
                ShiftScheduler.theschedule[2][1] = (String) wednesday2Chooser.getSelectedItem();
                ShiftScheduler.theschedule[2][2] = (String) wednesday3Chooser.getSelectedItem();

                ShiftScheduler.theschedule[3][0] = (String) thursday1Chooser.getSelectedItem();
                ShiftScheduler.theschedule[3][1] = (String) thursday2Chooser.getSelectedItem();
                ShiftScheduler.theschedule[3][2] = (String) thursday3Chooser.getSelectedItem();

                ShiftScheduler.theschedule[4][0] = (String) friday1Chooser.getSelectedItem();
                ShiftScheduler.theschedule[4][1] = (String) friday2Chooser.getSelectedItem();
                ShiftScheduler.theschedule[4][2] = (String) friday3Chooser.getSelectedItem();

            } catch (Exception ex) {
//                showErrorMessage("Account number and/or amount improperly formatted.");
            }
        } else if (source.equals(logoutButton)) {
            manager.logout();

        }
    else if(source.equals(ScheduleButton)){
        manager.viewschedule();
    }
    }

//
}
