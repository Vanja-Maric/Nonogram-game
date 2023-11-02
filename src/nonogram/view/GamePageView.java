package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BackToMainMenuListener;
import controller.GamePageController;

/**
 * The GamePageView class represents the view of the game page, which contains the nonogram grid, buttons to check and apply the solution, and a message indicating whether the solution is correct or not.
 */
public class GamePageView {
  private String[][] nonogramGrid;
  private BackToMainMenuListener backToMainMenuListener;
  private JPanel gamePageContainer = new JPanel();
  private JPanel checkedSolutionMessage = new JPanel();
  GameBoardView gameBoardView = new GameBoardView();
  GamePageController gamePageController = new GamePageController();

  /**
   * Constructs a new GamePageView object with the given nonogram grid.
   *
   * @param nonogramGrid the nonogram grid to display in the view
   */
  public GamePageView(String[][] nonogramGrid) {
    this.nonogramGrid = nonogramGrid;
  }

  /**
   * Sets the listener for the "Back to Main Menu" button.
   * 
   * @param listener the listener to be set
   */
  public void setBackToMainMenuListener(BackToMainMenuListener listener) {
    this.backToMainMenuListener = listener;
  }

  /**
   * Returns the JPanel containing the game page with all necessery elements.
   * 
   * @return the JPanel containing the game page.
   */
  public JPanel getGamePage() {
    addElementsToGamePage();
    return gamePageContainer;
  }

  private void addElementsToGamePage() {
    gamePageContainer.setLayout(new GridBagLayout());

    // Layout constraints
    GridBagConstraints gridBagConstrains = new GridBagConstraints();

    setGbc(gridBagConstrains, 0, 0);
    addOneElementToGamePage(gameBoard(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 1);
    addOneElementToGamePage(buttonsContainer(), gridBagConstrains);

    setGbc(gridBagConstrains, 0, 2);
    addOneElementToGamePage(checkedSolutionMessage, gridBagConstrains);
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
    gameBoardContainer.add(gameBoardView.getGameBoard(nonogramGrid));
    return gameBoardContainer;
  }

  private JPanel buttonsContainer() {
    JPanel buttonsContainer = new JPanel(new FlowLayout());
    setDimensionsOfButtonsContainer(buttonsContainer, 800, 50);

    buttonsContainer.add(createButton("Check my solution", e -> checkSolution()));
    buttonsContainer.add(createButton("Get solution", e -> applySolution()));
    buttonsContainer.add(createButton("Main menu", e -> goToMainMenu()));

    return buttonsContainer;
  }

  private void setDimensionsOfButtonsContainer(JPanel gameSizeButtonsContainer,
      int width, int height) {
    Dimension maxDimensionOfGameSizeButtonsContainer = new Dimension(width, height);
    gameSizeButtonsContainer.setMaximumSize(maxDimensionOfGameSizeButtonsContainer);
  }

  private JButton createButton(String text, ActionListener actionListener) {
    JButton button = new AppButton(text, actionListener);
    return button;
  }

  private void checkSolution() {
    boolean isCorrect = gamePageController.isSolutionCorrect(nonogramGrid, gameBoardView.getGameCells());
    updateCheckedSolutionMessage(isCorrect);
  }

  private void applySolution() {
    gamePageController.applySolutionToBoard(nonogramGrid, gameBoardView.getGameCells());
  }

  private void goToMainMenu() {
    if (backToMainMenuListener != null) {
      backToMainMenuListener.mainMenuButtonClicked();
    }
  }

  private void updateCheckedSolutionMessage(boolean isCorrect) {
    checkedSolutionMessage.removeAll();

    String message = isCorrect ? "Your solution is correct!" : "Your solution is not correct!";
    checkedSolutionMessage.add(new JLabel(message));
    
    gamePageContainer.repaint();
    gamePageContainer.revalidate();
  }

}
