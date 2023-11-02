package view;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collections;
import java.util.List;

public class GameSizeButtos {

  private ButtonGroup gameSizeButtonsGroup = new ButtonGroup();

  public String getSelectedGameSize() {
    return gameSizeButtonsGroup.getSelection().getActionCommand();
  }

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
