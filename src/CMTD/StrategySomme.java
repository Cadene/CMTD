package CMTD;

public class StrategySomme implements IStrategy {

	private double e;
	
	public StrategySomme(double e){
		this.e = e;
	}
	
	@Override
	public boolean isConv(Vector v, Vector vOld) {
		double norme = 0.0;
		for(int i=0; i<v.size(); i++){
			norme += Math.abs(v.get(i) - vOld.get(i));
		}
		if(norme<e)
			return true;
		return false;
	}
	
	
}
