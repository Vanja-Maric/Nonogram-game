package view;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;

import model.NonogramCounts;

public class NonogramCountsView {
  private NonogramCounts nonogramCounts;

  public NonogramCountsView(String[][] nonogramGrid) {
    nonogramCounts = new NonogramCounts(nonogramGrid);
  }

  public Box getColumnsNonogramCounts() {
    int highestSizeOfCountsInColumns = nonogramCounts.getHighestSizeOfCountsInColumns();
    int highestSizeOfCountsInRows = nonogramCounts.getHighestSizeOfCountsInRows();
    ArrayList<ArrayList<Integer>> nonogramCollumnsCounts = nonogramCounts.getNonogramColumnCounts();

    return allColumnsCountsCells(nonogramCollumnsCounts, highestSizeOfCountsInColumns,
        highestSizeOfCountsInRows);
  }

  public Box getOneRowOfNonogramCounts(int row) {
    int highestSizeOfCountsInRows = nonogramCounts.getHighestSizeOfCountsInRows();
    ArrayList<ArrayList<Integer>> nonogramRowCounts = nonogramCounts.getNonogramRowCounts();
    ArrayList<Integer> targetRowCounts = nonogramRowCounts.get(row);

    return createOneRowCounts(targetRowCounts, highestSizeOfCountsInRows);
  }

  private Box createOneRowCounts(ArrayList<Integer> targetRowCounts, int highestSizeOfCountsInAllRows) {
    Box oneRowCountsCells = Box.createHorizontalBox();

    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
      JButton buttonForCounts = createCellForCounts();

      if (targetRowCounts.size() > i) {
        buttonForCounts.setText(targetRowCounts.get(i).toString());
      }

      oneRowCountsCells.add(buttonForCounts);
    }

    return oneRowCountsCells;
  }

  private Box allColumnsCountsCells(ArrayList<ArrayList<Integer>> columnCounts,
      int highestSizeOfCountsInAllColumns, int highestSizeOfCountsInAllRows) {
    Box allColumnsCounts = Box.createHorizontalBox();
    addEmptyCellsOverRowCells(allColumnsCounts, highestSizeOfCountsInAllColumns, highestSizeOfCountsInAllRows);

    for (ArrayList<Integer> countsInOneColumn : columnCounts) {
      Box oneColumnCounts = createOneColumnOfCounts(countsInOneColumn, highestSizeOfCountsInAllColumns);
      allColumnsCounts.add(oneColumnCounts);
    }

    return allColumnsCounts;
  }

  private void addEmptyCellsOverRowCells(Box allColumnsCounts, int highestSizeOfCountsInAllColumns,
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
