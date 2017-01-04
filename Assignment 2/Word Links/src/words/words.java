package words;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class words {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String check;
		do{
			String[] input=readWords();
			check=input[0];
			boolean chain = isWordChain(input);
			if(chain==true){
				System.out.println("This is a word chain.");
			}
			else{
				System.out.println("This is not a word chain.");
			}			
		}while(check!=null);

	}
	public static String[]readWords(){
		System.out.println("Please enter the list of words seperated by minus characters.");
		Scanner input = new Scanner(System.in);
		String fullin = input.nextLine();
		input = new Scanner(fullin);
		input.useDelimiter("-");
		int wordCount=0;
		while(input.hasNext()){
			input.next();
			wordCount++;			
		}
		if (wordCount==0){
			System.exit(0);
		}
		String[]userIn=new String[wordCount];
		input= new Scanner(fullin);
		input.useDelimiter("-");
		for(int i=0;i<userIn.length;i++){
			userIn[i]=input.next();					
		}
		return userIn;
	}
	public static boolean isUnique(String[] input){
		String a;
		String b;
		int x;
		for(int i=0;i<input.length;i++){
			a=input[i];
			for(int j=0;j<input.length;j++){
				b=input[j];
				if(i!=j){
					x=a.compareTo(b);
					if(x==0){
						return false;
					}
				}
			}
			
		}
		return true;
		
		
	}
	public static boolean isWord(String input){
		File file = new File("words.txt");
		String[] words = In.readStrings("words.txt");
		int searchResult=Arrays.binarySearch(words, input);
		if(searchResult>=0){
			return true;
		}
		return false;
	}
	public static boolean byOne(String a,String b){
		if(a.length()!=b.length()){
			return false;
		}
		int difCount = 0;
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		for(int i=0;i<a.length();i++){
			if(ac[i]!=bc[i]){
				difCount++;
			}
		}
		if(difCount==1){
			return true;
		}
		return false;
		
	}
	public static boolean isWordChain(String[] input){
		boolean by1;
		boolean isWord=isWord(input[0]);
		if(isWord==false){
			System.out.println(input[0]+" is not a valid English word.");
			return false;
		}
		boolean unique = isUnique(input);
		if(unique==false){
			System.out.println("Not all words in the chain are unique.");
			return false;
		}
		for(int i=1;i<input.length;i++){
			by1=byOne(input[i-1],input[i]);
			if (by1==false){
				System.out.println(input[i-1]+" and "+input[i]+" are not different by one character.");
				return false;
			}
			isWord=isWord(input[i]);
			if(isWord==false){
				System.out.println(input[i]+" is not a valid English word.");
				return false;
			}
		}
		return true;
	}
	

}
