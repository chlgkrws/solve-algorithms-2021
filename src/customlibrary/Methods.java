package customlibrary;

public class Methods {
	
	/**
	 * Lpad
	 * param : ���� ���ڿ�, ����, ä�� �ܾ�
	 * InPut :	"aa", 5, b
	 * OutPut: "bbbaa"
	 */
	private static String setLPad(String strContext, int iLen, String strChar) {
		String strResult = "";
		StringBuilder sbAddChar = new StringBuilder();
		for (int i = strContext.length(); i < iLen; i++) { // iLen���� ��ŭ strChar���ڷ� ä���.
			sbAddChar.append(strChar);
		}
		strResult = sbAddChar + strContext; // LPAD�̹Ƿ�, ä�﹮�ڿ� + �������ڿ��� Concate�Ѵ�.
		return strResult;
	}

}
