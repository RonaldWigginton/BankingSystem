import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;        
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Accounts.Customer;
import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.LoanAccount;
import Accounts.SavingsAccounts;


public class Main { // This is our Banking System
    
    public static void main(String[] args) throws Exception {

       static List<Account> customerList = new ArrayList<>();
       static List<Account> loanAccounts= new ArrayList<>();
       static List<Account> checkingAccounts=new ArrayList<>();
       static List<Account> savingAccounts=new ArrayList<>();

       static String[] accountTypes={"none","Savings","CD","TMB","Gold/Diamond","Short Term","Long Term","Credit Card"};

        File loanFile = new File("Database/loanAccounts.txt");
        File checkingFile = new File("../bankingSystem/Database/checkingAccounts.txt");
        File savingFile = new File("../bankingSystem/Database/savingAccounts.txt");
        File customerFile = new File("../bankingSystem/Database/customers.txt");

       
        // load accounts into given arraylists
        loanAccounts = GetLoanData(loanFile);
        checkingAccounts = GetCheckingData(checkingFile);
        savingAccounts = GetSavingData(savingFile);
        customerList= GetCustomerData(customerFile);

        // Add our accounts to a accountlist
        accountList.addAll(loanAccounts);
        accountList.addAll(checkingAccounts);
        accountList.addAll(savingAccounts);

        GUI Menu = new GUi();
        



        // If we need to Save we must filter our account array list first

        FilterAccounts(accountList);
        SaveAccountData(loanFile,loanAccounts);
        SaveAccountData(checkingFile,checkingAccounts);
        SaveAccountData(savingFile,savingAccounts);
        SaveCustomerData(customerFile,customerList);

       

    } // End of main 


    // Loading from Database
    public static void LoadData(){
         GetCustomerData(customerFile);
         GetCheckingData(checkingFile);
         GetSavingData(savingFile);
         GetLoanData(loanFile);
    }
    // Load Customer Data
     public static List<Customer> GetCustomerData(File file){
        var Customers = new ArrayList<User>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                Customers.add(new Customer(Integer.parseInt(items[0]), items[1], items[2], items[3], Integer.parseInt(items[4]), items[5], items[6]));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return Customers;
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

                savingAccounts.add(new SavingAccount(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
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
    public static void SaveCustomerData(File file, List<Customer> customers)throws IOException {
        
        FileWriter writer = new FileWriter(file);
        ArrayList<String[]> records = new ArrayList<String[]>();

        for(var cust : customers)
        {
            records.add(Customer.accountToArray());
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
     public static void FilterAccounts(List<Account> accounts)throws IOException {
        
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
        }
}
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
            writer.append(String.join(",", record));
            writer.append("\n");
        }

        writer.flush();
        writer.close();
}
