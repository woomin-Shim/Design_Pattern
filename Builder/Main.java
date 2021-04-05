//��ɾ� �μ��� plain�� ġ�� TextBuilder�� instance�� Director class�� �����ڿ��� ����
//��ɾ� �μ��� html�� ġ�� HTMLBuilder�� instance�� Director class�� �����ڿ��� ���� 
public class Main {
	public static void main(String[] args) {
		if(args.length!=1) {
			usage();
			System.exit(0);
		}
		if(args[0].equals("plain")) {
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.construct(); //���� ���� instance�� ���� �ۼ�
			String result = textbuilder.getResult();
			System.out.println(result);
		}
		else if(args[0].contentEquals("html")) {
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.construct();
			String filename = htmlbuilder.getResult();
			System.out.println(filename + "�� �ۼ��Ǿ����ϴ�.");
		}
		else {
			usage();
			System.exit(0);
		}
	}
	public static void usage() {
		System.out.println("Usage : java Main plain �Ϲ� �ؽ�Ʈ�� �����ۼ�");
		System.out.println("Usage : java Main html  HTML ���Ϸ� �����ۼ�");
	}
}
