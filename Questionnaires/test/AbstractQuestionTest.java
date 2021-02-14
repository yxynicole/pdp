package questions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * A Junit test for abstract question class.
 */

public class AbstractQuestionTest {

  private static class ConcreteQuestion extends AbstractQuestion {
    public ConcreteQuestion(String text, List<String> options) {
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
    AbstractQuestion q = new ConcreteQuestion("xyz", Arrays.asList("A", "B", "C", "D"));
    String expected = "xyz\nA\nB\nC\nD\n";
    Assert.assertEquals(expected, q.getText());
  }
}