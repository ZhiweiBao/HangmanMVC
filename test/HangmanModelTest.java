import static org.junit.Assert.*;

import hangman.model.HangmanModel;
import hangman.model.HangmanModelImpl;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for Hangman model.
 */
public class HangmanModelTest {

  private HangmanModel hangmanModel;

  @Before
  public void setUp() throws Exception {
    hangmanModel = new HangmanModelImpl("Wordlist_test.json");
  }

  /**
   * Test the invalid case when the file is not found.
   */
  @Test
  public void testInvalidConstructor() {
    try {
      new HangmanModelImpl("123");
      fail("An exception should be thrown!");
    } catch (FileNotFoundException e) {
    }
  }

  /**
   * Test invalid input of method guess() when the input contains digits
   */
  @Test(expected = IllegalArgumentException.class)
  public void guessInvalid1() {
    hangmanModel.guess("n3d");
  }

  /**
   * Test invalid input of method guess() when the input contains symbols
   */
  @Test(expected = IllegalArgumentException.class)
  public void guessInvalid2() {
    hangmanModel.guess("n#d");
  }

  /**
   * Test method guess() when the player wins
   */
  @Test
  public void guessWin() {
    hangmanModel.guess("a");
    assertEquals("_____", hangmanModel.getGameState());
    hangmanModel.guess("N");
    assertEquals("__nn_", hangmanModel.getGameState());
    hangmanModel.guess("sanny");
    assertEquals("__nn_", hangmanModel.getGameState());
    hangmanModel.guess("s");
    assertEquals("s_nn_", hangmanModel.getGameState());
    hangmanModel.guess("sunny");
    assertEquals("sunny", hangmanModel.getGameState());
  }

  /**
   * Test method guess() when the player fails
   */
  @Test(expected = IllegalStateException.class)
  public void guessFails() {
    hangmanModel.guess("a");
    hangmanModel.guess("b");
    hangmanModel.guess("c");
    hangmanModel.guess("d");
    hangmanModel.guess("e");
    hangmanModel.guess("f");
    hangmanModel.guess("g");
    hangmanModel.guess("h");
    assertEquals("_____", hangmanModel.getGameState());
    hangmanModel.guess("i");
  }

  /**
   * Test method getChosenWord()
   */
  @Test
  public void getChosenWord() {
    assertEquals("sunny", hangmanModel.getChosenWord());
  }

  /**
   * Test method getGameState()
   */
  @Test
  public void getGameState() {
    hangmanModel.guess("a");
    assertEquals("_____", hangmanModel.getGameState());
    hangmanModel.guess("n");
    assertEquals("__nn_", hangmanModel.getGameState());
  }

  /**
   * Test method getWrongLetterList()
   */
  @Test
  public void getWrongLetterList() {
    assertEquals(new ArrayList<>(), hangmanModel.getWrongLetterList());
    hangmanModel.guess("a");
    assertEquals("[a]", hangmanModel.getWrongLetterList().toString());
    hangmanModel.guess("n");
    assertEquals("[a]", hangmanModel.getWrongLetterList().toString());
    hangmanModel.guess("b");
    assertEquals("[a, b]", hangmanModel.getWrongLetterList().toString());
  }

  /**
   * Test method getHealth()
   */
  @Test
  public void getHealth() {
    hangmanModel.guess("a");
    assertEquals(7, hangmanModel.getHealth());
    hangmanModel.guess("n");
    assertEquals(7, hangmanModel.getHealth());
    hangmanModel.guess("sanny");
    assertEquals(6, hangmanModel.getHealth());
  }

  /**
   * Test the method gameOver()
   */
  @Test
  public void gameOver() {
    assertFalse(hangmanModel.gameOver());
    hangmanModel.guess("a");
    hangmanModel.guess("b");
    hangmanModel.guess("c");
    hangmanModel.guess("d");
    hangmanModel.guess("e");
    hangmanModel.guess("f");
    hangmanModel.guess("g");
    hangmanModel.guess("h");
    assertTrue(hangmanModel.gameOver());
  }

  /**
   * Test invalid case then call playerWins() before game over
   */
  @Test(expected = IllegalStateException.class)
  public void playerWinsInvalid() {
    hangmanModel.playerWins();
  }

  /**
   * Test method playerWins() when player wins
   */
  @Test
  public void playerWins() {
    hangmanModel.guess("sunny");
    assertTrue(hangmanModel.playerWins());
  }

  /**
   * Test method playerWins() when player lose
   */
  @Test
  public void playerWinsMethodWhenLose() {
    hangmanModel.guess("a");
    hangmanModel.guess("b");
    hangmanModel.guess("c");
    hangmanModel.guess("d");
    hangmanModel.guess("e");
    hangmanModel.guess("f");
    hangmanModel.guess("g");
    hangmanModel.guess("h");
    assertFalse(hangmanModel.playerWins());
  }

  /**
   * Test method getHintOfCategory()
   */
  @Test
  public void getHintOfCategory() {
    assertEquals("Weather", hangmanModel.getHintOfCategory());
  }

  /**
   * Test method getHintByRemovingWrongOption()
   */
  @Test
  public void getHintByRemovingWrongOption() {
    hangmanModel.guess("a");
    hangmanModel.guess("b");
    hangmanModel.guess("c");
    hangmanModel.guess("d");
    hangmanModel.guess("e");
    hangmanModel.guess("f");
    hangmanModel.guess("s");

    assertEquals(8, hangmanModel.getHintByRemovingWrongOption().size());
    assertEquals(14, hangmanModel.getWrongLetterList().size());
  }

  /**
   * Test method restart()
   */
  @Test
  public void restart() {
    hangmanModel.guess("a");
    hangmanModel.guess("b");
    hangmanModel.guess("c");
    hangmanModel.guess("d");
    hangmanModel.guess("e");
    hangmanModel.guess("f");
    hangmanModel.guess("s");
    hangmanModel.restart();
    assertEquals("_____", hangmanModel.getGameState());
    assertEquals("[]", hangmanModel.getWrongLetterList().toString());
    assertEquals(8, hangmanModel.getHealth());
    assertFalse(hangmanModel.gameOver());
    try {
      hangmanModel.playerWins();
      fail("An exception should be thrown!");
    } catch (Exception e) {
    }
    assertEquals(11, hangmanModel.getHintByRemovingWrongOption().size());
    assertEquals(11, hangmanModel.getWrongLetterList().size());
  }
}