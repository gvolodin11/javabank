package Banking_system;

import java.util.Random;
import java.util.Scanner;

import static Banking_system.Bank.usersArray;
import static Banking_system.Acc_owner.accountArray;

public class Bank_employee {

    Scanner in = new Scanner(System.in);

    private String username;
    private String password;

    Bank_employee() {
    }

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

    public void getView() {
        System.out.println("Username : ");
        String user = in.nextLine();
        this.setUsername(user);
        System.out.println("\nPassword :");
        String pass = in.nextLine();
        this.setPassword(pass);
    }

    /*public void checkLogIn() {
        System.out.println("Your username is: " + this.username + "\nYour password is: " + this.password);
    }*/

    //----------------------------Методы работают только вместе с другими классами----------------------------------------
    public void logIn() {
        if (this.username == username && this.password == password) {
            System.out.println("\nRegistered.");
        } else {
            System.out.println("\nNot registered. ");
        }

    }

    public void logOut() {

        System.out.println("\nLogout");
    }


    public void changePass() {
        System.out.println("\nEnter old password : ");
        String oldPassword = in.nextLine();
        if (oldPassword.equals(getPassword())) {
            System.out.println("\nEnter new password : ");
            String newPassword = in.nextLine();
            if (!newPassword.equals(oldPassword)) {
                this.password = newPassword;
                System.out.println("\nPassword changed.");
                System.out.println("\nNew password: " + getPassword());
            }
        } else {
            System.out.println("\nPassword is not changed. ");
        }

    }

    //    посмотреть}
//                                                             проверить через гет/сет
    public Acc_owner addAccount(String username, String password, int id) {
        Acc_owner user = new Acc_owner(username, password, id); // название класса(Acc_owner)
        user.setUsername(username);
        user.setPassword(password);

        System.out.println("\nYour username is: " + username + "\nYour password is: " + password);
        Bank.usersArray.add(user);

        return user;
    }

    public void addAccountNum(Acc_owner user) {
        String accNumber = "";
        for (int i = 0; i<17; i++) {
            Random rand = new Random();
            int num = rand.nextInt(10);
            accNumber += String.valueOf(num);
        }
        for (Acc_owner owner : Bank.usersArray ) {
            for (Account acc : Acc_owner.accountArray) {
                if (!acc.acc_number.equals(accNumber)) {
                    acc.acc_number = accNumber;
                    break;
                }
            }
        }
        Account acount = new Account(accNumber);
            user.accountArray.add(acount);
            System.out.println("\nAdded account, your account number: " + accNumber + "\n");
    }

    public void dropAccount(String username) {
        for (int i = 0; i < usersArray.size(); i++){
            if (Bank.usersArray.get(i).getUsername().equals(username)) {
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

    public void getlist() {
        for (int i = 0; i < usersArray.size(); i++) {
            System.out.println("\nYour" + i + " object in array: " + Bank.usersArray.get(i) + "\n");
        }
    }

}

