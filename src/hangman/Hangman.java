package hangman;

import hangman.model.HangmanModel;
import hangman.model.HangmanModelImpl;
import hangman.view.HangmanView;
import hangman.view.HangmanGUI;
import hangman.controller.HangmanControllerImpl;

/**
 * This is the driver class for Hangman game, it will initialize the model and the view, and give
 * control to the controller.
 */
public class Hangman {

  public static void main(String[] args) throws Exception {
    HangmanModel model = new HangmanModelImpl();
//    HangmanModel model = new HangmanModelImpl("Wordlist_test.json");
    HangmanView view = new HangmanGUI();
    new HangmanControllerImpl(model, view);
  }
}
