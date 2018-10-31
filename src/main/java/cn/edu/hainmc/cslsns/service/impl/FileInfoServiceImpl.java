package cn.edu.hainmc.cslsns.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import cn.edu.hainmc.cslsns.mapper.FileInfoMapper;
import cn.edu.hainmc.cslsns.model.FileInfo;
import cn.edu.hainmc.cslsns.service.FileInfoService;

public class FileInfoServiceImpl implements FileInfoService {

	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Override
	public int create(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoMapper.create(fileInfo);
	}

	@Override
	public FileInfo findById(Long id) {
		// TODO Auto-generated method stub
		return fileInfoMapper.findById(id);
	}

	@Override
	public List<FileInfo> findAll() {
		// TODO Auto-generated method stub
		return fileInfoMapper.findAll();
	}

	@Override
	public int update(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		return fileInfoMapper.update(fileInfo);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return fileInfoMapper.delete(id);
	}
}
