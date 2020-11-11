package org.produce;

import org.produce.controller.ViewManager;
import org.produce.model.Account;
import org.produce.model.User;
import org.produce.view.LoginView;
import org.produce.view.ScheduleView;
import org.produce.view.SupervisorView;
import org.produce.view.WorkerView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ShiftScheduler extends JFrame {

    public static final int SUCCESS = 0;
    public static final int INVALID = 1;
    public static final int INSUFFICIENT = 2;
    public static final int ACCOUNT = 3;

    public static final String LOGIN_VIEW = "LOGIN_VIEW";
    public static final String WORKER_VIEW = "WORKER_VIEW";
    public static final String SUPERVISOR_VIEW = "SUPERVISOR_VIEW";
    public static final String SCHEDULE_VIEW = "SCHEDULE_VIEW";


    public static final int LOGIN_VIEW_INDEX = 0;
    public static final int WORKER_VIEW_INDEX = 1;
    public static final int SUPERVISOR_VIEW_INDEX =2;
    public static final int SCHEDULE_VIEW_INDEX =3;



    public static ArrayList<User> users;
public static String[][] theschedule = new String[5][3];
    public ShiftScheduler() {
        super("Walwa SuperStore Shift Scheduler");

        ShiftScheduler.users = new ArrayList<User>();

//adding users
        ShiftScheduler.users.add(new User("Billy", "Stevens", "bstevens@gmail.com", 5551234567L, true));
        ShiftScheduler.users.add(new User("Johny", "Bonds", "jbonds@yahoo.com", 5559741543L,false ));
        ShiftScheduler.users.add(new User("Tom", "Love", "tlove@yahoo.com", 9999876543L, false));
        ShiftScheduler.users.add(new User("Bob", "Stewart", "bstewart@yahoo.com", 5559876789L, false));
        ShiftScheduler.users.add(new User("City", "Smith", "csmith@yahoo.com", 5559485543L, false));
        ShiftScheduler.users.add(new User("Randoll", "Eng", "reng@yahoo.com", 7419876543L, false));



    }

    public static User lookupUser(long accountNumber, int pin) {
        for (User user : users) {
            if (user.getAccount().getAccountNumber() == accountNumber && user.getAccount().getPin() == pin) {
                return user;
            }
        }

        return null;
    }

    public static Account lookupAccount(long accountNumber) {
        for (User user : users) {
            if (user.getAccount().getAccountNumber() == accountNumber) {
                return user.getAccount();
            }
        }

        return null;
    }



    private void init() {
        JPanel views = new JPanel(new CardLayout());
        ViewManager manager = new ViewManager(views);

        // add child views to the parent container

        views.add(new LoginView(manager), LOGIN_VIEW);
        views.add(new WorkerView(manager), WORKER_VIEW);
        views.add(new SupervisorView(manager), SUPERVISOR_VIEW);
        views.add(new ScheduleView(manager), SCHEDULE_VIEW);
        // configure the application frame
//        SCHEDULE_VIEW
        this.add(views);
        this.setBounds(100, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    /*
     * Program execution begins here.
     * 
     * @param args
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ShiftScheduler().init();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
