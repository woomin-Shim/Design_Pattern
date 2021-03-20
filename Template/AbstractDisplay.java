
public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	public final void display() {  //abstract method들을 구현하고 있다 -> Template Method 
		open();
		for(int i=0; i<4; i++) {
			print();
		}
		close();
	}
}
