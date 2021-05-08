
public class Main {
	public static void main(String[] args) {
		//Support형 변수지만 실제로 대입은 상속받은 각 class들의 instance
		Support woomin = new HWSupport("Woomin");
		Support alice = new NoSupport("Alice"); //Nosupport instance 생성
		Support bob = new LimitSupport("Bob", 100); // 100 미만 까지 문제 해결
		Support charlie = new SpecialSupport("Charlie", 429);
		Support diana = new LimitSupport("Diana", 200);  //200 미만까지 문제 해결
		Support elmo = new OddSupport("Elmo");
		Support fred = new LimitSupport("Fred", 300);
		
		//사슬 형성
		woomin.setNext(alice).setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
		
		//Trouble 
		for(int i=0; i<100; i+=1) {
			woomin.support(new Trouble(i));
		}
	}
}
