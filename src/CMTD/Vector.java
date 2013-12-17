package CMTD;

import java.util.ArrayList;

import Afficher.Afficher;

public class Vector {

	ArrayList<Double> pis;
	int n = 0;
	
	public Vector(){
		pis = new ArrayList<Double>();
	}
	public Vector(ArrayList<Double> pis){
		this.pis = pis;
	}
	public Vector(int k){
		pis = new ArrayList<Double>();
		init(k);
	}
	
	public int size(){
		return pis.size();
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
	
	public void setN(int n){
		this.n = n;
	}
	
	public int getN(){
		return n;
	}
	
	public double get(int i){
		return pis.get(i).doubleValue();
	}
	
	public boolean isGetValid(int i, int k){
		if(i<0 || i>k)
			return false;
		return true;
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
	
	
	@SuppressWarnings("unchecked")
	public Vector clone(){
		return new Vector((ArrayList<Double>) pis.clone());
	}
	
	public String toString(){
		String s = "";
		double somme = somme();
		if(somme != 1)
			s+="Somme = " + Afficher.Double(this.somme(),0) + "\n";
		if(n != 0)
			s += "NStop = " + this.n + "\n";
		s += "[  ";
		for(double d : pis){
			s+= Afficher.Double(d) + "  ";
		}
		s+= "]";
		s += "\n";
		return s;
	}
	
	
}
