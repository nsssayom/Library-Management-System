package LibrarySystem.Modules;

import LibrarySystem.Database.*;
import LibrarySystem.Modules.*;
import LibrarySystem.Windows.*;
import LibrarySystem.Panels.LeftPanels.*;
import LibrarySystem.Panels.RightPanels.*;
import LibrarySystem.Panels.TopPanels.*;

public class Global{
  public static String USERNAME;
  public static int ROLEID;
  public static int ACCOUNTID;

  public static String NAME;
  public static String EMAIL;
  public static String ADDRESS;
  public static String PHONE;

  public static Database database = new Database("54.37.227.144", "my_library", "Library009", "library_database");
  public static GUI gui;

  public static String getRole(){
    String role = "";

    if (Global.ROLEID == 1){
      role = "SUPER ADMIN";
    }
    else if (Global.ROLEID == 2){
      role = "Manager";
    }
    else if (Global.ROLEID == 3){
      role = "Employee";
    }
    else if (Global.ROLEID == 4){
      role = "Member";
    }
    return role;
  }
}
