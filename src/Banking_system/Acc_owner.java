package Banking_system;

import java.util.ArrayList;
import java.util.Scanner;

enum Status {registered, not_registered}

public class Acc_owner {

    Scanner in = new Scanner(System.in);
    private String username;
    private String password;
    private int ID;
    Status status = Status.not_registered;

    static public ArrayList<Account> accountArray = new ArrayList();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getAccount(int position) {
        return accountArray.get(position);   // arrayList из класса банк
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = status;
    }


    Acc_owner(String username, String password, int id) {
        this.password = password;
        this.username = username;
        this.ID = id;
    }

    public void numOfAcc() {
        System.out.println("You have" + accountArray.size() + " accounts in our Bank");
    }

    public void logIn(String username, String password) {
        if (getUsername() == username && getPassword() == password) {
            System.out.println("Registered. ");
            status = Status.registered;
        } else {
            System.out.println("Not registered. ");
        }
    }

    public void logOut() {
        status = Status.not_registered;
        System.out.println("Logout");
    }

    public void changePassword() {
        if (status == Status.registered) {
            System.out.println("\nEnter old password : ");
            String oldPassword = in.nextLine();
            if (oldPassword.equals(getPassword())) {
                System.out.println("\nEnter new password : ");
                String newPassword = in.nextLine();
                if (!newPassword.equals(oldPassword)) {
                    this.password = newPassword;
                    System.out.println("\nYour password changed. ");
                    System.out.println("New password :" + newPassword);
                }
            } else {
                System.out.println("\nPassword is not changed. ");
            }
        }
    }

    public Account searchAcc(String acc_number) {
        for (int i = 0; i < accountArray.size(); i++) {
            if (accountArray.get(i).getAcc_number().equals(acc_number)) {
                //возвращаем обьект Account
                return accountArray.get(i);
            }    //    попробовать не через return
        }
        throw new RuntimeException("Not found");  //  если вышло за границы
    }

    public void deposit(double amount, String acc_number) {
        if (status == Status.registered) {
            for (Account acc : accountArray) {
                if (acc.acc_number.equals(acc_number)) {
                    Account.deposit(amount);
                }
            }
        }
    }

    public void cashout(double amount, String acc_number) {
        if (status == Status.registered) {
            for (Account acc : accountArray) {
                if (acc.acc_number.equals(acc_number)) {
                    Account.deposit(amount);
                }
            }
        }
    }

    static public void transfer(String to, double amount) {
        //for (UsersArray users : Bank.usersArray) {
        for (Account toAccount : Acc_owner.accountArray) {
            if (toAccount.getAcc_number().equals(to)) {
                double balance = toAccount.getAcc_balance();
                balance += amount;
                toAccount.setAcc_balance(balance);
            }
        }
    }


}
