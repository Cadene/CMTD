package CMTD;

public class StrategyNorme implements IStrategy {

	private double e;
	
	public StrategyNorme(double e){
		this.e = e;
	}
	
	@Override
	public boolean isConv(Vector v, Vector vOld) {
		double norme = 0.0;
		for(int i=0; i<v.size(); i++){
			norme += Math.pow(v.get(i) - vOld.get(i),2);
		}
		if(Math.sqrt(norme)<e)
			return true;
		return false;
	}
	
	
}
