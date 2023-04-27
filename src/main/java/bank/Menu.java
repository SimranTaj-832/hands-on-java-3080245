package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exceptions.AmountException;

public class Menu {
  private Scanner scanner;

  public static void main(String[] args) {
    System.out.println("Welcome to GBI");

    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    CustomeR customer = menu.authenticateUser();
    if (customer != null) {
      Account account = DataSource.geAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    }

    menu.scanner.close();
  }

  private CustomeR authenticateUser() {
    System.out.println("please enter your username");
    String username = scanner.next();

    System.out.println("please enter password");
    String password = scanner.next();

    CustomeR customer = null;
    try {
      customer = Authenticator.login(username, password);
    } catch (LoginException e) {
      System.out.println("There was an error" + e.getMessage());
    }

    return customer;
  }

  private void showMenu(CustomeR customer, Account account) {
    int selection = 0;

    while (selection != 4 && customer.isAuthenticated()) {
      System.out.println("============================");
      System.out.println("Please select one");
      System.out.println("1: Deposit");
      System.out.println("2: withdraw");
      System.out.println("3: Check balance");
      System.out.println("4: Exit");
      System.out.println("============================");

      selection = scanner.nextInt();
      double amount = 0;

      switch (selection) {
        case 1:
          System.out.println("Enter amount to deposit");
          amount = scanner.nextDouble();
          try {
            account.deposit(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage() + "\n Try Again");
          }
          break;

        case 2:
          System.out.println("Enter amount to withdraw");
          amount = scanner.nextDouble();
          try {
            account.withdraw(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage() + "\n Try Again");
          }
          break;

        case 3:
          System.out.println("Current Balance:" + account.getBalance());
          break;

        case 4:
          Authenticator.logout(customer);
          System.out.println("Thank you");
          break;

        default:
          System.out.println("Incalid option");
          break;
      }
    }
  }
}
