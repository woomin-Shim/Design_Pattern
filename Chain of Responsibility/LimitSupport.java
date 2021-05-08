
public class LimitSupport extends Support{  
	private int limit;
	public LimitSupport(String name, int limit) {
		super(name);
		this.limit = limit;
	}
	
	protected boolean resolve(Trouble trouble) {  //limit 보다 작으면 Trouble solve  
		if(trouble.getNumber() < limit) return true;
		else return false;
	}
}
