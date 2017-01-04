import java.util.Scanner;
public class Maze {
	private Cell[][] cells;
	private int xSize;
	private int ySize;
	private Player[] players;
	private boolean solved;
	public int winnerID;
	public Maze(){
		solved=false;
	}
	public void read(){
		Scanner scan=new Scanner(System.in);
		xSize=scan.nextInt();
		ySize=scan.nextInt();
		cells=new Cell[xSize][ySize];
		String current;
		
		for(int i=0;i<xSize;i++){
			for(int j=0;j<ySize;j++){
				current=scan.next();
				if(current.equals("D")){
					cells[i][j]=new Cell(0,scan.nextInt(),scan.nextInt());
				}
				else if(current.equals("T")){
					cells[i][j]=new Cell(1,0,0);
				}
				else{
					cells[i][j]=new Cell(2,0,0);
				}
			}
		}
		players=new Player[scan.nextInt()];
		for(int i=0;i<players.length;i++){
			players[i]=new Player(scan.nextInt(),scan.nextInt(),scan.nextInt());
		}	
	}
	public void run(){
		while(!solved){
			for(int i=0;i<players.length;i++){
				if(!players[i].dead){
					if(cells[players[i].x][players[i].y].type==0){
						players[i].x+=cells[players[i].x][players[i].y].dispX;
						players[i].y+=cells[players[i].x][players[i].y].dispY;
						if(players[i].x>xSize){
							players[i].x-=xSize;
						}
						else if(players[i].x<0){
							players[i].x+=xSize;
						}
						if(players[i].y>ySize){
							players[i].y-=ySize;
						}
						else if(players[i].y<0){
							players[i].y+=ySize;
						}
					}
					else if(cells[players[i].x][players[i].y].type==1){
						players[i].dead=true;
					}
					else{
						winnerID=players[i].id;
						solved=true;
					}
					
				}
			}
		}
	}
}
