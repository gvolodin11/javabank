package Banking_system;

import static Banking_system.Acc_owner.accountArray;

public class Account  {

    private String username;
    private String password;
    private int userID;

    private static double acc_balance = 0;
    public String acc_number;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    //_______________________________BALANCE_____________________________

    // феликс сказал гетбаланс не надо

    public double getAcc_balance() {
        return acc_balance;
    }

    public void setAcc_balance(double acc_balance) {   // проверить бабки
        Account.acc_balance = acc_balance;
    }

    //_______________________________ACC_NUMBER_____________________________


    Account(String acc_number) {
        this.acc_number = acc_number;
    }

    public String getAcc_number() {
        return this.acc_number;
    }

    public Account getAccount(int position) {   //
        return accountArray.get(position);   // arrayList из класса банк
    }

    // PAYMENTS
    public static void deposit(double amount) {
        Account.acc_balance += amount;
    }

    public static void cashout(double amount) {
        Account.acc_balance -= amount;
    }

}
