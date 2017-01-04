
public class RiceBug {
	int x,y;
	String direction;
	int strength;
	int startTime;
	boolean alive;
	public RiceBug(int x,int y,int startTime,String direction){
		strength=0;
		alive=false;
		this.x=x;
		this.y=y;
		this.startTime=startTime;
		this.direction=direction;
	}
}
