package hangman.model;

import java.util.List;

/**
 * This is the model of game Hangman, which is a guessing game for one player. The computer will
 * choose a word, and the player tries to guess it by suggesting letters within a certain number of
 * guesses.
 */
public interface HangmanModel {

  /**
   * Execute a guess of the world, the input could be a letter or a word.
   *
   * @param str the input could be a letter or a word provided by player.
   * @throws IllegalArgumentException if the input is not a letter or a word.
   */
  void guess(String str) throws IllegalArgumentException;

  /**
   * Get the chosen word of the game.
   *
   * @return the current state of the game.
   */
  String getChosenWord();

  /**
   * Get the current state of the game, i.e., the word is "align", and the start of the game should
   * be "_____" and after the player guess a correct letter "a", it should be "a____"
   *
   * @return the current state of the game.
   */
  String getGameState();

  /**
   * Get the list of wrong letters that the player has chosen.
   *
   * @return the list of wrong letter that the player has chosen.
   */
  List<Character> getWrongLetterList();

  /**
   * Get the current health of player. It means remaining times of wrong answer the player is
   * allowed to guess.
   *
   * @return the current health of player.
   */
  int getHealth();

  /**
   * Get whether the game is over. The game is over when health of player is 0, or the player has
   * won.
   *
   * @return true if the game is over, false otherwise
   */
  boolean gameOver();

  /**
   * Get whether the player wins. If the game is not over, throw exception.
   *
   * @return true if the player wins, false if the player loses, null otherwise.
   * @throws IllegalStateException if the game is not over
   */
  boolean playerWins() throws IllegalStateException;

  /**
   * Get the hints for the game by the category of word.
   *
   * @return hints for the game.
   */
  String getHintOfCategory();

  /**
   * Get the hints by removing some wrong options, the num is equal to half of the remaining
   * letters.
   */
  List<Character> getHintByRemovingWrongOption();

  /**
   * Restart the game.
   */
  void restart();
}
