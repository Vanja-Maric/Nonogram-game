package view;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.CellController;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: ADAPT THIS AS COUNT CELL

/**
 * Represents a cell in the Nonogram game board.
 */
public class GameCell extends JButton {
  private final int CELL_WIDTH = 20;
  private final int CELL_HEIGHT = 20;
  private final Color CELL_BACKGROUND_COLOR = Color.WHITE;
  private final Color CELL_BORDER_COLOR = Color.GRAY;
  private final int CELL_BORDER_WIDTH = 1;

  /**
   * Represents a constructor for a  cell in the Nonogram game board.
   * Extends JButton and adds functionality to change its color and text when clicked.
   */
  public GameCell() {
    setOpaque(true);
    setFocusPainted(false);
    setBackground(CELL_BACKGROUND_COLOR);
    setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
    setMaximumSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
    setMinimumSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
    setBorder(new LineBorder(CELL_BORDER_COLOR, CELL_BORDER_WIDTH));
    
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CellController cellController = new CellController();
        cellController.changeCellColorAndText(GameCell.this);
      }
    });
  }
}
