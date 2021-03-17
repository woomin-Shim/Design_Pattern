package iterator;

public interface Iterator {
  public abstract boolean hasNext();  //다음 요소가 존재하면 true, 존재하지 않으면 false
  public abstract Object next();
}
