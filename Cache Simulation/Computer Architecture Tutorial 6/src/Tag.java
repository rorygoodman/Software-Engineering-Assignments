
public class Tag {
	public String tag;
	public int set;
	private int offset;
	
	Tag(String address,int k,int l,int n){
		String offsetStr=address.substring(3);
		this.offset=Integer.parseInt(offsetStr,16);
		String setStr=address.substring(2,3);
		this.set=Integer.parseInt(setStr,16);
		set=set%n;
		this.tag=address.substring(0,3);			
	}
}
