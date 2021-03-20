
public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	public final void display() {  //abstract method���� �����ϰ� �ִ� -> Template Method 
		open();
		for(int i=0; i<4; i++) {
			print();
		}
		close();
	}
}
