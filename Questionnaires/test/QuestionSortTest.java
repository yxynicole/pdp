import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * A Junit test for testing whether questions are sorted based on their type and text.
 */
public class QuestionSortTest {

  @Test
  public void testSortQuestions() {
    Question tf = new TrueFalse("1+1=2", 1);

    Question mc = new MultipleChoice("What year is it? ",
            Arrays.asList("1-2008", "2-2012", "3-2020", "4-2021"),
            4);

    Question ms = new MultipleSelect("What course do you like?",
            Arrays.asList("1-CS5010", "2-CS5600", "3-CS5700", "4-Cake"),
            Arrays.asList(1, 2, 3));

    Question likert = new Likert("Do you like CS?");

    Question[] questionnaire = {likert, mc, ms, tf,};
    Arrays.sort(questionnaire);

    Assert.assertEquals(tf, questionnaire[0]);
    Assert.assertEquals(mc, questionnaire[1]);
    Assert.assertEquals(ms, questionnaire[2]);
    Assert.assertEquals(likert, questionnaire[3]);

  }
}
