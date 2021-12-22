package cs.vsu.ru.kapustin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utils {

    public static List<String> readLinesFromFile(File file) throws FileNotFoundException {
        Scanner scn = new Scanner(file);
        List<String> lines = new ArrayList<>();

        while (scn.hasNext()) {
            lines.add(scn.nextLine());
        }

        return lines;
    }

    public static List<String> readWordsFromFile(File file) throws FileNotFoundException {
        List<String> lines = readLinesFromFile(file);
        List<String> words = new ArrayList<>();
        String[] wordsOfLine;

        for (String line : lines) {
            wordsOfLine = line.split(", ");
            words.addAll(List.of(wordsOfLine));
        }

        return words;
    }

    public static void printWordsToFile(List<String> words, String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);

        for (String word : words) {
            out.print(word);

            if (!Objects.equals(word, words.get(words.size() - 1))) {
                out.print(", ");
            }
        }

        out.close();
    }

    public static void printWordsToConsole(List<String> words) {
        for (String word : words) {
            System.out.print(word);

            if (!Objects.equals(word, words.get(words.size() - 1))) {
                System.out.print(", ");
            }
        }
    }
}
