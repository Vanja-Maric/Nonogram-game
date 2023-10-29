package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controller.BackToMainMenuListener;
import controller.GamePageController;

public class GamePageView {
  private String[][] nongramGrid;
  private BackToMainMenuListener backToMainMenuListener;
  private JPanel gamePageContainer = new JPanel();
  private JPanel checkedSolutionMessage = new JPanel();
   GameBoardView gameBoardView = new GameBoardView();
  

  public GamePageView(String[][] nonogramGrid) {
    this.nongramGrid = nonogramGrid;
    System.out.println();
  }

  public void setBackToMainMenuListener(BackToMainMenuListener listener) {
    this.backToMainMenuListener = listener;
  }

  public JPanel getGamePage() {
    addElementsToGamePage();
    return gamePageContainer;
  }

  public void addElementsToGamePage() {
    setGamePageContainerLayout();

    // Layout constraints
    GridBagConstraints gridBagConstrains = new GridBagConstraints();

    setGbc(gridBagConstrains, 0, 0);
    addOneElementToGamePage(gameBoard(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 1);
    gamePageContainer.add(butonsContainer(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 2);
    gamePageContainer.add(checkedSolutionMessage, gridBagConstrains);
  }

  private void setGamePageContainerLayout() {
    gamePageContainer.setLayout(new GridBagLayout());
  }

  private void setGbc(GridBagConstraints gbc, int x, int y) {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.insets = new Insets(10, 10, 10, 10);
  }

  private void addOneElementToGamePage(JPanel element, GridBagConstraints gridBagConstrains) {
    gamePageContainer.add(element, gridBagConstrains);
  }

  private JPanel gameBoard() {
    JPanel gameBoardContainer = new JPanel();
    gameBoardContainer.add(gameBoardView.getGameBoard(nongramGrid));
    return gameBoardContainer;
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
    buttonsContainer.add(makeGetSolutionButton());
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
        GamePageController gamePageController = new GamePageController();
        makeCheckedSolutionMessage(gamePageController.isSolutionCorrect(nongramGrid, gameBoardView.getGameCells()));
      }
    });
  }

  private JPanel makeCheckedSolutionMessage(boolean isCorrect) {
    deleteOldCheckSolutionMessage();
    if (isCorrect) {
      checkedSolutionMessage.add(new JLabel("Your solution is correct!"));
    } else {
      checkedSolutionMessage.add(new JLabel("Your solution is not correct!"));
    }
    gamePageContainer.repaint();
    gamePageContainer.revalidate();

    return checkedSolutionMessage;
  }

  private void deleteOldCheckSolutionMessage() {
    if (checkedSolutionMessage != null) {
      checkedSolutionMessage.removeAll();
    }
  }

  private JButton makeGetSolutionButton() {
    JButton getSolutionButton = gamePageButton("Get solution");
    addActionListenerToMakeGetSolutionButton(getSolutionButton);
    return getSolutionButton;
  }

  private void addActionListenerToMakeGetSolutionButton(JButton getSolutionButton) {
    getSolutionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       makeSolution();
      }
    });
  }

  private void makeSolution() {
    GamePageController gamePageController = new GamePageController();
    gamePageController.applySolutionToBoard(nongramGrid, gameBoardView.getGameCells());
  }

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

    gamePageButtonDimensions(gamePageButton);
    gamePageButtonColor(gamePageButton);
    gamePageButtonBorder(gamePageButton);

    return gamePageButton;
  }

  private void gamePageButtonDimensions(JButton gamePageButton) {
    gamePageButton.setMinimumSize(new java.awt.Dimension(120, 30));
    gamePageButton.setMaximumSize(new java.awt.Dimension(120, 30));
    gamePageButton.setPreferredSize(new java.awt.Dimension(120, 30));
  }

  private void gamePageButtonColor(JButton gamePageButton) {
    gamePageButton.setBackground(java.awt.Color.YELLOW);
  }

  private void gamePageButtonBorder(JButton gamePageButton) {
    Border border = new LineBorder(java.awt.Color.BLACK, 1);
    gamePageButton.setBorder(border);
  }

}
