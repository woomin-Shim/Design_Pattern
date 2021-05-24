import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SafeFrame extends Frame implements ActionListener, Context {
	private TextField textClock = new TextField(60); //Display time
	private TextArea textScreen = new TextArea(10, 60);  //print security
	private Button buttonUse = new Button("�ݰ���");
	private Button buttonAlarm = new Button("���");
	private Button buttonPhone = new Button("�Ϲ���ȭ");
	private Button buttonExit = new Button("����");
	
	private State state = DayState.getInstance();  //initial setting = daystate 


	public SafeFrame(String title) {
		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());
		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);
		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);
	
		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);
		add(panel, BorderLayout.SOUTH);
	
		//display
		pack();
		show();
	
		//setting Listener
		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		if(e.getSource() == buttonUse) {  //'�ݰ� ���' button
			state.doUse(this);
		}
		else if(e.getSource() == buttonAlarm) { //'���' button
			state.doAlarm(this);
		}
		else if(e.getSource() == buttonPhone) {  //'�Ϲ���ȭ' button
			state.doPhone(this);
		}
		else if(e.getSource() == buttonExit) {  // '����' button
			System.exit(0);
		}
		else {
			System.out.println("?");
		}
	}
	
	public void setClock(int hour) {
		String clockstring = "���� �ð���";
		if(hour<10) {
			clockstring += "0" + hour + ":00";
		}
		else {
			clockstring += hour + ":00";
		}
		System.out.println(clockstring);
		textClock.setText(clockstring);
		state.doClock(this, hour);
	}
	
	public void changeState(State state) {
		System.out.println(this.state + "����" + state + "�� ���°� ��ȭ�߽��ϴ�.");
		this.state = state;
	}
	
	public void callSecurityCenter(String msg) {
		textScreen.append("call!" + msg + "\n");
	}
	
	public void recordLog(String msg) {
		textScreen.append("record..." + msg + "\n");
	}
}
