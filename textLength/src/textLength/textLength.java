package textLength;


public class textLength {
	int numText;
		public int wordCounter(String text) {
			for(int i= 0; i < text.length();i++) {
				 if( ((i>0)&&(text.charAt(i)!=' ')&&(text.charAt(i-1)==' ')) || ((text.charAt(0)!=' ')&&(i==0)) )  
					numText++;
				}
			return numText;
		}
}



