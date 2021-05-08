public class NoSupport extends Support {
	public NoSupport(String name) {
		super(name);
	}
	protected boolean resolve(Trouble trouble) {  //문제 해결 X
		return false;
	}
}
