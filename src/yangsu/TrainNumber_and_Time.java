package yangsu;


public class TrainNumber_and_Time{
	
	public String TrainNumber;
	public int deph, depm;
	public int desh, desm;

	
	public TrainNumber_and_Time(){
	}
	
	public TrainNumber_and_Time(String a, int sh, int  sm, int eh, int em){
		
		TrainNumber = new String(a);
		deph = sh;
		depm = sm;
		desh = eh;
		desm = em;
	}
	
}
