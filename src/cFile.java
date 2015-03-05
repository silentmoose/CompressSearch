
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cFile implements Runnable{
	private static String outputPath = "";
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
	public static void writeResults() throws IOException{
		BufferedWriter bW = new BufferedWriter(new FileWriter(outputPath));
		for ( int i = 0; i < wordsListCompressed.size(); i++);
		{
			int a = 0;
			bW.write(wordsListCompressed.get(a));
			a++;
		}
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
