import java.util.*;
public class Player_Turn 
{
    private int noOfPlayers;
    private LinkedList<Integer> playerturn;
    private Player playerposition;
    Player_Turn(int noOfPlayers, Player playerPosition)
    {
        this.noOfPlayers=noOfPlayers;
        playerturn=new LinkedList<>();
        this.playerposition=playerPosition;
        initializeQueue();
    }
    public void initializeQueue() 
    {
        // playerturn.clear(); 
        for(int i=1;i<=noOfPlayers;i++)
        {
            playerturn.add(i);
            playerposition.addPlayer(i);
        }
    }

    public int nextTurn()
    {
        int playerId=playerturn.poll();
        playerturn.add(playerId);
        return playerId;
    }
}
