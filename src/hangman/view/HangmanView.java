package hangman.view;

import hangman.controller.HangmanController;
import java.util.List;

/**
 * This is an interface of Hangman view.
 */
public interface HangmanView {

  /**
   * Open the view and give control to the controller
   *
   * @param controller the Hangman controller
   */
  void start(HangmanController controller);


  /**
   * Restart the game by initialize the view.
   */
  void restart();

  /**
   * Set the word on the window
   *
   * @param word the current word
   */
  void setWord(String word);

  /**
   * Draw the Hangman by health
   *
   * @param health the health of player
   */
  void drawHangman(int health);

  /**
   * Set the category hint.
   *
   * @param category the category of chosen word
   */
  void setLabelCategory(String category);

  /**
   * Remove part of the wrong letter
   *
   * @param wrongLetters the letters need to be removed.
   */
  void setBtnByRemovingWrongLetters(List<Character> wrongLetters);
}
