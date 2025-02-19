// Lab I - Word Search Solver

import java.util.*;
import java.io.*;

public class WordSearchSolver {

    public static int getPuzzleSize(String filename) throws Exception {
        File input = new File(filename);
        Scanner sc = new Scanner(input);
        
        // if there are no lines in the file, end the program with an error
        if (!sc.hasNextLine()) {
            sc.close();
            throw new Exception("Empty file");
        }

        // 1.a).1 - puzzle is always a square, so we can use the first line to get the size
        String firstLine = sc.nextLine();
        int size = firstLine.length();
        // 1.a).1 - if size is bigger than 40, end the program with an error
        if (size > 40) {
            sc.close();
            throw new Exception("Puzzle size is too big. Max size is 40x40");
        }

        sc.close();
        return size;
    }

    public static List<List<Character>> getPuzzle(String filename) throws Exception {
        List<List<Character>> puzzle = new ArrayList<>();
        int size = getPuzzleSize(filename);
        File input = new File(filename);
        Scanner sc = new Scanner(input);
        
        for (int i = 0; i < size; i++) {
            String line = sc.nextLine();

            // 1.a).5 - if the line is empty, end the program with an error
            if (line.isEmpty()) {
                sc.close();
                throw new Exception("Empty line in file");
            }

            List<Character> row = new ArrayList<>();
            for (char c : line.toCharArray()){
                // 1.a).1 - if the line has a different size than the first line, end the program with an error
                if (line.length() != size) {
                    sc.close();
                    throw new Exception("Puzzle is not a square");
                }

                // 1.a).2 - if the line has a lowercase character (or a character that is not a letter), end the program with an error
                if (!Character.isLetter(c) || Character.isLowerCase(c)) {
                    sc.close();
                    throw new Exception("Invalid character in puzzle");
                }

                row.add(c);
            }
            puzzle.add(row);
        }
        sc.close();

        return puzzle;
    }

    public static List<String> getWords(String filename) throws Exception {
        List<String> words = new ArrayList<>();
        File input = new File(filename);
        Scanner sc = new Scanner(input);
        
        // skip the puzzle by checking the size of the first line and skipping that many lines
        int size = getPuzzleSize(filename);
        for (int i = 0; i < size; i++) {
            sc.nextLine();
        }

        while (sc.hasNext()) {
            String line = sc.nextLine();
            // 1.a).6 - words can be separated by spaces, commas or semicolons
            String[] lineWords = line.split("[,;\\s]+");
            for (String word : lineWords) {
                // 1.a).5 - if the word is empty, end the program with an error
                if (word.isEmpty()) {
                    sc.close();
                    throw new Exception("Empty word in file");
                }

                // 1.a).3 - words can have lower or upper case letters
                // 1.a).4 - if the word has a non-letter character, end the program with an error
                if (!word.matches("[a-zA-Z]+")) {
                    sc.close();
                    throw new Exception("Invalid character in word");
                }
                words.add(word);
            }
        }
        sc.close();

        // 1.a.8 - check if there are any words that contain other words, if so we only count the bigger word
        List<String> wordsToRemove = new ArrayList<>();
        for (String word : words) {
            for (String otherWord : words) {
                if (!word.equals(otherWord) && word.contains(otherWord)) {
                    wordsToRemove.add(otherWord);
                }
            }
        }
        words.removeAll(wordsToRemove);

        return words;
    }

    public static int[][] getNeighbors(int i, int j) {
        return new int[][]{
            {i-1, j-1}, {i-1, j}, {i-1, j+1},
            {i, j-1}, {i, j+1},
            {i+1, j-1}, {i+1, j}, {i+1, j+1}
        };
    }

