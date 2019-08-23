package zad3.service;

import zad3.Util;

import zad3.model.User;

import java.io.IOException;



public class MenuService {

  public static boolean exitApp=false;

  private UserService userService;

  public MenuService() {
    this.userService = new UserService();
  }

  public void start() throws IOException {
    while (!exitApp ) {
      printMenuInfo();
      int choice = getUserInput();
      decide(choice);
    }
  }

  private void decide(int choice) throws IOException {
    switch (choice){
      case 0: {
        exitApp=true;
        break;
      }
      case 1: {
        boolean exitAddUser=false;
        while (!exitAddUser) {
          userService.addUser(
                  userService.getUserFromConsole()
          );
          System.out.println("Do you want to add another user? 1 - add user, 2 - return to menu");
          if (getUserInput()==2) {exitAddUser=true;}

        }
        break;
      }

      case 2: {
        list(userService.getUsers());
        break;
      }

      default: {
        printBadChoice();
      }
    }
  }

  private void printMenuInfo(){
    System.out.println("##########");
    System.out.println("#  MENU  #");
    System.out.println("##########");
    System.out.println("# 1 Add  #");
    System.out.println("# 2 List #");
    System.out.println("##########");
    System.out.println("# 0 Exit #");
    System.out.println("##########");
  }

  private int getUserInput() {
    System.out.print("Your choice: ");
    return Integer.parseInt(Util.readUserInput());
  }

  private void printBadChoice(){
    System.out.println("Zly wybor!!");
  }

  private void list(User[] users){
    for (User user : users){
      System.out.println(user);
    }
  }
}
