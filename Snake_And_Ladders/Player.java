import java.util.*;
public class Player 
{
    HashMap<Integer, Integer> playerPosition;
    private int boardsize=100;
    Player()
    {   
        playerPosition=new HashMap<Integer, Integer>();
        // this.boardsize=gameboard.getBoardSize();
    }  

    // public boolean validPlayerId(int id)
    // {
    //     if(id>0 && id<=noOfPlayers) 
    //         return true;
    // }
    
    public void addPlayer(int playerid)
    {
        if(!playerPosition.containsKey(playerid))
            playerPosition.put(playerid, 0);
        else
        {
            System.out.println("Player with the same id already exists.");
            return;
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
        if(position>0 && position<=boardsize)
        {
            playerPosition.put(playerid, position);
        }
        else
        {
            System.out.println("Invalid position.");
        }
    }
}
