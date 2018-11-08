public class Driver {
  public static void main (String [] args) {
    System.out.println("Testing addWordHorizontal");
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

    System.out.println("Testing addWordVertical");
    WordSearch B = new WordSearch(5,4);
    System.out.println(B);
    System.out.println(B.addWordVertical("MATH", 1, 1));
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

  }
}
