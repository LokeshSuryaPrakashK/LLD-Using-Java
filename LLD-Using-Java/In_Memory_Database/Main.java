
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserData userData = new UserData();
        Database db = new Database(userData);
        TableList tableList = new TableList(db);

        while (true) {
            System.out.println("!!!Welcome to Our Database !!!");
            System.out.println("Enter the number \n 1.New User \t 2.Existing User \t 3.Exit");
            int a = sc.nextInt();

            if (a == 3) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            String name, password;
            System.out.print("Enter your username: ");
            name = sc.next();
            System.out.print("Enter your password: ");
            password = sc.next();

            boolean isDataBaseExists = false;

            if (a == 1) {
                userData.addAuthenticateData(name, password);
                isDataBaseExists = true;
            } else if (a == 2) {
                isDataBaseExists = userData.authenticate(name, password);
            } else {
                System.out.println("Entered Invalid Number");
                continue;
            }

            while (isDataBaseExists) {
                System.out.println("\nPlease choose the operation \n 1.Create Database \t 2.Delete Database \t 3.Display all the databases \t4.Select an existing database \t5.Exit from databases");
                int b = sc.nextInt();
                boolean isTableExists = false;
                String selecteddb;

                if (b == 1) {
                    System.out.println("Enter the database name:");
                    selecteddb = sc.next();
                    db.addDatabase(name, selecteddb);

                    System.out.println("Do you want to create table or perform some operations on database\n 1.Yes \t2.No");
                    int temp1 = sc.nextInt();
                    if (temp1 == 1) {
                        isTableExists = true;
                    } else if (temp1 == 2) {
                        continue;
                    } else {
                        System.out.println("Invalid Choice");
                        continue;
                    }

                    isTableExists = true;
                } else if (b == 2) {
                    System.out.println("Enter the database name:");
                    String dbname = sc.next();
                    db.deleteDatabase(name, dbname);
                    continue;
                } else if (b == 3) {
                    db.getDatabaseNames(name);
                    continue;
                } else if (b == 4) {
                    int z = db.getDatabaseNames(name);
                    if (z != -1) {
                        System.out.print("Enter the index of wanted database : ");
                        int temp2 = sc.nextInt();
                        String tempdb = db.getSelectedDatabase(name, temp2);
                        System.out.println("The selected database is : " + tempdb);
                        System.out.println("Do you want to create table in " + tempdb + " or perform some operations on database\n 1.Yes \t2.No");
                        int temp1 = sc.nextInt();
                        if (temp1 == 1) {
                            isTableExists = true;
                        } else if (temp1 == 2) {
                            continue;
                        } else {
                            System.out.println("Invalid Choice");
                            continue;
                        }

                        isTableExists = true;

                    }
                } else if (b == 5) {
                    break;
                } else {
                    continue;
                }
                // switch (b) {
                //     case 1:
                //         System.out.println("Enter the database name:");
                //         String dbname = sc.next();
                //         db.addDatabase(name, dbname);
                //         isTableExists = true;
                //         break;
                //     case 2:
                //         System.out.println("Enter the database name:");
                //         String ndbname = sc.next();
                //         db.deleteDatabase(name, ndbname);

                //         break;
                //     case 3:
                //         db.getDatabaseNames(name);
                //         break;
                //     default:
                //         break;
                // }
                while (isTableExists) {
                    System.out.println("\nPlease choose the operation \n 1.Create Table \t 2.Delete Table \t 3.Display all the tables \t 4.Exit from tables");
                    int c = sc.nextInt();
                    if (c == 1) {
                        System.out.println("Enter the database name:");
                        String dbname = sc.next();
                        System.out.println("Enter the table name:");
                        String tableName = sc.next();
                        tableList.addTables(dbname, tableName);
                        System.out.println("End of the code");
                        break;
                    }

                }
            }
        }

        sc.close();
    }
}
