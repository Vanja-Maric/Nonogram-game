package controller;

import java.awt.Color;

import javax.swing.JButton;

public class NonogramCountsController {
  
  public void changeCountCellColor(JButton targetCountCell) {
    Color targetColor = targetCountCell.getBackground();
    
    if (targetColor == Color.YELLOW) {
      targetCountCell.setBackground(Color.GRAY);
    } else {
      targetCountCell.setBackground(Color.YELLOW);
    }
  }
}
