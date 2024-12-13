import java.util.*;
public class SnakeAndLadderPositions
{
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;    
    private int boardsize;
    SnakeAndLadderPositions(int boardsize)
    {
        this.boardsize=boardsize;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        if(boardsize==100)
            default_snake_and_ladder();
    }
    public void addSnake(int start, int end) 
    {
        if (isValidSnake(start, end)) 
        {
            snakes.put(start, end);
        } 
        else 
        {
            System.out.println("Invalid snake positions: Start should be greater than end and both should be within 1 to 100.");
            return;
        }
    }

    public void addLadder(int start, int end) 
    {
        if (isValidLadder(start, end)) 
        {
            ladders.put(start, end);
        } 
        else 
        {
            System.out.println("Invalid ladder positions: Start should be less than end and both should be within 1 to 100.");
            return;
        }
    }

    public boolean isValidLadder(int start, int end)
    {
        return start>0 && start<boardsize && end<boardsize && end>0 && start<end;
    }

    public boolean isValidSnake(int start, int end)
    {
        return start>0 && start<boardsize && end<boardsize && end>0 && start>end;
    }
 
    public void default_snake_and_ladder()
    {
        addSnake(27, 1);
        addSnake(21, 9);
        addSnake(17,4);
        addSnake(19, 7);

        addLadder(3, 22);
        addLadder(5, 8);
        addLadder(11, 26);
        addLadder(20, 29);
    } 
}
