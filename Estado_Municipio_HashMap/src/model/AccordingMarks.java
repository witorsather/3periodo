package model;

import java.util.Comparator;

class AccordingMarks implements Comparator<Municipio> {
    
	public int compare(Municipio s1, Municipio s2) {
		
        return s1.getCod().compareTo(s2.getCod());
    
	}
	
}