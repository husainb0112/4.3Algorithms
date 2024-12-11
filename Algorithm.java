import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Algorithm {
    private static File f;
    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");

        int twoLetters = twoLetters();
        int mostLetters = mostLetters();
        int palindromes = palindromes();
        

        System.out.println("Two letter words: " + twoLetters);
        System.out.println("Most letter words: " + mostLetters);
        System.out.println("Palindromes: " + palindromes);

        s.close();
    }

    public static int twoLetters() throws FileNotFoundException {
        s = new Scanner(f);
        int twoLetterWords = 0;
        while (s.hasNext()) {
            if (s.next().length() == 2)
                twoLetterWords++;
        }
        return twoLetterWords;
    }

    public static int mostLetters() throws FileNotFoundException {
        int maxLength = 0;
        s = new Scanner(f);
        int mostLetterWords = 0;
        while (s.hasNext()) {
            String word = s.next();
            if (word.length() > maxLength)
                maxLength = word.length();
        }
        s.close();
        s = new Scanner(f);
        while (s.hasNext()) {
            String word = s.next();
            if (word.length() == maxLength)
                mostLetterWords++;
        }
        return mostLetterWords;
    }

    public static int palindromes() throws FileNotFoundException {
        s = new Scanner(f);
        int palindromes = 0;
        while (s.hasNext()) {
            String word = s.next();
            String wordPalindrome = "";
            for(int i = word.length() - 1; i >= 0; i--) {
                wordPalindrome += word.charAt(i);
            }
            if (wordPalindrome.equals(word)) {
                palindromes++;
            }
        }
        return palindromes;
    }

}