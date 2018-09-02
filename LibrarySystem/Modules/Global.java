package LibrarySystem.Modules;

import LibrarySystem.Database.*;
import LibrarySystem.Modules.*;
import LibrarySystem.Windows.*;
import LibrarySystem.Panels.LeftPanels.*;
import LibrarySystem.Panels.RightPanels.*;
import LibrarySystem.Panels.TopPanels.*;

public class Global{
  public static String USERNAME;
  public static String NAME;
  public static int ROLEID;
  public static int ACCOUNTID;
  public static Database database = new Database("54.37.227.144", "my_library", "Library009", "library_database");
  public static GUI gui;
}
