package cn.edu.hainmc.cslsns.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.edu.hainmc.cslsns.model.FileInfo;

public interface FileInfoService {
	
	int create(FileInfo fileInfo);

	FileInfo findById(Long id);

	List<FileInfo> findAll();	

	int update(FileInfo fileInfo);

	int delete(Long id);

}
