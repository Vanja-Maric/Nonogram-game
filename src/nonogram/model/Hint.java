package model;
import nonogram.HintGetter;

public class Hint {
  private String[][] nonogramGrid;
  public Hint(String [][] nonogramGrid) {
    this.nonogramGrid = nonogramGrid;
  }

  public void getHint(int x, int y) {
    HintGetter hintGetter = new HintGetter(nonogramGrid);
    hintGetter.getHint(x, y);
  }
}
