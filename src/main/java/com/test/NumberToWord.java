package com.test;

public class NumberToWord {
	public String numberToWord(int num){
		String ones[]={" ", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
		String tens[]={" "," ", " Twenty", " Thirty", " Fourty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
		
		if (num > 19) {
			return tens[num / 10] + "" + ones[num % 10];
		} else {
			return ones[num];
		}
		
	}
	
	public String convertToWord(int i){
		if(i>=100){
				String threeDigit=numberToWord(((i / 100) % 10))+" HUNDRED";
				threeDigit+=numberToWord((i % 100));
				return threeDigit;
			}else{
				return numberToWord((i % 100));
			}
	}
}
