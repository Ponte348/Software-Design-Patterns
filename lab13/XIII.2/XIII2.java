import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

// Não alterar esta classe
// Mas pode (Deve!) comentar linhas com erros para poder testar o código que for desenvolvendo

public class XIII2 {
	private static Port av = new SeaPort();

	public static void main(String[] args) throws FileNotFoundException {
		String suser = System.getProperty("user.dir");
		String[] logFiles = new File(suser).list((d, s) -> {return s.equals("src");}); 
		String sp=""; if(logFiles.length>0) sp = logFiles[0]+"/";
		PrintStream fl = new PrintStream(new File(sp+"PDS2122.txt"));
		fl.println(suser + "\n" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		exam(System.out); // executa e escreve na consola
		exam(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void exam(PrintStream out) {
		question1(out);
		question2(out);
		question3(out);
	}

	// alínea a)
	private static void question1(PrintStream out) {
		out.println("\nAlínea a) ----------------------------------\n");

		av.add("C02", new CargoShip("S101", "Quebra Molas", 155.5));
		av.add("C11", new CargoShip("S732", "SoPingas", 20.2));
		av.add("C03", new CargoShip("S923", "Madalena", 18.8));
		av.add("P54", new PassengerShip("S199", "Bananeiros", 120));
		av.add("P35", new PassengerShip("S185", "PDS All aboard", 80));
		av.add("P06", new PassengerShip("S078", "Costeiro", 25));

		Iterator<String> it = av.iterator();
		while (it.hasNext()) {
			out.println(it.next());
		}
	}

	// alínea b)
	private static void question2(PrintStream out) {
		out.println("\nAlínea b) ----------------------------------\n");
		// Completar

	}

	// alínea c)
	private static void question3(PrintStream out) {
		// Completar

	}

}
