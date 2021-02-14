package questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * MultipleSelect, a type of question,  offers several options, but there are multiple correct
 * answers.
 */
public class MultipleSelect extends AbstractQuestion {
  private final Set<Integer> correctAnswers;

  /**
   * Constructs a MultipleSelect instance.
   *
   * @param text           the question description itself.
   * @param options        the options of this question.
   * @param correctAnswers the correct answers of this question.
   */
  public MultipleSelect(String text, List<String> options, List<Integer> correctAnswers) {
    super(text, options);
    if (options.size() < 3 || options.size() > 8) {
      throw new IllegalArgumentException(" A question may have _at least 3 options, but no more than 8_ ");
    }
    this.correctAnswers = new HashSet<>(correctAnswers);
  }

  @Override
  public String answer(String answer) {
    String[] splitUserAnswers = answer.split(" ");
    Set<Integer> userAnswers = new HashSet<>();
    for (String a : splitUserAnswers) {
      userAnswers.add(AbstractQuestion.getAnswerInt(a));
    }
    if (correctAnswers.equals(userAnswers)) {
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
