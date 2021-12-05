package hangman.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * This is a class to draw the hangman in a panel
 */
public class HangmanPanel extends JPanel {

  private final List<Color> colorList;

  /**
   * This is a constructor to initialize the colorList of hangman, the appearance of hangman depends
   * on the colorList, and the colorList depends on the health of the player
   *
   * @param health the health of the player
   */
  public HangmanPanel(int health) {
    this.colorList = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      if (i < 8 - health) {
        colorList.add(Color.BLACK);
      } else {
        colorList.add(Color.LIGHT_GRAY);
      }
    }
  }

  /**
   * This is a method to draw the hangman by colorList
   *
   * @param g the graphics will be used to draw the hangman
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g;
    g2D.setColor(Color.BLACK);
    g2D.setStroke(new BasicStroke(3.0f));
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    int pointX = 275;
    int pointY = 225;
    // Draw the rack
    g2D.drawLine(pointX, pointY - 175, pointX - 100, pointY - 175);
    g2D.drawLine(pointX - 100, pointY - 175, pointX - 100, pointY + 150);
    g2D.drawLine(pointX - 150, pointY + 150, pointX + 130, pointY + 150);

    int diameter = 65;
    // 1. Draw the rope
    g2D.setColor(colorList.get(0));
    g2D.drawLine(pointX, pointY - diameter / 2 - 100, pointX, pointY - 172);
    // 2. Draw the head
    g2D.setColor(colorList.get(1));
    g2D.drawOval(pointX - diameter / 2, pointY - diameter / 2 - 100, diameter, diameter);
    // 3. Draw the body
    g2D.setColor(colorList.get(2));
    g2D.drawLine(pointX, pointY + diameter / 2 - 96, pointX, pointY + 50);
    // 4. Draw the left hand
    g2D.setColor(colorList.get(3));
    g2D.drawLine(pointX - 3, pointY + diameter / 2 - 40, pointX - 65, pointY - 35);
    // 5. Draw the right hand
    g2D.setColor(colorList.get(4));
    g2D.drawLine(pointX + 3, pointY + diameter / 2 - 40, pointX + 65, pointY - 35);
    // 6. Draw the left leg
    g2D.setColor(colorList.get(5));
    g2D.drawLine(pointX - 3, pointY + 50, pointX - 65, pointY + 120);
    // 7. Draw the right leg
    g2D.setColor(colorList.get(6));
    g2D.drawLine(pointX + 3, pointY + 50, pointX + 65, pointY + 120);
    // 8. Draw the face
    g2D.setColor(colorList.get(7));
    int lineLength = 5;
    int height = pointY - diameter / 2 - 75;
    int eyeDist = 10;
    // Left eye
    g2D.drawLine(pointX - lineLength - eyeDist, height - lineLength,
        pointX + lineLength - eyeDist, height + lineLength);
    g2D.drawLine(pointX + lineLength - eyeDist, height - lineLength,
        pointX - lineLength - eyeDist, height + lineLength);
    // Right eye
    g2D.drawLine(pointX - lineLength + eyeDist, height - lineLength,
        pointX + lineLength + eyeDist, height + lineLength);
    g2D.drawLine(pointX + lineLength + eyeDist, height - lineLength,
        pointX - lineLength + eyeDist, height + lineLength);
    // mouth
    g2D.drawLine(pointX - eyeDist, height + 20, pointX + eyeDist, height + 20);
  }
}
