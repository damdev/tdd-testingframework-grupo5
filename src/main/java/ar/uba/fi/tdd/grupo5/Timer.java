package ar.uba.fi.tdd.grupo5;

public class Timer {
	
	private long startTime;
	
	public Timer(){
		startTime = 0;
	}
	
	public void setStart(){
		startTime = getSystemTime();
	}
		
	public long getRegisteredTime(){
		return getSystemTime() - startTime;
	}
	
	private long getSystemTime(){
		return System.currentTimeMillis();
	}
}
