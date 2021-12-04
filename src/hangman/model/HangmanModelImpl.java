package hangman.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * The implementation of interface HangmanModel
 */
public class HangmanModelImpl implements HangmanModel {

  private final Map<String, List<String>> wordList;
  private String chosenCategory;
  private String chosenWord;
  private String currentWord;
  private List<Character> wrongLetterList;
  private int health;
  private boolean gameOver;
  private boolean win;

  public HangmanModelImpl() throws FileNotFoundException {
    this("Wordlist.json");
  }

  public HangmanModelImpl(String fileName) throws FileNotFoundException {
    String rootPath = System.getProperty("user.dir");
    String filePath = rootPath + "/res/" + fileName;
    JSONTokener jsonTokener = new JSONTokener(new FileReader(filePath));
    JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
    Map<String, Object> jsonMap = jsonObject.toMap();

    this.wordList = new HashMap<>();
    for (String key : jsonMap.keySet()) {
      this.wordList.put(key, (ArrayList<String>) jsonMap.get(key));
    }

    initializeGame();
  }

  private void initializeGame() {
    String[] categories = this.wordList.keySet().toArray(new String[0]);
    Random random = new Random();
    this.chosenCategory = categories[random.nextInt(categories.length)];

    List<String> words = this.wordList.get(this.chosenCategory);
    this.chosenWord = words.get(random.nextInt(words.size())).toLowerCase();
    this.currentWord = "";
    for (int i = 0; i < this.chosenWord.length(); i++) {
      this.currentWord += "_";
    }
    this.wrongLetterList = new ArrayList<>();
    this.health = 8;
    this.gameOver = false;
    this.win = false;
  }

  /**
   * Execute a guess of the world, the input could be a letter or a word.
   *
   * @param str the input could be a letter or a word provided by player.
   * @throws IllegalArgumentException if the input is not a letter or a word.
   */
  @Override
  public void guess(String str) throws IllegalArgumentException, IllegalStateException {
    if (gameOver) {
      throw new IllegalStateException("Game over!");
    }
    str = str.replace(" ", "");
    if (str.equals("")) {
      return;
    }
    str = str.toLowerCase();
    if (!str.matches("[a-z]+")) {
//      throw new IllegalArgumentException("This is not a word or letter!");
      return;
    }
    if (str.length() == 1) { // Guess by one letter
      char letter = str.toLowerCase().charAt(0);
      StringBuilder strBuilder = new StringBuilder(currentWord);
      for (int i = 0; i < chosenWord.length(); i++) {
        if (letter == chosenWord.charAt(i)) {
          strBuilder.setCharAt(i, letter);
        }
      }
      // Check whether current word changes
      if (strBuilder.toString().equals(currentWord)) {
        health--;
        if (health <= 0) {
          gameOver = true;
        } else {
          wrongLetterList.add(letter);
        }
      } else {
        currentWord = strBuilder.toString();
        if (currentWord.equals(chosenWord)) {
          gameOver = true;
          win = true;
        }
      }
    } else { // Guess by words
      if (str.equals(chosenWord)) {
        currentWord = chosenWord;
        gameOver = true;
        win = true;
      } else {
        health--;
        if (health <= 0) {
          gameOver = true;
        }
      }
    }
  }

  /**
   * Get the chosen word of the game.
   *
   * @return the current state of the game.
   */
  @Override
  public String getChosenWord() {
    return chosenWord;
  }

  /**
   * Get the current state of the game, i.e., the word is "align", and the start of the game should
   * be "_____" and after the player guess a correct letter "a", it should be "a____"
   *
   * @return the current state of the game.
   */
  @Override
  public String getGameState() {
    return currentWord;
  }

  /**
   * Get the list of wrong letters that the player has chosen.
   *
   * @return the list of wrong letter that the player has chosen.
   */
  @Override
  public List<Character> getWrongLetterList() {
    return wrongLetterList;
  }

  /**
   * Get the current health of player. It means remaining times of wrong answer the player is
   * allowed to guess.
   *
   * @return the current health of player.
   */
  @Override
  public int getHealth() {
    return health;
  }

  /**
   * Return whether the game is over. The game is over when health of player is 0, or the player has
   * won.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean gameOver() {
    return gameOver;
  }

  /**
   * Return whether the player wins. If the game is not over and the health of player is not 0,
   * return null.
   *
   * @return true if the player wins, false if the player loses, null otherwise.
   * @throws IllegalStateException if the game is not over
   */
  @Override
  public boolean playerWins() throws IllegalStateException {
    if (!this.gameOver) {
      throw new IllegalStateException("Game is not over!");
    }
    return win;
  }

  /**
   * Get the hints for the game.
   *
   * @return hints for the game.
   */
  @Override
  public String getHintOfCategory() {
    return chosenCategory;
  }

  /**
   * Get the hints by removing some wrong options, the num is equal to half of the remaining
   * letters.
   */
  @Override
  public List<Character> getHintByRemovingWrongOption() {
    List<Character> restLetterList = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      char letter = (char) ('a' + i);
      if (!(chosenWord.contains(String.valueOf(letter))
          || wrongLetterList.contains(letter))) {
        restLetterList.add(letter);
      }
    }
    Random random = new Random();
    int removeNum = restLetterList.size() / 2;
    List<Character> removeLetterList = new ArrayList<>();
    for (int i = 0; i < removeNum; i++) {
      Character ch = restLetterList.remove(random.nextInt(restLetterList.size()));
      wrongLetterList.add(ch);
      removeLetterList.add(ch);
    }
    return removeLetterList;
  }

  /**
   * Restart the game.
   */
  @Override
  public void restart() {
    initializeGame();
  }
}
