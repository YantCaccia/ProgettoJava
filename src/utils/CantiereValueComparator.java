package utils;
import dirigenza.Cantiere;

public class CantiereValueComparator implements Comparator<Cantiere> {
	public int compare(Cantiere o1, Cantiere o2) {
		if(o1.getValore()<o2.getValore()) return 1;
		if(o1.getValore()==o2.getValore()) return 0;
		return -1;
	}
}
