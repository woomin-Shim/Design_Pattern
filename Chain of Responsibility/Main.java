
public class Main {
	public static void main(String[] args) {
		//Support�� �������� ������ ������ ��ӹ��� �� class���� instance
		Support woomin = new HWSupport("Woomin");
		Support alice = new NoSupport("Alice"); //Nosupport instance ����
		Support bob = new LimitSupport("Bob", 100); // 100 �̸� ���� ���� �ذ�
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);  //200 �̸����� ���� �ذ�
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);
		
		//�罽 ����
		woomin.setNext(alice).setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		
		//Trouble 
		for(int i=0; i<100; i+=1) {
			woomin.support(new Trouble(i));
		}
	}
}
