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
	private Button buttonUse = new Button("금고사용");
	private Button buttonAlarm = new Button("비상벨");
	private Button buttonPhone = new Button("일반통화");
	private Button buttonExit = new Button("종료");
	
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
		if(e.getSource() == buttonUse) {  //'금고 사용' button
			state.doUse(this);
		}
		else if(e.getSource() == buttonAlarm) { //'비상벨' button
			state.doAlarm(this);
		}
		else if(e.getSource() == buttonPhone) {  //'일반통화' button
			state.doPhone(this);
		}
		else if(e.getSource() == buttonExit) {  // '종료' button
			System.exit(0);
		}
		else {
			System.out.println("?");
		}
	}
	
	public void setClock(int hour) {
		String clockstring = "현재 시간은";
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
		System.out.println(this.state + "에서" + state + "로 상태가 변화했습니다.");
		this.state = state;
	}
	
	public void callSecurityCenter(String msg) {
		textScreen.append("call!" + msg + "\n");
	}
	
	public void recordLog(String msg) {
		textScreen.append("record..." + msg + "\n");
	}
}
