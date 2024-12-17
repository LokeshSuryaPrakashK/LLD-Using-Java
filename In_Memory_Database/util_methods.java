import java.util.Scanner;

public class util_methods 
{
    public static boolean handleUserLevel(Scanner sc, UserData userData, Database db, TableList tableList, TableData tableData) 
    {
        System.out.println("!!!Welcome to Our Database !!!");
        System.out.println("Enter the number \n 1.New User \t 2.Existing User \t 3.Exit");
        int choice = sc.nextInt();

        if (choice == 3) {
            System.out.println("Exiting... Thank you!");
            return false;
        }

        String name, password;
        System.out.print("Enter your username: ");
        name = sc.next();
        System.out.print("Enter your password: ");
        password = sc.next();

        boolean isAuthenticated = (choice == 1) ? handleNewUser(userData, name, password) : handleExistingUser(userData, name, password);

        if (!isAuthenticated) 
        {
            System.out.println("Authentication failed.");
            return true;
        }

        while (handleDatabaseLevel(sc, db, name, tableList, tableData)) 
        {
            // Looping through database operations
        }
        return true;
    }

    private static boolean handleNewUser(UserData userData, String name, String password) 
    {
        userData.addAuthenticateData(name, password);
        return true;
    }

    private static boolean handleExistingUser(UserData userData, String name, String password)
     {
        return userData.authenticate(name, password);
    }

    private static boolean handleDatabaseLevel(Scanner sc, Database db, String username, TableList tableList, TableData tableData) 
    {
        System.out.println("\nPlease choose the operation \n 1.Create Database \t 2.Delete Database \t 3.Display all the databases \t4.Select an existing database \t5.Exit from databases");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                String selectedDb = createDatabase(sc, db, username);
                if (selectedDb != null) {
                    while (handleTableLevel(sc, tableList, tableData, selectedDb)) {
                        // Looping through table operations
                    }
                }
                break;

            case 2:
                deleteDatabase(sc, db, username);
                break;

            case 3:
                db.getDatabaseNames(username);
                break;

            case 4:
                String selectedDbName = selectDatabase(sc, db, username);
                if (selectedDbName != null) {
                    while (handleTableLevel(sc, tableList, tableData, selectedDbName)) {
                        // Looping through table operations
                    }
                }
                break;

            case 5:
                return false;

            default:
                System.out.println("Invalid Choice");
        }
        return true;
    }

    private static String createDatabase(Scanner sc, Database db, String username) 
    {
        System.out.println("Enter the database name:");
        String dbName = sc.next();
        db.addDatabase(username, dbName);

        System.out.println("Do you want to create tables in " + dbName + "? \n 1.Yes \t 2.No");
        int choice = sc.nextInt();
        return (choice == 1) ? dbName : null;
    }

    private static void deleteDatabase(Scanner sc, Database db, String username) 
    {
        System.out.println("Enter the database name:");
        String dbName = sc.next();
        db.deleteDatabase(username, dbName);
    }

    private static String selectDatabase(Scanner sc, Database db, String username) 
    {
        db.getDatabaseNames(username);
        System.out.print("Enter the index of the database: ");
        int index = sc.nextInt();
        return db.getSelectedDatabase(username, index);
    }

    private static boolean handleTableLevel(Scanner sc, TableList tableList, TableData tableData, String selectedDb) 
    {
        System.out.println("\nPlease choose the operation \n 1.Create Table \t 2.Delete Table \t 3.Display all tables \t 4.Select a table \t 5.Exit");
        int choice = sc.nextInt();

        switch (choice) 
        {
            case 1:
                String tableName = createTable(sc, tableList, selectedDb);
                if (tableName != null) {
                    while (handleTableDataLevel(sc, tableData, tableName)) 
                    {
                        // Looping through table data operations
                    }
                }
                break;

            case 2:
                deleteTable(sc, tableList, selectedDb);
                break;

            case 3:
                tableList.getTableNames(selectedDb);
                break;

            case 4:
                String selectedTable = selectTable(sc, tableList, selectedDb);
                if (selectedTable != null) {
                    while (handleTableDataLevel(sc, tableData, selectedTable))
                     {
                        // Looping through table data operations
                    }
                }
                break;

            case 5:
                return false;

            default:
                System.out.println("Invalid Choice");
        }
        return true;
    }

    private static String createTable(Scanner sc, TableList tableList, String selectedDb) 
    {
        System.out.println("Enter the table name:");
        String tableName = sc.next();
        tableList.addTables(selectedDb, tableName);

        System.out.println("Do you want to insert data into " + tableName + "? \n 1.Yes \t 2.No");
        int choice = sc.nextInt();
        return (choice == 1) ? tableName : null;
    }

    private static void deleteTable(Scanner sc, TableList tableList, String selectedDb) 
    {
        System.out.println("Enter the table name:");
        String tableName = sc.next();
        tableList.deleteTables(selectedDb, tableName);
    }

    private static String selectTable(Scanner sc, TableList tableList, String selectedDb) 
    {
        tableList.getTableNames(selectedDb);
        System.out.print("Enter the index of the table: ");
        int index = sc.nextInt();
        return tableList.getSelectedTableName(selectedDb, index);
    }

    private static boolean handleTableDataLevel(Scanner sc, TableData tableData, String tableName) 
    {
        System.out.println("\nPlease choose the operation: \n 1.Add Data \t 2.Delete Column \t 3.Update Column \t 4.Display Table \t 5.Exit");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                addData(sc, tableData, tableName);
                break;

            case 2:
                deleteColumn(sc, tableData, tableName);
                break;

            case 3:
                updateColumn(sc, tableData, tableName);
                break;

            case 4:
                tableData.displayData(tableName);
                break;

            case 5:
                return false;

            default:
                System.out.println("Invalid Choice");
        }
        return true;
    }

    private static void addData(Scanner sc, TableData tableData, String tableName) {
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();
        for (int i = 0; i < columns; i++) {
            System.out.print("Enter column name: ");
            String columnName = sc.next();
            System.out.print("Enter column value: ");
            String columnValue = sc.next();
            tableData.insertData(tableName, columnName, columnValue);
        }
    }

    private static void deleteColumn(Scanner sc, TableData tableData, String tableName) {
        System.out.print("Enter the column name to delete: ");
        String columnName = sc.next();
        tableData.removeData(tableName, columnName);
    }

    private static void updateColumn(Scanner sc, TableData tableData, String tableName) {
        System.out.print("Enter the column name to update: ");
        String columnName = sc.next();
        System.out.print("Enter the new value: ");
        String columnValue = sc.next();
        tableData.updateData(tableName, columnName, columnValue);
    }    
}
