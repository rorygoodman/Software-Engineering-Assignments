
public class main {

	public static void main(String[] args) {
		Maze maze=new Maze();
		maze.read();
		maze.run();
		System.out.print(maze.winnerID+"\n");
	}

}
