import java.util.Scanner;
public class Soko {
	int R, C, destR, destC;
	int startX,startY;
    int [][] arr;
    boolean success;
    public int moves;
    int[] x_offset={-1,0,1,0};
    int[] y_offset={0,-1,0,1};
    public Soko(){
    	read();
    	success=false;
    	moves=0;
    	run(startX,startY,-1); 
    	System.out.print(moves);
    }
    void read(){
        Scanner sin = new Scanner(System.in);
        R = sin.nextInt();
        C = sin.nextInt();
        arr = new int[R + 2][C + 2];
        for (int i = 0; i < R + 2; i++) {
            for (int j = 0; j < C + 2; j++) {
                arr[i][j] = -1; //-1 is walls
            }
        }
        sin.nextLine();
        for (int i = 1; i <= R; i++) {
            String tmp = sin.nextLine();
            for (int j = 1; j <= C; j++) {                
                char ch = tmp.charAt(j-1);
                switch (ch) {
                    case '#':
                        arr[i][j] = -1; //wall
                        break;
                    case 'B':
                        arr[i][j] = 1; //box
                        startY=j;
                        startX=i;
                        break;
                    case 'D':
                        destR = j; //dest y
                        destC = i; //dest x
                        arr[i][j] = 2; 
                    default:
                        arr[i][j] = 0; //empty 0
                }
            }
        }
    }
    public void run(int x,int y,int currentDir){
    	int dir=0;
    	if(success){
    		return;
    	}
    	else{
    		while(dir<4&&!success){
    			if(!deadEnd(x,y,dir)&&currentDir!=opposite(dir)){
    				move(x,y,dir);
    				run(x+x_offset[dir],y+y_offset[dir],dir);
    				if(!success){
    					undo(x,y,dir);
    				}
    			}
    			dir++;
    			
    		}
    	}
    }
    public boolean deadEnd(int x, int y,int dir){//checks next move can be made
    	if(arr[x+x_offset[dir]][y+y_offset[dir]]!=-1){
    		if(arr[x-x_offset[dir]][y-y_offset[dir]]!=-1){
    			return false;
    		}
    	}
    	return true;
    }
    public void move(int x,int y,int dir){
    	if(destC==x+x_offset[dir]&&destR==y+y_offset[dir]){
    		success=true;
    	}
    	arr[x][y]=0;
    	arr[x+x_offset[dir]][y+y_offset[dir]]=1;
    	moves++;
    }
    public void undo(int x,int y,int dir){
    	arr[x][y]=1;
    	arr[x+x_offset[dir]][y+y_offset[dir]]=0;
    	moves--;
    }
    public int opposite(int dir){
    	if(dir==0){
    		return 2;
    	}
    	else if(dir==1){
    		return 3;
    	}
    	else if(dir==2){
    		return 0;
    	}
    	else{
    		return 1;
    		
    	}
    }
    

}
