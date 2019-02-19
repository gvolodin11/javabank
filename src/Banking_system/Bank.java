package Banking_system;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {

    static public ArrayList<Acc_owner> usersArray = new ArrayList();
    static public ArrayList<Account> accountArray = new ArrayList();
    Scanner in = new Scanner(System.in);


    public Acc_owner getUser(int position) {
        return usersArray.get(position);
    }

    public int searchAcc(String username) {
        for (int i = 0; i < usersArray.size(); i++) {
            if (usersArray.get(i).getUsername() == username) {
                return i;
            }
        }
        throw new RuntimeException("Not found");
    }



    public void getList() {
        for (int i = 0; i < usersArray.size(); i++)
            System.out.println("\nYour" + i + "object in array: " + Bank.usersArray.get(i) + "\n");
    }

    // ADD / DROP

    public void addAccount(String username, String password, int id) {
        Acc_owner user = new Acc_owner(username, password, id);

        System.out.println("\nYour username is: " + username + "\nYour password is: " + password);

        usersArray.add(user);
    }

    public void addAccountNum(Acc_owner user) {
        String accNumber = "";
        for (int i = 0; i < 17; i++) {
            Random rand = new Random();
            int num = rand.nextInt(10);
            accNumber += String.valueOf(num);
        }
//        for (Acc_owner owner : Bank.usersArray) {   addddddd
            for (Account acc : accountArray) {
                if (acc.acc_number.equals(accNumber)) {
                    System.out.println("\nNumber exists.");
                    return;
                }
            }
//        }

        Account acount = new Account(accNumber);
        acount.acc_number = accNumber;
        acount.setUserID(user.getID());
        System.out.println("\nAdded account, your account number: " + accNumber + "\n User id = " + acount.getUserID());
    }

    public void dropAccount(String username) {
        for (int i = 0; i < usersArray.size(); i++) {
            if (usersArray.get(i).getUsername().equals(username)) {
                usersArray.remove(i);
            }
        }
        System.out.println("\nAccount deleted.");
    }

    public void dropAccountNum(String number1) {
        for (int i = 0; i < accountArray.size(); i++) {
            if (Acc_owner.accountArray.get(i).getAcc_number().equals(number1)) {
                accountArray.remove(i);
            }
        }
        System.out.println("\nAccount number deleted.");
    }

    // logIn / logOut / ChangePass

    public void logIn(String username, String password) {
        for (Acc_owner owner : Bank.usersArray) {
            if (owner.getUsername().equals(username) && owner.getPassword().equals(password)) {
                System.out.println("\nRegistered.");
            } else {
                System.out.println("\nNot registered.");
            }
        }
    }

    public void logOut(String usename) {
        for (Acc_owner owner : Bank.usersArray) {
            if (!owner.getUsername().equals(usename)) {
                System.out.println("\nLogout");
                owner.status = Status.not_registered;
            }
        }
    }

    public void changePass(String username, String oldPassword, String newPassword) {
        for (Acc_owner owner : Bank.usersArray)
            if (owner.getUsername().equals(username) && oldPassword.equals(owner.getPassword())) {
                if (!newPassword.equals(oldPassword)) {
                    owner.setPassword(newPassword);
                    System.out.println("\nPassword changed.");
                    System.out.println("\nNew password: " + owner.getPassword());
                }
            } else {
                System.out.println("\nPassword is not changed.");
            }
    }

    public void getNumber(int i, int j) {
        System.out.println("Account number : " + Bank.usersArray.get(i).getAccount(j) + "\n");
    }

    public void getAcc_balance(int i, int j) {
        System.out.println("Your balance : " + Bank.usersArray.get(i).getAccount(j).getAcc_balance() + "\n");
    }

    public void getName(int i) {
        System.out.println("Name : " + Bank.usersArray.get(i).getUsername() + "\n");
    }

    // Transaction

    public void deposit(double amount, String acc_number) {
        for (int i = 0; i < usersArray.size(); i++) {
            for (Account acc : accountArray) {
                if (usersArray.get(i).getAccount(i).acc_number.equals(acc_number)) { // ++++++++++ как и кэшаут
                    acc.deposit(amount);
                }
            }
        }
    }

    public void cashout(double amount, String acc_number) {
        for (int i = 0; i < usersArray.size(); i++) {
            for (Account acc : accountArray) {
                if (usersArray.get(i).getAccount(i).acc_number.equals(acc_number)) { // попробовать getbalance
                    acc.cashout(amount);
                }
            }
        }
    }

    public void transfer(String to, double amount, String acc_number) {
        for (Acc_owner owner : usersArray) {
            Account from = owner.searchAcc(acc_number);
            double fromBalance = from.getAcc_balance();
            fromBalance -= amount;
            from.setAcc_balance(fromBalance);
        }
        for (Acc_owner toOwner : usersArray) {
            Account toAcc = toOwner.searchAcc(to);
            double fromBalance = toAcc.getAcc_balance();
            fromBalance += amount;
            toAcc.setAcc_balance(fromBalance);
        }
    }
}
