package framework;
import java.util.*;

public class Manager {
	private HashMap showcase = new HashMap(); //(name, instance)
	public void register(String name, Product proto) {
		showcase.put(name,  proto);
	}
	public Product create(String protoname) {
		Product p = (Product)showcase.get(protoname);
		return p.createClone(); // 호출 --> 복제 실행 
	}
}
