public class Gameboard {
    private int boardsize;
    private Dice dice;
    private Player_Turn player_Turn;
    private Player playerposition;
    private SnakeAndLadderPositions snakeladderpositions;


    Gameboard(int boardsize, Dice dice, Player_Turn players, Player player, SnakeAndLadderPositions snakeladderpositions)
    {
        this.boardsize = boardsize;
        this.dice = dice;
        this.player_Turn = players;
        this.snakeladderpositions = snakeladderpositions;
        this.playerposition = player;
    }

    public void playGame() 
    {
        System.out.println("Starting the game! Board size: " + boardsize);

        boolean isGameOver = false;
        
        while (!isGameOver)
        {
            int currentPlayer = player_Turn.nextTurn();
            System.out.println("Player " + currentPlayer + "'s turn!");

            int currentPosition = playerposition.getPosition(currentPlayer);
            int newPosition=currentPosition;
            int conseutive_six_count=0;
            
            //for handling getting three 6's in a row
            while (true) 
            {
                int temp=dice.roll();

                if (temp == 6) 
                {
                    conseutive_six_count++;
                    if (conseutive_six_count == 3) 
                    {
                        System.out.println("Player " + currentPlayer + " rolled a 6. Rolling again...");
                        System.out.println("Oops! Player " + currentPlayer + " rolled three 6's in a row. Turn skipped!");
                        newPosition = currentPosition;
                        break;
                    }
                    newPosition += temp; 
                    System.out.println("Player " + currentPlayer + " rolled a 6. Rolling again...");
                } 
                else 
                {
                    System.out.println("Player " + currentPlayer + " rolled: " + temp);
                    newPosition += temp;
                    break;
                }
            }


            if (newPosition > boardsize) 
            {
                System.out.println("Player " + currentPlayer + " stays at position " + currentPosition + " (Exceeds board size).");
                newPosition=currentPosition;
            }
            else if (newPosition == boardsize)
            {
                isGameOver = true;
                System.out.println("!!!!!Player " + currentPlayer + " wins!!!!!");
            }
            else
            {
                newPosition = getNewPosition(newPosition);
                
                playerposition.setPosition(currentPlayer, newPosition);
                System.out.println("Player " + currentPlayer + " moves to position " + newPosition);
            }
        }
    }

    public int getBoardSize()
    {
        return boardsize;
    }
    private int getNewPosition(int position) 
    {
        if (snakeladderpositions.snakes.containsKey(position)) 
        {
            System.out.println("Oops! Bitten by a snake. Sliding down to " + snakeladderpositions.snakes.get(position));
            return snakeladderpositions.snakes.get(position);
        } else if (snakeladderpositions.ladders.containsKey(position)) 
        {
            System.out.println("Yay! Climbed a ladder. Moving up to " + snakeladderpositions.ladders.get(position));
            return snakeladderpositions.ladders.get(position);
        }
        return position;
    }
}
