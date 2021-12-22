package cs.vsu.ru.kapustin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
    }

    public static CmdParams parseArgs(String[] args) {
        ConsoleMain.CmdParams params = new CmdParams();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }

            params.inputFile = args[0];
            if (args.length > 1) {
                params.outputFile = args[1];
                return params;
            }
        } else {
            params.help = true;
            params.error = true;
        }

        return params;
    }

    public static void main(String[] args) throws FileNotFoundException {
        CmdParams params = parseArgs(args);
        File inputFile = new File(params.inputFile);

        if (params.help) {
            printHelp(params);
        } else if (!inputFile.exists()) {
            printError(0, params);
        } else {
            List<String> lines = Utils.readLinesFromFile(inputFile);

            if (lines.size() < 2) {
                printError(3, params);
            } else {
                int length = 0;

                Scanner scn = new Scanner(lines.get(0));
                if (scn.hasNextInt()) {
                    length = Integer.parseInt(lines.get(0));
                    lines.remove(0);

                    if (length <= 0) {
                        printError(1, params);
                    }
                } else {
                    printError(2, params);
                }

                WordsSearch search = new WordsSearch(length, lines);
                List<String> words = search.findWordsOfGivenLength();

                if (params.outputFile == null) {
                    Utils.printWordsToConsole(words);
                } else {
                    Utils.printWordsToFile(words, params.outputFile);
                }
            }
        }
    }

    private static void printHelp(CmdParams params) {
        PrintStream out = params.error ? System.err : System.out;
        out.println("Usage:");
        out.println("  <cmd> args <input-file> (<output-file>)");
        out.println("  <cmd> --help");
    }

    private static void printError(int errorCode, CmdParams params) {
        if (errorCode == 0) {
            System.err.println("The file " + params.inputFile + " specified cannot be found!");
        } else if (errorCode == 1) {
            System.err.println("The data in the file " + params.inputFile + " is incorrect!");
            System.err.print("Length for the searching words must be greater than 0.");
        } else if (errorCode == 2) {
            System.err.println("The data in the file " + params.inputFile + " is incorrect!");
            System.err.print("Length for the searching words must be an integer.");
        } else {
            System.err.println("Data entered incorrectly.");
            System.err.print("The file " + params.inputFile + " must contain word length and text.");
        }
    }
}
