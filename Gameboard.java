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

            int diceRoll = dice.roll();
            System.out.println("Player " + currentPlayer + " rolled: " + diceRoll);

            int currentPosition = playerposition.getPosition(currentPlayer);
            int newPosition = currentPosition + diceRoll;


            if (newPosition > boardsize) 
            {
                System.out.println("Player " + currentPlayer + " stays at position " + currentPosition + " (Exceeds board size).");
                newPosition=currentPosition;
            }


            newPosition = getNewPosition(newPosition);
            

            playerposition.setPosition(currentPlayer, newPosition);
            System.out.println("Player " + currentPlayer + " moves to position " + newPosition);


            if (newPosition == boardsize)
            {
                isGameOver = true;
                System.out.println("!!!!!Player " + currentPlayer + " wins!!!!!");
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
