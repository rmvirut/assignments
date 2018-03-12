public class Event{
	static int eventCounter = 0;
	Calendar evDate;
	int priority;
	String [] invitees;
	String eventName;
	
	public Event(){
	
	}
	
	public String getName(){
		return "";
	}
	
	public void setName(String newName){
		this.eventName = newName;
	}
	
	public String getType(){
		return "";
	}
}