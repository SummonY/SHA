package summon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	// SHA加密
	public static String encodeSHAString(String str, String method) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			byte[] s = md.digest();
			dstr = hex2String(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return dstr;
	}
	
	private static String hex2String(byte[] s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; ++i) {
			sb.append(Integer.toHexString((s[i] & 0XFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "这是要加密的明文。";
		System.out.println("加密前的明文：" + str);
		
		System.out.println("SHA1加密后:" + encodeSHAString(str, "SHA-1"));
		System.out.println("SHA256加密后:" + encodeSHAString(str, "SHA-256"));
		System.out.println("SHA384加密后:" + encodeSHAString(str, "SHA-384"));
		System.out.println("SHA512加密后:" + encodeSHAString(str, "SHA-512"));
	}
}
