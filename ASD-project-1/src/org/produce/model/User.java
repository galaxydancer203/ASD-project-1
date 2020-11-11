package org.produce.model;

public class User {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private Account account;
    private boolean supervisor;
    private int mondayshift;
    private int tuesdayshift;
    private int wednesdayshift;
    private int thursdayshift;
    private int fridayshift;


    public User(String firstName, String lastName, String emailAddress, long phoneNumber, boolean supervisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
this.supervisor = supervisor;
        this.account = new Account();
        this.mondayshift = 0;
        this.tuesdayshift = 0;
        this.wednesdayshift = 0;
        this.thursdayshift = 0;
        this.fridayshift = 0;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Account getAccount() {
        return account;
    }
    public boolean isSupervisor() {
        return supervisor;
    }
    public int getmondayshift() {
        return mondayshift;
    }
    public int gettuesdayshift() {
        return tuesdayshift;
    }
    public int getwednesdayshift() {
        return wednesdayshift;
    }
    public int getthursdayshift() {
        return thursdayshift;
    }
    public int getfridayshift() {
        return fridayshift;
    }

    public void setmondayshift(int theshift) {
        mondayshift = theshift;
    }
    public void settuesdayshift(int theshift) {
        tuesdayshift = theshift;
    }
    public void setwednesdayshift(int theshift) {
        wednesdayshift = theshift;
    }
    public void setthursdayshift(int theshift) {
        thursdayshift = theshift;
    }
    public void setfridayshift(int theshift) {
        fridayshift = theshift;
    }
}
