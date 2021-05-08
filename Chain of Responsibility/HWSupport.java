
public class HWSupport extends Support {  //소수이면 문제 해결
	public HWSupport(String name) {
		super(name);
	}
	
	protected boolean resolve(Trouble trouble) {
		if(calcPrimeNumber(trouble.getNumber()))
			return true;
		else
			return false;
	}
	
	public boolean calcPrimeNumber(int n) {
		if(n < 2) return false;
		
		for(int i=2; i <= Math.sqrt(n); i++) 
			if(n%i==0) return false;  //not prime
		return true;
	}
}
