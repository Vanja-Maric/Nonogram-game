package view;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;


public class GameView {
    public Box createNonogramCellsGrid(String[][] nonogramGrid) { // TODO: NAME
    // BlackWhiteNonogramCellCounts bWhiteNonogramCellCounts = new BlackWhiteNonogramCellCounts(nonogramGrid); // TODO: DO not add this here
    // ArrayList<ArrayList<Integer>> rowCo = bWhiteNonogramCellCounts.getBlackCellCountsInAllRows(); 
    // TODO: REMOVE THIS ABOVE
    Box gameTable = Box.createVerticalBox();

    for (int row = 0; row < nonogramGrid.length; row++) {
     //  Box buttonRowBox = getNonogramOneRowCounts(rowCo, row); // COUNTS REMOVED HERE!!!!!!!
      Box oneRowOfGameTable = Box.createHorizontalBox();
      oneRowOfGameTable.add(getOneNonogramRow(nonogramGrid[row]));
      gameTable.add(oneRowOfGameTable);
    }

    return gameTable;
  }

  private Box getOneNonogramRow(String[] oneRowOfNonogramGrid) {
    Box buttonRowBox = Box.createHorizontalBox();

    for (int cell = 0; cell < oneRowOfNonogramGrid.length; cell++) {

      JButton nonogramCell = createCell();
      nonogramCell.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // changeCellValue(nonogramCell);
        }
      });
      
      buttonRowBox.add(nonogramCell);
    }
    return buttonRowBox;
  }

    private JButton createCell() {
    JButton gameCell = new JButton();

    setCellButtonColor(gameCell, Color.WHITE);
    setCellButtonSize(gameCell, 20, 20);
    setCellBorder(gameCell, 1, Color.GRAY);

    return gameCell;
  }

  private void setCellButtonColor(JButton gameCell, Color colorOfCell) {
    gameCell.setBackground(colorOfCell);
  }

  private void setCellButtonSize(JButton gameCell, int width, int height) {
    Dimension buttonSize = new Dimension(width, height);
    gameCell.setMaximumSize(buttonSize);
    gameCell.setMinimumSize(buttonSize);
    gameCell.setPreferredSize(buttonSize);
  }

  private void setCellBorder(JButton gameCell, int borderWidth, Color borderColor) { 
    gameCell.setBorder(new LineBorder(borderColor, borderWidth));
  }
}
