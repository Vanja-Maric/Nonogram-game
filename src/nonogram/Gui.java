import java.awt.*;
import javax.swing.*;

public class Gui {
  private JFrame gameFrame;

  public Gui() {
    gameFrame = new JFrame("Nonogram");
    setGameFrameCharacteristics();
    showStartGamePage();
  }

  private void setGameFrameCharacteristics() {
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setSize(800, 600);
    gameFrame.setVisible(true);
    gameFrame.setLocationRelativeTo(null); // Set JFrame to the middle of the screen
  }

  private void showStartGamePage() {
    JPanel startPage = getStartPage();
    gameFrame.add(startPage);
  }

  private JPanel getStartPage() {
    JPanel startPageContainer = new JPanel();
    setStartPageContainerCharacteristics(startPageContainer);
    addElemntsToStartPage(startPageContainer);
    return startPageContainer;
  }

  private void setStartPageContainerCharacteristics(JPanel startPageContainer) {
    startPageContainer.setLayout(new GridBagLayout());
    startPageContainer.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    startPageContainer.setAlignmentY(JComponent.CENTER_ALIGNMENT);
  }
 // IT is impossible to respect all Clean code principle. YOu have to think which one to secrafise, like I have outgoing arguments here in order to have not to big get start page, and to not use to much memmory by making to many JPanel in ordet to avoid outgoing arguments. 
  private void addElemntsToStartPage(JPanel startPageContainer) {
    GridBagConstraints gridBagConstrains = new GridBagConstraints();
    
    JLabel nonogramText = getNonogramText();
    setGbc(gridBagConstrains, 0, 0);
    setBiggerTopAndBottomInsets(gridBagConstrains);
    startPageContainer.add(nonogramText, gridBagConstrains);

    JLabel chooseGameSizeText = getChooseGameSizeText();
    setGbc(gridBagConstrains, 0, 1);
    startPageContainer.add(chooseGameSizeText, gridBagConstrains);

    JPanel chooseGameSizeButtons = getSetGameSizeButtons();
    setGbc(gridBagConstrains, 0, 2);
    startPageContainer.add(chooseGameSizeButtons, gridBagConstrains);

    JButton startGameButton = getStartGameButton();
    setGbc(gridBagConstrains, 0, 3);
    setBiggerTopAndBottomInsets(gridBagConstrains);
    startPageContainer.add(startGameButton, gridBagConstrains);
  }

  private void setBiggerTopAndBottomInsets (GridBagConstraints gbc) {
    gbc.insets = new Insets(30, 10, 30, 10);
  }

  // Sets components position
  private void setGbc(GridBagConstraints gbc, int x, int y) {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.insets = new Insets(10, 10, 10, 10);
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

  private JPanel getSetGameSizeButtons() {
    ButtonGroup gameSizeButtonsGroup = new ButtonGroup();
    JPanel gameSizeButtonsContainer = new JPanel();
    gameSizeButtonsContainer.setLayout(new FlowLayout());
    Dimension maxDimensionOfGameSizeButtonsContainer = new Dimension(800, 50);
    gameSizeButtonsContainer.setMaximumSize(maxDimensionOfGameSizeButtonsContainer);

    JRadioButton option1 = new JRadioButton("15 x 15 (easy)");
    JRadioButton option2 = new JRadioButton("30 x 30 (medium)");
    JRadioButton option3 = new JRadioButton("50 x 50 (hard)");

    gameSizeButtonsGroup.add(option1);
    gameSizeButtonsGroup.add(option2);
    gameSizeButtonsGroup.add(option3);

    gameSizeButtonsContainer.add(option1);
    gameSizeButtonsContainer.add(option2);
    gameSizeButtonsContainer.add(option3);

    return gameSizeButtonsContainer;
  }

  private JButton getStartGameButton() {
    JButton startGameButton = new JButton("Start game");
    startGameButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    return startGameButton;
  }

}
