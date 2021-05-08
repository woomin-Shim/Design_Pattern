
public class OddSupport extends Support { //odd number 이면 문제 해결
	public OddSupport(String name) {
		super(name);
	}
	protected boolean resolve(Trouble trouble) {
		if(trouble.getNumber()%2==0) return false;
		else return true;
	}
}
