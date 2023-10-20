package view;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.NonogramCountsController;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class NonogramCountsView {

  public Box getNonogramColumnsCounts(ArrayList<ArrayList<Integer>> columnsCounts, int highestSizeOfCountsInAllColumns, int highestSizeOfCountsInAllRows) {
    return createNonogramColumnsCountsCells(columnsCounts, highestSizeOfCountsInAllColumns, highestSizeOfCountsInAllRows);
  }

  public Box getNonogramOneRowCounts(ArrayList<Integer> targetRowCounts, int highestSizeOfCountsInAllRows) {
    return createNonogramOneRowCounts(targetRowCounts, highestSizeOfCountsInAllRows);
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
    JButton countCell = new JButton();

    setCountCellButtonColor(countCell, Color.YELLOW);
    setCountCellButtonSize(countCell, 20, 20);
    setCountCellButtonBorder(countCell, 1, Color.GRAY);
    addClickListener(countCell);
    
    return countCell;
  }

  private void setCountCellButtonColor(JButton button, Color colorOfCountCell) {
    button.setOpaque(true);
    button.setFocusPainted(false);
    button.setBackground(colorOfCountCell);
  }

  private void setCountCellButtonSize(JButton button, int width, int height) {
    Dimension buttonSize = new Dimension(width, height);
    button.setMaximumSize(buttonSize);
    button.setMinimumSize(buttonSize);
    button.setPreferredSize(buttonSize);
  }

  private void setCountCellButtonBorder(JButton button, int borderWidth, Color borderColor) {
    button.setBorder(new LineBorder(borderColor, borderWidth));
  }

  private void addClickListener(JButton button) {
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        NonogramCountsController nonogramCountsController = new NonogramCountsController();
        nonogramCountsController.changeCountCellColor(button);
      }
    });
  }

}
