package questions;


/**
 * MultipleChoice, a type of question, offers several options, only one of which is correct.
 */
public class MultipleChoice extends AbstractQuestion {
  private final String correctAnswer;

  /**
   * Constructs a multipleChoice object.
   *
   * @param text          the question description itself
   * @param options       the options of this question
   * @param correctAnswer the correct answer of this question
   */
  public MultipleChoice(String text, String correctAnswer, String... options) {
    super(text, options);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("A question has at least 3 options, but no more than 8");
    }
    this.correctAnswer = correctAnswer;
  }

  @Override
  public String answer(String answer) {
    int answerInt = AbstractQuestion.getAnswerInt(answer);
    if (answerInt <= 0) {
      throw new IllegalArgumentException("Answer has to be positive number.");
    }
    if (this.correctAnswer.equals(answer)) {
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
