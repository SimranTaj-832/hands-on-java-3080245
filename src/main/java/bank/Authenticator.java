package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {
  public static CustomeR login(String username, String password)throws LoginException{
    CustomeR customer = DataSource.getCustomeR(username);
    if (customer == null) {
      throw new LoginException("username not found");
    }

    if (password.equals(customer.getPassword())) {
      customer.setAuthenticated(true);
      return customer;
    }

    else throw new LoginException("incorrect password");
  }

  public static void logout(CustomeR customer) {
    customer.setAuthenticated(false);
  }
}
