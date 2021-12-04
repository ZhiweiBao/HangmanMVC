package hangman.view;

import hangman.controller.HangmanController;
import java.util.List;

public interface HangmanView {

  void addListeners(HangmanController controller);

  void setWord(String word);

  void drawHangman(int health);

  void setLabelCategory(String category);

  void setBtnByRemovingWrongLetters(List<Character> wrongLetters);

  void restart();
}
