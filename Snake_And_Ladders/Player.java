import java.util.*;
public class Player 
{
    HashMap<Integer, Integer> playerPosition;
    Player()
    {   
        playerPosition=new HashMap<Integer, Integer>();
    }  

    
    public void addPlayer(int playerid)
    {
        if(!playerPosition.containsKey(playerid))
            playerPosition.put(playerid, 0);
        else
        {
            System.out.println("Player with the same id already exists.");
        }
    }
    
    public void removePlayer(int playerid)
    {
        if(!playerPosition.containsKey(playerid))
            playerPosition.remove(playerid);
        else
        {
            System.out.println("Player with the same id already exists.");
        }
    }

    public int getPosition(int playerid)
    {
        if(playerPosition.containsKey(playerid))
            return playerPosition.get(playerid);
        else
        {
            System.out.println("Player not found.");
            return -1;
        }
    }
    public void setPosition(int playerid, int position)
    {
        playerPosition.put(playerid, position);
    }
}
