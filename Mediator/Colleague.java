//중개인에게 상담을 의뢰하는 회원을 나타냄
public interface Colleague {
	public abstract void setMediator(Mediator mediator);
	public abstract void setColleagueEnabled(boolean enabled);
}
