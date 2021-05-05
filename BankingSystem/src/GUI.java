import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Accounts.*;
//Written by Cassidy Edson
public class GUI extends JPanel {
    JFrame gui = new JFrame("Banking System");
    FlowLayout flow = new FlowLayout(FlowLayout.CENTER);

    //Menu
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");

    JMenuItem start = new JMenuItem("Start");
    JMenuItem signIn = new JMenuItem("Sign In");

    //General use
    JPanel navigation = new JPanel(new GridLayout(1, 2, 5, 5));
    Border margin = new EmptyBorder(10, 10, 10, 10);
    JButton home = new JButton("Home");
    JButton exit = new JButton("Exit");
    JComboBox<String> accountsDropDown = new JComboBox();
    JButton withdrawButton = new JButton("Withdraw");
    JButton depositButton = new JButton("Deposit");
    JButton balanceInquiry = new JButton("Balance");

    //Sign In Components................................................................................................
    JPanel signInLayout = new JPanel(new BorderLayout(5, 5));
    JPanel signInInfo = new JPanel(new GridLayout(2, 2, 5, 5));
    JLabel userNameLabel = new JLabel("User Name");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JButton signInSubmitButton = new JButton("Submit");

    //Atm Sign In Components............................................................................................
    JPanel atmSignInLayout = new JPanel(new BorderLayout(5, 5));
    JPanel enteringPin = new JPanel(new GridLayout(1, 2, 5, 5));
    JLabel pinLabel = new JLabel("Enter ID:");
    JTextField pinTextField = new JTextField();
    JButton enter = new JButton("Enter");

    //Atm withdraw/deposit Components...................................................................................
    JPanel atmLayout = new JPanel(new BorderLayout(5, 5));
    JPanel atmChooseAccount = new JPanel(new GridLayout(1, 2, 5, 5));
    JPanel atmActions = new JPanel(new GridLayout(1, 3, 5, 5));
    JLabel chooseAccount = new JLabel("Choose account:");

    //Creating Accounts Components......................................................................................
    String[] accountTypesArray = new String[] {"Savings", "That's My Bank", "Gold/Diamond", "CD", "Long Term Loan", "Short Term Loan", "Credit Card Loan"};
    JPanel createNewAccountLayout = new JPanel(new BorderLayout(5, 5));
    JPanel creatingAccount = new JPanel(new GridLayout(2, 1, 5, 5));
    JPanel radioButtonsPanel = new JPanel();
    JPanel newAccountStarting = new JPanel(new GridLayout(2, 2, 5, 5));
    JPanel newAccountSouth = new JPanel(new GridLayout(2, 1, 5, 5));
    JComboBox accountType = new JComboBox(accountTypesArray);
    JRadioButton newCustomerRadio = new JRadioButton("New Customer");
    JRadioButton existingCustomerRadio = new JRadioButton("Existing Customer");
    JLabel startingBalanceLabel = new JLabel("Starting Balance:");
    JTextField startingBalanceText = new JTextField();

    //Creating Accounts - Existing Customer
    JPanel existingCustomer = new JPanel(new GridLayout(6, 2, 5, 5));
    JLabel existingCustomerIDLabel = new JLabel("Customer ID:");
    JTextField existingCustomerIDText = new JTextField();
    JLabel backUpAccountLabel2 = new JLabel("Backup Account: ");
    JTextField backUpAccountText2 = new JTextField();
    JLabel backUpAccountNumberLabel2 = new JLabel("Backup Account Number:");
    JTextField backUpAccountNumberText2 = new JTextField();

    JLabel cardLimitLabel = new JLabel("Credit Card Limit:");
    JTextField cardLimitText = new JTextField();

    String[] notLoan = new String[] {"Not applicable"};
    JLabel loanTimeLabel2 = new JLabel("Loan Type");
    JComboBox loanTimeCombo2 = new JComboBox(notLoan);

    //Creating Accounts - New Customer
    JPanel newCustomerInfo = new JPanel(new GridLayout(12, 2, 5, 5));
    JLabel firstNameLabel = new JLabel("First name:");
    JTextField firstNameText = new JTextField();
    JLabel lastNameLabel = new JLabel("Last name:");
    JTextField lastNameText = new JTextField();
    JLabel ssnLabel = new JLabel("SSN:");
    JTextField ssnText = new JTextField();
    JLabel streetAddressLabel = new JLabel("Street Address:");
    JTextField streetAddressText = new JTextField();
    JLabel cityLabel = new JLabel("City:");
    JTextField cityText = new JTextField();
    JLabel stateLabel = new JLabel("State:");
    JTextField stateText = new JTextField();
    JLabel zipLabel = new JLabel("Zip:");
    JTextField zipText = new JTextField();
    JLabel backUpAccountLabel = new JLabel("Backup Account: ");
    JTextField backUpAccountText = new JTextField();
    JLabel backUpAccountNumberLabel = new JLabel("Backup Account Number:");
    JTextField backUpAccountNumberText = new JTextField();
    JLabel startingBalanceLabelNew = new JLabel("Starting balance:");
    JTextField startingBalanceTextNew = new JTextField();
    JButton submitAccount = new JButton("Submit");
    JLabel loanTimeLabel = new JLabel("Loan Type");
    JComboBox loanTimeCombo = new JComboBox(notLoan);
    JLabel cardLimitLabel2 = new JLabel("Credit Card Limit:");
    JTextField cardLimitText2 = new JTextField();

