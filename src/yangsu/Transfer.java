package yangsu;

public class Transfer {

	
	public TrainNumber_and_Time FindStartTrain(Station station, int h, int m, int linenum, int flag){
		
		int i = 0, find = 0;
		
		while(station.info_by_line[i] != null){
			if(station.info_by_line[i].lineNumber == linenum){
				find = 1;
				break;
			}
			i++;
		}
		if(find == 0) return null;
		
		
		if(flag == 1){
			for(int j = 0; j<station.info_by_line[i].trains_up; j++){
				
				if(h == station.info_by_line[i].TTA_up[j].deph){//����� �Է½ð� == ��ū�ð�
					if(m <= station.info_by_line[i].TTA_up[j].depm){
						return station.info_by_line[i].TTA_up[j];
					}
				}
				else if(h <station.info_by_line[i].TTA_up[j].deph){
					return station.info_by_line[i].TTA_up[j];
				}//��ߺ� ã��
			}	
		}
		else{
			for(int j = 0; j<station.info_by_line[i].trains_down; j++){
				
				if(h == station.info_by_line[i].TTA_down[j].deph){//����� �Է½ð� == ��ū�ð�
					if(m <= station.info_by_line[i].TTA_down[j].depm){
						return station.info_by_line[i].TTA_down[j];
					}
				}
				else if(h <station.info_by_line[i].TTA_down[j].deph){
					return station.info_by_line[i].TTA_down[j];
				}//��ߺ� ã��
			}	
		}
		
		return null;
	}
	
	public  TrainNumber_and_Time FindEndTime(TrainNumber_and_Time train, Station end, int num, int flag){
	
		String trainNumber = new String(train.TrainNumber);
		int i = 0 ,find = 0;
		
		while(end.info_by_line[i] != null){
			if(end.info_by_line[i].lineNumber == num){
				find = 1;
				break;
			}
			i++;
		}
		if(find == 0) return null;
		
		
		if(flag == 1){
			for(int j = 0; j<end.info_by_line[i].trains_up; j++){
			
				if(train.deph <= end.info_by_line[i].TTA_up[j].desh){//�ð�
			
					for( i = 0; i<end.info_by_line[i].trains_up; i++){
						if(train.TrainNumber.equals(end.info_by_line[i].TTA_up[i].TrainNumber))
							return end.info_by_line[i].TTA_up[i];
					}	
				}
			}
		}
		else{
			for(int j = 0; j<end.info_by_line[i].trains_down; j++){
			
				if(train.deph <= end.info_by_line[i].TTA_down[j].desh){//�ð�
			
					for( i = 0; i<end.info_by_line[i].trains_down; i++){
						if(train.TrainNumber.equals(end.info_by_line[i].TTA_down[i].TrainNumber))
							return end.info_by_line[i].TTA_down[i];
					}	
				}
			}
		}
		return null;
	}

	public int No_transfer_oneLine(Station start, Station end, int linenum, int h, int m){
		
		TrainNumber_and_Time st = null, et = null;
		Find find = new Find();
		
		int i = 0 ,f = 0, j = 0;
		
		while(start.info_by_line[i] != null){
			if(start.info_by_line[i].lineNumber == linenum){
				f = 1;
				break;
			}
			i++;
		}
		if(f == 0) return -1;
		
		f = 0;
		while(end.info_by_line[j] != null){
			if(end.info_by_line[j].lineNumber == linenum){
				f = 1;
				break;
			}
			j++;
		}
		
		
		
		if(linenum == 2){
		
			st = FindStartTrain(start, h, m, start.info_by_line[i].lineNumber, 1);
			if(st == null) return -1;
		
			et = FindEndTime(st, end, start.info_by_line[i].lineNumber, 1);
			if(et == null) return -1;
		
			int tmp = find.FindSpentTime(start, end,start.info_by_line[i].lineNumber ,end.info_by_line[j].lineNumber, st);
		
			st = FindStartTrain(start, h, m, start.info_by_line[i].lineNumber, 0);
			if(st == null) return -1;
		
			et = FindEndTime(st, end, start.info_by_line[i].lineNumber, 0);
			if(et == null) return -1;
		
			int tmp2  = find.FindSpentTime(start, end,start.info_by_line[i].lineNumber ,end.info_by_line[j].lineNumber, st);
		
			if(tmp>tmp2) return tmp;
			else return tmp2;
		}
		
		if(start.index <end.index){//up
		
			st = FindStartTrain(start, h, m, start.info_by_line[i].lineNumber, 1);
			if(st == null) return -1;
		
			et = FindEndTime(st, end, start.info_by_line[i].lineNumber, 1);
			if(et == null) return -1;
		
			return find.FindSpentTime(start, end,start.info_by_line[i].lineNumber ,end.info_by_line[j].lineNumber, st);
	
		}
		else{//down
			
			st = FindStartTrain(start, h, m, start.info_by_line[i].lineNumber, 0);
			if(st == null) return -1;
		
			et = FindEndTime(st, end, start.info_by_line[i].lineNumber, 0);
			if(et == null) return -1;
		
			return find.FindSpentTime(start, end,start.info_by_line[i].lineNumber ,end.info_by_line[j].lineNumber, st);
		}
		
	}
	
	public Way No_transfer_AllLine(Station start, Station end, int h, int m){
		
		int maxtime = 0, tmptime = 0;
		int j  = 0, i = 0;
		TrainNumber_and_Time st = null, et = null;
	
		
		while(start.info_by_line[i] != null){
			while(end.info_by_line[j] != null){
				if(start.info_by_line[i].lineNumber == end.info_by_line[j].lineNumber){
					
					tmptime = No_transfer_oneLine(start, end, start.info_by_line[i].lineNumber,  h, m);
					
					if(tmptime > maxtime) maxtime = tmptime;	
					break;
				}
				
				j++;
			}
			i++;
		}
	
		Way way = new Way(start, end, st, et, maxtime/60, maxtime%60);
		
		if(maxtime == 0) return null;
		return way;
	}
	
	
	public Way transfer(Station start, Station end, int h, int m){
		
		Way way =  null;
		
		if((way = No_transfer_AllLine(start,  end, h, m)) != null) return way;
		else{
			/*modify  one transfer*/
			return way;
		}
	}
}
