package hangman.controller;

import hangman.model.HangmanModel;
import hangman.view.HangmanView;


public class HangmanControllerImpl implements HangmanController {

  private final HangmanModel model;
  private final HangmanView view;


  public HangmanControllerImpl(HangmanModel model, HangmanView view) {
    this.model = model;

    this.view = view;
    this.view.addListeners(this);
  }

  public boolean gameOver() {
    return model.gameOver();
  }

  public void guess(String input) {
    model.guess(input);
    view.setWord(model.getGameState());
    view.drawHangman(model.getHealth());
  }

  public void getHint(int option) {
    if (option == 0) {
      view.setLabelCategory(model.getHintOfCategory());
    } else if (option == 1) {
      view.setBtnByRemovingWrongLetters(model.getHintByRemovingWrongOption());
    }
  }

  public int getHealth(){
    return model.getHealth();
  }

  public String getChosenWord(){
    return model.getChosenWord();
  }

  public boolean playerWins(){
    return model.playerWins();
  }

  /**
   * Restart the game by initialize the view.
   */
  public void restartGame() {
    model.restart();
    view.setWord(model.getGameState());
    view.drawHangman(model.getHealth());
    view.restart();
  }


}
