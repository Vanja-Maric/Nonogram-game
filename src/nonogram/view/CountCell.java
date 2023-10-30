package view;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.NonogramCountsController;

public class CountCell extends JButton {
  public CountCell() {
    setProperties();
    addClickListener();
  }

  private void setProperties() {
    setButtonColor(Color.YELLOW);
    setButtonSize(20, 20);
    setButtonBorder(1, Color.GRAY);
  }

  private void setButtonColor(Color color) {
    setOpaque(true);
    setFocusPainted(false);
    setBackground(color);
  }

  private void setButtonSize(int width, int height) {
    Dimension size = new Dimension(width, height);
    setMaximumSize(size);
    setMinimumSize(size);
    setPreferredSize(size);
  }

  private void setButtonBorder(int borderWidth, Color borderColor) {
    setBorder(new LineBorder(borderColor, borderWidth));
  }

  private void addClickListener() {
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        NonogramCountsController controller = new NonogramCountsController();
        controller.applyToggleCountCellColor(CountCell.this);
      }
    });
  }
}
