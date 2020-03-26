package com.org.leetcode;

import java.util.*;

public class TelephoneProblem {
	 
	public List<String> combinationformation(String digits) {
		List<String> result = new ArrayList<String>();
		
		if(digits == null || digits.length() == 0 || digits.equals(""))
		return result;
		
		Map<Character, char[]> maputil = new HashMap<Character, char[]>();
		maputil.put('0', new char[] {});
		maputil.put('1', new char[] {});
		maputil.put('2', new char[] {'a','b','c'});
		maputil.put('3', new char[] {'d','e','f'});
		maputil.put('4', new char[] {'g','h','i'});
		maputil.put('5', new char[] {'j','k','l'});
		maputil.put('6', new char[] {'m','n','o'});
		maputil.put('7', new char[] {'p','q','r','s'});
		maputil.put('8', new char[] {'t','u','v'});
		maputil.put('9', new char[] {'w','x','y','z'});
		
		StringBuilder sb = new StringBuilder();
		
		formation(digits, sb , maputil, result);
		
		return result;
	}

	private void formation(String digits, StringBuilder sb, Map<Character, char[]> maputil, List<String> result) {
			
		//Base condition
		//if the given digits length is equal to the formed string length then we can break the recursion
		if(digits.length() == sb.length()) {
			result.add(sb.toString());
			return;
		}
		for(char ch:maputil.get(digits.charAt(sb.length()))) {
			sb.append(ch);
			formation(digits, sb , maputil, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
	
		TelephoneProblem tel = new TelephoneProblem();
		System.out.println(tel.combinationformation("23"));
		
	}

}
