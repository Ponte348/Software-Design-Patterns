import java.util.*;
import java.io.*;

public class WordSearchGenerator {

    public static String[] readWordList(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            List<String> words = new ArrayList<String>();
            
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineWords = line.split("[,;\\s]+");
                for (String word : lineWords) {
                    if (word.isEmpty()) {
                        scanner.close();
                        throw new IllegalArgumentException("Empty word in word list");
                    }

                    if (!word.matches("[a-zA-Z]+")) {
                        scanner.close();
                        throw new IllegalArgumentException("Invalid word in word list: " + word);
                    }

                    words.add(word);
                }
            }
            scanner.close();
            return words.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
    }

    public static void addWordToPuzzle(List<List<Character>> puzzle, int size, String word) {
        Random random = new Random();
        boolean valid = false;
        int attempts = 0;
        while (!valid) {
            if (attempts > size * size * 1000) {
                throw new IllegalArgumentException("Can't place word " + word + " in the puzzle");
            }

            int row = random.nextInt(size);
            int col = random.nextInt(size);
            int direction = random.nextInt(8);

            // try to place the word in the puzzle
            // words can't overlap and can't go out of bounds
            switch (direction) {
                case 0:
                    if (col + word.length() <= size) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            char currentChar = Character.toUpperCase(puzzle.get(row).get(col + i));
                            if (currentChar != '.' && currentChar != Character.toUpperCase(word.charAt(i))) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row).set(col + i, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 1:
                    if (row + word.length() <= size) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            char currentChar = Character.toUpperCase(puzzle.get(row + i).get(col));
                            if (currentChar != '.' && currentChar != Character.toUpperCase(word.charAt(i))) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row + i).set(col, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 2:
                    if (col - word.length() >= -1) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            char currentChar = Character.toUpperCase(puzzle.get(row).get(col - i));
                            if (currentChar != '.' && currentChar != Character.toUpperCase(word.charAt(i))) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row).set(col - i, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 3:
                    if (row - word.length() >= -1) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            char currentChar = Character.toUpperCase(puzzle.get(row - i).get(col));
                            if (currentChar != '.' && currentChar != Character.toUpperCase(word.charAt(i))) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row - i).set(col, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 4:
                    if (row + word.length() <= size && col + word.length() <= size) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            if (puzzle.get(row + i).get(col + i) != '.') {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row + i).set(col + i, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 5:
                    if (row + word.length() <= size && col - word.length() >= -1) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            if (puzzle.get(row + i).get(col - i) != '.') {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row + i).set(col - i, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 6:
                    if (row - word.length() >= -1 && col - word.length() >= -1) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            if (puzzle.get(row - i).get(col - i) != '.') {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row - i).set(col - i, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                case 7:
                    if (row - word.length() >= -1 && col + word.length() <= size) {
                        valid = true;
                        for (int i = 0; i < word.length(); i++) {
                            if (puzzle.get(row - i).get(col + i) != '.') {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            for (int i = 0; i < word.length(); i++) {
                                puzzle.get(row - i).set(col + i, Character.toUpperCase(word.charAt(i)));
                            }
                        }
                    }
                    break;
                }
        }
    }

    public static String[] checkContainedWords(String[] wordlist) {
        List<String> words = new ArrayList<String>();
        // check if any word from wordlist contains another word, for example "cat" and "caterpillar", "cat" will be removed
        for (String word : wordlist) {
            boolean isDuplicate = false;
            for (String wordCompared : wordlist) {
                if (word != wordCompared && wordCompared.contains(word)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                words.add(word);
            }
        }
        return words.toArray(new String[0]);
    }

    public static List<List<Character>> generateEmptyPuzzle(int size) {
        List<List<Character>> puzzle = new ArrayList<List<Character>>();
        for (int i = 0; i < size; i++) {
            List<Character> row = new ArrayList<Character>();
            for (int j = 0; j < size; j++) {
                row.add('.');
            }
            puzzle.add(row);
        }
        return puzzle;
    }

    public static List<List<Character>> completePuzzle(List<List<Character>> puzzle) {
        for (int i = 0; i < puzzle.size(); i++) {
            for (int j = 0; j < puzzle.get(i).size(); j++) {
                if (puzzle.get(i).get(j) == '.') {
                    puzzle.get(i).set(j, (char) (65 + (int) (Math.random() * 26)));
                }
            }
        }
        return puzzle;
    }

    public static void savePuzzleToFile(List<List<Character>> puzzle, String[] wordlist, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (List<Character> row : puzzle) {
                for (Character c : row) {
                    writer.write(c);
                }
                writer.write("\n");
            }
            for (String word : wordlist) {
                writer.write(word + ";");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }

    public static void main(String[] args) {
        
        // Read parameters -i and -s from args: $ java WSGenerator -i wordlist_1.txt -s 12
        if (args.length != 4 && args.length != 6) {
            System.out.println("Usage: java WSGenerator -i <inputfile> -s <size> -o <outputfile>");
            return;
        }

        String inputfile = args[1];
        int size = Integer.parseInt(args[3]);
        // size can't be bigger than 40
        if (size > 40 || size < 1) {
            throw new IllegalArgumentException("Size must be between 1 and 40");
        }

        // Read word list from file, don't allow small words contained in bigger words
        String[] wordlist = readWordList(inputfile);
        wordlist = checkContainedWords(wordlist);
    
        List<List<Character>> puzzle = generateEmptyPuzzle(size);

        // place the words in the puzzle
        for (String word : wordlist) {
            if (word.length() > size) {
                throw new IllegalArgumentException("Word " + word + " is too long for the puzzle");
            }
            addWordToPuzzle(puzzle, size, word);
        }

        puzzle = completePuzzle(puzzle);
        WordSearchSolver.printPuzzle(puzzle);

        for (String word : wordlist) {
            System.out.print(word + ";");
        }
        System.out.println();

        // If the output file is specified, save the puzzle
        if (args.length == 6) {
            String outputfile = args[5];
            savePuzzleToFile(puzzle, wordlist, outputfile);
        }
    }
}
