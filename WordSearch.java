import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
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

    public WordSearch(int rows, int cols) {
      data = new char[rows][cols];
      clear();
    }

    //Fills list with words that need to be added from the five file and creates a blank grid.
    public void helper(int rows, int cols, String fileName) throws FileNotFoundException{
      wordsToAdd = new ArrayList();
      wordsAdded = new ArrayList();
      data = new char[rows][cols];
      clear();
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      while (in.hasNext()) {
        wordsToAdd.add(in.next());
      }
    }

    public WordSearch(int rows, int cols, String fileName) throws FileNotFoundException{
      helper(rows, cols, fileName);
      randgen = new Random();
      seed = Math.abs(randgen.nextInt() % 1000);
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed) throws FileNotFoundException {
      helper(rows, cols, fileName);
      seed = randSeed;
      randgen = new Random(seed);
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
          data[i][n] = '_';
        }
      }
    }
//change addword to private afterwards!!
    public boolean addWord (String word, int r, int c, int rowIncrement, int colIncrement) {
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
          if (data[r + i * rowIncrement][c + i * colIncrement] != '_' &&
              data[r + i * rowIncrement][c + i * colIncrement] != word.charAt(i) ) {
                return false;
              }
        }
        for (int i = 0; i < word.length(); i++) {
          data[r + i * rowIncrement][c + i * colIncrement] = word.charAt(i);
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



    /**Checks if the WordGrid can hold words and if the given position is valid
       *@return true if the given position parameters are valid. If the given
       *position parameters are not valid, return false.
       */
    public boolean valid(String word, int row, int col) {
      return data.length == 0 || data[0].length == 0 ||
             row < 0 || col < 0 ||
             row > data.length -1 || col > data[1].length -1;
    }

    public boolean addWordHorizontal(String word, int row, int col) {
      boolean complete = true;
      if (valid(word, row, col) || col + word.length() > data[0].length) {
        return false;
      }
      else {
        for (int i = 0; i < word.length(); i++) {
          if (data[row][col+i] != '_' && data[row][col+i] != word.charAt(i)) {
              return false;
          }
        }
        for (int i = 0; i < word.length(); i++) {
            data[row][col+i] = word.charAt(i);
        }
      }
      return complete;
    }

    public boolean addWordVertical(String word, int row, int col) {
      boolean complete = true;
      if (valid(word, row, col) || row + word.length() > data.length ) {
        return false;
      }
      else {
        for (int i = 0; i < word.length(); i++) {
          if (data[row+i][col] != '_' && data[row+i][col] != word.charAt(i)) {
              return false;
          }
        }
        for (int i = 0; i < word.length(); i++) {
            data[row+i][col] = word.charAt(i);
        }
      }
      return complete;
    }

    public boolean addWordDiagonal(String word,int row, int col){
      boolean complete = true;
      if (valid(word, row, col) || row + word.length() > data.length ||
          col + word.length() > data[0].length) {
        return false;
      }
      else {
        for (int i = 0; i < word.length(); i++) {
          if (data[row+i][col+i] != '_' && data[row+i][col+i] != word.charAt(i)) {
              return false;
          }
        }
        for (int i = 0; i < word.length(); i++) {
            data[row+i][col+i] = word.charAt(i);
        }
      }
      return complete;
    }

}
