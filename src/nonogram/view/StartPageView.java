package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.StartGameListener;

/**
 * The StartPageView class represents the view for the start page of the
 * Nonogram game.
 * It contain spublic methods to set the listener for the start game butto and
 * get a JPanel containing the start page.
 */
public class StartPageView {
  private StartGameListener startGameListener;
  private GameSizeButtos gameSizeButtonBuilder = new GameSizeButtos();

  /**
   * Sets the listener for the start game button.
   *
   * @param listener the listener to be set
   */
  public void setStartGameListener(StartGameListener listener) {
    this.startGameListener = listener;
  }

  /**
   * Gets a JPanel containing the start page for the Nonogram game.
   *
   * @return a JPanel containing the start page
   */
  public JPanel getStartPage() {
    return makeStartPage();
  }

  private JPanel makeStartPage() {
    JPanel startPageContainer = new JPanel();

    setStartPageContainerLayout(startPageContainer);
    addElementsToStartPage(startPageContainer);

    return startPageContainer;
  }

  private void setStartPageContainerLayout(JPanel startPageContainer) {
    startPageContainer.setLayout(new GridBagLayout());
  }

  private void addElementsToStartPage(JPanel startPageContainer) {
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
    return gameSizeButtonBuilder.getGameSizeButtons();
  }

  private JButton startGameButton() {
    JButton startGameButton = new AppButton("Start game", startGameListener());
    startGameButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    return startGameButton;
  }

  private ActionListener startGameListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (startGameListener != null) {
          startGameListener.startGameButtonClicked(getGameSize());
        }
      }
    };
  }

  private int getGameSize() {
    return Integer.parseInt(gameSizeButtonBuilder.getSelectedGameSize());
  }

}
