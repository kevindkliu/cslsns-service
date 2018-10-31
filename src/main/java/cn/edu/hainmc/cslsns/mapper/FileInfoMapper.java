package cn.edu.hainmc.cslsns.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.edu.hainmc.cslsns.model.FileInfo;

@Mapper
public interface FileInfoMapper {
	
	int create(@Param(value="fileInfo") FileInfo fileInfo);

	FileInfo findById(@Param(value="fileId") Long id);

	List<FileInfo> findAll();	

	int update(@Param(value="fileInfo") FileInfo fileInfo);

	int delete(@Param(value="fileId") Long id);

}
