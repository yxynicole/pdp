package questions;

import java.util.List;

/**
 * MultipleChoice, a type of question, offers several options, only one of which is correct.
 */
public class MultipleChoice extends AbstractQuestion {
  private final int correctAnswer;

  /**
   * Constructs a multipleChoice object.
   *
   * @param text          the question description itself
   * @param options       the options of this question
   * @param correctAnswer the correct answer of this question
   */
  public MultipleChoice(String text, List<String> options, int correctAnswer) {
    super(text, options);
    if (options.size() < 3 || options.size() > 8) {
      throw new IllegalArgumentException(" A question may have _at least 3 options, but no more than 8_ ");
    }
    this.correctAnswer = correctAnswer;
  }

  @Override
  public String answer(String answer) {
    int answerInt = AbstractQuestion.getAnswerInt(answer);
    if (answerInt <= 0) {
      throw new IllegalArgumentException("Answer has to be positive number.");
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
      return -1 * aQuestion.compareToMultipleChoice(this);
    }
    return -1;
  }

  @Override
  public int compareToTrueOrFalse(TrueFalse tf) {
    return 1;
  }

  @Override
  public int compareToMultipleChoice(MultipleChoice mc) {
    return this.getText().compareTo(mc.getText());
  }


}
