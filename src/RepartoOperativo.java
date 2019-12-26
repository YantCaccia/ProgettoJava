import java.util.ArrayList;

public class RepartoOperativo {
	ArrayList<Cantiere> cantieri;
	
	public RepartoOperativo() {
		cantieri = new ArrayList<Cantiere>();
	}
	
	public ArrayList<Cantiere> getCantieri(){
		return cantieri;
	}
	
	public void addCantiere(Cantiere c) {
		cantieri.add(c);
	}
	
	public ArrayList<Cantiere> getCantieriByValue(int min, int max){
		ArrayList<Cantiere> toBeRet = new ArrayList<Cantiere>();
		for(Cantiere c:cantieri) {
			if(c.getValore()>=min&&c.getValore()<=max) {
				toBeRet.add(c);
			}
		}
		return toBeRet;
	}
	
}
