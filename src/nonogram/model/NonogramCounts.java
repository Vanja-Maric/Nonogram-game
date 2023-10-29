package model;

import java.util.ArrayList;

import nonogram.BlackWhiteNonogramCellCounts;

public class NonogramCounts {

  private BlackWhiteNonogramCellCounts nonogramCounts;

  /**
   * Constructs a NonogramCounts object with the given nonogram grid.
   * 
   * @param nonogramGrid the 2D array representing the nonogram grid
   */
  public NonogramCounts(String[][] nonogramGrid) {
    nonogramCounts = new BlackWhiteNonogramCellCounts(nonogramGrid); 
  }

  /**
   * Gets an ArrayList of ArrayLists containing the count of black cells in each row of the nonogram.
   *
   * @return ArrayList of ArrayLists containing the count of black cells in each row of the nonogram.
   */
  public ArrayList<ArrayList<Integer>> getNonogramRowCounts() {
    return nonogramCounts.getBlackCellCountsInAllRows();
  }

  /**
   * Gets an ArrayList of ArrayLists containing the black cell counts for each column in the nonogram.
   *
   * @return an ArrayList of ArrayLists containing the black cell counts for each column in the nonogram.
   */
  public ArrayList<ArrayList<Integer>> getNonogramColumnCounts() {
    return nonogramCounts.getBlackCellCountsInAllColumns();
  }

  /**
   * Gets the highest size of counts in rows of the nonogram.
   *
   * @return the highest size of counts in rows of the nonogram
   */
  public int getHighestSizeOfCountsInRows() {
    return countHighestSizeOfCountsInRowsOrColumns(getNonogramRowCounts());
  }

  /**
   * Gets the highest size of counts in columns of the nonogram.
   *
   * @return the highest size of counts in columns of the nonogram
   */
  public int getHighestSizeOfCountsInColumns() {
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
