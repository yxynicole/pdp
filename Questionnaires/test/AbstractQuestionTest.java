package questions;

import org.junit.Test;


import org.junit.Assert;

/**
 * A Junit test for abstract question class.
 */

public class AbstractQuestionTest {

  private static class ConcreteQuestion extends AbstractQuestion {
    public ConcreteQuestion(String text, String... options) {
      super(text, options);
    }

    @Override
    public String answer(String answer) {
      return null;
    }

    @Override
    public int compareTo(Question o) {
      return 0;
    }
  }


  @Test
  public void getText() {
    AbstractQuestion q = new ConcreteQuestion("xyz", "A", "B", "C", "D");
    String expected = "xyz\nA\nB\nC\nD\n";
    Assert.assertEquals(expected, q.getText());
  }
}