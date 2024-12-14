import java.util.*;
class Main
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);   

        System.out.println("Enter the size of the board:");
        int boardSize = sc.nextInt();

        SnakeAndLadderPositions snakeAndLadderPositions = new SnakeAndLadderPositions(boardSize);

        if(boardSize !=100)
        {
            System.out.println("Enter the number of snakes:");
            int numberOfSnakes = sc.nextInt();
            System.out.println("Enter the head and tail of each snake (space-separated):");
            for (int i = 0; i < numberOfSnakes; i++) 
            {
                int head = sc.nextInt();
                int tail = sc.nextInt();
                snakeAndLadderPositions.addSnake(head, tail);
            }

            System.out.println("Enter the number of ladders:");
            int numberOfLadders = sc.nextInt();
            System.out.println("Enter the bottom and top of each ladder (space-separated):");
            for (int i = 0; i < numberOfLadders; i++) 
            {
                int bottom = sc.nextInt();
                int top = sc.nextInt();
                snakeAndLadderPositions.addLadder(bottom, top);
            }  
        }
        else
        {
            System.out.println("Board size is 100.");
        }

        System.out.println("Enter the number of players:");
        int numberOfPlayers = sc.nextInt();

        System.out.println("Enter number of Dice");
        int numberOfDice = sc.nextInt();
        Dice dice = new Dice(numberOfDice);

        Player playerposition=new Player();
        Player_Turn players=new Player_Turn(numberOfPlayers, playerposition); 


        Gameboard game = new Gameboard(boardSize, dice, players, playerposition, snakeAndLadderPositions);


        game.playGame();

        sc.close();
    }   
}
