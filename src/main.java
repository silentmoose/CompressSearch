
public class main {
	public static void main(String args[]){
		if (args.length != 2){
			System.out.println("Usage: Java main (input file) (output file)");
		}else{
			cFile compress = new cFile();
			compress.setfPath(args[0]);
			compress.setoutputPath(args[1]);
			compress.run();
		}
		
	}

}
