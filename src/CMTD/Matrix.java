package CMTD;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Matrix {

	private double[][] tab;
	private int k;
	
	public Matrix(int k){
		this.k = k;
		tab = new double[k+1][k+1];
		init();
	}
	
	public int getK(){
		return k;
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
	
	public double get(int i, int j){
		if(i<0 || j<0){
			return 0.0;
		}
		return tab[i][j];
	}
	
	public String toString(){
		NumberFormat nf = new DecimalFormat("#0.0000");
		nf.setMinimumFractionDigits(4);
		String s = "";
		for(int i=0; i<=k; i++){
			s += "[  ";
			for(int j=0; j<=k; j++){
				s += nf.format(tab[i][j]) + "  ";
			}
			s += "]\n";
		}
		return s;
	}
	
	
}
