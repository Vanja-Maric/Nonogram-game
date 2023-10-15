package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.StartGameListener;

public class StartPageView {
  private StartGameListener startGameListener;
  private ButtonGroup gameSizeButtonsGroup;

  public void setStartGameListener(StartGameListener listener) {
    this.startGameListener = listener;
  }

  public ButtonGroup getGameSizeButtonGroup() { // TODO: DODALA OVO PA PROVJERI DA LI RADI
    return gameSizeButtonsGroup;
  }

  public JPanel getStartPage() {
    return makeStartPage();
  }

  private JPanel makeStartPage() {
    JPanel startPageContainer = new JPanel();

    setStartPageContainerLayout(startPageContainer);
    addElemntsToStartPage(startPageContainer);

    return startPageContainer;
  }

  private void setStartPageContainerLayout(JPanel startPageContainer) {
    startPageContainer.setLayout(new GridBagLayout());
    startPageContainer.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    startPageContainer.setAlignmentY(JComponent.CENTER_ALIGNMENT);
  }

  // IT is impossible to respect all Clean code principle. YOu have to think which
  // one to secrafise, like I have outgoing arguments here in order to have not to
  // big get start page, and to not use to much memmory by making to many JPanel
  // in ordet to avoid outgoing arguments.
  private void addElemntsToStartPage(JPanel startPageContainer) {
    // Layout constraints
    GridBagConstraints gridBagConstrains = new GridBagConstraints();

    setGbc(gridBagConstrains, 0, 0);
    setBiggerTopAndBottomInsets(gridBagConstrains);
    startPageContainer.add(getNonogramText(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 1);
    startPageContainer.add(getChooseGameSizeText(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 2);
    startPageContainer.add(getGameSizeButtons(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 3);
    setBiggerTopAndBottomInsets(gridBagConstrains);
    startPageContainer.add(getStartGameButton(), gridBagConstrains);
  }

  // Sets components position
  private void setGbc(GridBagConstraints gbc, int x, int y) {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.insets = new Insets(10, 10, 10, 10);
  }

  // Sets bigger top and bottom insets for components
  private void setBiggerTopAndBottomInsets(GridBagConstraints gbc) {
    gbc.insets = new Insets(30, 10, 30, 10);
  }

  private JLabel getNonogramText() {
    JLabel nonogramText = new JLabel("NONOGRAM GAME");
    Font nonogramTextFont = new Font("Arial", Font.BOLD | Font.ITALIC, 28);

    nonogramText.setFont(nonogramTextFont);

    return nonogramText;
  }

  private JLabel getChooseGameSizeText() {
    JLabel chooseGameSizeText = new JLabel("Choose size of the game: ");
    return chooseGameSizeText;
  }

  private JPanel getGameSizeButtons() {
    gameSizeButtonsGroup = new ButtonGroup();
    JPanel gameSizeButtonsContainer = getContainerForGameSizeButtons();

    JRadioButton option1 = getRadioButtonForGameSize("15 x 15 (easy)", "15");
    JRadioButton option2 = getRadioButtonForGameSize("25 x 25 (medium)", "25");
    JRadioButton option3 = getRadioButtonForGameSize("40 x 40 (hard)", "40");

    option1.setSelected(true);

    gameSizeButtonsGroup.add(option1);
    gameSizeButtonsGroup.add(option2);
    gameSizeButtonsGroup.add(option3);

    gameSizeButtonsContainer.add(option1);
    gameSizeButtonsContainer.add(option2);
    gameSizeButtonsContainer.add(option3);

    return gameSizeButtonsContainer;
  }

  private JPanel getContainerForGameSizeButtons() {
    JPanel gameSizeButtonsContainer = new JPanel();

    gameSizeButtonsContainer.setLayout(new FlowLayout());
    setDimensionsOfGameSizeButtonsContainer(gameSizeButtonsContainer, 800, 50);

    return gameSizeButtonsContainer;
  }

  private void setDimensionsOfGameSizeButtonsContainer(JPanel gameSizeButtonsContainer,
      int width, int height) {
    Dimension maxDimensionOfGameSizeButtonsContainer = new Dimension(width, height);
    gameSizeButtonsContainer.setMaximumSize(maxDimensionOfGameSizeButtonsContainer);
  }

  private JRadioButton getRadioButtonForGameSize(String text, String actionCommand) {
    JRadioButton option = new JRadioButton(text);
    option.setActionCommand(actionCommand);
    return option;
  }

  private JButton getStartGameButton() {
    JButton startGameButton = new JButton("Start game");
    startGameButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

    startGameButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (startGameListener != null) {
          startGameListener.startGameButtonClicked();
        }
      }
    });

    return startGameButton;
  }

  // TODO: PREBACILA OVO U CONTROLLER: PROVJERI DA LI RADI
  /*
   * public int getGameSize() {
   * ButtonModel selectedGameSizeModel = gameSizeButtonsGroup.getSelection();
   * int selectedGameSize =
   * Integer.parseInt(selectedGameSizeModel.getActionCommand());
   * return selectedGameSize;
   * }
   */

}
