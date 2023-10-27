package controller;

import javax.swing.JButton;

import java.awt.Color;

public class GameBoardController {

   public void changeCellColorAndText(JButton targetCell) { 
    Color currentCellColor = targetCell.getBackground();

    if (currentCellColor == Color.WHITE) {
      targetCell.setBackground(Color.BLACK);
      targetCell.setText("");
    } else if (currentCellColor == Color.BLACK) {
      targetCell.setBackground(Color.LIGHT_GRAY);
      targetCell.setText("X");
    } else {
      targetCell.setBackground(Color.WHITE);
      targetCell.setText("");
    }
  }  
  
}
