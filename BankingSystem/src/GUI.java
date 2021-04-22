import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Accounts.*;
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
    JLabel pinLabel = new JLabel("Enter pin:");
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
    JPanel existingCustomer = new JPanel(new GridLayout(4, 2, 5, 5));
    JLabel existingCustomerIDLabel = new JLabel("Customer ID:");
    JTextField existingCustomerIDText = new JTextField();
    JLabel backUpAccountLabel2 = new JLabel("Backup Account: ");
    JTextField backUpAccountText2 = new JTextField();
    JLabel backUpAccountNumberLabel2 = new JLabel("Backup Account Number:");
    JTextField backUpAccountNumberText2 = new JTextField();

    //Creating Accounts - New Customer
    JPanel newCustomerInfo = new JPanel(new GridLayout(10, 2, 5, 5));
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
    JLabel accountStatusLabel = new JLabel("Account status: ");
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
    //Type means check, payment made to credit card, ect
    String[] columnNames = new String[] {"Type", "Amount", "Date"};
    String[][] recentDebitsData = new String[][] {
            {"Check", "50.00", "5/14/2021"},
            {"Check Payment", "250.00", "4/4/2021"},
            {"test", "5", "4/1/2021"},
            {"Check", "2", "4/1/2021"},
            {"Check", "6", "4/1/2021"},
            {"Credit Cards", "50", "3/30/2021"}
    };
    JTable tellerRecentDebits = new JTable(recentDebitsData, columnNames);

    JScrollPane tablePane = new JScrollPane(tellerRecentDebits);
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

    //Manager Components................................................................................................
    JPanel managerLayout = new JPanel(new BorderLayout(5, 5));
    JPanel accountInfoManager = new JPanel(new GridLayout(4, 2, 5, 5));
    JPanel managerButtons = new JPanel(new GridLayout(2, 3, 5, 5));
    JPanel managerCustomerLookup = new JPanel(new GridLayout(1, 2, 5, 5));
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

    //Start Components..................................................................................................
    JPanel startLayout = new JPanel();
    JButton atmButton = new JButton("ATM");
    JButton signInButton = new JButton("Sign In");

    GUI(List<Account> checkingAccounts, List<Account> savingsAccounts) {
        gui.setSize(500, 335);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Get all accounts from customer id

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
        managerAccounts.add(managerAccountList);
        managerAccounts.setBorder(new TitledBorder(""));
        managerLayout.add(managerCustomerLookup, BorderLayout.NORTH);
        managerLayout.add(managerAccounts, BorderLayout.WEST);
        managerLayout.add(accountInfoManager, BorderLayout.CENTER);
        managerLayout.add(managerButtons, BorderLayout.SOUTH);

        managerAccountList.setBorder(new TitledBorder(""));
        managerAccounts.setBorder(new EmptyBorder(0, 5, 0, 5));
        accountInfoManager.setBorder(new TitledBorder(""));

        Border managerBorder = new TitledBorder("Accounts");
        managerLayout.setBorder(new CompoundBorder(managerBorder, margin));

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
                JOptionPane.showConfirmDialog(gui, transferLayout, "Transfer", JOptionPane.OK_CANCEL_OPTION);
            }
        });

        //Breaks search currently