    //Teller Components.................................................................................................
    JPanel tellerLayout = new JPanel(new BorderLayout(5, 5));
    JPanel enterAccountID = new JPanel(new GridLayout(1, 3, 5, 5));
    JPanel accountInfo = new JPanel(new GridLayout(3, 2, 5, 5));
    JPanel tellerAccounts = new JPanel(new GridLayout(1, 1, 15, 15));
    JPanel tellerButtons = new JPanel(new GridLayout(2, 3, 5, 5));
    JLabel accountIDLabel = new JLabel("Account id:");
    JTextField accountIDText = new JTextField();
    JLabel balanceLabel = new JLabel("Balance: ");
    JLabel recentDebitsLabel = new JLabel("Recent Debits: ");
    JLabel accountStatusLabel = new JLabel(" Account status: ");
    JButton transferButton = new JButton("Transfer");
    JButton deleteButton = new JButton("Delete Account");
    JButton createNewButton = new JButton("Create New Account");
    JButton withdrawTellerButton = new JButton("Withdraw");
    JButton depositTellerButton = new JButton("Deposit");
    JButton stopPaymentTellerButton = new JButton("Stop Payment");
    JLabel customerIDLabelTeller = new JLabel("Customer ID:");
    JTextField customerIDTextTeller = new JTextField();
    JButton searchTeller = new JButton("Search");
    String[] customers;
    String[] test = new String[] {"Accounts"};
    String[] columnNames = new String[] {"Type", "Amount", "Date"};
    String[][] recentDebitsData = new String[][] {};
    JTable tellerRecentDebits2 = new JTable(recentDebitsData, columnNames);
    JTable tellerRecentDebits = new JTable(new DefaultTableModel(recentDebitsData, new Object[] {"Type", "Amount", "Date"}));
    JScrollPane tablePane = new JScrollPane();
    JPanel tester = new JPanel(new GridLayout(2, 1, 5, 5));

    //Transfer
    JPanel transferLayout = new JPanel(new GridLayout(2, 2, 5, 5));
    JLabel transferToLabel = new JLabel("Transfer to:");
    String[] transferArrayTest = new String[] {"That's My Bank 1", "That's My Bank 2", "Gold/Diamond 1"};
    JComboBox<String> transferToCombo = new JComboBox<>(transferArrayTest);
    JLabel transferAmountLabel = new JLabel("Transfer amount:");
    JLabel filler = new JLabel("");
    JTextField transferAmountText = new JTextField();
    String[] list = new String[] {};
    JList<String> tellerAccountList = new JList<>(test);

    //Check deposit
    JPanel checkDepositLayout = new JPanel(new GridLayout(3, 2, 5, 5));
    JLabel checkAccountLabel = new JLabel("Check Account Number:");
    JTextField checkAccountText = new JTextField();
    JLabel checkNumberLabel = new JLabel("Check Number:");
    JTextField checkNumberText = new JTextField();
    JLabel checkAmount = new JLabel("Check Amount:");
    JTextField checkAmountText = new JTextField();

    //Manager Components................................................................................................
    JPanel managerLayout = new JPanel(new BorderLayout(5, 5));
    JPanel accountInfoManager = new JPanel(new GridLayout(4, 2, 5, 5));
    JPanel managerButtons = new JPanel(new GridLayout(2, 3, 5, 5));
    JPanel managerCustomerLookup = new JPanel(new GridLayout(1, 3, 5, 5));
    JPanel managerAccounts = new JPanel(new GridLayout(1, 1, 15, 15));
    JLabel customerIDLabel = new  JLabel("Customer ID:");
    JTextField customerIDTextManager = new JTextField(20);
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
    JButton rollOverNoticeButton = new JButton("Send CD Notices");
    JList<String> managerAccountList = new JList<>(test);
    JButton searchManager = new JButton("Search");

    //Start Components..................................................................................................
    JPanel startLayout = new JPanel();
    JButton atmButton = new JButton("ATM");
    JButton signInButton = new JButton("Sign In");

