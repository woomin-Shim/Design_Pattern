
public class charDisplay extends AbstractDisplay {  //������ �߻� �޼ҵ���� �����ϰ� �ִ� 
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
