package view;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.NonogramCountsController;

/**
 * This class represents a cell used for displaying counts in the Nonogram game.
 */
public class CellForNonogramCounts extends JButton {
  private final int CELL_WIDTH = 20;
  private final int CELL_HEIGHT = 20;
  private final Color CELL_BACKGROUND_COLOR = Color.YELLOW;
  private final Color CELL_BORDER_COLOR = Color.GRAY;
  private final int CELL_BORDER_WIDTH = 1;

  private NonogramCountsController controller = new NonogramCountsController();

  /**
   * Constructor for CellForNonogramCounts class.
   * Sets the button color, size, border, and click listener.
   * If the cell is clicked, the controller will toggle the color of the cell between Yell
   * and Gray.
   */
  public CellForNonogramCounts() {
    setButtonColor();
    setButtonSize();
    setButtonBorder();
    addClickListener();
  }

  private void setButtonColor() {
    setOpaque(true);
    setFocusPainted(false);
    setBackground(CELL_BACKGROUND_COLOR);
  }

  private void setButtonSize() {
    Dimension size = new Dimension(CELL_WIDTH, CELL_HEIGHT);
    setMaximumSize(size);
    setMinimumSize(size);
    setPreferredSize(size);
  }

  private void setButtonBorder() {
    setBorder(new LineBorder(CELL_BORDER_COLOR, CELL_BORDER_WIDTH));
  }

  private void addClickListener() {
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.applyToggleCountCellColor(CellForNonogramCounts.this);
      }
    });
  }
}
