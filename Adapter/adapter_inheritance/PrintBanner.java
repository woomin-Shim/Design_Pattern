package adapter_inheritance;

public class PrintBanner extends Banner implements Print{ //Banner ���, Print�������̽� ����
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
