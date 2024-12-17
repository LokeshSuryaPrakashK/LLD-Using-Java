import java.util.*;

public class TableData
{
    TableList tableList;
    HashMap<String, HashMap<String, String>> tableData;
    private HashMap<String, String> cellValues;
    TableData(TableList tableList)
    {
        this.tableList=tableList;
        tableData=new HashMap<>();
    }

    public void initializeTable(String tableName)
    {
        HashMap<String, String> cellValues=new HashMap<>();
        tableData.put(tableName, cellValues);
    }

    public void insertData(String tableName, String colname, String val)
    {
        if(tableData.containsKey(tableName))
        {
            HashMap<String, String> cellValues=tableData.get(tableName);
            if(!cellValues.containsKey(colname))
            {
                cellValues.put(colname, val);
                System.out.println("Data Inserted Successfully");
            }
            else
            {
                System.out.println("Column already exists: " + colname);
            }
        }
        else
            System.out.println("Table does not exist: " + tableName);
    }

    public void removeData(String tableName, String colname, String val)
    {
        if(tableData.containsKey(tableName))
        {
            if(cellValues.containsKey(colname))
            {
                cellValues.remove(colname);
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
            if(cellValues.containsKey(colname))
            {
                cellValues.put(colname, val);
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
            HashMap<String, String> cellValues=tableData.get(tableName);
            for(Map.Entry<String, String> i:cellValues.entrySet())
            {
                System.out.println(i.getKey() + ": " + i.getValue());
            }
        }
        else
            System.out.println("Table does not exists");
    }
}
