package idcard;
import framework.*;  //connect package

public class IDCard extends Product{
	private String owner;
	IDCard(String owner) {
		this.owner=owner;
		System.out.println(owner + "�� ī�带 ����ϴ�.");
		
	}
	public void use() {
		System.out.println(owner + "�� ī�带 ����մϴ�.");
	}
	public String getOwner() {
		return owner;
	}
}
