
public class DayState implements State{
	private static DayState singleton = new DayState();
	private DayState() {}
	public static State getInstance() {  //������ instance
		return singleton;
	}
	public void doClock(Context context, int hour) {
		if((17 <= hour && hour < 23 || hour >= 0 && hour < 9))  //Night
			context.changeState(NightState.getInstance());   //singleton 
			//new NightState() --> no singleton
		/*
		else if(23 <= hour) {  //LNS
			context.changeState(LnsState.getInstance());
		}
		*/
		else if(hour >= 12 && hour < 13) //Lunch
			context.changeState(LunchState.getInstance());
	}
	public void doUse(Context context) {
		context.recordLog("�ݰ� ���(�ְ�)");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(�ְ�)");
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("�Ϲ���ȭ (�ְ�)");
	}
	public String toString() {
		return "[�ְ�]";
	}
}
