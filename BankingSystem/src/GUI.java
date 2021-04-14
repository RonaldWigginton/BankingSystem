import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

//Written by Cassidy Edson
public class GUI extends JPanel {
    JFrame gui = new JFrame("Banking System");
    FlowLayout flow = new FlowLayout(FlowLayout.CENTER);

    //General use
    JPanel navigation = new JPanel(new GridLayout(1, 2, 5, 5));
    Border margin = new EmptyBorder(10, 10, 10, 10);
    JButton home = new JButton("Home");
    JButton exit = new JButton("Exit");
    JComboBox<String> accountsDropDown = new JComboBox();
    JButton withdrawButton = new JButton("Withdraw");
    JButton depositButton = new JButton("Deposit");
    JButton balanceInquiry = new JButton("Balance");

    //Sign In
    JPanel signInLayout = new JPanel(new BorderLayout(5, 5));
    JPanel signInInfo = new JPanel(new GridLayout(2, 2, 5, 5));
    JLabel userNameLabel = new JLabel("User Name");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JButton signInSubmitButton = new JButton("Submit");

    //Atm sign in
    JPanel atmSignInLayout = new JPanel(new BorderLayout(5, 5));
    JPanel enteringPin = new JPanel(new GridLayout(1, 2, 5, 5));
    JLabel pinLabel = new JLabel("Enter pin:");
    JTextField pinTextField = new JTextField();
    JButton enter = new JButton("Enter");

    //Atm withdraw/deposit
    JPanel atmLayout = new JPanel(new BorderLayout(5, 5));
    JPanel atmChooseAccount = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel atmActions = new JPanel(new GridLayout(1, 3, 5, 5));
    JLabel chooseAccount = new JLabel("Choose account:");

    //Accounts
    JPanel accountsLayout = new JPanel(new BorderLayout(5, 5));
    JPanel accounts = new JPanel(new GridLayout(2, 2, 5, 5));
    String[] exampleAccounts = new String[] {"savings 1", "savings 2"};
    String[] exChecking = new String[] {"checking 1", "checking 2"};
    JComboBox savingsAccounts = new JComboBox(exampleAccounts);
    JComboBox checkingAccounts = new JComboBox(exChecking);
    JLabel savings = new JLabel("Savings Accounts:");
    JLabel checking = new JLabel("Checking Accounts:");

    //Creating accounts
    String[] accountTypesArray = new String[] {"Savings", "Checking"};
    JPanel createNewAccountLayout = new JPanel(new BorderLayout(5, 5));
    JPanel enterAccountInfo = new JPanel(new GridLayout(8, 2, 5, 5));
    JComboBox accountType = new JComboBox(accountTypesArray);
    JLabel firstNameLabel = new JLabel("First name:");
    JTextField firstNameText = new JTextField();
    JLabel lastNameLabel = new JLabel("Last name:");
    JTextField lastNameText = new JTextField();
    JLabel ssnLabel = new JLabel("SSN:");
    JTextField ssnText = new JTextField();
    JLabel streetAddressLabel = new JLabel("Street Address");
    JTextField streetAddressText = new JTextField();
    JLabel cityLabel = new JLabel("City:");
    JTextField cityText = new JTextField();
    JLabel stateLabel = new JLabel("State:");
    JTextField stateText = new JTextField();
    JLabel zipLabel = new JLabel("Zip:");
    JTextField zipText = new JTextField();

    JButton submitAccount = new JButton("Submit");
int x = 5;
    //Teller
    JPanel tellerLayout = new JPanel(new BorderLayout(5, 5));
    JPanel enterAccountID = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel accountInfo = new JPanel(new GridLayout(3, 2, 5, 5));
    JPanel tellerButtonsTop = new JPanel(new GridLayout(1, 3, 5, 5));
    JPanel tellerButtonsBottom = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel tellerButtons = new JPanel(new GridLayout(2, 1, 5, 5));
    JLabel accountIDLabel = new JLabel("Account id:");
    JTextField accountIDText = new JTextField();
    JLabel balanceLabel = new JLabel("Balance: " + x);
    JLabel recentDebitsLabel = new JLabel("Recent Debits: ");
    JLabel accountStatusLabel = new JLabel(" Account status: ");
    JButton transferButton = new JButton("Transfer");
    JButton deleteButton = new JButton("Delete Account");
    JButton createNewButton = new JButton("Create New Account");
    JButton withdrawTellerButton = new JButton("Withdraw");
    JButton depositTellerButton = new JButton("Deposit");

