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


public class Database { // This is our Banking System
    
/*     public static void Database(String[] args) throws Exception {

         List<User> userList = new ArrayList<>();
         List<Account> loanAccounts= new ArrayList<>();
         List<Account> checkingAccounts=new ArrayList<>();
         List<Account> savingAccounts=new ArrayList<>();

        
       
        File checkingFile = new File("./src/Database/checkingAccounts.txt");
        File savingFile = new File("./src/Database/savingsAccounts.txt");
        File userFile = new File("./src/Database/customers.txt");
       
        // load accounts into given arraylists
        loanAccounts = GetLoanData();
        checkingAccounts = GetCheckingData();
        savingAccounts = GetSavingData();
       // userList = GetUserData(userFile);
     
        // If we need to Save

       // SaveAccountData("loan",loanAccounts);




       
    } // End of Database  */
    // Load User Data
    public static List<User> GetUserData(){
        File file = new File("./src/Database/customers.txt");
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
        File checkingFile = new File("./src/Database/checkingAccounts.txt");
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
        File loanFile = new File("./src/Database/loanAccounts.txt");
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
        File savingFile = new File("./src/Database/savingsAccounts.txt");
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
        File userFile = new File("./src/Database/customers.txt");
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
// We can save whatever accounts we want whereever we want
 public static void SaveAccountData(String type,List<Account> accounts)throws IOException {
    File file = new File("./");
    System.out.println("Debug");
    switch(type.toLowerCase().trim()){
        case "loan":
            file = new File("./src/Database/loanAccounts.txt");
        case "saving" :
            file = new File("./src/Database/savingsAccounts.txt");
        case "checking" :
            file = new File("./src/Database/savingsAccounts.txt");
    }
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
