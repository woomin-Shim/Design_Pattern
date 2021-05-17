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
	private ColleagueTextField textIdCard; //�ֹε�Ϲ�ȣ 
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	//Colleague���� �����ϰ�, ��ġ�� �� ǥ�ø� ����
	public LoginFrame(String title) {
		super(title);
		
		BorderLayout b = new BorderLayout();  //���������� �ƴ� �����Ӱ� ��ġ��Ű�� ���� BorderLayout 
		setSize(700,700);
		setLayout(b);
		
		Panel p1 = new Panel();  //Radio box button part pannel
		Panel p2 = new Panel();  //Text Field pare Pannel
		setBackground(Color.lightGray);
		
		add(p1, "North");  //���� ��ܿ� ��ġ
		add(p2, "Center");  //�߰��� ��ġ 
		
		
		//Colleague���� ����
		createColleagues();
		
		p1.setLayout(new GridLayout(1, 3)); //Layout �Ŵ����� ����ؼ� 1*3�� �׸��带 ����
		//��ġ
		p1.add(checkGuest);
		p1.add(checkLogin);
		p1.add(checkMember);
		
		p2.setLayout(new GridLayout(4, 2));  //Layout �Ŵ����� ����ؼ� 4*2�� �׸��带 ����
		p2.add(new Label("Username:"));
		p2.add(textUser);
		p2.add(new Label("Password:"));
		p2.add(textPass);
		p2.add(new Label("�ֹε�Ϲ�ȣ:"));
		p2.add(textIdCard);
		p2.add(buttonOk);
		p2.add(buttonCancel);
		
		//��ȿ, ��ȿ�� �ʱ� ����
		colleagueChanged();
		
		//ǥ��
		pack();
		show();   //setVisible(true)
	}
	
	//Colleague�� ����
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
		
		//Mediator�� set
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		checkMember.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		textIdCard.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		//Listener�� set
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		checkMember.addItemListener(checkMember);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		textIdCard.addTextListener(textIdCard);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}
	
	//Colleage������ ������ Colleague�� ��ȿ,��ȿ ����
	public void colleagueChanged() {
		if(checkGuest.getState()) {  //Guest�� check
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			textIdCard.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		}
		else if(checkLogin.getState()) {  //Login�� check 
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
		else if(checkMember.getState()){  //Member�� check
			textUser.setColleagueEnabled(true);  //Username Ȱ��ȭ
			textPass.setColleagueEnabled(true);  //Password Ȱ��ȭ
			textIdCard.setColleagueEnabled(true);  // �ֹε�Ϲ�ȣ �ؽ�Ʈ�ʵ� Ȱ��ȭ
			buttonOk.setColleagueEnabled(false);  //OK ��ư ��Ȱ��ȭ
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
	
	//�ֹε�Ϲ�ȣ �ʵ忡 13�ڸ��� ���ڷ� �Է������� OK��ư Ȱ��ȭ
	private void IdCardChanged() {
		if(textIdCard.getText().length() == 13) {
			if(textIdCard.getText().matches("[a-zA-z]*"))  //13�ڸ� ���ڰ� ��� ���ڶ�� 
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
