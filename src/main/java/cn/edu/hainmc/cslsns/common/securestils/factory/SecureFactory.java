package cn.edu.hainmc.cslsns.common.securestils.factory;

import java.security.NoSuchAlgorithmException;

import cn.edu.hainmc.cslsns.common.securestils.other.SecureType;
import cn.edu.hainmc.cslsns.common.securestils.secure.AESCodec;
import cn.edu.hainmc.cslsns.common.securestils.secure.BasicCodec;
import cn.edu.hainmc.cslsns.common.securestils.secure.DESCodec;
import cn.edu.hainmc.cslsns.common.securestils.secure.MD5Codec;
import cn.edu.hainmc.cslsns.common.securestils.secure.NoSecureCodec;
import cn.edu.hainmc.cslsns.common.securestils.secure.RSAForPrivateCodec;
import cn.edu.hainmc.cslsns.common.securestils.secure.RSAForPublicCodec;
import cn.edu.hainmc.cslsns.common.securestils.secure.SHACodec;

public class SecureFactory {

	public static BasicCodec getCodec(SecureType type, String key) throws NoSuchAlgorithmException {
		
		BasicCodec codec = null;
		
		switch (type) {
		case MD5:
			codec = new MD5Codec();
			break;
		case SHA:
			codec = new SHACodec();
			break;
		case DES:
			if (key != null && !"".equals(key)) {
				codec = new DESCodec(key);
			} else {
				codec = new DESCodec();
			}
			break;
		case AES:
			if (key != null && !"".equals(key)) {
				codec = new AESCodec(key);
			} else {
				codec = new AESCodec();
			}
			break;
		case RSA_PRIVATE:
			codec = new RSAForPrivateCodec();
			break;
		case RSA_PUBLIC:
			codec = new RSAForPublicCodec(key);
			break;
		default:
			codec = new NoSecureCodec();
		}
		return codec;
	}
}