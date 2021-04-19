import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.CustomerATM;
import Accounts.LoanAccount;
import Accounts.SavingsAccount;
import Accounts.User;


public class Main { // This is our Banking System
    
    public static void main(String[] args) throws Exception {

        List<Account> accountList = new ArrayList<>();
         List<User> userList = new ArrayList<>();
         List<Account> loanAccounts= new ArrayList<>();
         List<Account> checkingAccounts=new ArrayList<>();
         List<Account> savingAccounts=new ArrayList<>();


        File loanFile = new File("src/Database/loanAccounts.txt");
        File checkingFile = new File("src/Database/checkingAccounts.txt");
        File savingFile = new File("src/Database/savingsAccounts.txt");
        File userFile = new File("src/Database/customers.txt");

       
        // load accounts into given arraylists
        loanAccounts = GetLoanData(loanFile);
        checkingAccounts = GetCheckingData(checkingFile);
        savingAccounts = GetSavingData(savingFile);
        userList = GetUserData(userFile);
     

        // Add our accounts to a accountlist
        accountList.addAll(loanAccounts);
        accountList.addAll(checkingAccounts);
        accountList.addAll(savingAccounts);

        GUI Menu = new GUI();
        



        // If we need to Save we must filter our account array list first

        SaveAccountData(loanFile,loanAccounts);
        SaveAccountData(checkingFile,checkingAccounts);
        SaveAccountData(savingFile,savingAccounts);
        SaveUserData(userFile,userList);

       

    } // End of main 
    // Load User Data
    public static List<User> GetUserData(File file){
        var UserAccounts = new ArrayList<User>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                UserAccounts.add(new CustomerATM(Integer.parseInt(items[0]), items[1], items[2], items[3], Integer.parseInt(items[4]), items[5], items[6]));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return UserAccounts;
    }

    // Load Checking Acct Data
    public static List<Account> GetCheckingData(File file){
        var checkingAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                checkingAccounts.add(new CheckingAccount(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                        items[2], Double.parseDouble(items[3]), Integer.parseInt(items[4]), Integer.parseInt(items[5]),
                        Integer.parseInt(items[6]),formatter.parse(items[7])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return checkingAccounts;
    }
    // Load Loan Acct Data
     public static  List<Account> GetLoanData(File file){
        var loanAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                loanAccounts.add(new LoanAccount(Integer.parseInt(items[0]),
                        Double.parseDouble(items[1]), Double.parseDouble(items[2]), formatter.parse(items[3]),
                        formatter.parse(items[4]), Double.parseDouble(items[5]), items[6],
                        Integer.parseInt(items[7])==1, formatter.parse(items[8])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return loanAccounts;
    }
    // Load Savings Actt Data
     public static List<Account> GetSavingData(File file){
        var savingAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                savingAccounts.add(new SavingsAccount(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                                                       Double.parseDouble(items[2]), Double.parseDouble(items[3]),
                                                       formatter.parse(items[4])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return savingAccounts;
    }

    // Save Customer Data
    public static void SaveUserData(File file, List<User> users)throws IOException {
        
        FileWriter writer = new FileWriter(file);
        ArrayList<String[]> records = new ArrayList<String[]>();

        for(var auser : users)
        {
            records.add(auser.accountToArray());
        }

        for(var record : records)
        {
            writer.append(String.join(",", record));
            writer.append("\n");
        }

        writer.flush();
        writer.close(); 
    }

    // Filter the accounts into before Saving Accounts
  /*    public static void FilterAccounts(List<Account> accounts)throws IOException {
        
        ArrayList<String[]> records = new ArrayList<String[]>();
        // sort the accounts
        for(var account : accounts)
        {
        if(account instanceof LoanAccount){
          if(!loanAccounts.contains(accounts)){
               loanAccounts.add(account);
          }
        }
        if(account instanceof CheckingAccount){
             if(!checkingAccounts.contains(accounts)){
                  checkingAccounts.add(account);
             }
        }
        if(account instanceof SavingAccount){
             if(!checkingAccounts.contains(accounts)){
                  checkingAccounts.add(account);
             }
          } 
        } */

// We can save whatever accounts we want whereever we want
 public static void SaveAccountData(File file,List<Account> accounts)throws IOException {
        
    FileWriter writer = new FileWriter(file);
    ArrayList<String[]> records = new ArrayList<String[]>();

    for(var account : accounts)
    {
        records.add(account.accountToArray());
    }

    for(var record : records)
    {
        writer.append(String.join(",",record));
        writer.append("\n");
    }

    writer.flush();
    writer.close();
    }
}
