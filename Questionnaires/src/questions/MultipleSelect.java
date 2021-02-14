package questions;

/**
 * MultipleSelect, a type of question,  offers several options, but there are multiple correct
 * answers.
 */
public class MultipleSelect extends AbstractQuestion {
  private final String correctAnswers;

  /**
   * Constructs a MultipleSelect instance.
   *
   * @param text           the question description itself.
   * @param correctAnswers the correct answers of this question.
   * @param options        the options of this question.
   */
  public MultipleSelect(String text, String correctAnswers, String... options) {
    super(text, options);
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("A question has at least 3 options, but no more than 8");
    }
    this.correctAnswers = correctAnswers;
  }

  @Override
  public String answer(String answer) {
    if (correctAnswers.equals(answer)) {
      return "Correct";
    } else {
      return "Incorrect";
    }
  }

  @Override
  public int compareTo(Question question) {
    if (question instanceof AbstractQuestion) {
      AbstractQuestion aQuestion = (AbstractQuestion) question;
      return -1 * aQuestion.compareToMultipleSelect(this);
    }
    return -1;
  }

  @Override
  public int compareToTrueOrFalse(TrueFalse tf) {
    return 1;
  }

  @Override
  public int compareToMultipleSelect(MultipleSelect ms) {
    return this.getText().compareTo(ms.getText());
  }

  @Override
  public int compareToMultipleChoice(MultipleChoice mc) {
    return 1;
  }

}
