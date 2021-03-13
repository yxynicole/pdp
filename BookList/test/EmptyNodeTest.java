import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmptyNodeTest {
  private IListOfBooks emptyList;

  @Before
  public void setup(){
      this.emptyList = new EmptyNode();
  }

  @Test
  public void testCount(){
    assertEquals(0, this.emptyList.count());
  }

  @Test
  public void testToString(){
    assertEquals("", emptyList.toString());
  }

  //@Test
  //todo public void testAllBefore(){

  //}
}