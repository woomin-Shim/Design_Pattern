
public class charDisplay extends AbstractDisplay {  //실제로 추상 메소드들을 구현하고 있다 
	private char ch;                                  //Concrete Class
	public charDisplay(char ch) {
		this.ch = ch;
	}
	public void open() {
		System.out.print( "<<");
	}
	public void print() {
		System.out.print(ch);
	}
	public void close() {
		System.out.println(">>");
	}
}
