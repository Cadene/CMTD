package CMTD;

import java.io.FileWriter;
import java.io.PrintWriter;

public class GenerateCurve {

	public static void methodeExacte(CMTD cmtd, int maxK, int every)
	{
		long startTime, endTime;
		
	    try{
	    	String fileName = "./data/perf"+maxK+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			for(int k=3; k <= maxK; k=k+every)
			{
				cmtd.setK(k);
				
				startTime = System.nanoTime();
				cmtd.methodeExacte();
				endTime = System.nanoTime();
				
				out.println(k + ";" + ( endTime - startTime ) );
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	public static void bestStrategy(CMTD cmtd, double min, double max, double every)
	{
		long[] startTime = new long[3], endTime = new long[3];
		
		
	    try{
	    	String fileName = "./data/"+min+"_"+max+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
	    	
			for(double d=min; d<=max; d=d+every)
			{
				/*for(int i=0; i<3; i++){
					startTime[i] = (long) 0.0;
					endTime[i] = (long) 0.0;
				}*/

				cmtd.setStrat(new StrategyNorme(d));
				startTime[0] = System.nanoTime();
				cmtd.methodePuissances();
				endTime[0] = System.nanoTime();
				
				cmtd.setStrat(new StrategyAll(d));
				startTime[1] = System.nanoTime();
				cmtd.methodePuissances();
				endTime[1] = System.nanoTime();
				
				cmtd.setStrat(new StrategyRand(d));
				startTime[2] = System.nanoTime();
				cmtd.methodePuissances();
				endTime[2] = System.nanoTime();
				
				out.println(d + ";" + ( endTime[0] - startTime[0] ) );
			}
		
			out.close();
	    }
	    catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	public static void bestMethode(double e,  int maxK, int every)
	{
		Vector v;
		Matrix m;
		CMTD cmtd;
		
	    try{
	    	String fileName = "./data/bestMethode"+e+":"+maxK+":"+every+".txt";
			PrintWriter out  = new PrintWriter(new FileWriter(fileName));
			
			
			for(int k=3; k <= maxK; k=k+every)
			{
				m = MatrixFactory.procNaissanceMort(k,0.02,0.01);
				cmtd = new CMTD(m);
				cmtd.setStrat(new StrategyAll(e));
				cmtd.setK(k);
				
				v = cmtd.methodePuissances();
				out.print(k + ";" + v.getN() );
				//System.out.print(v.toString());
				
				v = cmtd.methodeGauss();
				out.println(";" + v.getN() );
				//System.out.println(v.toString());
			}
		
			out.close();
	    }
	    catch(Exception ex){
	      ex.printStackTrace();
	    }
	}
	
	
	
}