package cn.edu.hainmc.cslsns.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hainmc.cslsns.common.securestils.factory.SecureFactory;
import cn.edu.hainmc.cslsns.common.securestils.other.SecureType;
import cn.edu.hainmc.cslsns.common.securestils.secure.AESCodec;
import cn.edu.hainmc.cslsns.mapper.UserMapper;
import cn.edu.hainmc.cslsns.model.User;
import cn.edu.hainmc.cslsns.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int create(User user) {

		try {
			// 加密代码
			byte[] data = user.getUserPassword().getBytes();// 加密前数据
			AESCodec codecA = (AESCodec) SecureFactory.getCodec(SecureType.AES, null);
			byte[] encryptData = codecA.encrypt(data);
			String encryptHex = codecA.parseByteArray2HexStr(encryptData);// 加密后数据
			System.out.println("encryptHex:" + encryptHex);
			user.setUserPassword(encryptHex);

			// 解密代码
			// byte[] data2 = user.getUserPassword().getBytes();//加密数据
			// String secretKey = codecA.getSecretKey();
			// AESCodec codecB = (AESCodec) SecureFactory.getCodec(SecureType.AES,
			// secretKey);
			// byte[] decryptData = codecB.decrypt(data2);
			// byte[] decryptData2 =
			// codecB.decrypt(codecB.parseHexStr2ByteArray(data2));//解密后数据
			// System.out.println("decryptHex:"+ new String(decryptData2));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userMapper.create(user);
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public int update( User user) {
		// TODO Auto-generated method stub
		Timestamp updateDatetime = new Timestamp(System.currentTimeMillis());
		user.setLastUpdateDate(updateDatetime);
		return userMapper.update(user);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return userMapper.delete(id);
	}
}
