package cs.vsu.ru.kapustin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsSearch {
    private final int length;
    private final List<String> lines;

    public WordsSearch(int length, List<String> lines) {
        this.length = length;
        this.lines = lines;
    }

    public List<String> findWordsOfGivenLength() {
        List<String> allWords = selectWordsFromText();
        List<String> wordsOfGivenLength = new ArrayList<>();

        for (String word : allWords) {
            if (word.length() == length) {
                if (!isThisWordAppended(word, wordsOfGivenLength)) {
                    wordsOfGivenLength.add(word);
                }
            }
        }

        return wordsOfGivenLength;
    }

    private List<String> selectWordsFromText() {
        List<String> words = new ArrayList<>();

        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я0-9]+");
        Matcher matcher;

        for (String line : lines) {
            matcher = pattern.matcher(line);

            while (matcher.find()) {
                words.add(matcher.group());
            }
        }

        return words;
    }


    private static boolean isThisWordAppended(String word, List<String> words) {
        for (String word1 : words) {
            if (Objects.equals(word, word1)) {
                return true;
            }
        }

        return false;
    }
}
