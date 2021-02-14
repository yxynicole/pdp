import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * A Junit test for TrueOrFalse class.
 */
public class TrueFalseTest {
  private Question question;

  @Before
  public void setup() {
    question = new TrueFalse("1+1=2", "True");
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
  public void testCompareToAnotherTureOrFalseReturnsZero() {
    Question another = new TrueFalse("1+1=2", "True");
    Assert.assertEquals(0, question.compareTo(another));
  }

  @Test
  public void testCompareToAnotherTureOrFalseReturnsPositive() {
    Question another = new TrueFalse("0+1=2", "1");
    Assert.assertTrue(question.compareTo(another) > 0);
  }

  @Test
  public void testCompareToAnotherTureOrFalseReturnsNegative() {
    Question another = new TrueFalse("2+1=2", "True");
    Assert.assertTrue(question.compareTo(another) < 0);
  }

  @Test
  public void testCompareToMultipleChoiceReturnsNegative() {
    Question another = new MultipleChoice("What year it is", "2",
            "1-2020", "2-2021", "3-2022", "4-2023");
    Assert.assertTrue(question.compareTo(another) < 0);
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

  @Test
  public void testAnswerCorrect() {
    String result = question.answer("True");
    Assert.assertEquals(Question.CORRECT, result);
  }

  @Test
  public void testAnswerIncorrect() {
    String result = question.answer("False");
    Assert.assertEquals(Question.INCORRECT, result);
  }

}