import cs.vsu.ru.kapustin.Utils;
import cs.vsu.ru.kapustin.WordsSearch;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class WordsSearchTest {
    WordsSearch search;
    File inputFile;
    File outputFile;

    @Test
    public void wordSearchTestForLength5() throws FileNotFoundException {
        inputFile = new File("testSrc/testFiles/inputForWordsSearchTestWithLength5.txt");
        List<String> lines = Utils.readLinesFromFile(inputFile);

        int length = 5;

        search = new WordsSearch(length, lines);
        List<String> actualWords = search.findWordsOfGivenLength();

        outputFile = new File("testSrc/testFiles/answerForWordSearchTestWithLength5.txt");
        List<String> expectedWords = Utils.readWordsFromFile(outputFile);

        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void wordSearchTestForLength4() throws FileNotFoundException {
        inputFile = new File("testSrc/testFiles/inputForWordsSearchTestWithLength4.txt");
        List<String> lines = Utils.readLinesFromFile(inputFile);

        int length = 4;

        search = new WordsSearch(length, lines);
        List<String> actualWords = search.findWordsOfGivenLength();

        outputFile = new File("testSrc/testFiles/answerForWordSearchTestWithLength4.txt");
        List<String> expectedWords = Utils.readWordsFromFile(outputFile);

        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void wordSearchTestForLength6() throws FileNotFoundException {
        inputFile = new File("testSrc/testFiles/inputForWordsSearchTestWithLength6.txt");
        List<String> lines = Utils.readLinesFromFile(inputFile);

        int length = 6;

        search = new WordsSearch(length, lines);
        List<String> actualWords = search.findWordsOfGivenLength();

        outputFile = new File("testSrc/testFiles/answerForWordSearchTestWithLength6.txt");
        List<String> expectedWords = Utils.readWordsFromFile(outputFile);

        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void wordSearchTestForLength7() throws FileNotFoundException {
        inputFile = new File("testSrc/testFiles/inputForWordsSearchTestWithLength7.txt");
        List<String> lines = Utils.readLinesFromFile(inputFile);

        int length = 7;

        search = new WordsSearch(length, lines);
        List<String> actualWords = search.findWordsOfGivenLength();

        outputFile = new File("testSrc/testFiles/answerForWordSearchTestWithLength7.txt");
        List<String> expectedWords = Utils.readWordsFromFile(outputFile);

        Assert.assertEquals(expectedWords, actualWords);
    }

    @Test
    public void wordSearchTestForLength8() throws FileNotFoundException {
        inputFile = new File("testSrc/testFiles/inputForWordsSearchTestWithLength8.txt");
        List<String> lines = Utils.readLinesFromFile(inputFile);

        int length = 8;

        search = new WordsSearch(length, lines);
        List<String> actualWords = search.findWordsOfGivenLength();

        outputFile = new File("testSrc/testFiles/answerForWordSearchTestWithLength8.txt");
        List<String> expectedWords = Utils.readWordsFromFile(outputFile);

        Assert.assertEquals(expectedWords, actualWords);
    }
}