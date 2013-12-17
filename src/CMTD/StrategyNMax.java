package CMTD;

public class StrategyNMax implements IStrategy {

	private int nMax;
	private int n;
	
	public StrategyNMax(int nMax) {
		this.nMax = nMax;
	}
	
	public void setN(int n){
		this.n = n;
	}
	
	@Override
	public boolean isConv(Vector v,Vector vOld) {
		if(n >= nMax)
			return true;
		return false;
	}
	
}
