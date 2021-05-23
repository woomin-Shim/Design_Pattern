
public class NamePrintObserver implements Observer{
	public void update(NumberGenerator generator) {
		System.out.print("NamePrintObserver : ");
		for(int i=0; i<generator.getNumber(); i++) {  //관찰대상자로부터 얻은 숫자만큼 반복
			System.out.print("심우민 ");
		}
		System.out.println("");
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {}
	}
}
