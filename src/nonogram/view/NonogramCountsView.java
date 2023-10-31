package view;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;

import model.NonogramCounts;

import java.awt.Color;

public class NonogramCountsView {
  private NonogramCounts nonogramCounts;

  public NonogramCountsView(String[][] nonogramGrid) {
    nonogramCounts = new NonogramCounts(nonogramGrid);
  }

  public Box getNonogramColumnsCounts() {
    int highestSizeOfCountsInColumns = nonogramCounts.getHighestSizeOfCountsInColumns();
    int highestSizeOfCountsInRows = nonogramCounts.getHighestSizeOfCountsInRows();
    ArrayList<ArrayList<Integer>> nonogramCollumnsCounts = nonogramCounts.getNonogramColumnCounts();

    return createNonogramColumnsCountsCells(nonogramCollumnsCounts, highestSizeOfCountsInColumns, highestSizeOfCountsInRows);
  }

  public Box getNonogramOneRowCounts(int row) {
    int highestSizeOfCountsInRows = nonogramCounts.getHighestSizeOfCountsInRows();
    ArrayList<ArrayList<Integer>> nonogramRowCounts = nonogramCounts.getNonogramRowCounts();
    ArrayList<Integer> targetRowCounts = nonogramRowCounts.get(row);

    return createNonogramOneRowCounts(targetRowCounts, highestSizeOfCountsInRows);
  }

  private Box createNonogramOneRowCounts(ArrayList<Integer>
    targetRowCounts, int highestSizeOfCountsInAllRows) {
    Box oneRowCountsCells = Box.createHorizontalBox();
    
    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
    JButton buttonForCounts = createCountCell();

    if (targetRowCounts.size() > i) {
    buttonForCounts.setText(targetRowCounts.get(i).toString());
    }
    oneRowCountsCells.add(buttonForCounts);
    }
    
    return oneRowCountsCells;
    }

  private Box createNonogramColumnsCountsCells(ArrayList<ArrayList<Integer>> columnCounts,
    int highestSizeOfCountsInAllColumns, int highestSizeOfCountsInAllRows) {
    Box allColumnsCounts = Box.createHorizontalBox();

    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
      allColumnsCounts.add(createEmptyCellsOverRowCounts(highestSizeOfCountsInAllColumns));
    }

    for (ArrayList<Integer> countsInOneColumn : columnCounts) {
      Box oneColumnCounts = createOneColumnCounts(countsInOneColumn, highestSizeOfCountsInAllColumns);
      allColumnsCounts.add(oneColumnCounts);
    }

    return allColumnsCounts;
  }

  private Box createOneColumnCounts(ArrayList<Integer> countsInOneColumn, int highestSizeOfCountsInAllColumns) {
    Box oneColumnCounts = Box.createVerticalBox();

    for (int i = 0; i < highestSizeOfCountsInAllColumns; i++) {
      JButton buttonForCounts = createCountCell();
      buttonForCounts.setBackground(Color.YELLOW);

      if (countsInOneColumn.size() > i) {
        buttonForCounts.setText(countsInOneColumn.get(i).toString());
      }

      oneColumnCounts.add(buttonForCounts);
    }

    return oneColumnCounts;
  }

 private Box createEmptyCellsOverRowCounts(int highestSizeOfCountsInAllColumns){
   Box oneColumnOfEmptyCounts = Box.createVerticalBox();
  for (int i = 0; i < highestSizeOfCountsInAllColumns; i++) {
    oneColumnOfEmptyCounts.add(createCountCell());
  }
   return oneColumnOfEmptyCounts;
 }

  private JButton createCountCell() {
    JButton countCell = new CellForCounts();
    return countCell;
  }

}
