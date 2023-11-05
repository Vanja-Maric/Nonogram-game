package view;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;

import model.NonogramCounts;

/**
 * NonogramCountsView is a class responsible for displaying the nonogram counts.
 * It contains methods to get the visual representation of the counts for a
 * single row or all columns.
 */
public class NonogramCountsView {
  private NonogramCounts nonogramCounts;

  public NonogramCountsView(NonogramCounts nonogramCounts) {
    this.nonogramCounts = nonogramCounts;
  }

  /**
   * Gets a horisontal Box object containing the nonogram counts for each column.
   * The box contains empty in the leftmost cells to align the counts with the
   * counts of the rows and the nonogram grid.
   *
   * @return a Box object containing the nonogram counts for each column
   */
  public Box getColumnsNonogramCounts() {
    int highestSizeOfCountsInColumns = nonogramCounts.getHighestSizeOfCountsInColumns();
    int highestSizeOfCountsInRows = nonogramCounts.getHighestSizeOfCountsInRows();
    ArrayList<ArrayList<Integer>> nonogramCollumnsCounts = nonogramCounts.getNonogramColumnCounts();

    return allColumnsCountsCells(nonogramCollumnsCounts, highestSizeOfCountsInColumns,
        highestSizeOfCountsInRows);
  }

  /**
   * Returns a horisontal Box object containing the nonogram counts for a single
   * row of the nonogram puzzle.
   *
   * @param row the row number for which to retrieve the counts
   * @return a Box object containing the nonogram counts for the specified row
   */
  public Box getNonogramCountsOfOneRow(int row) {
    int highestSizeOfCountsInRows = nonogramCounts.getHighestSizeOfCountsInRows();
    ArrayList<ArrayList<Integer>> nonogramRowCounts = nonogramCounts.getNonogramRowCounts();
    ArrayList<Integer> targetRowCounts = nonogramRowCounts.get(row);

    return createCountsOfOneRow(targetRowCounts, highestSizeOfCountsInRows);
  }

  private Box createCountsOfOneRow(ArrayList<Integer> countsOfTargetRow, int highestSizeOfCountsInAllRows) {
    Box oneRowOfCountsCells = Box.createHorizontalBox();

    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
      JButton buttonForCounts = createCellForCounts();

      if (countsOfTargetRow.size() > i) {
        buttonForCounts.setText(countsOfTargetRow.get(i).toString());
      }

      oneRowOfCountsCells.add(buttonForCounts);
    }

    return oneRowOfCountsCells;
  }

  private Box allColumnsCountsCells(ArrayList<ArrayList<Integer>> columnCounts,
      int highestSizeOfCountsInAllColumns, int highestSizeOfCountsInAllRows) {
    Box allColumnsCounts = Box.createHorizontalBox();

    // Add empty cells to empty space over the nonogram counts cells of all rows
    addEmptyCellsOverRowCountsCells(allColumnsCounts, highestSizeOfCountsInAllColumns, highestSizeOfCountsInAllRows);

    for (ArrayList<Integer> countsInOneColumn : columnCounts) {
      Box oneColumnCounts = createOneColumnOfCounts(countsInOneColumn, highestSizeOfCountsInAllColumns);
      allColumnsCounts.add(oneColumnCounts);
    }

    return allColumnsCounts;
  }

  private void addEmptyCellsOverRowCountsCells(Box allColumnsCounts, int highestSizeOfCountsInAllColumns,
      int highestSizeOfCountsInAllRows) {
    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
      Box oneColumnOfEmptyCells = createEmptyCells(highestSizeOfCountsInAllColumns);
      allColumnsCounts.add(oneColumnOfEmptyCells);
    }
  }

  private Box createOneColumnOfCounts(ArrayList<Integer> countsInOneColumn, int highestSizeOfCountsInAllColumns) {
    Box oneColumnOfCounts = Box.createVerticalBox();

    for (int i = 0; i < highestSizeOfCountsInAllColumns; i++) {
      JButton cellForCounts = createCellForCounts();

      if (countsInOneColumn.size() > i) {
        cellForCounts.setText(countsInOneColumn.get(i).toString());
      }

      oneColumnOfCounts.add(cellForCounts);
    }

    return oneColumnOfCounts;
  }

  private Box createEmptyCells(int numerOfRowsOfEmptyCells) {
    Box oneColumnOfEmptyCounts = Box.createVerticalBox();

    for (int i = 0; i < numerOfRowsOfEmptyCells; i++) {
      oneColumnOfEmptyCounts.add(createCellForCounts());
    }

    return oneColumnOfEmptyCounts;
  }

  private JButton createCellForCounts() {
    JButton countCell = new CellForNonogramCounts();
    return countCell;
  }

}