    //TEST...............................................
    JLabel customerIDLabelTeller = new JLabel("Customer ID:");
    String[] test = new String[] {"Account 1", "Account 2", "Account 3"};
    JList<String> tellerAccountList = new JList<>(test);
    JPanel tellerAccounts = new JPanel(new GridLayout(1, 1, 15, 15));

    //Manager
    JPanel managerLayout = new JPanel(new BorderLayout(5, 5));
    JLabel customerIDLabel = new  JLabel("Customer ID:");
    JLabel accountBalanceLabel = new JLabel("Account balance:");
    JLabel currentInterestRateLabel = new JLabel("Current interest rate:");
    JLabel dateOpenedLabel = new JLabel("Date opened:");
    JLabel accountTypeLabel = new JLabel("Account type:");
    JLabel backupAccountLabel = new JLabel("Backup account:");
    JLabel overdraftsLabel = new JLabel("Overdrafts:");
    JLabel dueDateLabel = new JLabel("Due date:");
    JButton billingProcessButton = new JButton("Initiate Billing");
    JButton setInterestRatesButton = new JButton("Set Interest");
    JButton creditButton = new JButton("Credit");
    JButton debitButton = new JButton("Debit");

    //Start
    JPanel startLayout = new JPanel();
    JButton atmButton = new JButton("ATM");
    JButton signInButton = new JButton("Sign In");


