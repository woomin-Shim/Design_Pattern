import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class LoginFrame extends Frame implements ActionListener, Mediator{
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueCheckbox checkMember; //member radio button
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueTextField textIdCard; //주민등록번호 
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	//Colleague들을 생성하고, 배치한 후 표시를 실행
	public LoginFrame(String title) {
		super(title);
		
		BorderLayout b = new BorderLayout();  //격자형식이 아닌 자유롭게 배치시키기 위해 BorderLayout 
		setSize(700,700);
		setLayout(b);
		
		Panel p1 = new Panel();  //Radio box button part pannel
		Panel p2 = new Panel();  //Text Field pare Pannel
		setBackground(Color.lightGray);
		
		add(p1, "North");  //제일 상단에 배치
		add(p2, "Center");  //중간에 배치 
		
		
		//Colleague들의 생성
		createColleagues();
		
		p1.setLayout(new GridLayout(1, 3)); //Layout 매니저를 사용해서 1*3의 그리드를 만듬
		//배치
		p1.add(checkGuest);
		p1.add(checkLogin);
		p1.add(checkMember);
		
		p2.setLayout(new GridLayout(4, 2));  //Layout 매니저를 사용해서 4*2의 그리드를 만듬
		p2.add(new Label("Username:"));
		p2.add(textUser);
		p2.add(new Label("Password:"));
		p2.add(textPass);
		p2.add(new Label("주민등록번호:"));
		p2.add(textIdCard);
		p2.add(buttonOk);
		p2.add(buttonCancel);
		
		//유효, 무효의 초기 지정
		colleagueChanged();
		
		//표시
		pack();
		show();   //setVisible(true)
	}
	
	//Colleague들 생성
	public void createColleagues() {
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		checkMember = new ColleagueCheckbox("Member", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textIdCard = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		//Mediator의 set
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		checkMember.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		textIdCard.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		//Listener의 set
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		checkMember.addItemListener(checkMember);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		textIdCard.addTextListener(textIdCard);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}
	
	//Colleage에서의 통지로 Colleague의 유효,무효 판정
	public void colleagueChanged() {
		if(checkGuest.getState()) {  //Guest에 check
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			textIdCard.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		}
		else if(checkLogin.getState()) {  //Login에 check 
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
		else if(checkMember.getState()){  //Member에 check
			textUser.setColleagueEnabled(true);  //Username 활성화
			textPass.setColleagueEnabled(true);  //Password 활성화
			textIdCard.setColleagueEnabled(true);  // 주민등록번호 텍스트필드 활성화
			buttonOk.setColleagueEnabled(false);  //OK 버튼 비활성화
			IdCardChanged();
			
		}
	}
	
	private void userpassChanged() {
		if(textUser.getText().length() > 0) {
			textPass.setColleagueEnabled(true);
			if(textPass.getText().length() > 0) {
				buttonOk.setColleagueEnabled(true);
			}
			else {
				buttonOk.setColleagueEnabled(false);
			}
		}
		else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	
	//주민등록번호 필드에 13자리를 숫자로 입력했으면 OK버튼 활성화
	private void IdCardChanged() {
		if(textIdCard.getText().length() == 13) {
			if(textIdCard.getText().matches("[a-zA-z]*"))  //13자리 숫자가 모두 숫자라면 
				buttonOk.setColleagueEnabled(false);
			else
				buttonOk.setColleagueEnabled(true);
		}
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);
	}

}
