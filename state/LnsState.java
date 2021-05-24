//Late Night Snack 
public class LnsState implements State{
	private static LnsState singleton = new LnsState();
	private LnsState() {}
	public static State getInstance() {
		return singleton;
	}
	
	public void doClock(Context context, int hour) {
		if(17 <= hour && hour < 23 || hour >= 0 && hour < 9) {  //Night 17~22:59  24:00 ~ 09:00
			context.changeState(NightState.getInstance());
		}
		/*
		else if((hour >= 9 && hour < 12) || (hour >= 13 && hour < 17)) {  //Day 
			context.changeState(DayState.getInstance());
		}
		else if(hour >= 12 && hour < 13) { //Lunch
			context.changeState(LunchState.getInstance());
		}
		*/
		
	}
	
	public void doUse(Context context) {
		context.callSecurityCenter("���: �߽Ľð� �ݰ� ���!");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("���(�߽� �ð�)");
	}
	public void doPhone(Context context) {
		context.recordLog("�߽Ľð� ��ȭ ����");
	}
	public String toString() {
		return "[�߽� �ð�]";
	}
}
