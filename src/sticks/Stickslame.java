package sticks;

import java.util.Scanner;

public class Stickslame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the game of sticks! \nHow many sticks are there on the table initially (10-100)?");
        int count = s.nextInt();
        while (count < 10 || count > 100) {
            System.out.println("Please enter a number between 10 and 100.");
            count = s.nextInt();
        }
        System.out.println("Options: Play against a friend (1) Play against the computer (2) Which option do you take (1-2)?");
        int option = s.nextInt();
        while (option < 1 || option > 2) {
            System.out.println("Sorry, thats not a valid option. Please choose (1) or (2).");
            option = s.nextInt();
        }
        if (option == 1) {
            System.out.println("Player 1: Good luck!\n" + "Player 2: Good luck!");
            int player;
            for (player = 0; count > 1; player++) {
                printCount(count);
                count -= getSticks(count, player % 2, s);
            }
            if (player % 2 == 1)
                System.out.println("Player 1, you win.\nPlayer 2, you lose.");
            else
                System.out.println("Player 2, you win.\nPlayer 1, you lose.");

        }


    }

    private static void printCount(int count) {
        if (count > 1) {
            System.out.println("There are " + count + " sticks on the board.");
        } else {
            System.out.println("There is 1 stick on the board.");
        }
    }

    private static int getSticks(int count, int player, Scanner s) {
        player++;
        System.out.println("Player " + player + ": How many sticks do you take? (1-3)?");
        int took = s.nextInt();
        while (took < 1 || took > 3 || count - took < 1) {
            System.out.println("Sorry, thats an invalid number of sticks. Please try again.");
            took = s.nextInt();
        }
        return took;
    }
}
