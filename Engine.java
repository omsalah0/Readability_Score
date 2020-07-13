package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Engine {
    static double score;
    static String path;
    static int characters;
    static int words;
    static int sentences;
    static int syllables;
    static int polysyllables;


    public Engine(String path) {
        this.path = path;
    }

    public void run() {
        try {
            String text = read_text(path);
            splitting(text);
            printable_func();
        } catch (IOException e) {
            System.out.println("cannot open the file," + e.getMessage());
        }

    }

    private void printable_func() {
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        MakeOrder(input);

    }

    private void MakeOrder(String input) {
        Automated_Readability_base runnable1 = new Automated_Readability_base();
        FleschKincaid runnable2 = new FleschKincaid();
        SMOG_index runnable3 = new SMOG_index();
        Coleman_Liau runnable4 = new Coleman_Liau();
        switch (input) {
            case "ARI":
                runnable1.runnable();
                break;
            case "FK":
                runnable2.runnable();
                break;
            case "SMOG":
                runnable3.runnable();
                break;
            case "CL":
                runnable4.runnable();
                break;
            case "all":
                runnable1.runnable();
                runnable2.runnable();
                runnable3.runnable();
                runnable4.runnable();
                avg();
                break;
            default:
                System.out.println("write in upper case try again...");
        }
    }

    private void avg() {
        double avg = (double) (FleschKincaid.age_FK + SMOG_index.age_SMOG + Coleman_Liau.age_Coleman + Automated_Readability_base.age_ARI) / 4;
        System.out.println("\nThis text should be understood in average by " + avg + " year olds.");
    }


    private String read_text(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private void splitting(String text) {
        String[] sentence = text.split("[.!?]");
        String[] word = text.split("\\s+");
        String[] copiedword = Arrays.copyOf(word, word.length);
        for (int i = 0; i < word.length; i++) {
            copiedword[i] = copiedword[i].replace(".", "");
            copiedword[i] = copiedword[i].replace("!", "");
            copiedword[i] = copiedword[i].replace(",", "");
        }

        characters = 0;
        syllables = 0;
        polysyllables = 0;
        for (int i = 0; i < word.length; i++) {
            word[i] = word[i].toLowerCase();
            copiedword[i] = copiedword[i].toLowerCase();
            characters += word[i].length();
            syllables += countSyllable(copiedword[i]);

        }

        sentences = sentence.length;
        words = word.length;


    }


    private int countSyllable(String word) {
        String re = "([aeiouy]+)";
        Matcher matcher = Pattern.compile(re).matcher(word);
        int count = 0;
        while (matcher.find()) {
            count++;

        }
        if (word.endsWith(String.valueOf('e'))) {
            count--;
        }
        if (count >= 3) {
            polysyllables++;
        }
        return Math.max(1, count);
    }

}
