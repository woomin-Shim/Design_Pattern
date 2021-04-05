//명령어 인수에 plain을 치면 TextBuilder의 instance를 Director class의 생성자에게 전달
//명령어 인수에 html을 치면 HTMLBuilder의 instance를 Director class의 생성자에게 전달 
public class Main {
	public static void main(String[] args) {
		if(args.length!=1) {
			usage();
			System.exit(0);
		}
		if(args[0].equals("plain")) {
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.construct(); //전달 받은 instance로 문서 작성
			String result = textbuilder.getResult();
			System.out.println(result);
		}
		else if(args[0].contentEquals("html")) {
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.construct();
			String filename = htmlbuilder.getResult();
			System.out.println(filename + "가 작성되었습니다.");
		}
		else {
			usage();
			System.exit(0);
		}
	}
	public static void usage() {
		System.out.println("Usage : java Main plain 일반 텍스트로 문서작성");
		System.out.println("Usage : java Main html  HTML 파일로 문서작성");
	}
}
