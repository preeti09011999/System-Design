
import java.util.Random;

public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount){
        this.diceCount = diceCount;
    }

    public int rollDice(){
        int diceRolled = 0;
        int totalSum = 0;
        while(diceRolled++ < diceCount){
            Random rndm = new Random();
            totalSum += rndm.nextInt(min, max);
        }
        return totalSum;
    }
}
