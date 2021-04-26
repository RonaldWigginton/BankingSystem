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


public class Database { // This is our Banking System Database
    // Load User Data
    public static List<User> GetUserData(){
        // Changed for Windows bc not everyone uses linux bc linux is actually not that cool when you think about it.
        File file = new File("BankingSystem\\src\\Database\\customers.txt");
        var UserAccounts = new ArrayList<User>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] chunks = line.split(",");
                UserAccounts.add(new CustomerATM(Integer.parseInt(chunks[0]), chunks[1], chunks[2], chunks[3], Integer.parseInt(chunks[4]), chunks[5], chunks[6]));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return UserAccounts;
    }

    // Load Checking Acct Data
    public static List<Account> GetCheckingData(){
        File checkingFile = new File("BankingSystem\\src\\Database\\checkingAccounts.txt");
        var checkingAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(checkingFile)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] chunks = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                checkingAccounts.add(new CheckingAccount(Integer.parseInt(chunks[0]), Integer.parseInt(chunks[1]),
                        chunks[2], Double.parseDouble(chunks[3]), Integer.parseInt(chunks[4]), Integer.parseInt(chunks[5]),
                        Integer.parseInt(chunks[6]),formatter.parse(chunks[7])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return checkingAccounts;
    }
    // Load Loan Acct Data
     public static  List<Account> GetLoanData(){
        File loanFile = new File("BankingSystem\\src\\Database\\loanAccounts.txt");
        var loanAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(loanFile)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] chunks = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                loanAccounts.add(new LoanAccount(Integer.parseInt(chunks[0]),
                        Double.parseDouble(chunks[1]), Double.parseDouble(chunks[2]), formatter.parse(chunks[3]),
                        formatter.parse(chunks[4]), Double.parseDouble(chunks[5]), chunks[6],
                        Integer.parseInt(chunks[7])==1, formatter.parse(chunks[8])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return loanAccounts;
    }
    // Load Savings Actt Data
     public static List<Account> GetSavingData(){
        File savingFile = new File("BankingSystem\\src\\Database\\savingsAccounts.txt");
        var savingAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(savingFile)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] chunks = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                savingAccounts.add(new SavingsAccount(Integer.parseInt(chunks[0]), Integer.parseInt(chunks[1]),
                                                       Double.parseDouble(chunks[2]), Double.parseDouble(chunks[3]),
                                                       formatter.parse(chunks[4])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return savingAccounts;
    }

    // Save Customer Data
    public static void SaveUserData(List<User> users)throws IOException {
        File userFile = new File("BankingSystem\\src\\Database\\customers1.txt");
        FileWriter writer = new FileWriter(userFile);
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
// We can save whatever accounts 
 public static void SaveAccountData(List<Account> accounts)throws IOException {
    File file = new File("");
    System.out.println("Debug");
    ArrayList<String[]> loanRecords = new ArrayList<String[]>();
    ArrayList<String[]> savingRecords = new ArrayList<String[]>();
    ArrayList<String[]> CheckingRecords = new ArrayList<String[]>();
    for (Account account : accounts) {
        if(account instanceof LoanAccount){
            loanRecords.add(account.accountToArray());
        }
        else if (account instanceof SavingsAccount){
            savingRecords.add(account.accountToArray());
        }
        else if (account instanceof CheckingAccount){
            CheckingRecords.add(account.accountToArray());
        }
    }
    file = new File("BankingSystem\\src\\Database\\loanAccounts1.txt");
    FileWriter writer = new FileWriter(file);

    for(var record : loanRecords)
    {
        writer.append(String.join(",",record));
        writer.append("\n");
    }
    writer.flush();
    writer.close();

    file = new File("BankingSystem\\src\\Database\\savingsAccounts1.txt");
    writer = new FileWriter(file);

    for(var record : savingRecords)
    {
        writer.append(String.join(",",record));
        writer.append("\n");
    }
        writer.flush();
        writer.close();
        
        file = new File("BankingSystem\\src\\Database\\checkingAccounts1.txt");
        writer = new FileWriter(file);

        for(var record : CheckingRecords)
        {
            writer.append(String.join(",",record));
            writer.append("\n");
        }
        writer.flush();
        writer.close();
        
        file = new File("BankingSystem\\src\\Database\\savingsAccounts1.txt");
        writer = new FileWriter(file);

        for(var record : savingRecords)
        {
            writer.append(String.join(",",record));
            writer.append("\n");
        }
    
    writer.flush();
    writer.close();
    }
}
