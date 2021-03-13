public class EmptyNode implements IListOfBooks{

  @Override
  public int count() {
    int accumulator = 0;
    return this.countHelp(accumulator);
  }

  @Override
  public int countHelp(int accumulator){
    return accumulator;
  }

  @Override
  public float totalPrice() {
    return 0;
  }

  @Override
  public IListOfBooks allBefore(int year) {
    return new EmptyNode();
  }

  @Override
  public IListOfBooks sortByPrice() {
    return new EmptyNode();
  }

  @Override
  public IListOfBooks insert(Book book) {
    return new ElementNode(book,this);
  }

  @Override
  public String toString(){
    return "";
  }
}
