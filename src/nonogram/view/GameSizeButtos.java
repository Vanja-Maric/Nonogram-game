package view;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a group of radio buttons that allow the user to select
 * the size of the nonogram game.
 * The available options are 12x12 (easy), 20x20 (medium), and 30x30 (hard).
 * The selected game size can be retrieved with the getSelectedGameSize()
 * method.
 * The radio buttons are contained in a JPanel that can be retrieved with the
 * getGameSizeButtons() method.
 */
public class GameSizeButtos {
  private ButtonGroup gameSizeButtonsGroup = new ButtonGroup();

  /**
   * Gets the action command of the selected game size button.
   *
   * @return the action command of the selected game size button.
   */
  public String getSelectedGameSize() {
    return gameSizeButtonsGroup.getSelection().getActionCommand();
  }

  /**
   * Gets a JPanel containing the game size buttons.
   * 
   * @return a JPanel containing the game size buttons
   */
  public JPanel getGameSizeButtons() {
    return gameSizeButtons();
  }

  private JPanel gameSizeButtons() {
    JPanel gameSizeButtonsContainer = new JPanel(new FlowLayout());
    setDimensionsOfGameSizeButtonsContainer(gameSizeButtonsContainer, 800, 50);

    addOptionsToButtonGroup();
    setSelectionToFirstButton();
    List<AbstractButton> buttonsList = Collections.list(gameSizeButtonsGroup.getElements());
    for (AbstractButton option : buttonsList) {
      gameSizeButtonsContainer.add(option);
    }

    return gameSizeButtonsContainer;
  }

  private void setDimensionsOfGameSizeButtonsContainer(JPanel gameSizeButtonsContainer,
      int width, int height) {
    Dimension maxDimensionOfGameSizeButtonsContainer = new Dimension(width, height);
    gameSizeButtonsContainer.setMaximumSize(maxDimensionOfGameSizeButtonsContainer);
  }

  private void addOptionsToButtonGroup() {
    addRadioButton("12 x 12 (easy)", "12");
    addRadioButton("20 x 20 (medium)", "20");
    addRadioButton("30 x 30 (hard)", "30");
  }

  private void setSelectionToFirstButton() {
    gameSizeButtonsGroup.getElements().nextElement().setSelected(true);
  }

  private void addRadioButton(String text, String actionCommand) {
    JRadioButton option = new JRadioButton(text);
    option.setActionCommand(actionCommand);
    gameSizeButtonsGroup.add(option);
  }
}
