import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            UserData userData = new UserData();
            Database db = new Database(userData);
            TableList tableList = new TableList(db);
            TableData tableData = new TableData(tableList);

            while (true) 
            {
                if (!util_methods.handleUserLevel(sc, userData, db, tableList, tableData)) 
                {
                    break;
                }
            }
            sc.close();
        }
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    
}
