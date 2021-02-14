import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
    question = new MultipleChoice("What year is it? ", "4",
            "1-2008", "2-2012", "3-2020", "4-2021");
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
    Question another = new MultipleChoice("What year is it? ", "4",
            "1-2008", "2-2012", "3-2020", "4-2021");
    Assert.assertEquals(0, question.compareTo(another));
  }

  @Test
  public void testCompareToAnotherMultipleChoiceReturnsPositive() {
    Question another = new MultipleChoice("Ahat year is it? ", "4",
            "1-2008", "2-2012", "3-2020", "4-2021");
    Assert.assertTrue(question.compareTo(another) > 0);
  }

  @Test
  public void testCompareToAnotherMultipleChoiceReturnsNegative() {
    Question another = new MultipleChoice("Zhat year is it? ", "4",
            "1-2008", "2-2012", "3-2020", "4-2021");
    Assert.assertTrue(question.compareTo(another) < 0);
  }

  @Test
  public void testCompareToTrueOrFalseReturnsPositive() {
    Question another = new TrueFalse("Does one plus one equal two", "True");
    Assert.assertTrue(question.compareTo(another) > 0);
  }

  @Test
  public void testCompareToMultipleSelectionReturnsNegative() {
    Question another = new MultipleSelect("What course do you like?", "1 2 3",
            "1-CS5010", "2-CS5600", "3-CS5700", "4-Cake");
    Assert.assertTrue(question.compareTo(another) < 0);
  }

  @Test
  public void testCompareToLikertReturnsNegative() {
    Question likert = new Likert("Do you like CS?");
    Assert.assertTrue(question.compareTo(likert) < 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTooManyArgument() {
    new MultipleChoice("Test", "1", "1", "2", "3", "1", "2", "3", "1", "2", "3");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorTooFewArgument() {
    new MultipleChoice("Test", "1", "1", "2");
  }

  @Test
  public void testAnswerCorrect() {
    String result = question.answer("4");
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