tellerAccountList.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
    String tellerAccount = tellerAccountList.getSelectedValue();
    try {
    String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
    int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));
    
    balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).getCurrentBalance());
    accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).getStatus());
    } catch (NullPointerException E) {
    
    } catch (StringIndexOutOfBoundsException E) {
    
    }
    
    gui.revalidate();
    gui.repaint();
    }
    });
    
    //Finish.......................................................................................................................................
    searchTeller.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
    
    int customerID = Integer.parseInt(customerIDTextTeller.getText());
    tellerAccountList.setListData(getAccountNumber(savingsAccounts, checkingAccounts, customerID));
    
    gui.revalidate();
    gui.repaint();
    
    
    }
    });

        //Deposits money into selected account in Teller Interface
        depositTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int depositedAmount = 0;
                boolean notNumeric = true;
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));
                System.out.println(accountNumber);

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

                getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).deposit(depositedAmount);

                balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).getCurrentBalance());
                accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).getStatus());

                gui.revalidate();
                gui.repaint();
            }
        });

        //Withdraws money from selected account in Teller Interface
        withdrawTellerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int withdrawnAmount = 0;
                boolean notNumeric = true;
                String tellerAccount = tellerAccountList.getSelectedValue();
                String accountType = tellerAccount.substring(0, tellerAccount.indexOf(" "));
                int accountNumber = Integer.parseInt(tellerAccount.substring(tellerAccount.indexOf(" ") + 1));

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String depositAmount = JOptionPane.showInputDialog(gui, "Deposit Amount", "Deposit", JOptionPane.QUESTION_MESSAGE);
                        if (depositAmount == null) { //If null exit loop
                            System.out.println("null");
                            break;
                        } else if (depositAmount.matches("^[0-9]*$")) { //If only numeric exit loop
                            withdrawnAmount = Integer.parseInt(depositAmount);
                            notNumeric = false;
                        }
                    } catch (NumberFormatException e) {
                        break;
                    }
                }

                getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).withdraw(withdrawnAmount);

                balanceLabel.setText("Balance: " + getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).getCurrentBalance());
                accountStatusLabel.setText("Status: " + getAccount(savingsAccounts, checkingAccounts, accountType, accountNumber).getStatus());

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
                int deleteConfirm = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(gui, "Are you sure you want to delete this account?", "Delete Account", deleteConfirm);
                if(deleteConfirm == JOptionPane.YES_OPTION) {
                    List one = new ArrayList(tellerAccountList.getModel().getSize());
                    for(int i = 0; i< tellerAccountList.getModel().getSize();i++){
                        one.add(tellerAccountList.getModel().getElementAt(i));
                    }
                    //Delete account
                    delete(checkingAccounts, accountNumber,accountType );
                    delete(savingsAccounts, accountNumber, accountType);
                    delete(one, accountNumber, accountType);
                    DefaultListModel listModel = new DefaultListModel();
                    for(int i = 0; i<one.size(); i++){
                        listModel.addElement(one.get(i));
                    }
                    tellerAccountList.setModel(listModel);

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
                int checkNumber = 0;
                boolean notNumeric = true;

                //Check if input is numeric
                while (notNumeric) {
                    try {
                        String enteredCheckNumber = JOptionPane.showInputDialog(gui, "Check number", "Stop Payment", JOptionPane.QUESTION_MESSAGE);
                        if (enteredCheckNumber == null) { //If null exit loop
                            break;
                        } else if (enteredCheckNumber.matches("^[0-9]*$")) { //If only numeric exit loop
                            checkNumber = Integer.parseInt(enteredCheckNumber);
                            notNumeric = false;
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
        existingCustomer.add(existingCustomerIDLabel);
        existingCustomer.add(existingCustomerIDText);
        existingCustomer.add(backUpAccountLabel2);
        existingCustomer.add(backUpAccountText2);
        existingCustomer.add(backUpAccountNumberLabel2);
        existingCustomer.add(backUpAccountNumberText2);
        existingCustomer.add(startingBalanceLabel);
        existingCustomer.add(startingBalanceText);
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
                int customerID;
                double currentBalance;
                int backUpAccount;
                int backUpAccountNumber;

                if(existingCustomerRadio.isSelected()) {
                    customerID = Integer.parseInt(existingCustomerIDText.getText());
                    currentBalance = Double.parseDouble(startingBalanceText.getText());
                    backUpAccount = Integer.parseInt(backUpAccountText2.getText());
                    backUpAccountNumber = Integer.parseInt(backUpAccountNumberText2.getText());
                } else {
                    customerID = Integer.parseInt(ssnText.getText());
                    currentBalance = Double.parseDouble(startingBalanceTextNew.getText());
                    backUpAccount = Integer.parseInt(backUpAccountText.getText());
                    backUpAccountNumber = Integer.parseInt(backUpAccountNumberText.getText());
                }

                createNewAccount(savingsAccounts, checkingAccounts, type, customerID, currentBalance, backUpAccount, backUpAccountNumber);
                
                gui.getContentPane().removeAll();
                gui.add(tellerLayout);
                gui.revalidate();
                gui.repaint();
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
                String pinNumber = pinTextField.getText();
                if(pinNumber.equals("1234")) {
                    gui.getContentPane().removeAll();
                    gui.add(atmLayout);
                    gui.revalidate();
                    gui.repaint();
                } else {
                    JOptionPane.showMessageDialog(gui, "Please enter a valid pin", "Invalid Pin", JOptionPane.ERROR_MESSAGE);
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
        gui.add(tellerLayout);
        gui.setVisible(true);
    }

    public static void main(String[] args) {

        List<Account> accountList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<Account> loanAccounts= new ArrayList<>();
        List<Account> checkingAccounts=new ArrayList<>();
        List<Account> savingsAccounts=new ArrayList<>();
              
        userList = Database.GetUserData();  // RW
        loanAccounts = Database.GetLoanData(); // RW
        savingsAccounts = Database.GetSavingData();// RW
        checkingAccounts = Database.GetCheckingData();// RW

        accountList.addAll(loanAccounts);// RW
        accountList.addAll((checkingAccounts));// RW
        accountList.addAll((savingsAccounts));// RW
        LoanAccount.Notify(loanAccounts);
    
        new GUI(checkingAccounts, savingsAccounts);
    }

    public void delete (List<Account> list, int num, String type){
        for(int i = 0; i < list.size(); i++){
            Account a = list.get(i);
            if((a.getAccountNumber() == num)&&(type.equals(a.getAccountType()) == true)){
                System.out.println(list);
                list.remove(i);
                System.out.println(list);
            }
        }
    }

    public void createNewAccount(List<Account> savingsAccounts, List<Account> checkingAccounts, String accountType, int customerId, double currentBalance, int backUpAccount, int backUpAccountNumber) {
        int savingsAccountNumber = savingsAccounts.size() + 1;
        int checkingAccountNumber = checkingAccounts.size() + 1;
        double interestRate = 1.0;

        if(accountType.equals("Savings")) {
            savingsAccounts.add(new SavingsAccount(customerId, savingsAccountNumber, currentBalance, interestRate, new Date()));
            savingsAccountNumber++;
        } else if(accountType.equals("That's My Bank") || accountType.equals("Gold/Diamond")) {
            checkingAccounts.add(new CheckingAccount(customerId, checkingAccountNumber, accountType, currentBalance, backUpAccount, backUpAccountNumber, 0, new Date()));
            checkingAccountNumber++;
        } else if(accountType.equals("CD")) {

        } else if(accountType.equals("Long Term Loan")) {

        } else if(accountType.equals("Short Term Loan")) {

        } else if(accountType.equals("Credit Card Loan")) {

        }
    }

    public String[] getAccountNumber(List<Account> savingsAccounts, List<Account> checkingAccounts, int customerId) {
        ArrayList<String> accountTypes = new ArrayList<>();
        String[] accountTypesReturn;

        for(int i = 0; i < savingsAccounts.size(); i++) {
            if(savingsAccounts.get(i).getCustomerId() == customerId) {
                accountTypes.add("Savings " + Integer.toString(savingsAccounts.get(i).getAccountNumber()));
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

    public Account getAccount(List<Account> savings, List<Account> checking, String accountType, int accountNumber) {
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
        return account;
    }
}
