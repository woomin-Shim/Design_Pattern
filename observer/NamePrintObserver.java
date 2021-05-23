
public class NamePrintObserver implements Observer{
	public void update(NumberGenerator generator) {
		System.out.print("NamePrintObserver : ");
		for(int i=0; i<generator.getNumber(); i++) {  //��������ڷκ��� ���� ���ڸ�ŭ �ݺ�
			System.out.print("�ɿ�� ");
		}
		System.out.println("");
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {}
	}
}
