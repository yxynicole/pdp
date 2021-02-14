import java.util.Arrays;
import java.util.Scanner;

import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * A Driver class tests whether questions could be sorted in an expected order: -All true/false
 * questions should be before any multiple-choice questions. -All multiple-choice questions should
 * be before any multiple-select questions. -All multiple-select questions should be before any
 * Likert questions. -Within a question type, they should be ordered in the lexicographical order of
 * their question text.
 */
public class Driver {

  public static void main(String[] args) {
    Question tf = new TrueFalse("1+1=2", 1);

    Question mc = new MultipleChoice("What year is it? ",
            Arrays.asList("1-2008", "2-2012", "3-2020", "4-2021"),
            4);

    Question ms = new MultipleSelect("What course do you like?",
            Arrays.asList("1-CS5010", "2-CS5600", "3-CS5700", "4-Cake"),
            Arrays.asList(1, 2, 3));

    Question likert = new Likert("Do you like CS?");

    Question[] questionBank = {likert, mc, ms, tf,};
    Arrays.sort(questionBank);


    for (Question q : questionBank) {
      System.out.println(q.getText());
      Scanner scanner = new Scanner(System.in);
      System.out.println(q.answer(scanner.nextLine()));
      System.out.println("--------------------\n");
    }
  }
}
