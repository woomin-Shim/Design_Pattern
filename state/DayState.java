
public class DayState implements State{
	private static DayState singleton = new DayState();
	private DayState() {}
	public static State getInstance() {  //유일한 instance
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
		context.recordLog("금고 사용(주간)");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(주간)");
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("일반통화 (주간)");
	}
	public String toString() {
		return "[주간]";
	}
}