    GUI(List<Account> checkingAccounts, List<Account> savingsAccounts, List<Account> loanAccounts, List<LoanAccount> creditCards, List<User> userList) {
        gui.setSize(800, 500);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Menu
        menu.add(start);
        menu.add(signIn);

        menuBar.add(menu);
        gui.setJMenuBar(menuBar);

        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gui.getContentPane().removeAll();
                gui.add(startLayout);
                gui.revalidate();
                gui.repaint();
            }
        });

        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gui.getContentPane().removeAll();
                gui.add(signInLayout);
                gui.revalidate();
                gui.repaint();
            }
        });

        //Get all accounts from customer id


        loanTimeCombo.disable();
        loanTimeCombo2.disable();
        cardLimitText.disable();
        cardLimitText2.disable();

        //Start Layout..................................................................................................
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

        //Sign In Layout................................................................................................
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
                } else if(username.equals("manager") && password.equals("manager")) {
                    gui.getContentPane().removeAll();
                    gui.add(managerLayout);
                    gui.revalidate();
                    gui.repaint();
                }

                //Clears sign in text boxes
                userNameText.setText("");
                passwordText.setText("");
            }
        });

        //Manager Layout................................................................................................
        accountInfoManager.add(accountBalanceLabel);
        accountInfoManager.add(currentInterestRateLabel);
        accountInfoManager.add(dateOpenedLabel);
        accountInfoManager.add(accountTypeLabel);
        accountInfoManager.add(accountTypeLabel);
        accountInfoManager.add(backupAccountLabel);
        accountInfoManager.add(overdraftsLabel);
        accountInfoManager.add(dueDateLabel);
        accountInfoManager.setBorder(new TitledBorder(""));
        managerButtons.add(creditButton);
        managerButtons.add(debitButton);
        managerButtons.add(setInterestRatesButton);
        managerButtons.add(billingProcessButton);
        managerButtons.add(rollOverNoticeButton);
        managerCustomerLookup.add(customerIDLabel);
        customerIDLabel.setHorizontalAlignment(JLabel.RIGHT);
        managerCustomerLookup.add(customerIDTextManager);
        customerIDTextManager.setHorizontalAlignment(JTextField.LEFT);
        managerCustomerLookup.add(searchManager);
        managerAccounts.add(managerAccountList);
        managerAccounts.setBorder(new TitledBorder(""));
        managerLayout.add(managerCustomerLookup, BorderLayout.NORTH);
        managerLayout.add(managerAccounts, BorderLayout.WEST);
        managerLayout.add(accountInfoManager, BorderLayout.CENTER);
        managerLayout.add(managerButtons, BorderLayout.SOUTH);

        Border managerAccountsBorder = new TitledBorder("");
        managerAccountList.setBorder(new CompoundBorder(managerAccountsBorder, margin));
        managerAccounts.setBorder(new EmptyBorder(0, 5, 0, 5));
        Border accountInfoManagerBorder = new TitledBorder("");
        accountInfoManager.setBorder(new CompoundBorder(accountInfoManagerBorder, margin));

        Border managerBorder = new TitledBorder("Accounts");
        managerLayout.setBorder(new CompoundBorder(managerBorder, margin));

        //Adds accounts to list on left side of screen from searched customer id
        searchManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                int customerID = Integer.parseInt(customerIDTextManager.getText());
                managerAccountList.setListData(getAccountNumber(savingsAccounts, checkingAccounts, loanAccounts, customerID));

                gui.revalidate();
                gui.repaint();
            }
        });

        setInterestRatesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showInputDialog(gui, "Interest rate", "Set Interest Rate", JOptionPane.QUESTION_MESSAGE);
            }
        });

        billingProcessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showConfirmDialog(gui, "Are you sure you want to initiate billing?", "Initiate Billing Process", JOptionPane.OK_CANCEL_OPTION);
            }
        });

        rollOverNoticeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showConfirmDialog(gui, "Are you sure you want to send rollover notices?", "Send roll over notices", JOptionPane.OK_CANCEL_OPTION);
            }
        });

        debitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int debitedAmount = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String debitAmount = JOptionPane.showInputDialog(gui, "Debit Amount", "Debit", JOptionPane.QUESTION_MESSAGE);
                        if (debitAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (debitAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            debitedAmount = Integer.parseInt(debitAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
                System.out.println(debitedAmount);
            }
        });

        creditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int creditedAmount = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String creditAmount = JOptionPane.showInputDialog(gui, "Credit Amount", "Credit", JOptionPane.QUESTION_MESSAGE);
                        if (creditAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (creditAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            creditedAmount = Integer.parseInt(creditAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
                System.out.println(creditedAmount);
            }
        });

        //Teller Layout.................................................................................................
        enterAccountID.add(customerIDLabelTeller);
        customerIDLabelTeller.setHorizontalAlignment(JLabel.RIGHT);
        enterAccountID.add(customerIDTextTeller);
        customerIDTextTeller.setHorizontalAlignment(JTextField.LEFT);
        enterAccountID.add(searchTeller);
        accountInfo.add(balanceLabel);
        balanceLabel.setHorizontalAlignment(JLabel.LEFT);
        accountInfo.add(accountStatusLabel);
        accountStatusLabel.setHorizontalAlignment(JLabel.LEFT);
        accountInfo.add(recentDebitsLabel);
        recentDebitsLabel.setHorizontalAlignment(JLabel.LEFT);
        tellerButtons.add(withdrawTellerButton);
        tellerButtons.add(depositTellerButton);
        tellerButtons.add(transferButton);
        tellerButtons.add(deleteButton);
        tellerButtons.add(createNewButton);
        tellerButtons.add(stopPaymentTellerButton);
        tellerAccounts.add(tellerAccountList);

        tester.add(accountInfo);
        tester.add(tablePane);
        tablePane.setPreferredSize(new Dimension(50, 50));
        tablePane.setMaximumSize(new Dimension(50, 50));
        tablePane.setMinimumSize(new Dimension(50, 50));

        tellerLayout.add(enterAccountID, BorderLayout.NORTH);
        tellerLayout.add(tellerAccounts, BorderLayout.WEST);
        tellerLayout.add(tester, BorderLayout.CENTER);
        tellerLayout.add(tellerButtons, BorderLayout.SOUTH);

        Border tellerAccountListBorder = new TitledBorder("");
        tellerAccountList.setBorder(new CompoundBorder(tellerAccountListBorder, margin));
        tellerAccounts.setBorder(new EmptyBorder(0, 5, 0, 5));
        Border testerBorder = new TitledBorder("");
        tester.setBorder(new CompoundBorder(testerBorder, margin));
        Border tellerBorder = new TitledBorder("Accounts");
        tellerLayout.setBorder(new CompoundBorder(tellerBorder, margin));

        //Transfer Button
        transferLayout.add(transferToLabel);
        transferLayout.add(transferToCombo);
        transferLayout.add(transferAmountLabel);
        transferLayout.add(transferAmountText);

        transferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int customerID = Integer.parseInt(customerIDTextTeller.getText());
                int selectedIndex = tellerAccountList.getSelectedIndex();
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));
 
                //Sets account to transfer to drop down and removes selected account from it
                DefaultComboBoxModel model = new DefaultComboBoxModel(getAccountNumberWithoutLoans(savingsAccounts, checkingAccounts, customerID));
                transferToCombo.setModel(model);
                transferToCombo.removeItemAt(selectedIndex);
 
                //Transfer pop up
                int result = JOptionPane.showConfirmDialog(gui, transferLayout, "Transfer", JOptionPane.OK_CANCEL_OPTION);
 
                try {
                    double transferAmount = Double.parseDouble(transferAmountText.getText());
                    String accountToTransferTo = transferToCombo.getSelectedItem().toString();
                    String accountTypeTransfer = accountToTransferTo.substring(0, accountToTransferTo.indexOf(" "));
                    int accountNumberTransfer = Integer.parseInt(accountToTransferTo.substring(accountToTransferTo.indexOf(" ") + 1));

                    if(result == JOptionPane.OK_OPTION) {
                        getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountTypeTransfer, accountNumberTransfer).deposit(transferAmount);
                        getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).withdraw(transferAmount);

                        if(accountType.equals("Gold/Diamond") && 
                          getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getCurrentBalance() >= transferAmount + 1000) {
                            getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).addRecentDebits("Transfer Out", Double.toString(transferAmount));
                        }
                    }
                } catch(NumberFormatException e) {

                }
 
                //Not working
                // if(accountType.equals("Gold/Diamond") && getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).getCurrentBalance() - transferAmount < 1000) {
                //     JOptionPane.showMessageDialog(transferLayout, "You cannot withdraw more than the minimum balance", "Minimum Balance", JOptionPane.ERROR_MESSAGE);
                // }

                //Updates account info panel
                balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getCurrentBalance());
                accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts,loanAccounts, accountType, accountNumber).getStatus());
 
                gui.revalidate();
                gui.repaint();
            }
        });

        //Check Depoist Layout
        checkDepositLayout.add(checkAccountLabel);
        checkDepositLayout.add(checkAccountText);
        checkDepositLayout.add(checkNumberLabel);
        checkDepositLayout.add(checkNumberText);
        checkDepositLayout.add(checkAmount);
        checkDepositLayout.add(checkAmountText);

        //Breaks search currently
        tellerAccountList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                String tellerAccount = tellerAccountList.getSelectedValue();
                //Fix this.......................confused when searching cause it doesn't have value to pull from
                try {
                    String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                    int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));

                    balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts,loanAccounts, accountType, accountNumber).getCurrentBalance());
                    accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts,loanAccounts, accountType, accountNumber).getStatus());

                    tablePane.setViewportView(getAccount(savingsAccounts, checkingAccounts,loanAccounts, accountType, accountNumber).getRecentDebits());
                } catch (NullPointerException E) {

                }

                gui.revalidate();
                gui.repaint();
            }
        });

        //Finish.......................................................................................................................................
        searchTeller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                int customerID = Integer.parseInt(customerIDTextTeller.getText());
                tellerAccountList.setListData(getAccountNumber(savingsAccounts, checkingAccounts, loanAccounts, customerID));

                gui.revalidate();
                gui.repaint();
            }
        });

        //Deposits money into selected account in Teller Interface
        depositTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double depositedAmount = 0;
                boolean notNumeric = true;
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));
                String checkNumber = null;
                int checkAmount = 0;
                int checkAccountNumber = 0;
                System.out.println(accountNumber);

                Object[] options = new Object[] {"Cash", "Check"};
                int result = JOptionPane.showOptionDialog(gui, "Cash or Check", "Deposit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                //Check if input is numeric
                if(result == JOptionPane.YES_OPTION) {
                    while (notNumeric) {
                        try {
                            String depositAmount = JOptionPane.showInputDialog(gui, "Deposit Amount", "Deposit", JOptionPane.QUESTION_MESSAGE);
                            if (depositAmount == null) { //If null exit loop
                                System.out.println("null");
                                break;
                            } else if (depositAmount.matches("[0-9]*\\.?[0-9]*?")) { //If only numeric exit loop
                                depositedAmount = Double.parseDouble(depositAmount);
                                notNumeric = false;
                            }
                        } catch (NumberFormatException e) {
                            break;
                        }
                    }
                }

                if(result == JOptionPane.NO_OPTION) {
                    JOptionPane.showConfirmDialog(gui, checkDepositLayout, "Deposit Check", JOptionPane.OK_CANCEL_OPTION);

                    checkNumber = checkNumberText.getText();
                    checkAmount = Integer.parseInt(checkAmountText.getText());
                    checkAccountNumber = Integer.parseInt(checkAccountText.getText());

                    //Check if in stopped checks - redo this.......................................................................................
                    if(getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).checkStoppedChecks(checkNumber)) {
                        JOptionPane.showMessageDialog(gui, "This check was stopped", "Stopped Check", JOptionPane.WARNING_MESSAGE);
                    } else if(getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).getAccountType().equals("TMB") || 
                              getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).getAccountType().equals("Gold/Diamond")){
                                  System.out.println("Account is checkings");
                                  System.out.println(getCheckingAccount(checkingAccounts, checkAccountNumber).getCurrentBalance() + "   " + checkAmount);
                                if(getCheckingAccount(checkingAccounts, checkAccountNumber).getCurrentBalance() < checkAmount &&  //Change equation
                                   getCheckingAccount(checkingAccounts, checkAccountNumber).getBackupAccount() == 1) {
                                       System.out.println("Withdrawing from backup");
                                    int backup = getCheckingAccount(checkingAccounts, checkAccountNumber).getBackupAccountNumber();
                                    getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, backup).withdraw(checkAmount);
                                    getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, backup).addRecentDebits("Check Withdraw", Double.toString(checkAmount));    
                                } else {
                                    getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).withdraw(checkAmount);
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).deposit(checkAmount); //Good
                                    getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).addRecentDebits("Check Withdraw", Double.toString(checkAmount));
                                }        
                            
                        } else {
                        getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).withdraw(checkAmount);
                        getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).deposit(checkAmount); //Good
                        getAccountFromNumber(savingsAccounts, checkingAccounts, loanAccounts, checkAccountNumber).addRecentDebits("Check Withdraw", Double.toString(checkAmount));
                        }
                }
                System.out.println(getAccount(savingsAccounts, checkingAccounts,loanAccounts, accountType, accountNumber).getAccountType());
                System.out.println(getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).getCurrentBalance());
                getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).deposit(depositedAmount);
                System.out.println(getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).getAccountType());
                System.out.println(getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getCurrentBalance());

                //Updates account info panel
                balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).getCurrentBalance());
                accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts,loanAccounts,accountType, accountNumber).getStatus());

                gui.revalidate();
                gui.repaint();
            }
        });

        //Withdraws money from selected account in Teller Interface
        withdrawTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double withdrawnAmount = 0;
                boolean notNumeric = true;
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));
                int backupAccount;
                double backupAccountWithdraw;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String withdrawAmount = JOptionPane.showInputDialog(gui, "Withdraw Amount", "Withdraw", JOptionPane.QUESTION_MESSAGE);
                        if (withdrawAmount == null) { //If null exit loop
                            break;
                        } else if (withdrawAmount.matches("[0-9]*\\.?[0-9]*?")) { //If only numeric exit loop
                            withdrawnAmount = Double.parseDouble(withdrawAmount);
                            notNumeric = false;

                            //Adds to recent debits
                            if(accountType.equals("Long") || accountType.equals("Short")){
                                getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addRecentDebits("Withdraw", Double.toString(0));

                                getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).withdraw(0);
                            }
                            else {
                                getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).withdraw(withdrawnAmount);
                                System.out.println("First withdraw");

                                if((accountType.equals("Gold/Diamond") || accountType.equals("TMB")) && getCheckingAccount(checkingAccounts, accountNumber).getUseBackup()) { //Check if need to use backup
                                    System.out.println("Backup Withdraw");
                                    //Check amount needed from backup
                                    backupAccountWithdraw = withdrawnAmount - getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getCurrentBalance();
                                    System.out.println(backupAccountWithdraw);

                                    backupAccount = getCheckingAccount(checkingAccounts, accountNumber).getBackupAccountNumber();
                                    System.out.println(backupAccount);
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,"Savings", backupAccount).withdraw(backupAccountWithdraw); //Withdraws from backup
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).withdraw(withdrawnAmount - backupAccountWithdraw); //Withdraws from original
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,"Savings", backupAccount).addRecentDebits("Withdraw", Double.toString(backupAccountWithdraw)); //Adds withdraw to backup
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addRecentDebits("Withdraw", Double.toString(withdrawnAmount - backupAccountWithdraw));
                                } else { //You can add original withdraw
                                    System.out.println("First withdraw recent debits");
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addRecentDebits("Withdraw", Double.toString(withdrawnAmount)); //Adds withdraw to original
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }

                //Updates account info panel
                balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getCurrentBalance());
                accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getStatus());

                gui.revalidate();
                gui.repaint();
            }
        });

        //Deletes selected account in Teller Interface
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                List list = new ArrayList();
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));
                //int deleteConfirm = JOptionPane.showConfirmDialog(gui, "Are you sure you want to delete this account?", "Delete Account", JOptionPane.YES_NO_OPTION);
                if(JOptionPane.showConfirmDialog(gui, "Are you sure you want to delete this account?", "Delete Account", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    List one = new ArrayList(tellerAccountList.getModel().getSize());
                    for(int i = 0; i< tellerAccountList.getModel().getSize();i++){
                        one.add(tellerAccountList.getModel().getElementAt(i));
                    }
                    //Delete account 
                    //Long, Short, and Credit Loan type
                    if(accountType.contains(("Long")) || accountType.contains("Short") || accountType.contains("Credit")){
                        try {
                            delete(loanAccounts, accountNumber);
                        } catch (IOException e) {
                            System.out.println("ERROR Deleting Loan Account");
                        }
                    }
                    // checking account Types ("That's My Bank") || accountType.equals("Gold/Diamond")) 
                    if(accountType.contains("That's My Bank") || accountType.equals("Gold/Diamond")){
                        try {
                            delete(checkingAccounts, accountNumber );
                        } catch (IOException e) {
                            System.out.println("ERROR Deleting Checking Account");
                        }
                    }
                    if(accountType.contains("Savings") || accountType.equals("CD")){
                        try {
                            delete(savingsAccounts, accountNumber);
                        } catch (IOException e) {
                                System.out.println("Error Deleting Saving Account");
                            }
                        }
               
                    DefaultListModel listModel = new DefaultListModel();
                    for(int i = 0; i<one.size(); i++){
                        listModel.addElement(one.get(i));
                    }
                    tellerAccountList.setModel(listModel);
                    gui.revalidate();
                    gui.repaint();

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

        //Gets check number to be stopped
        stopPaymentTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String checkNumber = null;
                boolean notNumeric = true;
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String enteredCheckNumber = JOptionPane.showInputDialog(gui, "Check number", "Stop Payment", JOptionPane.QUESTION_MESSAGE);
                        if (enteredCheckNumber == null) { //If null exit loop
                            break;
                        } else if (enteredCheckNumber.matches("^[0-9]*$")) { //If only numeric exit loop
                            checkNumber = enteredCheckNumber;
                            notNumeric = false;
                            //Add to stopped checks array list for this account
                            getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addStopPayment(checkNumber);
                            getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).withdraw(15); //Fee

                            gui.revalidate();
                            gui.repaint();
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
            }
        });

        //Create new account Layout.....................................................................................
        newCustomerInfo.add(firstNameLabel);
        newCustomerInfo.add(firstNameText);
        newCustomerInfo.add(lastNameLabel);
        newCustomerInfo.add(lastNameText);
        newCustomerInfo.add(ssnLabel);
        newCustomerInfo.add(ssnText);
        newCustomerInfo.add(streetAddressLabel);
        newCustomerInfo.add(streetAddressText);
        newCustomerInfo.add(cityLabel);
        newCustomerInfo.add(cityText);
        newCustomerInfo.add(stateLabel);
        newCustomerInfo.add(stateText);
        newCustomerInfo.add(zipLabel);
        newCustomerInfo.add(zipText);
        newCustomerInfo.add(backUpAccountLabel);
        newCustomerInfo.add(backUpAccountText);
        newCustomerInfo.add(backUpAccountNumberLabel);
        newCustomerInfo.add(backUpAccountNumberText);
        newCustomerInfo.add(startingBalanceLabelNew);
        newCustomerInfo.add(startingBalanceTextNew);
        newCustomerInfo.add(loanTimeLabel);
        newCustomerInfo.add(loanTimeCombo);
        newCustomerInfo.add(cardLimitLabel);
        newCustomerInfo.add(cardLimitText);
        existingCustomer.add(existingCustomerIDLabel);
        existingCustomer.add(existingCustomerIDText);
        existingCustomer.add(backUpAccountLabel2);
        existingCustomer.add(backUpAccountText2);
        existingCustomer.add(backUpAccountNumberLabel2);
        existingCustomer.add(backUpAccountNumberText2);
        existingCustomer.add(startingBalanceLabel);
        existingCustomer.add(startingBalanceText);
        existingCustomer.add(loanTimeLabel2);
        existingCustomer.add(loanTimeCombo2);
        existingCustomer.add(cardLimitLabel2);
        existingCustomer.add(cardLimitText2);
        radioButtonsPanel.add(newCustomerRadio);
        radioButtonsPanel.add(existingCustomerRadio);
        creatingAccount.add(accountType);
        creatingAccount.add(radioButtonsPanel);
        newAccountSouth.add(newAccountStarting);
        newAccountSouth.add(submitAccount);
        createNewAccountLayout.add(creatingAccount, BorderLayout.NORTH);
        createNewAccountLayout.add(submitAccount, BorderLayout.SOUTH);

        Border createAccountBorder = new TitledBorder("Create Account");
        createNewAccountLayout.setBorder(new CompoundBorder(createAccountBorder, margin));

        //Creates new account and adds to array
        submitAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String type = accountType.getSelectedItem().toString();
                String loanTime;
                int customerID;
                double currentBalance;
                int backUpAccount = 0;
                int backUpAccountNumber = 0;
                int loanLength = 0;
                String streetAddress;
                String city;
                String state;
                int zip;
                String first;
                String last;
                double cardLimit = 0;

                if(existingCustomerRadio.isSelected()) {
                    customerID = Integer.parseInt(existingCustomerIDText.getText());
                    currentBalance = Double.parseDouble(startingBalanceText.getText());
                    // backUpAccount = Integer.parseInt(backUpAccountText2.getText());
                    // backUpAccountNumber = Integer.parseInt(backUpAccountNumberText2.getText());
                    // cardLimit = Double.parseDouble(cardLimitText2.getText());

                    if(accountType.equals("Short Term Loan") || accountType.equals("Long Term Loan") || accountType.equals("Credit Card Loan") || accountType.equals("Short") || accountType.equals("Long") || accountType.equals("Credit")) {
                        loanTime = (String) loanTimeCombo2.getSelectedItem();
                        loanLength = Integer.parseInt(loanTime.substring(0, loanTime.indexOf(" ")));

                        backUpAccount = Integer.parseInt(backUpAccountText2.getText());
                        backUpAccountNumber = Integer.parseInt(backUpAccountNumberText2.getText());
                    }

                    if(accountType.equals("Credit Card Loan")) {
                        cardLimit = Double.parseDouble(cardLimitText2.getText());
                    }
                } else {
                    customerID = Integer.parseInt(ssnText.getText());
                    currentBalance = Double.parseDouble(startingBalanceTextNew.getText());
                    backUpAccount = Integer.parseInt(backUpAccountText.getText());
                    backUpAccountNumber = Integer.parseInt(backUpAccountNumberText.getText());
                    streetAddress = streetAddressText.getText();
                    city = cityText.getText();
                    state = stateText.getText();
                    zip = Integer.parseInt(zipText.getText());
                    first = firstNameText.getText();
                    last = lastNameText.getText();
                    cardLimit = Double.parseDouble(cardLimitText.getText());

                    //Creates new user and adds to userList
                    userList.add(new CustomerATM(customerID, streetAddress, city, state, zip, first, last));

                    if(accountType.equals("Short Term Loan") || accountType.equals("Long Term Loan") || accountType.equals("Credit Card Loan") || accountType.equals("Short") || accountType.equals("Long") || accountType.equals("Credit")) {
                        loanTime = (String) loanTimeCombo2.getSelectedItem();
                        loanLength = Integer.parseInt(loanTime.substring(0, loanTime.indexOf(" ")));
                    }
                }

                try {
                    createNewAccount(savingsAccounts, checkingAccounts, loanAccounts, creditCards, type, customerID, currentBalance, backUpAccount, backUpAccountNumber, loanLength, cardLimit);
                } catch (IOException e) {
                    System.out.println("Exception in Create New Account (Submit button)");
                }
