import java.util.*;
public class Database 
{
    HashMap<String,LinkedList<String>> database=new HashMap<>();
    UserData userData;
    Database(UserData userData) 
    {
        this.userData = userData;
    }   
    public void addDatabase(String user, String databaseName)
    {
        database.putIfAbsent(user,new LinkedList<>());
        LinkedList<String> databasesList = database.get(user);
        if(!databasesList.contains(databaseName))
        {
            databasesList.add(databaseName);
            database.put(user, databasesList);
            System.out.println(databaseName+" database is created successfully");
        }
        else
        {
            System.out.println(databaseName+" database already exists.");
        }
    }

    public boolean deleteDatabase(String user, String databaseName)
    {
        if(database.containsKey(user))
        {
            LinkedList<String> databasesList = database.get(user);
            if(databasesList.contains(databaseName))
            {
                databasesList.remove(databaseName);
                System.out.println(databaseName+" deleted successfully");
                return true;
            }
            else
            {
                System.out.println("Database does not exists.");
                return false;
            }
        }
        else
        {
            System.out.println("The database "+databaseName+" does not exist.");
            return false;
        }
    }


    public void getDatabaseNames(String username)
    {
        if(database.containsKey(username))
        {
            LinkedList<String> databasesList = database.get(username);
            for(String i:databasesList)
            {
                System.out.print(i+", ");
            }
            System.out.println();
        }
        else
        {
            System.out.println("User does not exist.");
        }
    }
}
