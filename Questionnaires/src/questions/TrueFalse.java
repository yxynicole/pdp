package questions;

import java.util.Arrays;

/**
 * True/False, a type of question, can be answered in one of two ways: true or false.
 */
public class TrueFalse extends AbstractQuestion {
  private final int correctAnswer;

  /**
   * Constructs a TrueOrFalse question.
   *
   * @param text          the text of the question itself
   * @param correctAnswer the correct answer of this question that is either true or false
   */
  public TrueFalse(String text, int correctAnswer) {
    super(text, Arrays.asList("1-True", "2-False"));
    if (correctAnswer < 1 || correctAnswer > 2) {
      throw new IllegalArgumentException("Only 1(True) or 2(false) is allowed as correct answer");
    }
    this.correctAnswer = correctAnswer;
  }


  @Override
  public String answer(String answer) {
    int answerInt = AbstractQuestion.getAnswerInt(answer);
    if (answerInt < 1 || answerInt > 2) {
      throw new IllegalArgumentException("You can only choose from 1 and 2");
    }
    if (this.correctAnswer == answerInt) {
      return "Correct";
    } else {
      return "Incorrect";
    }
  }

  @Override
  public int compareTo(Question question) {
    if (question instanceof AbstractQuestion) {
      AbstractQuestion aQuestion = (AbstractQuestion) question;
      return -1 * aQuestion.compareToTrueOrFalse(this);
    }
    return -1;
  }

  @Override
  public int compareToTrueOrFalse(TrueFalse tf) {
    return this.getText().compareTo(tf.getText());
  }

}
