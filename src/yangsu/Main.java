package yangsu;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

			Line[] line = new Line[9];// line array
			Find find = new Find();
			
		
				line[1] = new Line(2);
				line[3] = new Line(4);
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("start h:");
			int time_h = input.nextInt();
			//���ڿ� �Է� ����ó�� ���� 
			System.out.println("start m:");
			int time_m = input.nextInt();
			
			System.out.println("start : ");
			String departure = input.next();
			
			
			
			Station start = find.FindStation_All_line(departure, line);
			
			if(start == null){
				System.out.println("error");
				return ;
			}
			
			System.out.println("end : ");
			String destination = input.next();
			
			Station end = find.FindStation_All_line(destination, line);

			if(end == null){
				System.out.println("error");
				return ;
			}
			
			
			Transfer trans = new Transfer();
			Way way = null;
			
			way = trans.transfer(start, end, time_h, time_m);
			
			if(way == null){
				System.out.println("error");
				return ;
			}
			

			System.out.println("departure:"+way.deph+":"+way.depm);
			System.out.println("destination:"+way.desh+":"+way.desm);
			System.out.println("spent:"+way.sh+":"+way.sm);
			
	}
	
	public static String printing(){
		
		return "helloworld^_^";
		
	}
	
	

}



