import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int fieldX=scan.nextInt();
		int fieldY=scan.nextInt();
		int period=scan.nextInt();
		int numBugs=scan.nextInt();
		int bugx;
		int bugy;
		int start;
		String direction;
		
		Field theField=new Field(fieldX,fieldY,numBugs);
		
		for(int i=0;i<numBugs;i++){
			bugx=scan.nextInt();
			bugy=scan.nextInt();
			start=scan.nextInt();
			direction=scan.next();
			theField.bugs[i]=new RiceBug(bugx,bugy,start,direction);
		}
		scan.close();
		
		for(int i=0;i<period;i++){
			theField.moveBugs();
			theField.bugBirth(i);
			theField.collisionCheck();
		}
		int surviving=0;
		int uninfected=0;
		
		for(int i=0;i<fieldX;i++){
			for(int j=0;j<fieldY;j++){
				if(theField.plants[i][j]){
					uninfected++;
				}
			}
		}
		for(int i=0;i<numBugs;i++){
			if(theField.bugs[i].alive){
				surviving++;
			}
		}
		System.out.print(""+uninfected+" "+surviving+"");
		System.exit(0);
		
		
	

	}


}
