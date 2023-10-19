package view;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.Color;

public class NonogramCountsView {
    private Box getNonogramColumnsCountsCells(ArrayList<ArrayList<Integer>> collumnCounts) {
    Box allCollumnCounts = Box.createHorizontalBox();
    int highestSizeOfCountsInAllRows = getHighestSizeOfCountsInRowsOrColumns(collumnCounts);

    int highestNumberOfColumnCounts = 3; // TODO: DO NOT HARD CODE THIS
    for (int i = 0; i < highestNumberOfColumnCounts; i++) { // TODO: THINK ABOUT THIS AND CHANGE NEXT 8 ROWS
      Box verticalBox = Box.createVerticalBox();
      for (int j = 0; j < highestSizeOfCountsInAllRows; j++) {
        JButton emptyButton = createCell();
        emptyButton.setBackground(Color.YELLOW);
        verticalBox.add(emptyButton);
      }
      allCollumnCounts.add(verticalBox);
    }

    for (ArrayList<Integer> countsInOneColumn : collumnCounts) {
      Box oneColumnCounts = Box.createVerticalBox();

      for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
        JButton buttonForCounts = createCell();
        buttonForCounts.setBackground(Color.YELLOW);
        if (countsInOneColumn.size() > i) {
          buttonForCounts.setText(countsInOneColumn.get(i).toString());
        }
        oneColumnCounts.add(buttonForCounts);
      }
      allCollumnCounts.add(oneColumnCounts);
    }

    // allCollumnCounts.add(emptyButtonsOverVerticalCounts);
    return allCollumnCounts;
  }


  private Box getNonogramOneRowCounts(ArrayList<ArrayList<Integer>> allRowsCounts, int targetRowNumber) {
    int highestSizeOfCountsInAllRows = getHighestSizeOfCountsInRowsOrColumns(allRowsCounts);
    ArrayList<Integer> targetRowCounts = allRowsCounts.get(targetRowNumber);
    Box oneRowCountsCells = Box.createHorizontalBox();

    for (int i = 0; i < highestSizeOfCountsInAllRows; i++) {
      JButton buttonForCounts = createCell();
      buttonForCounts.setBackground(Color.YELLOW);
      if (targetRowCounts.size() > i) {
        buttonForCounts.setText(targetRowCounts.get(i).toString());
      }
      oneRowCountsCells.add(buttonForCounts);
    }

    return oneRowCountsCells;
  }

  private JButton createCell() {
    JButton button = new JButton();
    // Color cellColor = setCellColor(gridCellColor);
    button.setBackground(Color.WHITE);

    Dimension buttonSize = new Dimension(20, 20);
    button.setMaximumSize(buttonSize);
    button.setMinimumSize(buttonSize);
    button.setPreferredSize(buttonSize);
    button.setOpaque(true);
    button.setFocusPainted(false);
    int borderWidth = 1;
    Color borderColor = Color.GRAY;
    button.setBorder(new LineBorder(borderColor, borderWidth));
    return button;
  }

    private int getHighestSizeOfCountsInRowsOrColumns -------> prebaceno je u model

}
