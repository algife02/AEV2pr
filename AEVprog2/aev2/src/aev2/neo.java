package aev2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Iterator;

public class neo {
	
	public double funcion(double posicionNEO, double velocidadNEO, String nombre) {
		
		String nom = nombre;
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		
		return resultado;
	}
	
	
	public static void main(String[] args) {
		//aqui pasamos los parametros de velocidad, posicion y nombre.
		neo prueb = new neo();
		Double vel = Double.parseDouble(args[0]);
		Double pos = Double.parseDouble(args[1]);
		String nom = args[2];
		
		double resultado = 0;
		resultado = prueb.funcion(vel, pos, nom);

		try {
			//este escribe y almacena el txt que necesitamos.
			File f1 = new File(nom + ".txt");
			FileWriter fr = new FileWriter(f1);
			BufferedWriter br = new BufferedWriter(fr);
			String linea = 	nom + vel + pos;
			
			for (int i = 0; i < 1; i++) {
				br.write(linea); 
			}
			
			br.close();
			fr.close();
			} 
			catch (Exception e) {
				//En caso de error este lo atrapa y saca el mensaje.
				System.out.println("Error: Fichero no encontrado");
	            System.out.println(e.getMessage());
			}
		double oper = prueb.funcion(pos, vel, nom);
		
		//aqui hacemos un if para ver si tiene mas de 10% y segun sea mayor al 10% o menos sacar el mensaje correspondiente.
		if (oper < 10) {
			System.err.println("todo esta en orden " + String.format("%.2f", oper));
		}else {
			System.err.println("Hay peligro, alerta!! " +  String.format("%.2f", oper));
		}
        
	} 
}
