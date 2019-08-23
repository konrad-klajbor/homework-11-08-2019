package zad3.model;

public class User
{
  private static final String DELIMITER = " ! ";

  private String username;
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(String formattedUser) {
    if(formattedUser.contains(DELIMITER)){
      String[] splitted = formattedUser.split(DELIMITER);
      this.username = splitted[0];
      this.password = splitted[1];
    }
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String toString() {
    return username + DELIMITER + password;
  }
}
