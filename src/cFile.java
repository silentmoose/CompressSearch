
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cFile implements Runnable{
	private static List<String> wordsListCompressed = new ArrayList<String>();
	@SuppressWarnings("unused")
	private static String fPath = null;
	@SuppressWarnings("unused")
	private static String fContents = null;
	private static String[] words = null;
	public static void Readfile() throws IOException{
		BufferedReader fReader = new BufferedReader(new FileReader(fPath));
		while(fReader.readLine()!= null){
			fContents+= fReader.readLine();
		}
	}
	public static void sortStrings(){
		words = fContents.split(" ");
		int counter = 0;
		for (int i = 0; i < words.length; i++)
		{
			counter = 0;
			for(int a = 0; a < words.length; a++)
			{
				if (wordsListCompressed.contains(words[i])){
					
				}else if (words[i] == words[a]){
					counter++;
				}
			}
			wordsListCompressed.add(words[i] + ":" + counter);
		}
		
	}
	
	private Runnable doE(){
		
		return null;
		
	}

	public void setfPath(String fPath) {
		this.fPath = fPath;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread t = new Thread(this.doE());
		t.start();
		
	}
	

}
