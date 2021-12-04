package hangman.controller;

import hangman.view.HangmanGUI;
import java.util.List;

/**
 * This is an interface of the view of Hangman game.
 */
public interface HangmanController {

  void guess(String input);

  String getChosenWord();

  int getHealth();

  boolean gameOver();

  boolean playerWins();

  void getHint(int option);

  void restartGame();
}
