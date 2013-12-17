package CMTD;

import Afficher.Afficher;
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
		double e = 0.00001;
		
		cmtd = new CMTD(3,1/3.0, 0.5);
		
		s+= "Matrice :\n";
		m = MatrixFactory.procNaissanceMort(k,p,q);
		s+= m.toString();
		s+= "\n";

		cmtd = new CMTD(m);
		
		
		/**/
		
		s+= Afficher.Exercice(1);
		
		
		s+= Afficher.Question(1);
		
		s+= "Génération de la courbe\n";
		GenerateCurve.methodeExacte(cmtd, 50, 1);
		
		
		s+= Afficher.Question(2);
		
		s+= "K=6 p=0.02 q=0.01\n\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.02,0.01);
		cmtd = new CMTD(m);
		
		cmtd.setStrat(new StrategyNMax(1500));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		v = cmtd.methodeExacte();
		s+= v.toString() + "\n";
		
	
		
		s+= Afficher.Question(3);
		
		s+= "K=6 p=0.5 q=0.5\n\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.5,0.5);
		cmtd = new CMTD(m);
		
		cmtd.setStrat(new StrategyNMax(1500));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		v = cmtd.methodeExacte();
		s+= v.toString() + "\n";
		
		
		
		s+= Afficher.Question(4);
		
		s+= "K=6 p=0.02 q=0.01\n\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.02,0.01);
		cmtd = new CMTD(m);
		
		v = cmtd.methodeExacte();
		s+= v.toString() + "\n";
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyRand(e,50));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyNorme(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategySomme(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";

		
		
		
		s+= Afficher.Question(5);
		
		s+= "K=6 p=0.02 q=0.01\n\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.02,0.01);
		cmtd = new CMTD(m);
		
		
		cmtd.setStrat(new StrategyAll(0.001));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(0.0001));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(0.00001));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(0.000001));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(0.0000001));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";

		
		
		
		
		s+= Afficher.Exercice(2);
		
		
		s+= Afficher.Question(2);
		
		s+= "K=6 p=0.02 q=0.01\n\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.02,0.01);
		cmtd = new CMTD(m);
		
		v = cmtd.methodeExacte();
		s+= v.toString() + "\n";
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategySomme(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategySomme(e));
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		
		s+= Afficher.Question(3);
		
		GenerateCurve.bestMethode(0.00001, 50, 1);
		
		
		s+= Afficher.Question(4);
		
		m = MatrixFactory.procNaissanceMort(6,0.02,0.01);
		s+= m.toInfo();
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.9,0.9);
		s+= m.toInfo();
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.9,0.01);
		s+= m.toInfo();
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.1,0.9);
		s+= m.toInfo();
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procNaissanceMort(6,0.002,0.001);
		s+= m.toInfo();
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		cmtd.setStrat(new StrategyAll(e));
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		s+= Afficher.Question(5);
		
		
		
	
		
		s+= Afficher.Exercice(3);
		
		
		s+= Afficher.Question(1);
		
		s+= Afficher.Question(2);

		m = MatrixFactory.procDrapeau(6, 2/5.0, 1/6.0);
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		cmtd.setStrat(new StrategyAll(e));
		
		v = cmtd.methodeExacteDrap();
		s+= v.toString() + "\n";
		
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";	
		
		
		s+= Afficher.Question(3);
		
		m = MatrixFactory.procDrapeau(6, 2/5.0, 1/6.0);
		cmtd = new CMTD(m);
		s+= m.toInfo();
		v = cmtd.methodeExacteDrap();
		s+= v.toString() + "\n";
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procDrapeau(20, 2/5.0, 1/6.0);
		cmtd = new CMTD(m);
		s+= m.toInfo();
		v = cmtd.methodeExacteDrap();
		s+= v.toString() + "\n";
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procDrapeau(6, 0.1, 0.9);
		cmtd = new CMTD(m);
		s+= m.toInfo();
		v = cmtd.methodeExacteDrap();
		s+= v.toString() + "\n";
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		m = MatrixFactory.procDrapeau(6, 0.9, 0.1);
		cmtd = new CMTD(m);
		s+= m.toInfo();
		v = cmtd.methodeExacteDrap();
		s+= v.toString() + "\n";
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		
		s+= Afficher.Question(4);
		
		m = MatrixFactory.procDraPoisson(6, 1, 1, 1/6.0);
		cmtd = new CMTD(m);
		
		e = 0.00001;
		
		s+= m.toString() + "\n";
		
		v = cmtd.methodePuissances();
		s+= v.toString() + "\n";
		
		v = cmtd.methodeGauss();
		s+= v.toString() + "\n";
		
		
		/**/

		System.out.println(s);
	}
	
	

	
	
}
