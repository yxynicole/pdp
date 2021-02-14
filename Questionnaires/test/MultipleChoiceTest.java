import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * A Junit test for MultipleChoice class.
 */

public class MultipleChoiceTest {
  private Question question;

  @Before
  public void setup() {
    question = new MultipleChoice("What year it is", Arrays.asList(
            "1-2020", "2-2021", "3-2022", "4-2023"
    ), 2);
  }

  @Test
  public void testCompareToNonAbstractQuestion() {
    Question another = new Question() {
      @Override
      public String answer(String answer) {
        return null;
      }

      @Override
      public String getText() {
        return null;
      }

      @Override
      public int compareTo(Question o) {
        return 0;
      }
    };

    Assert.assertEquals(-1, question.compareTo(another));
  }

  @Test
  public void testCompareToAnotherMultipleChoiceReturnsZero() {
    Question another = new MultipleChoice("What year it is", Arrays.asList(
            "1-2020", "2-2021", "3-2022", "4-2023"
    ), 2);
    Assert.assertEquals(0, question.compareTo(another));
  }

  @Test
  public void testCompareToAnotherMultipleChoiceReturnsPositive() {
    Question another = new MultipleChoice("Ahat year it is", Arrays.asList(
            "1-2020", "2-2021", "3-2022", "4-2023"
    ), 2);
    Assert.assertTrue(question.compareTo(another) > 0);
  }

  @Test
  public void testCompareToAnotherMultipleChoiceReturnsNegative() {
    Question another = new MultipleChoice("Zhat year it is", Arrays.asList(
            "1-2020", "2-2021", "3-2022", "4-2023"
    ), 2);
    Assert.assertTrue(question.compareTo(another) < 0);
  }

  @Test
  public void testCompareToTrueOrFalseReturnsPositive() {
    Question another = new TrueFalse("Does one plus one equal two", 1);
    Assert.assertTrue(question.compareTo(another) > 0);
  }

  @Test
  public void testCompareToMultipleSelectionReturnsNegative() {
    Question another = new MultipleSelect("What course do you like?",
            Arrays.asList("1-CS5010", "2-CS5600", "3-CS5700", "4-Cake"),
            Arrays.asList(1, 2, 3));
    Assert.assertTrue(question.compareTo(another) < 0);
  }

  @Test
  public void testCompareToLikertReturnsNegative() {
    Question likert = new Likert("Do you like CS?");
    Assert.assertTrue(question.compareTo(likert) < 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTooManyArgument() {
    new MultipleChoice("Test", Arrays.asList("1", "2", "3", "1", "2", "3", "1", "2", "3"), 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTooFewArgument() {
    new MultipleChoice("Test", Arrays.asList("1", "2"), 1);
  }

  @Test
  public void testAnswerCorrect() {
    String result = question.answer("2");
    Assert.assertEquals(Question.CORRECT, result);
  }

  @Test
  public void testAnswerIncorrect() {
    String result = question.answer("1");
    Assert.assertEquals(Question.INCORRECT, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAnswerInvalid() {
    question.answer("0");
  }

}