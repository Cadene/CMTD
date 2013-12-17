package CMTD;

public class MatrixFactory {

	/* k>=2 */
	public static Matrix procNaissanceMort(int k, double p, double q)
	{
		Matrix m = new Matrix(k);
		m.setP(p);
		m.setQ(q);
		
		m.set(0,0, (1-p));
		m.set(0,1, p);
		
		for(int i=1; i<k; i++)
		{
			m.set(i,i-1, q*(1-p) );
			m.set(i, i , 1-p-q + 2*p*q );
			m.set(i,i+1, p*(1-q) );
		}
		
		m.set(k,k-1, q);
		m.set(k, k , 1-q);
		
		return m;
	}
	
	/* k>=1 */
	public static Matrix procDrapeau(int k, double p, double q)
	{
		Matrix m = new Matrix(k);
		m.setP(p);
		m.setQ(q);
		
		m.set(0,0, 1-p+q*p);
		
		for(int i=1; i<=k; i++)
		{
			m.set(i,0, q );
			m.set(i-1,i, p*(1-q) );
			m.set(i,i, (1-p)*(1-q) );
		}
		
		return m;
	}
	
	public static Matrix procDraPoisson(int k, double l, double T, double q)
	{
		Matrix m = new Matrix(k);
		m.setP(1.0);
		m.setQ(q);
		
		double p = Math.exp(-l*T);
		
		m.set(0,0, 1-p+q*p);
		
		for(int i=1; i<=k; i++)
		{
			p = poisson(i,l,T);
			m.set(i,0, q );
			m.set(i-1,i, p*(1-q) );
			m.set(i,i, (1-p)*(1-q) );
		}
		
		return m;
	}
	
	private static double poisson(int k, double l, double T)
	{
		int fact = 1;
		for(int i=k; i>0; i--){
			fact *= i;
		}
		return Math.pow(l*T, k) * Math.exp(-l*T) / fact;
	}
	
}
