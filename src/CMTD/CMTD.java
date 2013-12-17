package CMTD;

import java.util.Random;

public class CMTD {
	
	private int k;
	private double p;
	private double q;
	
	private Matrix m;
	
	private IStrategy strat = new StrategyRand();
	
	public CMTD(int k, double p, double q){
		this.k = k;
		this.p = p;
		this.q = q;
	}
	
	public CMTD(int k){
		this.k = k;
		Random r = new Random();
		this.p = r.nextDouble();
		this.q = r.nextDouble();
	}
	
	public CMTD(Matrix m){
		this.m = m;
		this.q = m.getQ();
		this.p = m.getP();
		this.k = m.getK();
	}
	
	public void setK(int k){
		this.k = k;
	}
	
	public void setStrat(IStrategy strat){
		this.strat = strat;
	}
	
	
	public Vector probaStationnaires()
	{
		Vector v = new Vector(3);
    		
		v.set(3, ( 1 / (
			1 + ( q/(p*(1-q)) *
					( 1 + ( (1-p)*q / ((1-q)*p) ) *
							(1 + q*(1-p) / p)
					))))
		); 
		
		v.set(2, q/(p*(1-q)) * v.get(3));
		
		v.set(1, (1-p)*q/(p*(1-q)) * v.get(2));
		
		v.set(0, (1-p)*q/p * v.get(1));
		
		return v;
	}
	

	public Vector methodeExacte()
	{
		Vector v = new Vector(k);
		Random r = new Random();
		Double pi0 = new Double( r.nextDouble() );
		//pi0 = new Double(1.0);
		
		//pi(0) :
		v.set(0,pi0);
		
		//pi(1) :
		v.set(1, v.get(0) * (p/(q*(1-p)) )); 
		//v.normaliser();
		
		
		//pi(2 à k-1) ;
		for(int i=1; i<k-1; i++)
		{
			v.set( i+1, v.get(i) * (1-q)*p / ((1-p)*q) );
			//v.normaliser();
		}
		
		
		//pi(k) ;
		v.set(k, v.get(k-1) * (1-q)*p/q );
		v.normaliser();
		//v.normaliser();
		
		
		return v;
	}
	
	public Vector methodeExacteDrap()
	{
		Vector v = new Vector(k);
		Random r = new Random();
		Double pi0 = new Double( r.nextDouble() );
		//pi0 = new Double(1.0);
		
		//pi(0) :
		v.set(0,pi0);
		
		//pi(1 à k) ;
		for(int i=1; i<=k; i++)
		{
			v.set( i, v.get(i-1) * p*(1-q) / (1-(1-p)*(1-q)) );
		}
		
		v.normaliser();
		
		
		return v;
	}
	
	
	public Vector methodePuissances()
	{
		Vector v = new Vector();
		v.init(k, 1/(double)(k+1));

		Vector vOld = new Vector(k);
		
		v = methodePuissancesRec(v,vOld,0);
		
		v.normaliser();
		
		return v;
	}

	private Vector methodePuissancesRec(Vector v, Vector vOld, int n)
	{
		if(strat instanceof StrategyNMax){
			((StrategyNMax) strat).setN(n);
		}
		if (strat.isConv(v,vOld))
		{ 
			v.setN(n);
			return v;
		}
		else
		{
			vOld = v.clone();
			
			double somme;

			for(int j=0; j<=k; j++)
			{
				somme = 0.0;
				for(int i=0; i<=k; i++)
				{
					if(v.isGetValid(i, k)){
						somme += v.get(i) * m.get(i,j);
					}
				}
				v.set(j,somme);
			}
			
			v.normaliser();
		}

		return methodePuissancesRec(v,vOld,n+1);
	}
	
	public Vector methodeGauss()
	{
		Vector v = new Vector();
		v.init(k, 1/(double)(k+1));
		Vector vOld = new Vector(k);
		
		v = methodeGaussRec(v,vOld,0);
		
		return v;
	}
	
	private Vector methodeGaussRec(Vector v, Vector vOld, int n)
	{
		if(strat instanceof StrategyNMax){
			((StrategyNMax) strat).setN(n);
		}
		if (strat.isConv(v,vOld))
		{ 
			v.setN(n);
			return v;
		}
		else
		{
			double sommeij;
			double sommeji;
			
			vOld = v.clone();
			
			for(int j=0; j<=k; j++)
			{	
				sommeij = 0.0;
				for(int i=0; i<j; i++) {
					sommeij += v.get(i) * m.get(i,j);
				}

				sommeji = 0.0;
				for(int i=j+1; i<=k; i++) {
					sommeji += v.get(i) * m.get(i,j);
				}
				
				v.set(j, 1/(1-m.get(j,j)) * (sommeij + sommeji));
			}
			
			v.normaliser();
		}
		
		return methodeGaussRec(v,vOld,n+1);
	}

	public String toString(){
		String s = "CMTD :\n";
		s+= "(k,p,q) : " + k + ", " + p + ", " + q + "\n";
		return s;
	}
	
}