<<<<<<< HEAD
                // Save
                try {
                    Database.SaveAccountData(savingsAccounts);
                    Database.SaveAccountData(checkingAccounts);
                    Database.SaveAccountData(loanAccounts);
                    Database.SaveUserData(userList);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
=======

                System.out.println("Trying to return to teller");
                gui.getContentPane().removeAll();
                gui.add(tellerLayout);
                gui.revalidate();
                gui.repaint();
>>>>>>> e18b50109c9743203c9fb3b882ebf0b19357f364
            }
        });

        accountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String accountTypeSelected = (String) accountType.getSelectedItem();
                String[] loanTime = new String[] {"15 yrs", "30yrs"};

                if(accountTypeSelected.equals("Long Term Loan")||accountTypeSelected.equals("Long")) {
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(loanTime);
                    loanTimeCombo.setModel(model);
                    loanTimeCombo.enable();

                    DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(loanTime);
                    loanTimeCombo2.setModel(model2);
                    loanTimeCombo2.enable();

                     gui.revalidate();
                     gui.repaint();
                } else {
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(notLoan);
                    loanTimeCombo.setModel(model);
                    loanTimeCombo.disable();

                    DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(notLoan);
                    loanTimeCombo2.setModel(model2);
                    loanTimeCombo2.disable();

                     gui.revalidate();
                     gui.repaint();
                }

                if(accountType.equals("Short Term Loan") || accountType.equals("Long Term Loan") || accountType.equals("Credit Card Loan") || accountType.equals("Short") || accountType.equals("Long") || accountType.equals("Credit")) {
                    backUpAccountNumberText.enable();

                    backUpAccountText2.enable();
                    backUpAccountNumberText2.enable();
                } else {
                    backUpAccountText.disable();
                    backUpAccountNumberText.disable();

                    backUpAccountText2.disable();
                    backUpAccountNumberText2.disable();
                }

                if(accountTypeSelected.equals("Credit Card Loan")||accountTypeSelected.equals("Credit")) {
                    cardLimitText.enable();
                    cardLimitText2.enable();
                } else {
                    cardLimitText.disable();
                    cardLimitText2.disable();
                }
            }
        });

        //Adds panel to create new customer or add account to existing customer
        newCustomerRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(newCustomerRadio.isSelected()) {
                    createNewAccountLayout.add(newCustomerInfo, BorderLayout.CENTER);
                    gui.revalidate();
                    gui.repaint();
                    existingCustomerRadio.setEnabled(false);
                } else {
                    createNewAccountLayout.remove(newCustomerInfo);
                    gui.revalidate();
                    gui.repaint();
                    existingCustomerRadio.setEnabled(true);
                }
            }
        });

        existingCustomerRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(existingCustomerRadio.isSelected()) {
                    createNewAccountLayout.add(existingCustomer, BorderLayout.CENTER);
                    gui.revalidate();
                    gui.repaint();
                    newCustomerRadio.setEnabled(false);
                } else {
                    createNewAccountLayout.remove(existingCustomer);
                    gui.revalidate();
                    gui.repaint();
                    newCustomerRadio.setEnabled(true);
                }
            }
        });

        //Atm sign in Layout............................................................................................
        enteringPin.add(pinLabel);
        enteringPin.add(pinTextField);
        atmSignInLayout.add(enteringPin, BorderLayout.NORTH);
        atmSignInLayout.add(enter, BorderLayout.SOUTH);

        //Takes user to screen where they can choose from their accounts .................testing pin with 1234
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int pinNumber = Integer.parseInt(pinTextField.getText());
                if(isCustomer(userList, pinNumber)) {
                    gui.getContentPane().removeAll();
                    gui.add(atmLayout);

                    DefaultComboBoxModel model = new DefaultComboBoxModel(getAccountNumber(savingsAccounts, checkingAccounts, loanAccounts, pinNumber));
                    accountsDropDown.setModel(model);

                    pinTextField.setText("");

                    gui.revalidate();
                    gui.repaint();
                } else {
                    JOptionPane.showMessageDialog(gui, "Please enter a valid pin", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    pinTextField.setText("");
                }
            }
        });

        //Atm withdraw/deposit Layout...................................................................................
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

        //Gets amount to be withdrawn when withdraw button is clicked
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int withdrawnAmount = 0;
                boolean notNumeric = true;
                String chosenAccount = (String) accountsDropDown.getSelectedItem();
                String accountType = chosenAccount.substring(0, chosenAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(chosenAccount.substring(chosenAccount.indexOf(" ") + 1));

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
                            if(getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).overWithdrawLimit()) {
                                System.out.println("Withdrawing");
                                //Adds to
                                if(accountType.equals("Long") || accountType.equals("Short")){
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addRecentDebits("Withdraw", Double.toString(0));

                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).withdraw(0);
                                }
                                else {
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).addRecentDebits("Withdraw", Integer.toString(withdrawnAmount));
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).withdraw(withdrawnAmount);
                                    getAccount(savingsAccounts, checkingAccounts, loanAccounts, accountType, accountNumber).addWithdrawnToday();
                                    ;
                                }
                            } else {
                                JOptionPane.showMessageDialog(gui, "You can only make 2 withdraws at day from the ATM", "Withdraw Limit", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (NumberFormatException e) { //Break look if user hits ok without any input
                        System.out.println("no input");
                        break;
                    }
                }
<<<<<<< HEAD
                
                if(getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).overWithdrawLimit()) {
                    System.out.println("Withdrawing");
                    //Adds to recent debits
                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addRecentDebits("Withdraw", Integer.toString(withdrawnAmount));

                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).withdraw(withdrawnAmount);

                    getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).addWithdrawnToday();;
                } else {
                    JOptionPane.showMessageDialog(gui, "You can only make 2 withdraws at day from the ATM", "Withdraw Limit", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    Database.SaveAccountData(loanAccounts);
                    Database.SaveAccountData(checkingAccounts);
                    Database.SaveAccountData(savingsAccounts);
                    Database.SaveUserData(userList);
                } catch(Exception e){

                }
               
=======
>>>>>>> e18b50109c9743203c9fb3b882ebf0b19357f364
            }
        });

        //Gets amount to be deposited when deposit button is clicked
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int depositedAmount = 0;
                boolean notNumeric = true;
                String chosenAccount = (String) accountsDropDown.getSelectedItem();
                String accountType = chosenAccount.substring(0, chosenAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(chosenAccount.substring(chosenAccount.indexOf(" ") + 1));

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

                getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).deposit(depositedAmount);
                System.out.println(depositedAmount);
