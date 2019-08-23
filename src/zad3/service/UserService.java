package zad3.service;

import zad3.Util;
import zad3.model.User;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserService {

  private static final Path USERS_PATH = Paths.get("./src/zad3/users");

  public User createUserObject(String username, String password) {
    return new User(username, password);
  }

  public User getUserFromConsole() {
    String username = Util.readInputWithMessage("Username: ");
    String password = Util.readInputWithMessage("Password: ");
    return createUserObject(username, password);
  }

  public void addUser(User user) throws IOException {
    String userString = user.toString() + "\n";
    Util.writeToFile(USERS_PATH, userString.getBytes());
  }

  public User[] getUsers() throws IOException {
    List<String> linesFromFile = Util.readFileContent(USERS_PATH);

    User[] usersArray = new User[linesFromFile.size()];

    for(int i = 0 ; i < usersArray.length ; i++){
      usersArray[i] = new User(linesFromFile.get(i));
    }

    return usersArray;
  }
}
