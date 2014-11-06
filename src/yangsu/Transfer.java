
public class Transfer {

	
	public Station_information FindStartinfo(Station start, Station end){
		
		int linenum = 0;
		
		for(int i = 0; i<start.numberoflines; i++){
			for(int j = 0; j<end.numberoflines; j++){
				if(start.trans[i] == end.trans[j]){
					linenum = start.trans[i];
					break;
					
				}
					
			}
		}
		
		if(linenum != 0){
			//no-transfer
			for(int i = 0; i<start.numberoflines; i++){
				if(linenum == start.line[i].lineNumber){
					return start.line[i];
					
				}
			}//find start info
		}
		else{
			//transfer
		}
		return null;
		
	}
	
	public TrainNumber_and_Time FindinfoTrain(Station_information info,  int h, int m, int flag){
	
		
		int num = 0;
		TrainNumber_and_Time[] TTA = null;
		
		if(flag == 0){ 
			num = info.trains_down;
			TTA = info.TTA_down;
		}
		else if(flag == 1){
			num = info.trains_up;
			TTA = info.TTA_up;
		}
		else if(flag == 2){ 
			num = info.trains_down_red;
			TTA = info.TTA_down_red;
		}
		else if(flag == 3){
			num = info.trains_up_red;
			TTA = info.TTA_up_red;
		}
		else if(flag == 4){ 
			num = info.trains_down_w;
			TTA = info.TTA_down_w;
		}
		else if(flag == 5){
			num = info.trains_up_w;
			TTA = info.TTA_up_w;
		}
		else return null;
		
		
		for(int j = 0; j<num; j++){
					
			if(h == TTA[j].deph){
				if(m <= TTA[j].depm){
					return TTA[j];	
				}
			}
			else if(h <TTA[j].deph){
				return TTA[j];
			}
		}
		return null;	
			
	}	
	
	public Output findpath(Station start, Station end, int h, int m){
		
		Station_information  startinfo, endinfo;
		Output output =  new Output();
		startinfo = FindStartinfo(start, end);
		endinfo = FindStartinfo(end, start);
		int flag, tmp;
		
		output.start = startinfo;
		output.end = endinfo;
		
		/*if(monday~friday){
		 * 	if(up )	flag = 1; 
		 *  else if(down|| startinfo.linenum ==2)	flag  = 0;
		 * 	
		 * }
		 * else if(red){
		 * 	if(up)	flag = 3; 
		 *  else if(down ||startinfo.linenum ==2)	flag  = 2;
		 * 
		 * }
		 * else if(w){
		 *  if(up)	flag = 5; 
		 *  else if(down||startinfo.linenum ==2)	flag  = 4;
		 * 	
		 *
		 * }
		 * 
		 
		 */
		if(startinfo.lineNumber == endinfo.lineNumber){//no-transfer
			
			if(start.index < end.index )  tmp = No_transfer(startinfo, endinfo,  h,  m, 1, output);
			else if(start.index > end.index) tmp = No_transfer(startinfo, endinfo,  h,  m, 0, output);
			else if(startinfo.lineNumber == 2){
				tmp = No_transfer(startinfo, endinfo,  h,  m, 1, output);
				int tmp2 = No_transfer(startinfo, endinfo,  h,  m, 0, output);
				// tmp = No_transfer(startinfo, endinfo,  h,  m, flag, output);
				//int tmp2 = No_transfer(startinfo, endinfo,  h,  m, flag+1, output);
				if(tmp > tmp2) tmp = tmp2;
			}
			else return null;
			if(tmp == 1) return null;
			
			output.spentTime = new String(tmp/60+":"+tmp%60);
			return output;
		}
		else{
			//transfer
		}
		
		return null;
	}
	
	public TrainNumber_and_Time FindendTime(TrainNumber_and_Time start,Station_information end, int flag){
	
		int num = 0;
		TrainNumber_and_Time[] TTA = null;
		
		if(flag == 0){ 
			num = end.trains_down;
			TTA = end.TTA_down;
		}
		else if(flag == 1){
			num = end.trains_up;
			TTA = end.TTA_up;
		}
		else if(flag == 2){ 
			num = end.trains_down_red;
			TTA = end.TTA_down_red;
		}
		else if(flag == 3){
			num = end.trains_up_red;
			TTA = end.TTA_up_red;
		}
		else if(flag == 4){ 
			num = end.trains_down_w;
			TTA = end.TTA_down_w;
		}
		else if(flag == 5){
			num = end.trains_up_w;
			TTA = end.TTA_up_w;
		}
		else return null;
			
		for(int i = 0; i<num; i++){
			if(start.deph <= TTA[i].deph){
				if(start.TrainNumber.equals(TTA[i].TrainNumber))
					return TTA[i];
			}
		}
		
		return null;
		
	}
	

	public int No_transfer(Station_information startinfo, Station_information endinfo,  int h, int m, int flag, Output output){
	
		TrainNumber_and_Time start = FindinfoTrain(startinfo,  h, m, flag);		
		TrainNumber_and_Time end;
		Find find = new Find();
		int tmp;
		
		
		end = FindendTime(start, endinfo, flag);
		if(end == null) return -1;
		
		tmp = find.FindSpentTime(start, end);
		output.startTime = new String(start.desh + ":"+ start.desm);
		output.endTime = new String(end.deph+":"+ end.depm);
		
		
		return tmp;
	}
		
}	