package customlibrary;

public class Methods {
	
	/**
	 * Lpad
	 * param : 원본 문자열, 길이, 채울 단어
	 * InPut :	"aa", 5, b
	 * OutPut: "bbbaa"
	 */
	private static String setLPad(String strContext, int iLen, String strChar) {
		String strResult = "";
		StringBuilder sbAddChar = new StringBuilder();
		for (int i = strContext.length(); i < iLen; i++) { // iLen길이 만큼 strChar문자로 채운다.
			sbAddChar.append(strChar);
		}
		strResult = sbAddChar + strContext; // LPAD이므로, 채울문자열 + 원래문자열로 Concate한다.
		return strResult;
	}

}
