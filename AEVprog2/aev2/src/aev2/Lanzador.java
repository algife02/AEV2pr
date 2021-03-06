package aev2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lanzador {
	
	public void lanzarSumador(String n, Double n1,Double n2){
		String clase = "aev2.neo";
		try {

		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clase;

		List<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		command.add(n1.toString());
		command.add(n2.toString());
		command.add(n);
		
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.inheritIO().start();
		// Process process = builder.start();
		process.waitFor();
		System.out.println(process.exitValue());

		} catch (Exception e) {
		e.printStackTrace();
		}
		}

	public static void main(String[] args) throws InterruptedException{
		
		long inicio = System.currentTimeMillis();

		String[] guardarLinea;
		Lanzador lanz = new Lanzador();
		
		String ruta= "NEOs.txt";
		
		try {
			File f1 = new File(ruta);
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			int cont = 0;
			
			//aqui nos va a guardar cada linea en un fichero nuevo
			for (int i = 0; i < 12; i++) {
				linea.split(",");
				guardarLinea= linea.split(",");
				System.out.println(linea + "\n");
				lanz.lanzarSumador(guardarLinea[0] , Double.parseDouble(guardarLinea[1]), Double.parseDouble(guardarLinea[2]));
				linea=br.readLine();
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		//este saca el tiempo medio que tarda en hacer la ejecucion del programa.
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
        //aqui nos dice la media de cada ejecucion.
       tiempo =  tiempo/12;
       System.out.println(String.format("%.2f", tiempo) + " es la media de tiempo");
       
       //Sirve para sacar los cores que tiene el PC
       Runtime.getRuntime().availableProcessors();
       System.out.println(Runtime.getRuntime().availableProcessors() + " nucleos");
	}
	

}