<<<<<<< HEAD
                try{
                Database.SaveAccountData(loanAccounts);
                Database.SaveAccountData(checkingAccounts);
                Database.SaveAccountData(savingsAccounts);
                Database.SaveUserData(userList);
                } catch(Exception ex){
                    
                }
=======
>>>>>>> e18b50109c9743203c9fb3b882ebf0b19357f364
            }
        });

        balanceInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String chosenAccount = (String) accountsDropDown.getSelectedItem();
                String accountType = chosenAccount.substring(0, chosenAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(chosenAccount.substring(chosenAccount.indexOf(" ") + 1));

                //Pull in balance based on account chosen.......................................................
               JOptionPane.showMessageDialog(gui, "Account: " + accountType + " " +accountNumber + "\nBalance: " + getAccount(savingsAccounts, checkingAccounts, loanAccounts,accountType, accountNumber).getCurrentBalance(), "Balance", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        gui.setLayout(flow);
        //Change this to where you want to GUI to start from
        gui.add(startLayout);
        gui.setVisible(true);
    }

    public static void main(String[] args) throws IOException {

        List<Account> accountList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<Account> loanAccounts= new ArrayList<>();
        List<Account> checkingAccounts=new ArrayList<>();
        List<Account> savingsAccounts=new ArrayList<>();
        List<LoanAccount> creditCards = new ArrayList<>();
              
        userList = Database.GetUserData();  // RW
        loanAccounts = Database.GetLoanData(); // RW
        savingsAccounts = Database.GetSavingData();// RW
        checkingAccounts = Database.GetCheckingData();// RW
        

        accountList.addAll(loanAccounts);// RW
        accountList.addAll((checkingAccounts));// RW
        accountList.addAll((savingsAccounts));// RW
    
        new GUI(checkingAccounts, savingsAccounts, loanAccounts, creditCards, userList);

    }

    public void delete (List<Account> list, int num) throws IOException{
        for(int i = 0; i < list.size(); i++){
            Account a = (Account)(list.get(i));
            if(a.getAccountNumber() == num){
                System.out.println(list);
                list.remove(i);
                System.out.println(list);
            }
        }
        Database.SaveAccountData(list);
    }

    public void createNewAccount(List<Account> savingsAccounts, List<Account> checkingAccounts, List<Account> loanAccounts, List<LoanAccount> creditCards, String accountType, int customerId, double currentBalance, int backUpAccount, int backUpAccountNumber, int loanLength, double cardLimit) throws IOException {
        int savingsAccountNumber = savingsAccounts.size() + 1;
        String savingsAcc = Integer.toString(savingsAccountNumber);
        savingsAcc = savingsAcc.concat("2");
        savingsAccountNumber = Integer.parseInt(savingsAcc);
        int checkingAccountNumber = checkingAccounts.size() + 1;
        String checkingAcc = Integer.toString(checkingAccountNumber);
        checkingAcc = checkingAcc.concat("1");
        checkingAccountNumber = Integer.parseInt(checkingAcc);
        int loanAccountNumber = loanAccounts.size() + 1;
        String loanAcc = Integer.toString(loanAccountNumber);
        loanAcc = loanAcc.concat("3");
        loanAccountNumber = Integer.parseInt(loanAcc);
        double interestRate = 1;
        Calendar loanDueDate =  Calendar.getInstance();
        Calendar creditCardDueDate = Calendar.getInstance();
        Date dueDate;
        Calendar paymentNotify = Calendar.getInstance();

        //Change this later.................................
        Date paymentNotifyDate = new Date(10-10-2021);

        if(accountType.equals("Savings")) {
            savingsAccounts.add(new SavingsAccount(customerId, savingsAccountNumber, currentBalance, interestRate, new Date(),"no"));
            savingsAccountNumber++;
        } else if(accountType.equals("That's My Bank") || accountType.equals("Gold/Diamond")) {
            checkingAccounts.add(new CheckingAccount(customerId, checkingAccountNumber, accountType, currentBalance, backUpAccount, backUpAccountNumber, 0, new Date()));
            checkingAccountNumber++;
        } else if(accountType.equals("CD")) {
            savingsAccounts.add(new SavingsAccount(customerId, savingsAccountNumber, currentBalance, interestRate, new Date(), "yes'"));
            savingsAccountNumber++;
        } else if(accountType.equals("Long Term Loan")||accountType.equals("Long")) {
            loanDueDate.get((Calendar.YEAR) + loanLength);
            dueDate = loanDueDate.getTime();
            loanAccounts.add(new LoanAccount(customerId, loanAccountNumber, currentBalance, interestRate, dueDate, paymentNotifyDate, currentBalance, "Long", false, new Date()));
        } else if(accountType.equals("Short Term Loan")||accountType.equals("Short")) {
            loanDueDate.get((Calendar.YEAR) + 5);
            dueDate = loanDueDate.getTime();
            loanAccounts.add(new LoanAccount(customerId, loanAccountNumber,currentBalance, interestRate, dueDate, paymentNotifyDate, currentBalance, "Short", false, new Date()));
        } else if(accountType.equals("Credit Card Loan")||accountType.equals("Credit")) {
            creditCardDueDate.get((Calendar.MONTH) + 1);
            System.out.println(creditCardDueDate);
            dueDate = creditCardDueDate.getTime();
            System.out.println(dueDate);
            paymentNotify.set(Calendar.YEAR, (Calendar.MONTH) + 1, 10);
            paymentNotifyDate = paymentNotify.getTime();
            System.out.println(paymentNotify + "     " + paymentNotifyDate);
            loanAccounts.add(new CreditCard(customerId, loanAccountNumber, currentBalance, interestRate, new Date(), paymentNotifyDate, 0, "Credit", false, new Date(), cardLimit));
        }

        Database.SaveAccountData(savingsAccounts);
        Database.SaveAccountData(checkingAccounts);
        Database.SaveAccountData(loanAccounts);
    }

    public String[] getAccountNumber(List<Account> savingsAccounts, List<Account> checkingAccounts, List<Account> loanAccounts, int customerId) {
        ArrayList<String> accountTypes = new ArrayList<>();
        String[] accountTypesReturn;

        for(int i = 0; i < savingsAccounts.size(); i++) {
            if(savingsAccounts.get(i).getCustomerId() == customerId) {
                accountTypes.add(savingsAccounts.get(i).getAccountType() + " " + Integer.toString(savingsAccounts.get(i).getAccountNumber()));
            }
        }

        for(int i = 0; i < checkingAccounts.size(); i++) {
            if(checkingAccounts.get(i).getCustomerId() == customerId) {
                accountTypes.add(checkingAccounts.get(i).getAccountType() + " " + Integer.toString(checkingAccounts.get(i).getAccountNumber()));
            }
        }

        for(int i = 0; i < loanAccounts.size(); i++) {
            if(loanAccounts.get(i).getCustomerId() == customerId) {
                accountTypes.add(loanAccounts.get(i).getAccountType() + " " + Integer.toString(loanAccounts.get(i).getAccountNumber()));
            }
        }

        accountTypesReturn = accountTypes.toArray(new String[0]);

        return accountTypesReturn;
    }

    public String[] getAccountNumberWithoutLoans(List<Account> savingsAccounts, List<Account> checkingAccounts, int customerId) {
        ArrayList<String> accountTypes = new ArrayList<>();
        String[] accountTypesReturn;

        for(int i = 0; i < savingsAccounts.size(); i++) {
            if(savingsAccounts.get(i).getCustomerId() == customerId) {
                accountTypes.add(savingsAccounts.get(i).getAccountType() + " " + Integer.toString(savingsAccounts.get(i).getAccountNumber()));
            }
        }

        for(int i = 0; i < checkingAccounts.size(); i++) {
            if(checkingAccounts.get(i).getCustomerId() == customerId) {
                accountTypes.add(checkingAccounts.get(i).getAccountType() + " " + Integer.toString(checkingAccounts.get(i).getAccountNumber()));
            }
        }

        accountTypesReturn = accountTypes.toArray(new String[0]);

        return accountTypesReturn;
    }

    public Account getAccount(List<Account> savings, List<Account> checking, List<Account> loans, String accountType, int accountNumber) {
        Account account = null;
        if(accountType.equals("Savings")) {
            for (int i = 0; i < savings.size(); i++) {
                if (savings.get(i).getAccountNumber() == accountNumber) {
                    account = savings.get(i);
                }
            }
        }

        if(accountType.equals("TMB") || accountType.equals("Gold/Diamond")) {
            for (int i = 0; i < checking.size(); i++) {
                if (checking.get(i).getAccountNumber() == accountNumber) {
                    account = checking.get(i);
                }
            }
        }
        if(accountType.equals("Long") || accountType.equals("Short") || accountType.equals("Credit")) {
            for (int i = 0; i < loans.size(); i++) {
                if (loans.get(i).getAccountNumber() == accountNumber) {
                    account = loans.get(i);
                }
            }
        }
        return account;
    }

    public CheckingAccount getCheckingAccount(List<Account> checkingAccounts, int accountNumber) {
        CheckingAccount account = null;
        for(int i = 0; i < checkingAccounts.size(); i++) {
            if(checkingAccounts.get(i).getAccountNumber() == accountNumber) {
                account = (CheckingAccount) checkingAccounts.get(i);
            }
        }
        return account;
    }

    public Account getAccountFromNumber(List<Account> savings, List<Account> checking, List<Account> loans, int accountNumber) {
        Account account = null;

        //Checks savings
        for(int i = 0; i < savings.size(); i++) {
            if(savings.get(i).getAccountNumber() == accountNumber) {
                account = savings.get(i);
            }
        }

        //Checks checking
        for(int i = 0; i < checking.size(); i++) {
            if(checking.get(i).getAccountNumber() == accountNumber) {
                account = checking.get(i);
            }
        }

        //Checks loans
        for(int i = 0; i < loans.size(); i++) {
            if(loans.get(i).getAccountNumber() == accountNumber) {
                account = loans.get(i);
            }
        }

        return account;
    }

    public boolean isCustomer(List<User> users, int enteredID) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getCustomerId() == enteredID) {
                return true;
            }
        }
        return false;
    }
}

