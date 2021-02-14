package questions;


/**
 * A skeleton class for question implementation.
 */
abstract class AbstractQuestion implements Question {
  String text;// the description of the question
  String[] options;

  /**
   * Parses input into integer.
   *
   * @param answer the raw answer as string
   * @return integer representation of the answer
   */
  static protected int getAnswerInt(String answer) {
    return Integer.parseInt(answer.trim());
  }

  /**
   * Constructs abstract question.
   *
   * @param text    the question description itself
   * @param options options of this question
   */
  public AbstractQuestion(String text, String[] options) {
    this.text = text;
    this.options = options;
  }

  @Override
  public String getText() {
    StringBuilder text = new StringBuilder();
    text.append(this.text);
    text.append("\n");
    for (String anOption : options) {
      text.append(anOption);
      text.append("\n");
    }
    return text.toString();
  }


  protected int compareToTrueOrFalse(TrueFalse tf) {
    return -1;
  }

  protected int compareToMultipleChoice(MultipleChoice mc) {
    return -1;
  }

  protected int compareToMultipleSelect(MultipleSelect ms) {
    return -1;
  }

  protected int compareToLikert(Likert l) {
    return -1;
  }


}

