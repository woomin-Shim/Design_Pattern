//Builder class�� ����Ǿ� �ִ� method�� ����Ͽ� ������ ����� class
public class Director {
	private Builder builder;  
	public Director(Builder builder) {  //Builder class�� abstract class�̱� ������ 
		this.builder = builder; //Director�� �����ڷ� ���޵Ǵ� ���� Builder�� ����� ���� Ŭ���� 
	}
	
	public void construct() {  //������ ����� method 
		builder.makeTitle("Greeting");
		builder.makeString("��ħ�� ����");
		builder.makeItems(new String[] {
			"Hello World",
			"Good Morning",
		});
		builder.makeString("Hi there");
		builder.makeItems(new String[] {
				"Good night",
				"Good Morning",
				"See you later",
			});
		builder.close();
	}
}
