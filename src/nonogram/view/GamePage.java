package view;

import javax.swing.JPanel;

public class GamePage {
  private String[][] nongramGrid;
  private JPanel gamePageContainer = new JPanel();

  public GamePage(String[][] nonogramGrid) {
    this.nongramGrid = nonogramGrid;
  }

  public JPanel getGamePage() {
    addPartsToGamePage();
    return gamePageContainer;
  }

  private void addPartsToGamePage() {
    addGameTableToGamePage();
  }

  private void addGameTableToGamePage() {
    GameTableView gameTableView = new GameTableView();
    gamePageContainer.add(gameTableView.getGameTable(nongramGrid));
  }
  
}
