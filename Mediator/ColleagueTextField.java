import java.awt.TextField;
import java.awt.Color;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements TextListener, Colleague{ 
	private Mediator mediator;
	public ColleagueTextField(String text, int columns) {
		super(text, columns);
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled? Color.white : Color.lightGray); //유효/무효에 따라 배경색 지정
	}
	public void textValueChanged(TextEvent e) { //문자열이 변하면 mediator에게 알림
		mediator.colleagueChanged();
	}
}
