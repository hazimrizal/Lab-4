package translation;

import java.util.ArrayList;

public class translation {
		String text, language;
			
			public void setPhrase(String Text) {
				this.text= Text;
			}
			
			public String getPhrase() {
				return text;
			}
			
			public void setLang(String language) {
				this.language = language;
			}
			
			public String getLang() {
				return language;
			}
			
			String translate[][]= {{"Good morning","Selamat Pagi" , "الخير صباح", "좋은 아침"},
									{"Good night", "Selamat malam", "مساؤك طاب", "안녕히 주무세요"},
									{"How are you?", "Apa khabar?", "حالك؟ كيف", "어떻게 지내세요?"},
									{"Thank you","Terima kasih","لك شكرا","감사합니다"},
									{"Goodbye","Selamat tinggal","السالمة مع","안녕"},
									{"What's up?","Ada apa?","أخبارك؟ ما","뭐야?"}};
			
			
			public String translateText(String text, String language) {
				int convert;
				
				if(language.equalsIgnoreCase("Malay"))
					convert = 1;
				else if(language.equalsIgnoreCase("Arabic"))
					convert = 2;
				else 
					convert = 3;
				
				System.out.println("\n"+convert + " " + text);
				for(int i = 0;i<translate.length;i++) {
					if(translate[i][0].equalsIgnoreCase(text)) {
						System.out.println(translate[i][convert]);
						return translate[i][convert];
						}
					
				}
				return "Error";
			}
}
			
			
