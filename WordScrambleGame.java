import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordScrambleGame {
    private String gameName;
    private String gameDescription;
    private List<String> words;

    public WordScrambleGame() {
        this.gameName = "Word Scramble Game for Kids";
        this.gameDescription = "Unscramble the words and guess them correctly! Get a hint if you're stuck.";
        this.words = Arrays.asList("apple", "banana", "orange", "grapes", "elephant", "tiger", "pencil", "monkey");
    }

    private String scrambleWord(String word) {
        List<Character> characters = Arrays.asList(new Character[word.length()]);
        for (int i = 0; i < word.length(); i++) {
            characters.set(i, word.charAt(i));
        }
        Collections.shuffle(characters);
        StringBuilder scrambled = new StringBuilder();
        for (char c : characters) {
            scrambled.append(c);
        }
        return scrambled.toString();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎉 Welcome to " + gameName + "! 🎉");
        System.out.println(gameDescription);

        Collections.shuffle(words);
        int score = 0;

        for (String word : words) {
            String scrambledWord = scrambleWord(word);
            System.out.println("🔠 Unscramble this word: " + scrambledWord);

            boolean guessedCorrectly = false;
            int attempts = 0;
            while (attempts < 3 && !guessedCorrectly) {
                System.out.print("Your guess (or type 'hint'): ");
                String userGuess = scanner.nextLine().trim();
                if (userGuess.equalsIgnoreCase("hint")) {
                    System.out.println("💡 Hint: The first letter is '" + word.charAt(0) + "'");
                    continue;
                }
                if (userGuess.equalsIgnoreCase(word)) {
                    System.out.println("✅ Correct!");
                    score++;
                    guessedCorrectly = true;
                } else {
                    System.out.println("❌ Try again!");
                    attempts++;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("😞 The correct word was: " + word);
            }
        }

        System.out.println("🎊 Game Over! Your final score: " + score + "/" + words.size() + " 🎊");
        scanner.close();
    }

    public static void main(String[] args) {
        WordScrambleGame game = new WordScrambleGame();
        game.playGame();
    }
}