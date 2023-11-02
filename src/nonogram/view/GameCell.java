package view;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controller.CellController;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a cell in the Nonogram game board.
 */
public class GameCell extends JButton {
  private final int CELL_WIDTH = 20;
  private final int CELL_HEIGHT = 20;
  private final Color CELL_BACKGROUND_COLOR = Color.WHITE;
  private final Color CELL_BORDER_COLOR = Color.GRAY;
  private final int CELL_BORDER_WIDTH = 1;

  private CellController cellController = new CellController();

  /**
   * Constructs a new GameCell object with default button color, size, and border,
   * and adds a click listener.
   * The click listener will change the cell's color and text - either to black,
   * white or gray with x.
   */
  public GameCell() {
    setCellColor();
    setCellSize();
    setCellBorder();
    addClickListener();
  }

  private void setCellColor() {
    setOpaque(true);
    setFocusPainted(false);
    setBackground(CELL_BACKGROUND_COLOR);
  }

  private void setCellSize() {
    setPreferredSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
    setMaximumSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
    setMinimumSize(new Dimension(CELL_WIDTH, CELL_HEIGHT));
  }

  private void setCellBorder() {
    setBorder(new LineBorder(CELL_BORDER_COLOR, CELL_BORDER_WIDTH));
  }

  private void addClickListener() {
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cellController.changeCellColorAndText(GameCell.this);
      }
    });
  }
}
