import java.util.*;

public class UserData 
{
    HashMap<String, String> authentication_data;

    UserData() 
    {
        authentication_data = new HashMap<>();
    }

    public void addAuthenticateData(String name, String password) 
    {
        if (!authentication_data.containsKey(name)) 
        {
            authentication_data.put(name, password);
            System.out.println("!!! Your Account " + name + " has been created");
        } 
        else 
        {
            System.out.println("User " + name + " has already exists in the system, Please enter unique name");
        }
    }

    public boolean authenticate(String name, String password) 
    {
        if (authentication_data.containsKey(name)) 
        {
            if (authentication_data.get(name).equals(password)) 
            {
                System.out.println("!!! Welcome back " + name + " !!!");
                return true;
            } 
            else 
            {
                System.out.println("!!! Incorrect Password or Username!!!");
                return false;
            }
        } 
        else 
        {
            System.out.println("!!! Username Does not exists in the database !!!");
            return false;
        }
    }
}