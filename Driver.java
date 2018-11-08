public class Driver {
  public static void main (String [] args) {
    WordSearch A = new WordSearch(4,7);
    System.out.println(A);
    System.out.println(A.addWordHorizontal("MATH", 2, 1));
    System.out.println(A);
    System.out.println(A.addWordHorizontal("CAT", 2, 1));
    System.out.println(A);
    System.out.println(A.addWordHorizontal("SCIENCE", 2, 1));
    System.out.println(A);
    A.clear();
    System.out.println(A);

    WordSearch B = new WordSearch(2,3);
    System.out.println(B);
    WordSearch C = new WordSearch(3,3);
    System.out.println(C);
  }
}
