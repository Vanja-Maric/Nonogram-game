package model;

import java.util.ArrayList;

import nonogram.BlackWhiteNonogramCellCounts;

public class NonogramCounts {

  private BlackWhiteNonogramCellCounts nonogramCounts;

  public NonogramCounts(String[][] nonogramGrid) {
    nonogramCounts = new BlackWhiteNonogramCellCounts(nonogramGrid); 
  }

  public ArrayList<ArrayList<Integer>> getNonogramRowCounts() {
    return nonogramCounts.getBlackCellCountsInAllRows();
  }

  public ArrayList<ArrayList<Integer>> getNonogramColumnCounts() {
    return nonogramCounts.getBlackCellCountsInAllColumns();
  }

  public int getHighestSizeOfCountsInRows() {
    return countHighestSizeOfCountsInRowsOrColumns(getNonogramRowCounts());
  }

  public int getHighestSizeOfCountsInolumns() {
    return countHighestSizeOfCountsInRowsOrColumns(getNonogramColumnCounts());
  }

  private int countHighestSizeOfCountsInRowsOrColumns(ArrayList<ArrayList<Integer>> rowOrCOlumnCounts) {
    int highestSizeOfCounts = 0;

    for (ArrayList<Integer> countsInOneColumn : rowOrCOlumnCounts) {
      if (countsInOneColumn.size() > highestSizeOfCounts) {
        highestSizeOfCounts = countsInOneColumn.size();
      }
    }

    return highestSizeOfCounts;
  }

}
