package CMTD;

public class MatrixFactory {

	/* k>=2 */
	public static Matrix procNaissanceMort(int k, double p, double q)
	{
		Matrix m = new Matrix(k);
		
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
}
