package questions;


/**
 * True/False, a type of question, can be answered in one of two ways: true or false.
 */
public class TrueFalse extends AbstractQuestion {
  private final String correctAnswer;

  /**
   * Constructs a TrueOrFalse question.
   *
   * @param text          the text of the question itself
   * @param correctAnswer the correct answer of this question that is either true or false
   */
  public TrueFalse(String text, String correctAnswer) {
    super(text, new String[]{"1-True", "2-False"});
    this.correctAnswer = correctAnswer;
  }


  @Override
  public String answer(String answer) {
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
      return -1 * aQuestion.compareToTrueOrFalse(this);
    }
    return -1;
  }

  @Override
  public int compareToTrueOrFalse(TrueFalse tf) {
    return this.getText().compareTo(tf.getText());
  }

}
