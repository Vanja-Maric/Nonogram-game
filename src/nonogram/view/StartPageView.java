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

  public ButtonGroup getGameSizeButtonGroup() {
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
  }

  private void addElemntsToStartPage(JPanel startPageContainer) {
    // Layout constraints
    GridBagConstraints gridBagConstrains = new GridBagConstraints();

    setGbc(gridBagConstrains, 0, 0);
    setBiggerTopAndBottomInsets(gridBagConstrains);
    startPageContainer.add(nonogramText(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 1);
    startPageContainer.add(chooseGameSizeText(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 2);
    startPageContainer.add(gameSizeButtons(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 3);
    setBiggerTopAndBottomInsets(gridBagConstrains);
    startPageContainer.add(startGameButton(), gridBagConstrains);
    
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

  private JLabel nonogramText() {
    JLabel nonogramText = new JLabel("NONOGRAM GAME");
    Font nonogramTextFont = new Font("Arial", Font.BOLD | Font.ITALIC, 28);

    nonogramText.setFont(nonogramTextFont);

    return nonogramText;
  }

  private JLabel chooseGameSizeText() {
    JLabel chooseGameSizeText = new JLabel("Choose size of the game: ");
    return chooseGameSizeText;
  }

  private JPanel gameSizeButtons() {
    gameSizeButtonsGroup = new ButtonGroup();
    JPanel gameSizeButtonsContainer = containerForGameSizeButtons();

    JRadioButton option1 = radioButtonForGameSize("12 x 12 (easy)", "12");
    JRadioButton option2 = radioButtonForGameSize("20 x 20 (medium)", "20");
    JRadioButton option3 = radioButtonForGameSize("30 x 30 (hard)", "30");

    option1.setSelected(true);

    gameSizeButtonsGroup.add(option1);
    gameSizeButtonsGroup.add(option2);
    gameSizeButtonsGroup.add(option3);

    gameSizeButtonsContainer.add(option1);
    gameSizeButtonsContainer.add(option2);
    gameSizeButtonsContainer.add(option3);

    return gameSizeButtonsContainer;
  }

  private JPanel containerForGameSizeButtons() {
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

  private JRadioButton radioButtonForGameSize(String text, String actionCommand) {
    JRadioButton option = new JRadioButton(text);
    option.setActionCommand(actionCommand);
    return option;
  }

  private JButton startGameButton() {
    JButton startGameButton = new JButton("Start game");
    startGameButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

    startGameButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (startGameListener != null) {
          startGameListener.startGameButtonClicked(getGameSize());
        }
      }
    });

    return startGameButton;
  }

  private int getGameSize() {
    return Integer.parseInt(gameSizeButtonsGroup.getSelection().getActionCommand());
  }

}
