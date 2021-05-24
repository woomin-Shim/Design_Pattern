
public class LunchState implements State{
	private static LunchState singleton = new LunchState();
	private LunchState() {}
	public static State getInstance() {
		return singleton;
	}
	public void doClock(Context context, int hour) {	
		if((hour >= 9 && hour < 12) || (hour >= 13 && hour < 17)) { //day
			context.changeState(DayState.getInstance());
		}
		/*
		else if(23 <= hour) {  //LNS
			context.changeState(LnsState.getInstance());
		}
		if((17 <= hour && hour < 23 || hour >= 0 && hour < 9)) {  //night
			context.changeState(NightState.getInstance());
		}
		*/
	}
	
	public void doUse(Context context) {
		context.callSecurityCenter("비상: 점심 시간 금고 사용!");
	}
	
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(점심)");
	}
	
	public void doPhone(Context context) {
		context.recordLog("점심 시간 통화 녹음");
	}
	
	public String toString() {
		return "[점심]";
	}
}
