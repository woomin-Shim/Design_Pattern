
public abstract class Support {  //������ �ذ��� �罽 ������ ���� abstract class
	private String name;
	private Support next; //å���� ���ѱ�� ��
	public Support(String name) {
		this.name = name;
	}
	
	public Support setNext(Support next) { //å���� ���ѱ�� ���� ����
		this.next = next;
		return next;
	}
	
	public final void support(Trouble trouble) {
		if(resolve(trouble)) {  //���� �ذ�
			done(trouble);
		}
		else if (next != null) {  //å���� ���ѱ� 
			next.support(trouble);
		}
		else  //���� �ذ� X
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
