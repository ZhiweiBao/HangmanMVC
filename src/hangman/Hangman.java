package hangman;

import hangman.controller.HangmanController;
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
    HangmanView view = new HangmanGUI();
    HangmanController controller = new HangmanControllerImpl(model, view);
    controller.playGame();
  }
}
