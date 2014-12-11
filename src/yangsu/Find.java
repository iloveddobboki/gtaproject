package yangsu;

public class Find {

	public Station FindStation_All_line(String name, Line[] line){
	
		for(int i = 0; i<9; i++){
			for(int j = 0; j<line[i].num; j++){
				if(line[i].station[j].StationName.equals(name)) return line[i].station[j];
			}
		}
		return null;
	}
	
/*	public Station FindStation_by_priority(String name, Station station, Line[] line){
		
		for(int j = 0; j<station.lines; j++){
			for(int i = 0; i<line[station.lineNum[j].lineNumber].num; i++){
					if(line[station.lineNum[j].lineNumber].station[i].StationName.equals(name)) 
						return line[station.lineNum[j].lineNumber].station[i];
			}
		}
		
		return  FindStation_All_line(name, line);
	}
	*/
	public int FindSpentTime(TrainNumber_and_Time start, TrainNumber_and_Time end){

		int th, th2, tm, tm2;

			th = start.deph;
			th2 = end.desh;
			tm = start.depm;
			tm2 = end.desm;

		
		if(th > th2 ){
			
			th = th-12;
			th2 = th2+12;
			
		}
		
		if(tm2 < tm){
			
			th2 = th2-1;
			tm2 = tm2+60;
		}
		
		th = th2-th;
		tm = tm2-tm;
		
		return th*60+tm;
	}
	
	
	public void nothing(){
	
	}

}
