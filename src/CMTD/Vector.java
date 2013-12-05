package CMTD;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Vector {

	ArrayList<Double> pis;
	
	public Vector(){
		pis = new ArrayList<Double>();
	}
	public Vector(int k){
		pis = new ArrayList<Double>();
		init(k);
	}

	public void init(int n){
		init(n,0.0);
	}
	
	public void init(int n, double v){
		for(int i=0; i<=n; i++)
			pis.add(v);
	}
	
	public void set(int i, double d){
		pis.set(i, new Double(d));
	}
	
	public double get(int i){
		return pis.get(i).doubleValue();
	}
	
	public void normaliser(){
		double somme = this.somme();
		for(int i=0; i<pis.size(); i++){
			pis.set(i, pis.get(i)/somme);
		}
	}
	
	public double somme(){
		double somme = 0.0;
		for(double d : pis){
			somme += d;
		}
		return somme;
	}
	
	public double nbMoyen(){
		double nb = 0.0;
		for(int i=1; i<pis.size(); i++){
			nb += i*pis.get(i);
		}
		return nb/pis.size();
	}
	
	public boolean isConv(double conv)
	{
		for(double d : pis){
			if (d < conv)
				return true;
		}
		return false;
	}
	
	public String toString(){
		NumberFormat nf = new DecimalFormat("#0.0000");
		nf.setMinimumFractionDigits(4);
		String s = "Somme : " + this.somme();
		s += "\n";
		s += "[  ";
		for(double d : pis){
			s+= nf.format(d) + "  ";
		}
		s+= "]";
		s += "\n";
		return s;
	}
	
	
}
