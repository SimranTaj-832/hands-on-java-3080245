package bank;

public class CustomeR {
  private int id;
  private String name;
  private String username;
  private String password;
  private int accountId;

  public CustomeR(int id, String name, String username, String password, int accountId){
    setId(id);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAccountid(accountId);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountid() {
    return this.accountid;
  }

  public void setAccountid(int accountid) {
    this.accountid = accountid;
  }




}
