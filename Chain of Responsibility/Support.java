
public abstract class Support {  //문제를 해결할 사슬 제작을 위한 abstract class
	private String name;
	private Support next; //책임을 떠넘기는 곳
	public Support(String name) {
		this.name = name;
	}
	
	public Support setNext(Support next) { //책임을 떠넘기는 곳을 설정
		this.next = next;
		return next;
	}
	
	public final void support(Trouble trouble) {
		if(resolve(trouble)) {  //문제 해결
			done(trouble);
		}
		else if (next != null) {  //책임을 떠넘김 
			next.support(trouble);
		}
		else  //문제 해결 X
			fail(trouble);
	}
	
	public String toString() {
		return "[" + name + "]";
	}
	
	protected abstract boolean resolve(Trouble trouble);
	protected void done(Trouble trouble) {
		System.out.println(trouble + " is resolved by " + this + ".");
	}
	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}

}
