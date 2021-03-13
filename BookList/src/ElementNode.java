public class ElementNode implements IListOfBooks {
  private Book book;
  private IListOfBooks rest;

  public ElementNode(Book book, IListOfBooks listOfBooks) {
    this.book = book;
    this.rest = listOfBooks;
  }

  @Override
  public int count() {
    int accumulator = 0;
    return this.countHelp(accumulator);
  }

  @Override
  public int countHelp(int accumulator) {
    return this.rest.countHelp(accumulator + 1);
  }

  @Override
  public float totalPrice() {
    return 0;
  }

  @Override
  public IListOfBooks allBefore(int year) {
    if (this.book.before(year)) {
      return new ElementNode(this.book, this.rest.allBefore(year));
    } else {
      return this.rest.allBefore(year);
    }
  }

  @Override
  public IListOfBooks sortByPrice() {
    return this.rest.sortByPrice().insert(this.book); //insert this book into the sorted rest of list
  }

  @Override
  public IListOfBooks insert(Book book) {
    if (this.book.cheaperThan(book)) {
      return new ElementNode(this.book, this.rest.insert(book));
    } else {
      return new ElementNode(book,this);
    }
  }

  @Override
  public String toString() {
    return "(" + this.book.toString() + ")" + this.rest.toString();
  }
}
