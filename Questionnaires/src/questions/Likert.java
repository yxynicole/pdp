package questions;

/**
 * Likert, a type of question, can be answered on a fixed, 5-point Likert scale (Strongly Agree,
 * Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree).
 */
public class Likert extends AbstractQuestion {
  /**
   * Constructs a Likert question.
   *
   * @param text the question description itself
   */
  public Likert(String text) {
    super(text, new String[]{
        "1-Strongly Agree", "2-Agree",
        "3-Neither Agree nor Disagree", "4-Disagree",
        "5-Strongly Disagree"});
  }

  @Override
  public String answer(String answer) {
    int answerInt = AbstractQuestion.getAnswerInt(answer);
    if (answerInt > 5 || answerInt < 1) {
      return "Incorrect";
    } else {
      return "Correct";
    }
  }


  @Override
  public int compareTo(Question question) {
    if (question instanceof AbstractQuestion) {
      AbstractQuestion aQuestion = (AbstractQuestion) question;
      return -1 * aQuestion.compareToLikert(this);
    }
    return -1;
  }

  @Override
  public int compareToTrueOrFalse(TrueFalse tf) {
    return 1;
  }

  @Override
  public int compareToMultipleChoice(MultipleChoice mc) {
    return 1;
  }

  @Override
  protected int compareToMultipleSelect(MultipleSelect ms) {
    return 1;
  }

  @Override
  protected int compareToLikert(Likert l) {
    return this.getText().compareTo(l.getText());
  }
}

