
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cFile implements Runnable{
	private static String outputPath = "";
	private static List<String> wordsListCompressed = new ArrayList<String>();
	private static String fPath = null;
	private static String fContents = null;
	private static int[] wordCounter = null;
	private static String[] words = null;
	public static void Readfile() throws IOException{
		BufferedReader fReader = new BufferedReader(new FileReader(fPath));
		while(fReader.readLine()!= null){
			fContents+= fReader.readLine();
		}
		fReader.close();
	}
	public static void sortStrings(){
		fContents = fContents.replace(",", "");
		fContents = fContents.replace(".", "");
		words = fContents.split(" ");
		wordCounter = new int[words.length];
		
		
		for (int i = 0; i < words.length; i++)
		{
			//System.out.println("" + words[i]);
			if (wordsListCompressed.contains(words[i].toLowerCase()) == false){
				wordsListCompressed.add(words[i].toLowerCase());
			}
			for(int a = 0; a < words.length; a++)
			{
				if(words[i] == words[a])
				{
					wordCounter[i]++;
					System.out.println("here");
				}
			}
			
		}
		
	}
	public static void writeResults() throws IOException{
		BufferedWriter bW = new BufferedWriter(new FileWriter(outputPath));
		for ( int i = 0; i < wordsListCompressed.size(); i++)
		{
			
			bW.write(wordsListCompressed.get(i) + " " + wordCounter[i]);
			
		
		}
		bW.close();
	}
	
	private Runnable doE() throws IOException{
		Readfile();
		System.out.println("File Read");
		sortStrings();
		System.out.println("Strings Sorted");
		writeResults();
		System.out.println("Results Written");
		return null;
		
	}

	public void setfPath(String fPath) {
		this.fPath = fPath;
	}
	public void setoutputPath(String path) {
		this.outputPath = path;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting Thread...");
		Thread t = null;
		try {
			t = new Thread(this.doE());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.start();
		
	}
	

}
