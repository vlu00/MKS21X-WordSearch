public class WordSearch {
  private char [][] data;

  public WordSearch(int rows, int cols) {
    data = new char[rows][cols];
    clear();
  }

  public void clear() {
    for (int i = 0; i < data.length; i++) {
      for (int n = 0; n < data[i].length; n++) {
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

  public boolean addWordHorizontal(String word, int row, int col) {
    boolean complete = true;
    if (col + word.length() > data[row].length) {
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

}
