package CMTD;

import java.util.Random;

public class CMTD {
	
	private int k;
	private double p;
	private double q;
	
	private Matrix m;
	
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
		this.k = m.getK();
	}
	
	
	public Vector probaStationnaires()
	{
		Vector v = new Vector();
        v.init(3);
    		
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
	

	public Vector resolutionExacte()
	{
		Vector v = new Vector(k);
		Random r = new Random();
		Double pi0 = new Double( r.nextDouble() );
		pi0 = new Double(1.0);
		
		//pi(0) :
		v.set(0,pi0);
		
		//pi(1) :
		if(k>1){
			v.set(1, v.get(0) * (p/(q*(1-p)) )); 
			v.normaliser();
		}
		
		//pi(2 à k-1) ;
		for(int i=1; i<k-2; i++)
		{
			v.set( i+1, v.get(i) * (1-q)*p / (1-p)*q );
			v.normaliser();
		}
		
		v.set(k-1, v.get(k-2) * (1-q)*p / q );
		
		//pi(k) ;
		v.set(k, v.get(k-1) * (1-q)*p/(-q) );
		v.normaliser();
		//v.normaliser();
		
		
		return v;
	}
	
	
	public Vector methodePuissances(int n)
	{
		Vector v = new Vector();
		v.init(k, 1/(double)(k+1));
		
		v = methodePuissancesRec(v,n);
		
		v.normaliser();
		
		return v;
	}

	private Vector methodePuissancesRec(Vector v, int n)
	{
		if (v.isConv(0.00005) || (n <= 0))
		{ 
			return v;
		}
		else
		{
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
		}
		
		return methodePuissancesRec(v,n-1);
	}
	
	
	public Vector methodeGauss(int n)
	{
		Vector v = new Vector();
		v.init(k, 1/(double)(k+1));
		
		v = methodeGaussRec(v,n);
		
		return v;
	}
	
	private Vector methodeGaussRec(Vector v, int n)
	{
		if (v.isConv(0.00005) || (n <= 0))
		{ 
			return v;
		}
		else
		{
			double sommeij;
			double sommeji;
			
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
		
		return methodeGaussRec(v, n-1);
	}


}
