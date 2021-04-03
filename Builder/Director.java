//Builder class로 선언되어 있는 method를 사용하여 문서를 만드는 class
public class Director {
	private Builder builder;  
	public Director(Builder builder) {  //Builder class는 abstract class이기 때문에 
		this.builder = builder; //Director의 생성자로 전달되는 것은 Builder를 상속한 하위 클래스 
	}
	
	public void construct() {  //문서를 만드는 method 
		builder.makeTitle("Greeting");
		builder.makeString("아침과 낮에");
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
