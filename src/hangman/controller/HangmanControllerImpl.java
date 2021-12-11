package hangman.controller;

import hangman.model.HangmanModel;
import hangman.view.HangmanView;

/**
 * The implementation of interface HangmanController
 */
public class HangmanControllerImpl implements HangmanController {

  private final HangmanModel model;
  private final HangmanView view;

  /**
   * This is a constructor to initialize the model and view of Hangman game
   *
   * @param model the Hangman model
   * @param view  the Hangman view
   */
  public HangmanControllerImpl(HangmanModel model, HangmanView view) {
    if (model == null) {
      throw new IllegalArgumentException("Invalid model!");
    }
    if (view == null) {
      throw new IllegalArgumentException("Invalid view!");
    }
    this.model = model;
    this.view = view;
  }

  /**
   * Start the game
   */
  @Override
  public void playGame() {
    this.view.start(this);
  }

  /**
   * Get the string from the player, and call the model to guess word by input
   *
   * @param input the input string from the player
   */
  @Override
  public void guess(String input) {
    model.guess(input);
    view.setWord(model.getGameState());
    view.drawHangman(model.getHealth());
  }

  /**
   * Get the health from the model
   *
   * @return the health
   */
  @Override
  public int getHealth() {
    return model.getHealth();
  }

  /**
   * Get whether the game is over from the model
   *
   * @return whether the game is over
   */
  @Override
  public boolean gameOver() {
    if (model.gameOver()) {
      view.setWord(model.getChosenWord());
      return true;
    } else {
      return false;
    }
  }

  /**
   * Get whether the player wins, it should be called when game is over
   *
   * @return whether the player wins
   * @throws IllegalStateException when the game is not over.
   */
  @Override
  public boolean playerWins() throws IllegalStateException {
    if (!model.gameOver()) {
      throw new IllegalStateException("Game is not over!");
    }
    return model.playerWins();
  }

  /**
   * Get the option from the player, and call the model to give hint by the option
   *
   * @param option the option from the player
   */
  @Override
  public void getHint(int option) {
    if (option == 0) {
      view.setLabelCategory(model.getHintOfCategory());
    } else if (option == 1) {
      view.setBtnByRemovingWrongLetters(model.getHintByRemovingWrongOption());
    }
  }

  /**
   * Restart the game by restart the model and restart the view.
   */
  @Override
  public void restartGame() {
    model.restart();
    view.restart();
    view.setWord(model.getGameState());
  }
}
