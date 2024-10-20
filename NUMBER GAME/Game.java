import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Random value= new Random();
        Scanner scanner = new Scanner(System.in);

        int score = 10;
        int attempts = 10;
        int input;
        int number = value.nextInt(100) ; 

        System.out.println("Guess the number between 1 and 100");

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter your number: ");
            input = scanner.nextInt();

            

            if (number == input) {
                System.out.println("Your Numner is Correct");
                System.out.println("Your score is: " + score);
                break;
            }

            if (number > input) {
                System.out.println("Your guess is too low.");
                score--;
                --attempts;
                System.out.println("Attempts left: " + attempts);
            }

            if (number < input) {
                System.out.println("Your guess is too high.");
                --score;

                attempts--; 
                System.out.println("Attempts left: " + attempts);

            }
            if (input > 100) {
                System.out.println("You have entered number out of the range");
                continue;
            }

            if (attempts == 0) {
                System.out.println("Your chance is over.Exiting......\n The number was " + number + ".");
            }
        }

    }
}
