import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        UserData userData = new UserData();
        Database db = new Database(userData);
        TableList tableList = new TableList(db);
        TableData tableData = new TableData(tableList);

        //Uer Level
        do 
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
            System.out.print("Enter your username: ");
            name = sc.next();
            System.out.print("Enter your password: ");
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

            //Database Level
            while (isDataBaseExists)
            {
                System.out.println("\nPlease choose the operation \n 1.Create Database \t 2.Delete Database \t 3.Display all the databases \t4.Select an existing database \t5.Exit from databases");
                int b = sc.nextInt();
                boolean isTableExists = false;
                String selecteddb="";

                if (b == 1) {
                    System.out.println("Enter the database name:");
                    selecteddb = sc.next();
                    db.addDatabase(name, selecteddb);

                    System.out.println("Do you want to create table in "+ selecteddb +"or perform some operations on databases in user account.\n 1.Yes \t2.No");
                    int temp1 = sc.nextInt();
                    if (temp1 == 1) 
                    {
                        isTableExists = true;
                    } 
                    else if (temp1 == 2) 
                    {
                        continue;
                    } 
                    else 
                    {
                        System.out.println("Invalid Choice");
                        continue;
                    }

                    isTableExists = true;
                } 
                else if (b == 2) 
                {
                    System.out.println("Enter the database name:");
                    String dbname = sc.next();
                    db.deleteDatabase(name, dbname);
                    continue;
                } 
                else if (b == 3) 
                {
                    db.getDatabaseNames(name);
                    continue;
                } 
                else if (b == 4) 
                {
                    int z = db.getDatabaseNames(name);
                    if (z != -1) 
                    {
                        System.out.print("Enter the index of wanted database : ");
                        int temp2 = sc.nextInt();
                        String tempdb = db.getSelectedDatabase(name, temp2);
                        selecteddb=tempdb;
                        System.out.println("The selected database is : " + tempdb);
                        System.out.println("Do you want to create table in " + tempdb + " or perform some operations on database\n 1.Yes \t2.No");
                        int temp1 = sc.nextInt();
                        if (temp1 == 1) 
                        {
                            isTableExists = true;
                        } 
                        else if (temp1 == 2) 
                        {
                            continue;
                        } 
                        else 
                        {
                            System.out.println("Invalid Choice");
                            continue;
                        }
                        isTableExists = true;
                    }
                } 
                else if (b == 5) 
                {
                    break;
                } 
                else 
                {
                    continue;
                }

                // TableList Level
                while (isTableExists)
                {
                    System.out.println("\nPlease choose the operation \n 1.Create Table \t 2.Delete Table \t 3.Display all the tables in " + selecteddb + "\t4.Select a table from "+selecteddb +"\t5.Exit from tables");
                    int c = sc.nextInt();
                    boolean isTableDataExists = false;
                    String tableName="";
                    if (c == 1) 
                    {
                        System.out.println("Enter the table name:");
                        tableName = sc.next();
                        tableList.addTables(selecteddb, tableName);
                        System.out.println("Do you want to enter the values in "+tableName+" or perform operations on tables ?\n 1.Yes \t 2.No");
                        int temp3 = sc.nextInt();
                        if (temp3 == 1)
                        {
                            isTableDataExists = true; 
                            // continue;
                        }
                        else if (temp3 == 2)
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("Invalid Choice");
                            continue;
                        }
                    }
                    else if (c == 2)
                    {
                        System.out.println("Enter the table name:");
                        tableName = sc.next();
                        tableList.deleteTables(selecteddb, tableName);
                        continue;
                    }
                    else if (c == 3)
                    {
                        tableList.getTableNames(selecteddb);
                        continue;
                    }
                    else if (c == 4)
                    {
                        tableList.getTableNames(selecteddb);
                        System.out.print("Enter the index of wanted table : ");
                        int temp4 = sc.nextInt();
                        String selectedTableName = tableList.getSelectedTableName(selecteddb, temp4);
                        System.out.println("The selected table is : " + selectedTableName);
                        isTableDataExists = true;                   
                    }
                    else if (c == 5)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Invalid Choice");
                        continue;
                    }

                    // TableData Level
                    while(isTableDataExists)
                    {
                        System.out.print("Enter number of columns in "+tableName+" : ");
                        int noOfColumns = sc.nextInt();
                        for(int i=0;i<noOfColumns;i++)
                        {
                            System.out.print("Enter column name : ");
                            String columnName = sc.next();
                            System.out.print("Enter column value : ");
                            String columnValue = sc.next();
                            tableData.insertData(tableName, columnName, columnValue);
                        }
                        System.out.println("Please choose the operation : \n 1.Add more columns and values in " + tableName+ "\t2.Delete a column in " + tableName+ "\t3.Update the value in a column in "+tableName+"4.Delete a column in "+tableName+"5.Exit");
                    
                        int temp4 = sc.nextInt();
                        if (temp4 == 1) 
                        {
                            continue;
                        } 
                        else if (temp4 == 2) 
                        {
                            System.out.print("Enter the column name to delete : ");
                            String columnName = sc.next();
                            tableData.removeData(tableName, columnName);
                            continue;
                        } 
                        else if (temp4 == 3) 
                        {
                            System.out.print("Enter the column name to update value in it : ");
                            String columnName = sc.next();
                            System.out.print("Enter the new value : ");
                            String newColumnValue = sc.next();
                            tableData.updateData(tableName, columnName, newColumnValue);
                            continue;
                        } 
                        else if (temp4 == 4)
                        {
                            System.out.print("Enter the column name to delete : ");
                            String columnName = sc.next();
                            tableData.removeData(tableName, columnName);
                            continue;
                        }
                        else if(temp4==5)
                        {
                            break;
                        }
                        else 
                        {
                            System.out.println("Invalid Choice");
                            continue;
                        }
                    
                    }
                    

                } 
            }
        }while (true);

        sc.close();
    }
}