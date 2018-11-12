import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Driver {
  public static void main (String [] args) {
    try {
      WordSearch C = new WordSearch(4,4,"Word.txt");
      System.out.println(C);
      WordSearch D = new WordSearch(4,4,"Word.txt", 110);
      System.out.println(D);

    }catch (FileNotFoundException e){
        System.out.println("File not found");
        System.exit(1);
     }




/*
    System.out.println("Testing addWord");
    WordSearch C = new WordSearch(4,4);
    System.out.println(C);
    System.out.println(C.addWord(0,1,"Cat",0,1));
    System.out.println(C);
    System.out.println(C.addWord(1,1,"Dog",1,0));
    System.out.println(C);
    System.out.println(C.addWord(0,1,"frog",1,0));
    System.out.println(C.addWord(3,0, "Fish", -1, 0));
    System.out.println(C);
    System.out.println(C.addWord(0,1,"Cat",1,1));
    System.out.println(C);
    System.out.println(C.addWord(3,3,"Dog",0,-1));
    System.out.println(C);

    System.out.println("Testing addWordHorizontal");
    WordSearch A1 = new WordSearch(0,0);
    WordSearch A2 = new WordSearch(4,7);
    System.out.println(A1);
    System.out.println(A1.addWordHorizontal("MATH", 2, 1));
    System.out.println(A2);
    System.out.println(A2.addWordHorizontal("MATH", 2, 1));
    System.out.println(A2);
    System.out.println(A2.addWordHorizontal("SCIENCE", 2, 1));
    System.out.println(A2);
    A2.clear();
    System.out.println(A2);

    System.out.println("Testing addWordVertical");
    WordSearch B = new WordSearch(5,4);
    System.out.println(B);
    System.out.println(B.addWordVertical("MATH", 5, 1));
    System.out.println(B);
    System.out.println(B.addWordVertical("DOG", 1, 1));
    System.out.println(B);
    System.out.println(B.addWordVertical("SCIENCE", 1, 1));
    System.out.println(B);
    System.out.println(B.addWordVertical("DOG", 1, 3));
    System.out.println(B);
    B.clear();
    System.out.println(B);

    System.out.println("Testing Mix of addWordHorizontal and addWordVertical");
    WordSearch C = new WordSearch(7,7);
    System.out.println(C);
    System.out.println(C.addWordHorizontal("MATH", 1, 1));
    System.out.println(C.addWordHorizontal("EYES", 5, 3));
    System.out.println(C.addWordVertical("HAPPY", 1, 4));
    System.out.println(C.addWordHorizontal("CHRISTMASTIME", 5, 3));
    System.out.println(C.addWordHorizontal("ZOO", 3, 3));
    System.out.println(C.addWordVertical("ZOOTOPIA", 1, 4));
    System.out.println(C.addWordVertical("DOG", 0, 2));
    System.out.println(C);

    System.out.println("Testing addWordDiagonal");
    WordSearch D = new WordSearch(5,5);
    System.out.println(D.addWordDiagonal("MATH", 1, 1));
    System.out.println(D.addWordDiagonal("TIME", 0, 1));
    System.out.println(D.addWordDiagonal("HAPPY", 0, 0));
    System.out.println(D);
*/
  }
}
