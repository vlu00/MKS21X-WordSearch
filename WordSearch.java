import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.text.*;
public class WordSearch{
    private char[][]data;

    //the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    public ArrayList<String> wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String> wordsAdded;

    public WordSearch(int rows, int cols, String fileName, boolean key, int myseed) throws FileNotFoundException{
      data = new char [rows][cols];
      clear();
      seed = myseed;
      randgen = new Random(seed);
      wordsAdded = new ArrayList();
      getWords(fileName);
      addAllWords();
      if (!key) {
        fillRandom();
      }
    }

    //Creates list of words that need to be added to the puzzle
    public void getWords(String fileName) throws FileNotFoundException{
      wordsToAdd = new ArrayList();
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while (in.hasNext()) {
        wordsToAdd.add(in.next());
      }
    }

    //Fills in remaining blank spaces of puzzle with random letters
    public void fillRandom() {
      for (int i = 0; i < data.length; i++) {
        for (int n = 0; n < data[0].length; n++) {
          if (data[i][n] == ' ') {
            data[i][n] = (char)('A' + randgen.nextInt(26)); //
          }
        }
      }
    }

    //Formats the list of added words.
    public String list(ArrayList<String> s) {
      String l = "";
      for (int i = 0; i < s.size(); i++) {
        l = l + s.get(i) + " ";
      }
      return l;
    }

    public String toString() {
      String s = "";
      for (int i = 0; i < data.length; i++) {
        s = s + "|";
        for (int n = 0; n < data[i].length; n++) {
          s = s + data[i][n] + " ";
        }
        s = s + "|\n";
      }
      return s + "Words: " + list(wordsAdded) +"(seed: " + seed + ")";
    }

    public void clear() {
      for (int i = 0; i < data.length; i++) {
        for (int n = 0; n < data[i].length; n++) {
          data[i][n] = ' ';
        }
      }
    }

    /**Checks if the WordGrid can hold words and if the given position is valid
       *@return true if the given position parameters are valid. If the given
       *position parameters are not valid, return false.
       */
    public boolean valid(String word, int row, int col) {
      return data.length == 0 || data[0].length == 0 ||
             row < 0 || col < 0 ||
             row > data.length -1 || col > data[1].length -1;
    }

    private boolean addWord (String word, int r, int c, int rowIncrement, int colIncrement) {
      boolean complete = true;
      if (!valid(word, r, c) && (rowIncrement == 0 && colIncrement == 0)) {
        return false;
      }
      if (colIncrement == 1 && c + word.length() > data[0].length) {
        return false;
      }
      if (colIncrement == -1 && c+1 - word.length() < 0) {
        return false;
      }
      if (rowIncrement == 1 && r + word.length() > data.length) {
        return false;
      }
      if (rowIncrement == -1 && r+1 - word.length() < 0) {
        return false;
      }
      else {
        for (int i = 0; i < word.length(); i++) {
          String w = "" + word.charAt(i);
          if (data[r + i * rowIncrement][c + i * colIncrement] != ' ' &&
              data[r + i * rowIncrement][c + i * colIncrement] != w.toUpperCase().charAt(0)) {
                return false;
              }
        }
        for (int i = 0; i < word.length(); i++) {
          String w = "" + word.charAt(i);
          data[r + i * rowIncrement][c + i * colIncrement] = w.toUpperCase().charAt(0);
        }
      }
      return complete;
    }

    public void addAllWords() {
      String word = "";
      int index;
      while (wordsToAdd.size() > 0) {
        index = randgen.nextInt(wordsToAdd.size());
        word = wordsToAdd.get(index);
        int rowInc = randgen.nextInt(3) -1;
        int colInc = randgen.nextInt(3) -1;
        for (int i = 0; i < 100000; i++) {
          int row = randgen.nextInt(data.length);
          int col = randgen.nextInt(data[0].length);
          if (addWord(word, row, col, rowInc, colInc)) {
            wordsAdded.add(word);
            i = 100000;
          }
        }
        wordsToAdd.remove(index);
      }
    }

    public static void main (String [] args) {
      boolean exception = false;
      try {
        if (args.length < 3 || Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[1]) < 1) {
          System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
          exception = true;
        }

        if (args.length > 2) {
          File f = new File(args[2]);
          Scanner in = new Scanner(f);
        }

        int myseed = 0;
        if (args.length == 3) {
          Random seedgen = new Random ();
          myseed = Math.abs(seedgen.nextInt() % 10001);
        }

        if (args.length >= 4 && Integer.parseInt(args[3]) > -1) {
          if (Integer.parseInt(args[3]) > 10000 || Integer.parseInt(args[3]) < 0) {
            exception = true;
            System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
          }
          else {
            myseed = Integer.parseInt(args[3]);
          }
        }

        boolean key = false;
        if (args.length == 5) {
          if (args[4].equals("key")) {
            key = true;
          }
        }

        if (!(exception)) {
            WordSearch A = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], key, myseed);
            System.out.println(A);
        }

      } catch (FileNotFoundException e) {
        System.out.println("File not found: " + args[2]);
        exception = true;
      } catch (NumberFormatException e) {
        System.out.println("usage: java WordSearch [rows cols filename [randomSeed [answers]]]");
        exception = true;
      }
    }
}
