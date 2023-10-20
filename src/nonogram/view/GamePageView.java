package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controller.BackToMainMenuListener;
import model.Hint;

public class GamePageView {
  private String[][] nongramGrid;
  private BackToMainMenuListener backToMainMenuListener;

  public GamePageView(String[][] nonogramGrid) {
    this.nongramGrid = nonogramGrid;
    System.out.println();
  }

  public void setBackToMainMenuListener(BackToMainMenuListener listener) {
    this.backToMainMenuListener = listener;
  }

  public JPanel getGamePage() {
    return makeGamePagPanel();
  }

  public JPanel makeGamePagPanel() {
    JPanel gamePageContainer = new JPanel();

    setGamePageContainerLayout(gamePageContainer);
    addElementsToGamePage(gamePageContainer);
    return gamePageContainer;
  }

  private void setGamePageContainerLayout(JPanel gamePageContainer) {
    gamePageContainer.setLayout(new GridBagLayout());
  }

  private void addElementsToGamePage(JPanel gamePageContainer) {
    // Layout constraints
    GridBagConstraints gridBagConstrains = new GridBagConstraints();

    setGbc(gridBagConstrains, 0, 0);
    gamePageContainer.add(gameBoard(), gridBagConstrains);

    JPanel buttonsContainer = butonsContainer();
    setGbc(gridBagConstrains, 0, 1);
    gamePageContainer.add(buttonsContainer, gridBagConstrains);

  }

  private void setGbc(GridBagConstraints gbc, int x, int y) {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.insets = new Insets(10, 10, 10, 10);
  }

  private Box gameBoard() {
    GameBoardView gameBoardView = new GameBoardView();
    return gameBoardView.getGameBoard(nongramGrid);
  }

  private JPanel butonsContainer() {
    JPanel buttonsContainer = new JPanel();

    buttonsContainer.setLayout(new FlowLayout());
    setDimensionsOfButtonsContainer(buttonsContainer, 800, 50);
    addButtonsToButtonsContainer(buttonsContainer);

    return buttonsContainer;
  }

  private void setDimensionsOfButtonsContainer(JPanel gameSizeButtonsContainer,
      int width, int height) {
    Dimension maxDimensionOfGameSizeButtonsContainer = new Dimension(width, height);
    gameSizeButtonsContainer.setMaximumSize(maxDimensionOfGameSizeButtonsContainer);
  }

  private void addButtonsToButtonsContainer(JPanel buttonsContainer) {
    buttonsContainer.add(makeCheckMySolutinButton());
    buttonsContainer.add(makeGetHintButton());
    buttonsContainer.add(makeMainMenuButton());
  }

  private JButton makeCheckMySolutinButton() {
    JButton checkMySolutionButton = gamePageButton("Check my solution");
    addActionListenerToCheckMySolutionButton(checkMySolutionButton);
    return checkMySolutionButton;
  }

  private void addActionListenerToCheckMySolutionButton(JButton checkMySolutionButton) {
    checkMySolutionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // checkMySolutionButtonActionPerformed(e);
      }
    });
  }

  private JButton makeGetHintButton() {
    JButton getHintButton = gamePageButton("Get hint");
    addActionListenerToMakeGetHintButton(getHintButton);
    return getHintButton;
  }

  private void addActionListenerToMakeGetHintButton(JButton getHintButton) {
    getHintButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // getHintButtonActionPerformed();
      }
    });
  }

 /*  private void getHintButtonActionPerformed() {
    // Generate random x and y coordinates in the range of the grid size
    int x = (int) (Math.random() * nongramGrid.length);
    int y = (int) (Math.random() * nongramGrid.length);
    
    Hint hint = new Hint(nongramGrid);
    String hintColor = hint.getHint(x, y);
  }*/

  private JButton makeMainMenuButton() {
    JButton mainMenuButton = gamePageButton("Main menu");
    addActionListenerToMakeMainMenuButton(mainMenuButton);
    return mainMenuButton;
  }

  private void addActionListenerToMakeMainMenuButton(JButton mainMenuButton) {
    mainMenuButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (backToMainMenuListener != null) {
          backToMainMenuListener.mainMenuButtonClicked();
        }
      }
    });
  }

  private JButton gamePageButton(String buttonName) {
    JButton gamePageButton = new JButton(buttonName);

    setGamePageButtonDimensions(gamePageButton);
    setGamePageButtonColor(gamePageButton);
    setGamePageButtonBorder(gamePageButton);

    return gamePageButton;
  }

  private void setGamePageButtonDimensions(JButton gamePageButton) {
    gamePageButton.setMinimumSize(new java.awt.Dimension(120, 30));
    gamePageButton.setMaximumSize(new java.awt.Dimension(120, 30));
    gamePageButton.setPreferredSize(new java.awt.Dimension(120, 30));
  }

  private void setGamePageButtonColor(JButton gamePageButton) {
    gamePageButton.setBackground(java.awt.Color.YELLOW);
  }

  private void setGamePageButtonBorder(JButton gamePageButton) {
    Border border = new LineBorder(java.awt.Color.BLACK, 1);
    gamePageButton.setBorder(border);
  }

}