    GUI() {
        gui.setSize(500, 300);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Start
        startLayout.add(atmButton);
        startLayout.add(signInButton);

        //Takes user to customer atm interface
        atmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gui.getContentPane().removeAll();
                gui.add(atmSignInLayout);
                gui.revalidate();
                gui.repaint();
            }
        });

        //Takes user to sign in screen - this will show if the user is a teller or manager
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gui.getContentPane().removeAll();
                gui.add(signInLayout);
                gui.revalidate();
                gui.repaint();
            }
        });

        //Sign In
        signInInfo.add(userNameLabel);
        signInInfo.add(userNameText);
        signInInfo.add(passwordLabel);
        signInInfo.add(passwordText);
        signInLayout.add(signInInfo, BorderLayout.NORTH);
        signInLayout.add(signInSubmitButton, BorderLayout.SOUTH);

        Border signInBorder = new TitledBorder("Sign In");
        signInLayout.setBorder(new CompoundBorder(signInBorder, margin));

        signInSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String username = userNameText.getText();
                String password = passwordText.getText();
                if(username.equals("teller") && password.equals("teller")) {
                    gui.getContentPane().removeAll();
                    gui.add(tellerLayout);
                    gui.revalidate();
                    gui.repaint();
                }
            }
        });

        //Teller
        enterAccountID.add(customerIDLabel);
        customerIDLabel.setHorizontalAlignment(JLabel.RIGHT);
        enterAccountID.add(accountIDText);
        accountIDText.setHorizontalAlignment(JTextField.LEFT);
        accountInfo.add(balanceLabel);
        balanceLabel.setHorizontalAlignment(JLabel.LEFT);
        accountInfo.add(recentDebitsLabel);
        recentDebitsLabel.setHorizontalAlignment(JLabel.LEFT);
        accountInfo.add(accountStatusLabel);
        accountStatusLabel.setHorizontalAlignment(JLabel.LEFT);
        tellerButtonsTop.add(withdrawTellerButton);
        tellerButtonsTop.add(depositTellerButton);
        tellerButtonsTop.add(transferButton);
        tellerButtonsBottom.add(deleteButton);
        tellerButtonsBottom.add(createNewButton);
        tellerButtons.add(tellerButtonsTop);
        tellerButtons.add(tellerButtonsBottom);
        tellerAccounts.add(tellerAccountList);
        tellerAccounts.setBorder(new TitledBorder(""));
        tellerLayout.add(enterAccountID, BorderLayout.NORTH);
        tellerLayout.add(tellerAccounts, BorderLayout.WEST);
        tellerLayout.add(accountInfo, BorderLayout.CENTER);
        tellerLayout.add(tellerButtons, BorderLayout.SOUTH);

        accountInfo.setBorder(new TitledBorder(""));
        Border tellerBorder = new TitledBorder("Accounts");
        tellerLayout.setBorder(new CompoundBorder(tellerBorder, margin));

        depositTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int depositedAmount = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String depositAmount = JOptionPane.showInputDialog(gui, "Deposit Amount", "Deposit", JOptionPane.QUESTION_MESSAGE);
                        if (depositAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (depositAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            depositedAmount = Integer.parseInt(depositAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
                System.out.println(depositedAmount);
            }
        });

        withdrawTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int depositedAmount = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String depositAmount = JOptionPane.showInputDialog(gui, "Deposit Amount", "Deposit", JOptionPane.QUESTION_MESSAGE);
                        if (depositAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (depositAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            depositedAmount = Integer.parseInt(depositAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
                System.out.println(depositedAmount);
            }
        });

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int deleteConfirm = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(gui, "Are you sure you want to delete this account?", "Delete Account", deleteConfirm);
                if(deleteConfirm == JOptionPane.YES_OPTION) {
                    //Delete account
                }
            }
        });

        //Takes teller to new screen to input information on new customer and accounts
        createNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    gui.getContentPane().removeAll();
                    gui.add(createNewAccountLayout);
                    gui.revalidate();
                    gui.repaint();
            }
        });

        //Create new account
        enterAccountInfo.add(firstNameLabel);
        enterAccountInfo.add(firstNameText);
        enterAccountInfo.add(lastNameLabel);
        enterAccountInfo.add(lastNameText);
        enterAccountInfo.add(ssnLabel);
        enterAccountInfo.add(ssnText);
        enterAccountInfo.add(streetAddressLabel);
        enterAccountInfo.add(streetAddressText);
        enterAccountInfo.add(cityLabel);
        enterAccountInfo.add(cityText);
        enterAccountInfo.add(stateLabel);
        enterAccountInfo.add(stateText);
        enterAccountInfo.add(zipLabel);
        enterAccountInfo.add(zipText);
        createNewAccountLayout.add(accountType, BorderLayout.NORTH);
        createNewAccountLayout.add(enterAccountInfo, BorderLayout.CENTER);
        createNewAccountLayout.add(submitAccount, BorderLayout.SOUTH);

        Border createAccountBorder = new TitledBorder("Create Account");
        createNewAccountLayout.setBorder(new CompoundBorder(createAccountBorder, margin));

        //Transaction
        JPanel transactionLayout = new JPanel();

        //Atm sign in
        enteringPin.add(pinLabel);
        enteringPin.add(pinTextField);
        atmSignInLayout.add(enteringPin, BorderLayout.NORTH);
        atmSignInLayout.add(enter, BorderLayout.SOUTH);

        //Takes user to screen where they can choose from their accounts .................testing pin with 1234
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String pinNumber = pinTextField.getText();
                if(pinNumber.equals("1234")) {
                    gui.getContentPane().removeAll();
                    gui.add(atmLayout);
                    gui.revalidate();
                    gui.repaint();
                }
            }
        });

        //Atm withdraw/deposit
        atmChooseAccount.add(chooseAccount);
        atmChooseAccount.add(accountsDropDown);
        atmActions.add(withdrawButton);
        atmActions.add(depositButton);
        atmActions.add(balanceInquiry);
        atmLayout.add(atmChooseAccount, BorderLayout.NORTH);
        atmLayout.add(atmActions, BorderLayout.SOUTH);

        Border atmBorder = new TitledBorder("Atm");
        atmLayout.setBorder(new CompoundBorder(atmBorder, margin));

        atmSignInLayout.setBorder(new CompoundBorder(atmBorder, margin));

        //Accounts
        accounts.add(savings);
        accounts.add(savingsAccounts);
        accounts.add(checking);
        accounts.add(checkingAccounts);
        navigation.add(home);
        navigation.add(exit);
        accountsLayout.add(accounts, BorderLayout.NORTH);
        accountsLayout.add(navigation, BorderLayout.SOUTH);

        Border accountsBorder = new TitledBorder("Accounts");
        accountsLayout.setBorder(new CompoundBorder(accountsBorder, margin));

        //Gets amount to be withdrawn when withdraw button is clicked
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int withdrawnAmount = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String withdrawAmount = JOptionPane.showInputDialog(gui, "Withdraw Amount", "Withdraw", JOptionPane.QUESTION_MESSAGE);
                        if (withdrawAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (withdrawAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            withdrawnAmount = Integer.parseInt(withdrawAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) { //Break look if user hits ok without any input
                        System.out.println("no input");
                        break;
                    }
                }
                System.out.println(withdrawnAmount);
            }
        });

        //Gets amount to be deposited when deposit button is clicked
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int depositedAmount = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String depositAmount = JOptionPane.showInputDialog(gui, "Deposit Amount", "Deposit", JOptionPane.QUESTION_MESSAGE);
                        if (depositAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (depositAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            depositedAmount = Integer.parseInt(depositAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
                System.out.println(depositedAmount);
            }
        });

        balanceInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Pull in balance based on account chosen.......................................................
               JOptionPane.showMessageDialog(gui, "Account: " + "\nBalance:", "Balance", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        gui.setLayout(flow);
        //Change this to where you want to GUI to start from
        gui.add(atmLayout);
        gui.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
