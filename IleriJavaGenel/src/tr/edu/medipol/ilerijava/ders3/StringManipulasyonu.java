package tr.edu.medipol.ilerijava.ders3;

import org.apache.commons.lang3.StringUtils;

public class StringManipulasyonu {

	public static void main(String[] args) {
		
		String [] strArr = {"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a" };
		String joinedStr = StringUtils.join(strArr);
		System.out.println(joinedStr);
		
	}

}
