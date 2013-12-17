package Afficher;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Afficher {

	public static String Question(int n){
		return "\n-- Question "+n+" --\n\n";
	}
	
	public static String Exercice(int n){
		return "\n\n== Exercice "+n+" ==\n\n";
	}
	
	public static String Double(double d){
		return Double(d,4);
	}
	
	public static String Double(double d, int n){
		NumberFormat nf = new DecimalFormat("#0.0000");
		nf.setMinimumFractionDigits(n);
		return nf.format(d);
	}
}
