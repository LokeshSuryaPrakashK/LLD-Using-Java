import java.util.*;

public class TableData
{
    TableList tableList;
    HashMap<String, HashMap<String, String>> tableData;
    private HashMap<String, String> cellData;
    TableData(TableList tableList)
    {
        this.tableList=tableList;
        tableData=new HashMap<>();
    }

    public void initializeTable(String tableName)
    {
        tableData.putIfAbsent(tableName, new HashMap<String, String>());
    }

    public void insertData(String tableName, String colname, String val)
    {
        initializeTable(tableName);
        if(tableData.containsKey(tableName))
        {
            cellData=tableData.get(tableName);
            if(!cellData.containsKey(colname))
            {
                cellData.put(colname, val);
                System.out.println("Data Inserted Successfully");
            }
            else
            {
                System.out.println("Column already exists, enter different column name");
            }
        }
        else
            System.out.println("Table does not exist: " + tableName);
    }

    public void removeData(String tableName, String colname)
    {
        if(tableData.containsKey(tableName))
        {
            if(cellData.containsKey(colname))
            {
                cellData.remove(colname);
                System.out.println("Data Removed Successfully");
            }
            else
            {
                System.out.println("Column does not exists: " + colname);
            }
        }
        else
            System.out.println("Table does not exist: " + tableName);
    }

    public void updateData(String tableName, String colname, String val)
    {
        if(tableData.containsKey(tableName))
        {
            if(cellData.containsKey(colname))
            {
                cellData.put(colname, val);
                System.out.println("Data Updated Successfully");
            }
            else
            {
                System.out.println("Column does not exists: " + colname);
            }
        }
        else
            System.out.println("Table does not exist: " + tableName);
    }

    public void displayData(String tableName)
    {
        if(tableData.containsKey(tableName))
        {
            HashMap<String, String> cellData=tableData.get(tableName);
            for(Map.Entry<String, String> i:cellData.entrySet())
            {
                System.out.println(i.getKey() + ": " + i.getValue());
            }
        }
        else
            System.out.println("Table does not exists");
    }
}