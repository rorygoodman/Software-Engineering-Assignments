
public class Field {
	int x,y;
	RiceBug[] bugs;
	boolean[][] plants;
	public Field(int x,int y,int numBugs){
		this.x=x;
		this.y=y;
		bugs=new RiceBug[numBugs];
		plants=new boolean[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				plants[i][j]=true;
			}
		}
	}
	public void bugBirth(int p){
		for(int i=0;i<bugs.length;i++){
			if(bugs[i].startTime==p){
				bugs[i].alive=true;
				if(plants[bugs[i].x][bugs[i].y]){
					bugs[i].strength++;
				}
				plants[bugs[i].x][bugs[i].y]=false;
				
			}
		}
	}
	public void moveBugs(){
		for(int i=0;i<bugs.length;i++){
			if(bugs[i].alive==true){
				if(bugs[i].direction.equals("A")){
					bugs[i].x--;
					bugs[i].y--;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("B")){
					bugs[i].y--;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("C")){
					bugs[i].x++;
					bugs[i].y--;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("D")){
					bugs[i].x--;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("E")){
					bugs[i].x++;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("F")){
					bugs[i].x--;
					bugs[i].y++;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("G")){
					bugs[i].y++;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
				else if(bugs[i].direction.equals("H")){
					bugs[i].x++;
					bugs[i].y++;
					electrocuteBugs(i);
					if(bugs[i].alive){
						if(plants[bugs[i].x][bugs[i].y]){
							bugs[i].strength++;
						}
						plants[bugs[i].x][bugs[i].y]=false;
					}
				}
					
				
			}
		}
	}
	public void electrocuteBugs(int i){
			if(bugs[i].x>x-1||bugs[i].x<0
					||bugs[i].y>y-1||bugs[i].y<0){
				bugs[i].alive=false;
			}
	}
	public void collisionCheck(){
		for (int i=0;i<bugs.length;i++){
			for(int j=0;j<bugs.length;j++){
				if(bugs[i].alive&&bugs[j].alive){
					if(bugs[i].x==bugs[j].x&&bugs[i].y==bugs[j].y){
						if(bugs[i].strength>bugs[j].strength){
							bugs[j].alive=false;
						}
						else if(bugs[i].strength<bugs[j].strength){
							bugs[i].alive=false;
						}
					}
				}
			}
		}
	}
}
