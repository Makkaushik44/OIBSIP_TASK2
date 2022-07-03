import java.util.Scanner;
import java.util.Random;

class Game {
    int SystemInput;
    int userInput;
    int noOfGuesses = 0;

    Game() {
        Random random = new Random();
        this.SystemInput = random.nextInt(100) + 1;

    }

    public boolean takeUserInput() {

        if (noOfGuesses < 10) {
            System.out.println("Guess the number : ");
            this.userInput = GuessTheNumber.takeIntegerInput(100);
            noOfGuesses++;
            return false;

        } else {
            System.out.println("Number of attempts finished...Better luck next time\n");
            return true;

        }
    }

    public boolean isCorrectGuess() {

        if (SystemInput == userInput) {
            System.out.println(
                    " Congratulation, You guess the number " + SystemInput + " in " + noOfGuesses + " guesses ");
            switch (noOfGuesses) {
                case 1:
                    System.out.println("You score is 100");
                    break;
                case 2:
                    System.out.println("You score is 90");
                    break;
                case 3:
                    System.out.println("You score is 80");
                    break;
                case 4:
                    System.out.println("You score is 70");
                    break;
                case 5:
                    System.out.println("You score is 60");
                    break;
                case 6:
                    System.out.println("You score is 50");
                    break;
                case 7:
                    System.out.println("You score is 40");
                    break;
                case 8:
                    System.out.println("You score is 30");
                    break;
                case 9:
                    System.out.println("You score is 20");
                    break;
                case 10:
                    System.out.println("You score is 10");
                    break;

            }
            System.out.println();
            return true;

        } else if (noOfGuesses < 10 && userInput > SystemInput) {
            if (userInput - SystemInput > 10) {
                System.out.println(" The Number is Too High \n");
            } else {
                System.out.println("The Number is Little High \n");
            }
        } else if (noOfGuesses < 10 && userInput < SystemInput) {
            if (SystemInput - userInput > 10) {
                System.out.println("The Number is Too low \n");
            } else {
                System.out.println("The Number is Little low \n");
            }
        }
        return false;
    }
}

public class GuessTheNumber {
    public static int takeIntegerInput(int limit) {

        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("choose the number between 1 to " + limit);
                    flag = false;

                }

            } catch (Exception e) {
                System.out.println(" Enter only integer value");
                flag = false;

            }
        }
        ;
        return input;

    }

    public static void main(String[] args) {

        System.out.println("1. Start the Game \n2. Exit");
        System.out.println(" Enter Your choice :-");
        int choice = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRound = 0;

        if (choice == 1) {
            while (nextRound == 1) {
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitcross = false;
                System.out.println("\n Round " + ++noOfRound + " Starts...");

                while (!isMatched && !isLimitcross) {
                    isLimitcross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();

                }

                System.out.println("1. Next Round \n2. Exit");
                System.out.println(" Enter Your Choice :-");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }

            }
        } else {
            System.exit(0);
        }
    }
}
