package hangman.view;

import hangman.controller.HangmanController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This is an implementation of HangmanView by Java Swing
 */
public class HangmanGUI extends JFrame implements HangmanView {

  private JPanel mainPanel;
  private JPanel letterPanel;
  private JPanel gamePanel;
  private JPanel rightPanel;
  private JPanel leftPanel;
  private JPanel centralPanel;
  private JPanel wordPanel;
  private JPanel hangmanPanel;
  private JLabel labelWord;
  private JButton btnRestart;
  private JButton btnGuessWord;
  private JButton btnGetHints;
  private JButton btnA;
  private JButton btnB;
  private JButton btnC;
  private JButton btnD;
  private JButton btnE;
  private JButton btnF;
  private JButton btnG;
  private JButton btnH;
  private JButton btnI;
  private JButton btnJ;
  private JButton btnK;
  private JButton btnL;
  private JButton btnM;
  private JButton btnN;
  private JButton btnO;
  private JButton btnP;
  private JButton btnQ;
  private JButton btnR;
  private JButton btnS;
  private JButton btnT;
  private JButton btnU;
  private JButton btnV;
  private JButton btnW;
  private JButton btnX;
  private JButton btnY;
  private JButton btnZ;
  private JTextField textWord;
  private JRadioButton radioBtnCategory;
  private JRadioButton radioBtnRemoveWrongLetters;
  private JLabel labelCategory;
  private JLabel labelHead;

  private int[] hintList;
  private final List<JButton> letterBtnList;
  private HangmanController controller;

  /**
   * This is a constructor to initialize the Hangman GUI
   */
  public HangmanGUI() {
    super("Hangman");
    this.letterBtnList = new ArrayList<>(Arrays.asList(
        btnA, btnB, btnC, btnD, btnE, btnF,
        btnG, btnH, btnI, btnJ, btnK, btnL, btnM,
        btnN, btnO, btnP, btnQ, btnR, btnS, btnT,
        btnU, btnV, btnW, btnX, btnY, btnZ));
  }

  /**
   * Start the game.
   */
  @Override
  public void show(HangmanController controller) {
    this.controller = controller;
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int width = 800;
    int height = 650;
    this.setPreferredSize(new Dimension(width, height));
    this.setResizable(false);
    Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    this.setBounds(p.x - width / 2, p.y - height / 2, width, height);
    this.setContentPane(mainPanel);

    this.pack();
    this.addListeners();
    controller.restartGame();
    this.setVisible(true);
  }

  /**
   * Add the listener to the view and give control to the controller
   */
  private void addListeners() {
    btnRestart.addActionListener(e -> controller.restartGame());

    btnGuessWord.addActionListener(e -> this.clickBtnGuessWord());

    btnGetHints.addActionListener(e -> this.clickBtnHint());

    for (JButton btn : letterBtnList) {
      btn.addActionListener(e -> this.clickLetterBtn(btn, btn.getText().toLowerCase()));
    }
  }

  /**
   * This is a private method to be processed when the Player the letter buttons
   *
   * @param btn    the button clicked by the player
   * @param letter the corresponding letter of the button.
   */
  private void clickLetterBtn(JButton btn, String letter) {
    if (controller.gameOver()) {
      return;
    }
    btn.setEnabled(false);
    btn.setBackground(Color.LIGHT_GRAY);
    controller.guess(letter);
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver();
  }

  /**
   * This is a private method to be called when the Player click the "Guess word" button
   */
  private void clickBtnGuessWord() {
    if (controller.gameOver()) {
      return;
    }
    String word = this.textWord.getText();
    word = word.replace(" ", "");
    word = word.toLowerCase();
    if (word.length() <= 1 || !word.matches("[a-z]+")) {
      return;
    }
    controller.guess(word);
    this.textWord.setText("");
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver();
  }

  /**
   * This method is to enable the hint options depending on the health of the player.
   *
   * @param health the health of the player
   */
  private void enableRadioBtnByHealth(int health) {
    if (health <= 5 && Arrays.stream(hintList).sum() == 2) {
      radioBtnCategory.setEnabled(true);
      radioBtnRemoveWrongLetters.setEnabled(true);
    } else if (health <= 2 && Arrays.stream(hintList).sum() == 1) {
      if (hintList[0] == 1) {
        radioBtnCategory.setEnabled(true);
      } else if (hintList[1] == 1) {
        radioBtnRemoveWrongLetters.setEnabled(true);
      }
    }
  }

  /**
   * This method is called after the game is over.
   */
  private void processAfterGameOver() {
    if (controller.gameOver()) {
      if (controller.playerWins()) {
        this.labelHead.setText("Congratulations!");
      } else {
        this.labelHead.setText("Game Over");
        this.labelWord.setForeground(Color.RED);
      }
    }
  }

  /**
   * Restart the game by initialize the view.
   */
  @Override
  public void restart() {
    this.labelHead.setText("Hangman");
    this.labelHead.setForeground(Color.BLACK);
    this.labelWord.setForeground(Color.BLACK);
    hintList = new int[]{1, 1};
    textWord.setText("");
    radioBtnCategory.setSelected(true);
    radioBtnCategory.setEnabled(false);
    radioBtnRemoveWrongLetters.setEnabled(false);
    labelCategory.setText("?????");
    this.drawHangman(controller.getHealth());
    for (JButton btn : letterBtnList) {
      btn.setEnabled(true);
      btn.setBackground(new Color(67, 140, 242));
    }
  }

  /**
   * Set the word on the window
   *
   * @param word the current word
   */
  @Override
  public void setWord(String word) {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      strBuilder.append(word.charAt(i));
      strBuilder.append(" ");
    }
    strBuilder.deleteCharAt(strBuilder.length() - 1);
    this.labelWord.setText(strBuilder.toString());
  }

  /**
   * Draw the Hangman by health
   *
   * @param health the health of player
   */
  @Override
  public void drawHangman(int health) {
    this.hangmanPanel.removeAll();
    this.hangmanPanel.add(new HangmanPanel(health));
    this.validate();
  }

  /**
   * This method is called after the player clicks the button "Hints"
   */
  private void clickBtnHint() {
    if (controller.gameOver()) {
      return;
    }

    if (radioBtnCategory.isSelected() && radioBtnCategory.isEnabled()) {
      controller.getHint(0);
      radioBtnCategory.setEnabled(false);
      radioBtnRemoveWrongLetters.setEnabled(false);
      hintList[0] = 0;
    } else if (radioBtnRemoveWrongLetters.isSelected() && radioBtnRemoveWrongLetters.isEnabled()) {
      controller.getHint(1);
      radioBtnCategory.setEnabled(false);
      radioBtnRemoveWrongLetters.setEnabled(false);
      hintList[1] = 0;
    }
  }

  /**
   * Set the category hint.
   *
   * @param category the category of chosen word
   */
  @Override
  public void setLabelCategory(String category) {
    this.labelCategory.setText(category);
  }

  /**
   * Remove part of the wrong letter
   *
   * @param wrongLetters the letters need to be removed.
   */
  @Override
  public void setBtnByRemovingWrongLetters(List<Character> wrongLetters) {
    for (Character c : wrongLetters) {
      disableBtnByChar(c);
    }
  }

  /**
   * Disable the button by the given Character
   *
   * @param c the given Character
   */
  private void disableBtnByChar(Character c) {
    if (c < 97 || c > 122) {
      return;
    }
    JButton btn = letterBtnList.get(c - 97);
    btn.setEnabled(false);
    btn.setBackground(Color.lightGray);
  }
}
