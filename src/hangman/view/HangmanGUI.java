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

  private int numOfHints;

  public HangmanGUI() {
    super("Hangman");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int width = 800;
    int height = 650;
    this.setPreferredSize(new Dimension(width, height));
    this.setResizable(false);
    Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    this.setBounds(p.x - width / 2, p.y - height / 2, width, height);
    this.setContentPane(mainPanel);
    List<Color> colorList = new ArrayList<>(
        Arrays.asList(Color.LIGHT_GRAY, Color.LIGHT_GRAY,
            Color.LIGHT_GRAY, Color.LIGHT_GRAY,
            Color.LIGHT_GRAY, Color.LIGHT_GRAY,
            Color.LIGHT_GRAY, Color.LIGHT_GRAY));
    this.hangmanPanel.add(new HangmanPanel(colorList));

    this.pack();
    this.setVisible(true);
  }

  public void addListeners(HangmanController controller) {
    btnRestart.addActionListener(e -> controller.restartGame());

    btnGuessWord.addActionListener(e -> this.clickBtnGuessWord(controller));

    btnGetHints.addActionListener(e -> this.clickBtnHint(controller));

    btnA.addActionListener(e -> this.clickBtnA(controller));
    btnB.addActionListener(e -> this.clickBtnB(controller));
    btnC.addActionListener(e -> this.clickBtnC(controller));
    btnD.addActionListener(e -> this.clickBtnD(controller));
    btnE.addActionListener(e -> this.clickBtnE(controller));
    btnF.addActionListener(e -> this.clickBtnF(controller));
    btnG.addActionListener(e -> this.clickBtnG(controller));
    btnH.addActionListener(e -> this.clickBtnH(controller));
    btnI.addActionListener(e -> this.clickBtnI(controller));
    btnJ.addActionListener(e -> this.clickBtnJ(controller));
    btnK.addActionListener(e -> this.clickBtnK(controller));
    btnL.addActionListener(e -> this.clickBtnL(controller));
    btnM.addActionListener(e -> this.clickBtnM(controller));
    btnN.addActionListener(e -> this.clickBtnN(controller));
    btnO.addActionListener(e -> this.clickBtnO(controller));
    btnP.addActionListener(e -> this.clickBtnP(controller));
    btnQ.addActionListener(e -> this.clickBtnQ(controller));
    btnR.addActionListener(e -> this.clickBtnR(controller));
    btnS.addActionListener(e -> this.clickBtnS(controller));
    btnT.addActionListener(e -> this.clickBtnT(controller));
    btnU.addActionListener(e -> this.clickBtnU(controller));
    btnV.addActionListener(e -> this.clickBtnV(controller));
    btnW.addActionListener(e -> this.clickBtnW(controller));
    btnX.addActionListener(e -> this.clickBtnX(controller));
    btnY.addActionListener(e -> this.clickBtnY(controller));
    btnZ.addActionListener(e -> this.clickBtnZ(controller));

    controller.restartGame();
  }

  public void restart() {
    this.labelHead.setText("Hangman");
    this.labelHead.setForeground(Color.BLACK);
    this.labelWord.setForeground(Color.BLACK);
    numOfHints = 2;
    textWord.setText("");
    radioBtnCategory.setSelected(true);
    radioBtnCategory.setEnabled(false);
    radioBtnRemoveWrongLetters.setEnabled(false);
    labelCategory.setText("?????");
    btnA.setEnabled(true);
    btnB.setEnabled(true);
    btnC.setEnabled(true);
    btnD.setEnabled(true);
    btnE.setEnabled(true);
    btnF.setEnabled(true);
    btnG.setEnabled(true);
    btnH.setEnabled(true);
    btnI.setEnabled(true);
    btnJ.setEnabled(true);
    btnK.setEnabled(true);
    btnL.setEnabled(true);
    btnM.setEnabled(true);
    btnN.setEnabled(true);
    btnO.setEnabled(true);
    btnP.setEnabled(true);
    btnQ.setEnabled(true);
    btnR.setEnabled(true);
    btnS.setEnabled(true);
    btnT.setEnabled(true);
    btnU.setEnabled(true);
    btnV.setEnabled(true);
    btnW.setEnabled(true);
    btnX.setEnabled(true);
    btnY.setEnabled(true);
    btnZ.setEnabled(true);

    btnA.setBackground(new Color(67, 140, 242));
    btnB.setBackground(new Color(67, 140, 242));
    btnC.setBackground(new Color(67, 140, 242));
    btnD.setBackground(new Color(67, 140, 242));
    btnE.setBackground(new Color(67, 140, 242));
    btnF.setBackground(new Color(67, 140, 242));
    btnG.setBackground(new Color(67, 140, 242));
    btnH.setBackground(new Color(67, 140, 242));
    btnI.setBackground(new Color(67, 140, 242));
    btnJ.setBackground(new Color(67, 140, 242));
    btnK.setBackground(new Color(67, 140, 242));
    btnL.setBackground(new Color(67, 140, 242));
    btnM.setBackground(new Color(67, 140, 242));
    btnN.setBackground(new Color(67, 140, 242));
    btnO.setBackground(new Color(67, 140, 242));
    btnP.setBackground(new Color(67, 140, 242));
    btnQ.setBackground(new Color(67, 140, 242));
    btnR.setBackground(new Color(67, 140, 242));
    btnS.setBackground(new Color(67, 140, 242));
    btnT.setBackground(new Color(67, 140, 242));
    btnU.setBackground(new Color(67, 140, 242));
    btnV.setBackground(new Color(67, 140, 242));
    btnW.setBackground(new Color(67, 140, 242));
    btnX.setBackground(new Color(67, 140, 242));
    btnY.setBackground(new Color(67, 140, 242));
    btnZ.setBackground(new Color(67, 140, 242));
  }

  public void setWord(String word) {
    StringBuilder strBuilder = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      strBuilder.append(word.charAt(i));
      strBuilder.append(" ");
    }
    strBuilder.deleteCharAt(strBuilder.length() - 1);
    this.labelWord.setText(strBuilder.toString());
  }

  public void drawHangman(int health) {
    List<Color> colorList = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      if (i < 8 - health) {
        colorList.add(Color.BLACK);
      } else {
        colorList.add(Color.LIGHT_GRAY);
      }
    }
    this.hangmanPanel.removeAll();
    this.hangmanPanel.add(new HangmanPanel(colorList));
    this.setVisible(true);
  }

  private void clickBtnHint(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }

    if (radioBtnCategory.isSelected() && radioBtnCategory.isEnabled()) {
      controller.getHint(0);
      radioBtnCategory.setEnabled(false);
      radioBtnRemoveWrongLetters.setEnabled(false);
      numOfHints--;
    } else if (radioBtnRemoveWrongLetters.isSelected() && radioBtnRemoveWrongLetters.isSelected()) {
      controller.getHint(1);
      radioBtnCategory.setEnabled(false);
      radioBtnRemoveWrongLetters.setEnabled(false);
      numOfHints--;
    }
  }

  public void setLabelCategory(String category) {
    this.labelCategory.setText(category);
  }

  public void setBtnByRemovingWrongLetters(List<Character> wrongLetters) {
    for (Character c : wrongLetters) {
      disableBtnByChar(c);
    }
  }

  private void disableBtnByChar(Character c) {
    if (c == 'a') {
      btnA.setEnabled(false);
      btnA.setBackground(Color.lightGray);
    } else if (c == 'b') {
      btnB.setEnabled(false);
      btnB.setBackground(Color.lightGray);
    } else if (c == 'c') {
      btnC.setEnabled(false);
      btnC.setBackground(Color.lightGray);
    } else if (c == 'd') {
      btnD.setEnabled(false);
      btnD.setBackground(Color.lightGray);
    } else if (c == 'e') {
      btnE.setEnabled(false);
      btnE.setBackground(Color.lightGray);
    } else if (c == 'f') {
      btnF.setEnabled(false);
      btnF.setBackground(Color.lightGray);
    } else if (c == 'g') {
      btnG.setEnabled(false);
      btnG.setBackground(Color.lightGray);
    } else if (c == 'h') {
      btnH.setEnabled(false);
      btnH.setBackground(Color.lightGray);
    } else if (c == 'i') {
      btnI.setEnabled(false);
      btnI.setBackground(Color.lightGray);
    } else if (c == 'j') {
      btnJ.setEnabled(false);
      btnJ.setBackground(Color.lightGray);
    } else if (c == 'k') {
      btnK.setEnabled(false);
      btnK.setBackground(Color.lightGray);
    } else if (c == 'l') {
      btnL.setEnabled(false);
      btnL.setBackground(Color.lightGray);
    } else if (c == 'm') {
      btnM.setEnabled(false);
      btnM.setBackground(Color.lightGray);
    } else if (c == 'n') {
      btnN.setEnabled(false);
      btnN.setBackground(Color.lightGray);
    } else if (c == 'o') {
      btnO.setEnabled(false);
      btnO.setBackground(Color.lightGray);
    } else if (c == 'p') {
      btnP.setEnabled(false);
      btnP.setBackground(Color.lightGray);
    } else if (c == 'q') {
      btnQ.setEnabled(false);
      btnQ.setBackground(Color.lightGray);
    } else if (c == 'r') {
      btnR.setEnabled(false);
      btnR.setBackground(Color.lightGray);
    } else if (c == 's') {
      btnS.setEnabled(false);
      btnS.setBackground(Color.lightGray);
    } else if (c == 't') {
      btnT.setEnabled(false);
      btnT.setBackground(Color.lightGray);
    } else if (c == 'u') {
      btnU.setEnabled(false);
      btnU.setBackground(Color.lightGray);
    } else if (c == 'v') {
      btnV.setEnabled(false);
      btnV.setBackground(Color.lightGray);
    } else if (c == 'w') {
      btnW.setEnabled(false);
      btnW.setBackground(Color.lightGray);
    } else if (c == 'x') {
      btnX.setEnabled(false);
      btnX.setBackground(Color.lightGray);
    } else if (c == 'y') {
      btnY.setEnabled(false);
      btnY.setBackground(Color.lightGray);
    } else if (c == 'z') {
      btnZ.setEnabled(false);
      btnZ.setBackground(Color.lightGray);
    }
  }

  private void enableRadioBtnByHealth(int health) {
    if (health <= 5 && numOfHints == 2) {
      radioBtnCategory.setEnabled(true);
      radioBtnRemoveWrongLetters.setEnabled(true);
    } else if (health <= 2 && numOfHints >= 1) {
      if (radioBtnCategory.isSelected()) {
        radioBtnRemoveWrongLetters.setEnabled(true);
      } else {
        radioBtnCategory.setEnabled(true);
      }
    }
  }

  private void processAfterGameOver(HangmanController controller) {
    if (controller.gameOver()) {
      if (controller.playerWins()) {
        this.labelHead.setText("Congratulations!");
      } else {
        this.labelHead.setText("Game Over");
        this.setWord(controller.getChosenWord());
        this.labelWord.setForeground(Color.RED);
      }
    }
  }

  private void clickBtnGuessWord(HangmanController controller) {
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
    processAfterGameOver(controller);
  }

  private void clickBtnA(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnA.setEnabled(false);
    btnA.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnB(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnB.setEnabled(false);
    btnB.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnC(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnC.setEnabled(false);
    btnC.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnD(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnD.setEnabled(false);
    btnD.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnE(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnE.setEnabled(false);
    btnE.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnF(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnF.setEnabled(false);
    btnF.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnG(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnG.setEnabled(false);
    btnG.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnH(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnH.setEnabled(false);
    btnH.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnI(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnI.setEnabled(false);
    btnI.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnJ(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnJ.setEnabled(false);
    btnJ.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnK(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnK.setEnabled(false);
    btnK.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnL(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnL.setEnabled(false);
    btnL.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnM(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnM.setEnabled(false);
    btnM.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnN(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnN.setEnabled(false);
    btnN.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnO(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnO.setEnabled(false);
    btnO.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnP(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnP.setEnabled(false);
    btnP.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnQ(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnQ.setEnabled(false);
    btnQ.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnR(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnR.setEnabled(false);
    btnR.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnS(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnS.setEnabled(false);
    btnS.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnT(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnT.setEnabled(false);
    btnT.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnU(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnU.setEnabled(false);
    btnU.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnV(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnV.setEnabled(false);
    btnV.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnW(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnW.setEnabled(false);
    btnW.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnX(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnX.setEnabled(false);
    btnX.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnY(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnY.setEnabled(false);
    btnY.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }

  private void clickBtnZ(HangmanController controller) {
    if (controller.gameOver()) {
      return;
    }
    btnZ.setEnabled(false);
    btnZ.setBackground(Color.LIGHT_GRAY);
    String method = Thread.currentThread().getStackTrace()[1].getMethodName();
    controller.guess(method.substring(method.length() - 1));
    enableRadioBtnByHealth(controller.getHealth());
    processAfterGameOver(controller);
  }
//  public static void main(String[] args) {
//    HangmanGUI frame = new HangmanGUI();
//  }
}
