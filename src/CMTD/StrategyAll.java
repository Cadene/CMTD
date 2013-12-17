package CMTD;

public class StrategyAll implements IStrategy {
	
	private double e;
	
	public StrategyAll(double e){
		this.e = e;
	}
	
	@Override
	public boolean isConv(Vector v, Vector vOld) {
		for(int i=0; i<v.size(); i++){
			if (Math.abs(v.get(i) - vOld.get(i)) > e)
				return false;
		}
		return true;
	}
	
	
}
