package CMTD;

import Afficher.Afficher;

public class Matrix {

	private double[][] tab;
	private int k;
	
	private double p;
	private double q;
	
	public Matrix(int k){
		this.k = k;
		tab = new double[k+1][k+1];
		init();
	}
	
	public int getK(){
		return k;
	}
	
	public double getP(){
		return p;
	}
	
	public double getQ(){
		return q;
	}
	
	private void init(){
		for(int i=0; i<=k; i++){
			for(int j=0; j<=k; j++){
				tab[i][j] = 0.0;
			}
		}
	}
	
	public void set(int i, int j, double d){
		tab[i][j] = d;
	}
	
	public void setP(double p){
		this.p = p;
	}
	public void setQ(double q){
		this.q = q;
	}
	
	public double get(int i, int j){
		if(i<0 || j<0){
			return 0.0;
		}
		return tab[i][j];
	}
	
	public String toString(){
		String s = "";
		for(int i=0; i<=k; i++){
			s += "[  ";
			for(int j=0; j<=k; j++){
				s += Afficher.Double(tab[i][j]) + "  ";
			}
			s += "]\n";
		}
		return s;
	}
	
	public String toInfo(){
		return "	(k,p,q) : ("+k+","+p+","+q+")\n\n";
	}
	
	
}
