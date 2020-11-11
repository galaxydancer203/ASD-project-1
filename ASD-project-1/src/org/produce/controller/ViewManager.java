package org.produce.controller;
import org.produce.ShiftScheduler;
import org.produce.model.User;
import org.produce.view.LoginView;
import org.produce.view.SupervisorView;
import org.produce.view.WorkerView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ViewManager {
    JFrame frame  = new JFrame();
    JPanel panel = new JPanel();
    private Container views;
    private User activeUser;

    public ViewManager(Container views) {
        this.views = views;
        this.activeUser = null;
    }

    public void switchTo(String view) {
        ((CardLayout) views.getLayout()).show(views, view);
    }
    
    public void login(String accountNumber, char[] pin) {
        LoginView lv = ((LoginView) views.getComponents()[ShiftScheduler.LOGIN_VIEW_INDEX]);

        try {
            activeUser = ShiftScheduler.lookupUser(Long.valueOf(accountNumber), Integer.valueOf(new String(pin)));

            if (activeUser == null) {
                lv.toggleErrorMessage(true);
            } else {
                if (activeUser.isSupervisor() == true) {
                    ((SupervisorView) views.getComponents()[ShiftScheduler.SUPERVISOR_VIEW_INDEX]).populate(activeUser);
                    switchTo(ShiftScheduler.SUPERVISOR_VIEW);
                    lv.clear();
                } else {
                    ((WorkerView) views.getComponents()[ShiftScheduler.WORKER_VIEW_INDEX]).populate(activeUser);
                    switchTo(ShiftScheduler.WORKER_VIEW);
                    lv.clear();

                }
            }
        } catch (NumberFormatException e) {
            lv.toggleErrorMessage(true);
        }
    }

    public void setmondayshift(int theshift) {
        activeUser.setmondayshift(theshift);
    }
    public void settuesdayshift(int theshift) {
        activeUser.settuesdayshift(theshift);
    }
    public void setwednesdayshift(int theshift) {
        activeUser.setwednesdayshift(theshift);
    }
    public void setthursdayshift(int theshift) {
        activeUser.setthursdayshift(theshift);
    }
    public void setfridayshift(int theshift) {
        activeUser.setfridayshift(theshift);
    }

    public void logout() {

        switchTo(ShiftScheduler.LOGIN_VIEW);

        activeUser = null;

    }
    public void viewschedule() {

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Walva SuperStore Shift Schedule", TitledBorder.CENTER, TitledBorder.TOP));

        String[] header = { "Shift 1", "Shift 2", "Shift 3" };
        JTable table = new JTable(ShiftScheduler.theschedule, header);
        panel.add(new JScrollPane(table));
        frame.add(panel);
        frame.setSize(550, 200);
        frame.setVisible(true);
        activeUser = null;
    }
}
