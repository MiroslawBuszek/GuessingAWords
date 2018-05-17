package Game;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "elephant", "giraffe"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int fails = 0;
        int round = 0;
        String answer;
        while (fails <= 3) {
            String word = words[random.nextInt(words.length)];
            String hashWord = word;

            for (int i = 0; i < round; i += 5) {
                char randomChar = hashWord.charAt(random.nextInt(hashWord.length()));
                if (randomChar == '*') {
                    i--;
                    continue;
                }
                hashWord = hashWord.replaceFirst(String.valueOf(randomChar), "*");
            }

            System.out.println("Your random word: " + hashWord);
            System.out.print("Give me an answer: ");
            answer = scanner.nextLine();

            if (word.equalsIgnoreCase(answer)) {
                System.out.println("Success!!!");
                round++;
            } else {
                System.out.println("Wrong answer!");
                fails++;
            }
        }
        System.out.print("The end. Your score is " + round);
    }
}


