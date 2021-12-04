package hangman.controller;

/**
 * This is an interface of the controller of Hangman game.
 */
public interface HangmanController {

  /**
   * Get the string from the player, and call the model to guess word by input
   *
   * @param input the input string from the player
   */
  void guess(String input);

  /**
   * Get the chosen word from the model
   *
   * @return the chosen word
   */
  String getChosenWord();

  /**
   * Get the health from the model
   *
   * @return the health
   */
  int getHealth();

  /**
   * Get whether the game is over from the model
   *
   * @return whether the game is over
   */
  boolean gameOver();

  /**
   * Get whether the player wins, it should be called when game is over
   *
   * @return whether the player wins
   * @throws IllegalStateException when the game is not over.
   */
  boolean playerWins() throws IllegalStateException;

  /**
   * Get the option from the player, and call the model to give hint by the option
   *
   * @param option the option from the player
   */
  void getHint(int option);

  /**
   * Restart the game by restart the model and restart the view.
   */
  void restartGame();
}
