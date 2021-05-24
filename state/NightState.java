
public class NightState implements State{
	private static NightState singleton = new NightState();
	private NightState() {}
	public static State getInstance() {  //유일한 instance
		return singleton;
	}
	public void doClock(Context context, int hour) {
		if((hour >= 9 && hour < 12) || (hour >= 13 && hour < 17))  //day
			context.changeState(DayState.getInstance());   //singleton 
		/*
		else if(hour >= 12 && hour < 13) {
			context.changeState(LunchState.getInstance());
		}
		*/
		else if(hour >= 23) {  //LNS(late night snack)
			context.changeState(LnsState.getInstance());
		}
	}
	public void doUse(Context context) {
		context.callSecurityCenter("비상 : 야간 금고 사용!");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(야간)");
	}
	public void doPhone(Context context) {
		context.recordLog("야간 통화 녹음");
	}
	public String toString() {
		return "[야간]";
	}
}

