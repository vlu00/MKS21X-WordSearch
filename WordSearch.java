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
