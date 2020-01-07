package utils;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter<T> {
	
	public ArrayList<? extends T> sort(ArrayList<? extends T> list, Comparator<T> c){
		//Selection Sort
		for(int i = 0; i < list.size() - 1; i++) {
			int pos = i;
			for(int j = i + 1; j<list.size(); j++) {
				if(c.compare(list.get(j), list.get(pos))<0) {
					pos = j;
				}
			}
			Collections.swap(list, i, pos);
		} //Fine Sort		
		return list;
	}

}
