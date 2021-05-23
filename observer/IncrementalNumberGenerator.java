
public class IncrementalNumberGenerator extends NumberGenerator {
	private int number;
	private int last;
	private int increase;
	
	public IncrementalNumberGenerator(int number, int last, int increase) {
		this.number = number;
		this.last = last;
		this.increase = increase;
	}
	
	public int getNumber() {
		return number;
	}
	public void execute() {
		while(number < last) {
			notifyObservers();
			number += increase;
		}
		
	}
}
