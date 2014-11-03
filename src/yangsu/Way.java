package yangsu;

public class Way {
	
	public int deph, depm, desh, desm;
	public int sh,sm;
	public Station start, end;
	
	public Way(Station start, Station end,TrainNumber_and_Time st, TrainNumber_and_Time et, int sh, int sm ){
		
		this.start = start;
		this.end = end;
		deph = st.deph;
		depm = st.depm;
		desh = et.desh;
		desm = et.desm;
		this.sh = sh;
		this.sm = sm;
	}
	

}
