import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][]data;

    //the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String>wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded;

    public WordSearch( int rows, int cols, String fileName) {
      
    }
    public WordSearch( int rows, int cols, String fileName, int randSeed)
    Both will read in the word text file, then run addAllWords(). Do not fill in random letters after.

//toString should print in the following format:
//use '|' as left/right boundaries of the grid.
//One long line of comma separated words after the string "Words: "

}
