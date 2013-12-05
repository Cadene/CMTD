package CMTD;

import CMTD.CMTD;
import CMTD.Matrix;
import CMTD.MatrixFactory;
import CMTD.Vector;


public class main {

	public static void main(String[] args) {
		
		Vector v;
		Matrix m;
		CMTD cmtd;
		String s = "";

		int k = 3;
		double p = 1/3.0;
		double q = 0.5;
		
		m = MatrixFactory.procNaissanceMort(k,p,q);
		cmtd = new CMTD(6);
		
		s+= m.toString();
		
		//cmtd = new CMTD(6,0.02,0.01);
		cmtd = new CMTD(3,1/3.0, 0.5);
		
		
		s+= "ProbaStationnaires :\n";
		s+= (v= cmtd.probaStationnaires()).toString();
		s+= "nbMoyen: " + v.nbMoyen();
		s+= "\n\n";
		
		
		s+= "Resolution Exacte :\n";
		s+= cmtd.resolutionExacte().toString();
		s+= "\n";

		cmtd = new CMTD(m);
		
		s+= "Methode des Puissances\n";
		s+= cmtd.methodePuissances(100).toString();
		s+= "\n";
		
		s+= "Methode de Gauss\n";
		s+= cmtd.methodeGauss(100).toString();
		s+= "\n";
		
		
		System.out.println(s);
	}
	
	

	
	
}
