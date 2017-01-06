import java.util.Scanner;
public class Cache {
	private int l;
	private int n;
	private int k;
	public int hits;
	public int misses;
	private Tag[][] tags;
	private int[][] lruCheck;
	private int addressCount;
	
	
	Cache(int l,int n,int k){
		this.l=l;
		this.n=n;
		this.k=k;
		hits=0;
		misses=0;
		addressCount=0;
		tags = new Tag[n][k];
		lruCheck=new int[n][k];
	}
	public void processAddresses(){
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("⇒ ");
		while(sc.hasNext()){
			addressCount++;
			Tag currentTag=new Tag(sc.next(),k,l,n);
			if(checkCache(currentTag)){
				hits++;
				System.out.print("H");
			}
			else{
				misses++;
				System.out.print("M");
			}
		}
		System.out.println("hits: "+hits);
		System.out.println("miss: "+misses);
		
	}
	private boolean checkCache(Tag currentTag){
		int lowest=0;
		for(int i=0;i<k;i++){
			if(tags[currentTag.set][i]==null){
				tags[currentTag.set][i]=currentTag;
				lruCheck[currentTag.set][i]=addressCount;
				return false;
			}
			else if(tags[currentTag.set][i].tag.equals(currentTag.tag)){
				lruCheck[currentTag.set][i]=addressCount;
				return true;
			}
			

		}
		for(int j=0;j<k;j++){
			if(lruCheck[currentTag.set][j]<lruCheck[currentTag.set][lowest]){
				lowest=j;
			}
		}
		tags[currentTag.set][lowest]=currentTag;
		lruCheck[currentTag.set][lowest]=addressCount;
		return false;
	}
}

