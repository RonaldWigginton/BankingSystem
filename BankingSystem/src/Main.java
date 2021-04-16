import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main { // This is our Banking System
    
    public static void main(String[] args) throws Exception {
        Customer[] Customers = new Customer[1000];


        // Show UI

        // Create a Customer for testing
        Customer cus = new Customer("Ronnie","Wigginton,", 0, 0, null, null, null, null, 911); 
        Customers[0] = cus;
        // Save a Customer 
        saveCustomers(Customers);

        Customers[1] = loadCustomers();

    } // End of main 














    public static Customer loadCustomers() // start of load Customers
    {
        try {
            
            FileInputStream fi = new FileInputStream(new File("Database/Customers.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read object(s) need to look at a loop structure for reading all objects.
            Customer customer = (Customer) oi.readObject();
            
            System.out.println(customer.toString());
            
            oi.close();
            fi.close();
            System.out.println("Customers Loaded");
            return customer;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    } //end of load of Customers 

    public static void saveCustomers(Customer[] Customers){ // Start of save customers 
        try {
            FileOutputStream f = new FileOutputStream(new File("Database/Customers.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            for (int i = 0; i < Customers.length; i++) {
                o.writeObject(Customers[i]);
            }

            o.close();
            f.close();
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        System.out.println("Customers Saved");
    } // end of save customers 
}
