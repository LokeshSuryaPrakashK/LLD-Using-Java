import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserData userData = new UserData(); 
        Database db = new Database(userData);
        TableList tableList = new TableList(db);

        while (true) 
        { 
            System.out.println("!!!Welcome to Our Database !!!");
            System.out.println("Enter the number \n 1.New User \t 2.Existing User \t 3.Exit");
            int a = sc.nextInt();

            if (a == 3) 
            {
                System.out.println("Exiting... Thank you!");
                break;
            }

            String name, password;
            System.out.println("Enter your username:");
            name = sc.next();
            System.out.println("Enter your password:");
            password = sc.next();

            boolean isDataBaseExists = false;

            if (a == 1) 
            {
                userData.addAuthenticateData(name, password);
                isDataBaseExists = true; 
            } 
            else if (a == 2) 
            {
                isDataBaseExists = userData.authenticate(name, password);
            } 
            else 
            {
                System.out.println("Entered Invalid Number");
                continue;
            }

            while(isDataBaseExists) 
            {
                System.out.println("Please choose the operation \n 1.Create Database \t 2.Delete Database \t 3.Display all the databases \t 4.Exit from databases");
                int b = sc.nextInt();
                boolean isTableExists = false;

                if (b == 1) 
                {
                    System.out.println("Enter the database name:");
                    String dbname = sc.next();
                    db.addDatabase(name, dbname);
                    isTableExists = true; 
                } 
                else if (b == 2) 
                {
                    System.out.println("Enter the database name:");
                    String dbname = sc.next();
                    db.deleteDatabase(name, dbname);
                } 
                else if(b==3)
                {
                    db.getDatabaseNames(name);
                }
                else 
                {
                    break;
                }
                
                while (isTableExists)
                {
                    System.out.println("Please choose the operation \n 1.Create Table \t 2.Delete Table \t 3.Display all the tables \t 4.Exit from tables");
                    int c = sc.nextInt();
                    if(c==1)
                    {
                        System.out.println("Enter the database name:");
                        String dbname = sc.next();
                        System.out.println("Enter the table name:");
                        String tableName = sc.next();
                        tableList.addTables(dbname, tableName);
                    }

                }
            }   
        }
        sc.close();
    }
}