    public static int[] solveWord(List<List<Character>> puzzle, String word, int i, int j) {
        // takes i and j as the starting position and for each direction, checks if the word can be found
        // by taking the word length and checking if the characters in that direction are the same as the word
        for (int[] neighbor : getNeighbors(i, j)) {
            int ni = neighbor[0];
            int nj = neighbor[1];
            if (ni >= 0 && ni < puzzle.size() && nj >= 0 && nj < puzzle.get(i).size()) {
                int dx = ni - i;
                int dy = nj - j;
                if (dx == 0 || dy == 0 || Math.abs(dx) == Math.abs(dy)) {
                    int k = 1;
                    for (k = 1; k < word.length(); k++) {
                        int nni = i + k*dx;
                        int nnj = j + k*dy;
                        if (nni < 0 || nni >= puzzle.size() || nnj < 0 || nnj >= puzzle.get(i).size()) {
                            break;
                        }
                        if (Character.toLowerCase(puzzle.get(nni).get(nnj)) != Character.toLowerCase(word.charAt(k))) {
                            break;
                        }
                    }
                    if (k == word.length()) {
                        return new int[]{ni, nj};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    public static String getOrientation(int i, int j, int ni, int nj) {
        if (i == ni) {
            return (j < nj) ? "Right" : "Left";
        } else if (j == nj) {
            return (i < ni) ? "Down" : "Up";
        } else {
            int dx = ni - i;
            int dy = nj - j;
            if (dx > 0 && dy > 0) {
                return "DownRight";
            } else if (dx > 0 && dy < 0) {
                return "DownLeft";
            } else if (dx < 0 && dy > 0) {
                return "UpRight";
            } else if (dx < 0 && dy < 0) {
                return "UpLeft";
            }
            else {
                throw new IllegalArgumentException("Invalid orientation");
            }
        }
    }
    
    public static List<List<Character>> getSolvedPuzzle(List<List<Character>> puzzle, List<List<String>> solutions) {
        List<List<Character>> solvedPuzzle = new ArrayList<>();
        for (List<Character> row : puzzle) {
            List<Character> newRow = new ArrayList<>();
            for (Character c : row) {
                newRow.add('.');
            }
            solvedPuzzle.add(newRow);
        }

        // for each word, find the location and orientation and change the characters in the solvedPuzzle
        for (List<String> solution : solutions) {
            String word = solution.get(0);
            int size = Integer.parseInt(solution.get(1));
            String location = solution.get(2);
            String[] locationSplit = location.split(",");
            int i = Integer.parseInt(locationSplit[0]) - 1;
            int j = Integer.parseInt(locationSplit[1]) - 1;
            String orientation = solution.get(3);
            for (int k = 0; k < size; k++) {
                solvedPuzzle.get(i).set(j, Character.toUpperCase(word.charAt(k)));
                switch (orientation) {
                    case "Right":
                        j++;
                        break;
                    case "Left":
                        j--;
                        break;
                    case "Down":
                        i++;
                        break;
                    case "Up":
                        i--;
                        break;
                    case "DownRight":
                        i++;
                        j++;
                        break;
                    case "DownLeft":
                        i++;
                        j--;
                        break;
                    case "UpRight":
                        i--;
                        j++;
                        break;
                    case "UpLeft":
                        i--;
                        j--;
                        break;
                }
            }
        }

        return solvedPuzzle;
    }

    public static void printSolutions(List<List<String>> solutions) {
        System.out.println("\nSolutions:");
        // find the size of the biggest word to help format
        int maxSize = 0;
        for (List<String> solution : solutions) {
            int size = Integer.parseInt(solution.get(1));
            if (size > maxSize) {
                maxSize = size;
            }
        }
        // print the solutions with an appropriate format
        for (List<String> solution : solutions) {
            String word = solution.get(0);
            String size = solution.get(1);
            String location = solution.get(2);
            String orientation = solution.get(3);
            System.out.printf("%-" + maxSize + "s %-4s %-4s %s\n", word, size, location, orientation);
        }
        System.out.println();
    }

    public static void printPuzzle(List<List<Character>> puzzle) {
        for (List<Character> row : puzzle) {
            for (Character c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void savePuzzle(String filename, List<List<String>> solutions, List<List<Character>> puzzle) throws Exception {
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        for (List<String> solution : solutions) {
            String word = solution.get(0);
            String size = solution.get(1);
            String location = solution.get(2);
            String orientation = solution.get(3);
            Integer maxSize = solutions.stream().map(s -> s.get(0).length()).max(Integer::compare).get();
            writer.printf("%-" + maxSize + "s %-4s %-4s %s\n", word, size, location, orientation);
        }
        writer.println();
        for (List<Character> row : puzzle) {
            for (Character c : row) {
                writer.print(c);
            }
            writer.println();
        }
        writer.close();
    }
    
    public static void main(String[] args) throws Exception {
        
        if (args.length != 2) {
            System.out.println("Usage: java WordSearchSolver <input file> <output file>");
            System.exit(1);
        }
        
        String inputFile = args[0];
        List<List<Character>> puzzle = getPuzzle(inputFile);
        List<String> words = getWords(inputFile);

        // Lista para guardar as palavras encontradas e verificar se alguma palavra foi encontrada mais do que uma vez (erro)
        List<String> foundWords = new ArrayList<>();
        List<List<String>> solutions = new ArrayList<>();

        for (String word : words) {
            // Percorrer o puzzle e encontrar a primeira letra da palavra
            for (int x = 0; x < puzzle.size(); x++) {
                for (int y = 0; y < puzzle.get(x).size(); y++) {
                    char puzzleLetter = Character.toLowerCase(puzzle.get(x).get(y));
                    char wordLetter = Character.toLowerCase(word.charAt(0));
                    if (puzzleLetter == wordLetter) {

                        int[] result = solveWord(puzzle, word, x, y);
                        if (result[0] != -1 && result[1] != -1){
                            if (foundWords.contains(word)){
                                throw new Exception("Word found twice");
                            }
                            foundWords.add(word);
                            List<String> solution = new ArrayList<>();
                            // Guardar as soluções como "word", "size" (da word), "i,j" (para a posição inicial) e "orientation"
                            solution.add(word);
                            solution.add(Integer.toString(word.length()));
                            solution.add((x+1) + "," + (y+1));
                            solution.add(getOrientation(x, y, result[0], result[1]));
                            solutions.add(solution);
                        }
                    }
                }
            }
        }

        printSolutions(solutions);
        // print puzzle with found words only
        List<List<Character>> solvedPuzzle = getSolvedPuzzle(puzzle, solutions);
        printPuzzle(solvedPuzzle);

        String outputFile = args[1];
        savePuzzle(outputFile, solutions, solvedPuzzle);
    }
}
