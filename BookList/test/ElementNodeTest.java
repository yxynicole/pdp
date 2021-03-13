import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementNodeTest {

  IListOfBooks partialListOfBooks;
  IListOfBooks listOfBooks;
  @Before
  public void setup(){
    partialListOfBooks = new ElementNode(new Book("HP 1", "J.K. Rowling", 1997,  19.99f),
            new ElementNode(new Book("HP 2", "J.K. Rowling", 1999,  29.99f),
                    new ElementNode(new Book("HP 3", "J.K Rowling", 2001,10.99f),
                            new EmptyNode())));

     listOfBooks = new ElementNode(new Book("HP 4", "J.K. Rowling", 2004, 15.49f),
            new ElementNode(new Book("HP 5", "J.K. Rowling", 2006, 12.99f),
                    new ElementNode(new Book("HP 6", "J.K Rowling", 2007, 7.99f),
                            partialListOfBooks)));

  }

  @Test
  public void testCount(){
    assertEquals(3, partialListOfBooks.count());
    assertEquals(6,listOfBooks.count());
  }

  @Test
  public void testToString(){
    String expectedPartialListOfBooks = "(Title: HP 1 Year: 1997 Price: 19.99)(Title: HP 2 Year: 1999 Price: 29.99)(Title: HP 3 Year: 2001 Price: 10.99)";
    assertEquals(expectedPartialListOfBooks, partialListOfBooks.toString());

    String expectedListOfBooks = "(Title: HP 4 Year: 2004 Price: 15.49)"+
            "(Title: HP 5 Year: 2006 " + "Price: 12.99)"+
            "(Title: HP 6 Year: 2007 Price: 7.99)"+
            "(Title: HP 1 Year: 1997 Price: 19.99)"+
            "(Title: HP 2 Year: 1999 Price: 29.99)"+
            "(Title: HP 3 Year: 2001 Price: 10.99)";
    assertEquals(expectedListOfBooks,listOfBooks.toString());
  }

  @Test
  public void testAllBefore(){
    IListOfBooks before2000 = listOfBooks.allBefore(2000);
    String expected = "(Title: HP 1 Year: 1997 Price: 19.99)" +"(Title: HP 2 Year: 1999 Price: 29.99)";
    assertEquals(expected, before2000.toString());
  }

  @Test
  public void testSortByPrice(){
    IListOfBooks sortedByPrice = listOfBooks.sortByPrice();
    String expected = "(Title: HP 6 Year: 2007 " +"Price: 7.99)"+
            "(Title: HP 3 Year: 2001 Price: 10.99)"+
            "(Title: HP 5 Year: 2006 Price: 12.99)"+
            "(Title: HP 4 Year: 2004 Price: 15.49)"+
            "(Title: HP 1 Year: 1997 Price: 19.99)"+
            "(Title: HP 2 Year: 1999 Price: 29.99)";
    assertEquals(expected, sortedByPrice.toString());
  }



}