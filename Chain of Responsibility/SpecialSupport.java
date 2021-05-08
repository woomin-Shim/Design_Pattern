
public class SpecialSupport extends Support {  
	private int number;
	public SpecialSupport(String name, int number) {
		super(name);
		this.number = number;
	}
	
	protected boolean resolve(Trouble trouble) {  //지정한 숫자이면 문제 해결 
		if(trouble.getNumber() == number) return true;
		else 
			return false;
	}
}
