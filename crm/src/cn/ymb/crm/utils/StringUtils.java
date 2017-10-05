package cn.ymb.crm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class StringUtils {


	public static String getMD5Value(String value) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			byte[] md5ValueByteArray =messageDigest.digest(value.getBytes());
			BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
			return bigInteger.toString(16);
		} catch (Exception e) {
			return value;
		}
	}
	

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
