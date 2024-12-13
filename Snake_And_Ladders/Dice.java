import java.util.Random;

public class Dice
{
    private int noOfDice;
    private Random rand;
    Dice(int noOfDice)
    {
        this.noOfDice = noOfDice;
        this.rand = new Random();
    }
    public int roll()
    {
        return rand.nextInt(noOfDice*6)+1;
    }
}