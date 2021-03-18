package adapter_inheritance;

public class PrintBanner extends Banner implements Print{ //Banner 상속, Print인터페이스 구현
	public PrintBanner(String string) {
		super(string);
	}
	public void printWeak() {
		showWithParen();
	}
	public void printStrong() {
		showWithAster();
	}
}
