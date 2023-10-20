package model;
import nonogram.HintGetter;

public class Hint {
  private String[][] nonogramGrid;
  public Hint(String [][] nonogramGrid) {
    this.nonogramGrid = nonogramGrid;
  }

  public String getHint(int x, int y) {
    HintGetter hintGetter = new HintGetter(nonogramGrid);
    return hintGetter.getHint(x, y);
  }
}
