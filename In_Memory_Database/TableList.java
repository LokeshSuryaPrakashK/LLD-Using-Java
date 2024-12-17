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
                System.out.println(tableName+"table is removed successfully");
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
            int y=1;
            for(String i: tableList.get(dbname))
            {
                System.out.print(y+"."+i+"\t");
                y++;
            }
            System.out.println();
        }
        else
            System.out.println("Table does not exist in the Database.");
    }

    public String getSelectedTableName(String dbname, int index)
    {
        getTableNames(dbname);
        LinkedList<String> templist = tableList.get(dbname);
        if(index<=templist.size() && index>0)
        {
            String selectedTableName=templist.get(index-1);
            return selectedTableName;
        }
        return "";
    }
}