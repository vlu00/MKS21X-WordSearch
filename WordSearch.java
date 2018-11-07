public class WordSearch {
  private char [][] data;

  public WordSearch(int rows, int cols) {
    data = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int n = 0; n < cols; n++) {
        data[i][n] = '_';
      }
    }
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < data.length; i++) {
      for (int n = 0; n < data[i].length; n++) {
        s = s + data[i][n] + " ";
      }
      s = s + "\n";
    }
    return s;
  }
}
