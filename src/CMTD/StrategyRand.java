package CMTD;

public class StrategyRand implements IStrategy {
	
	private int n;
	private double e;
	
	public StrategyRand(){
		this.n = 5;
		this.e = 0.00001;
	}
	public StrategyRand(double e){
		this.n = 5;
		this.e = e;
	}
	public StrategyRand(double e,int n){
		this.n = n;
		this.e = e;
	}

	@Override
	public boolean isConv(Vector v, Vector vOld) {
		int rand;
		for(int i=0; i<n; i++) {
			rand = (int)(Math.random() * v.size());
			if(Math.abs(v.get(rand) - vOld.get(rand)) > e){
				return false;
			}
		}
		return true;
	}
	
	
}
