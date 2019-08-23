package zad3;



import zad3.service.MenuService;

import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    new MenuService().start();
  }

}
