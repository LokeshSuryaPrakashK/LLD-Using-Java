import java.util.*;

public class TableList 
{
    Database database;
    HashMap<String,LinkedList<String>> tableList;
    TableList(Database database)
    {
        this.database = database;
        this.tableList = new HashMap<>();
    }    

    public void initializeTableList(String dbname)
    {
        tableList.putIfAbsent(dbname, new LinkedList<>());
    } 

    public boolean addTables(String dbname, String tableName)
    {
        initializeTableList(dbname);
        LinkedList<String> temp = tableList.get(dbname);
        if(!temp.contains(tableName))
        {
            temp.add(tableName);
            tableList.put(dbname, temp);
        }
        else
            System.out.println("Table already exists.");
        return true;
    }

    public boolean deleteTables(String dbname, String tableName)
    {
        if(tableList.containsKey(dbname))
        {
            LinkedList<String> templist = tableList.get(dbname);
            if(templist.contains(tableName))
            {
                templist.remove(tableName);
            }
            else
                System.out.println("Table does not exists.");
        }
        else
            System.out.println("Database does not exist.");
        return false;
    }


    public void getTableNames(String dbname)
    {
        if(tableList.containsKey(dbname))
        {
            for(String i: tableList.get(dbname))
            {
                System.out.print(i+", ");
            }
        }
        else
            System.out.println("DataBase does not exist.");
    }

}
