
public class PrimeNumberGenerator extends NumberGenerator{
	private int num=1;
	
	public boolean isPrime(int n) {
		if(n<2) return false;
		for(int i=2; i<=Math.sqrt(n); i++) 
			if(n%i==0) return false;
		return true;
	}
	
	public int getNumber() {
		return num;
	}
	public void execute() {
		while(num <50) {
			if(isPrime(num)) notifyObservers();
			num++;
		}
	}
}
