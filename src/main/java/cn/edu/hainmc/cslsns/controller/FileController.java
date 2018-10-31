package cn.edu.hainmc.cslsns.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.hainmc.cslsns.common.bean.ResponseResult;
import cn.edu.hainmc.cslsns.common.enums.ResponseErrorEnum;
import cn.edu.hainmc.cslsns.common.util.RestResultGenerator;
import cn.edu.hainmc.cslsns.model.FileInfo;
import cn.edu.hainmc.cslsns.service.FileInfoService;

@RestController
@RequestMapping("/api/v1.0")
public class FileController {

	@Autowired
	private FileInfoService fileInfoService;

	/*
	 * 文件上传
	 */
	@RequestMapping(value = "/files", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	public ResponseResult<FileInfo> fileUpload(@RequestParam("fileInfo") MultipartFile file) {

		if (file.isEmpty()) {
			return RestResultGenerator.genResponseResult(null, ResponseErrorEnum.FAILURE);// "请选择一个文上传";
		}
		String filename = file.getOriginalFilename();
		String uploadpath = "/opt/dev_server/files_libs";
		File dest = new File(uploadpath + "/" + filename);

		if (!dest.getParentFile().exists()) {
			// 父目录不存在就创建一个
			dest.getParentFile().mkdir();
		}

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFileName(file.getOriginalFilename());
			String strFileExt = file.getName().substring(file.getName().lastIndexOf("."));
			fileInfo.setFlieext(strFileExt);
			fileInfo.setFilesize(file.getSize());
			fileInfo.setFilePath(uploadpath);
			// 保存文件，到文件服务器上。
			file.transferTo(dest);

			// 保存记录到数据库中
			fileInfoService.create(fileInfo);

			return RestResultGenerator.genResponseResult(fileInfo, ResponseErrorEnum.SUCCESS);// "文件上传成功";
		} catch (IOException e) {
			e.printStackTrace();
			return RestResultGenerator.genResponseResult(null, ResponseErrorEnum.FAILURE);// "请选择一个文上传";
		}
	}

	/*
	 * 文件下载  
	 *  HttpServletResponse response 
	 */
//	@RequestMapping(value = "/files/{id}", method = RequestMethod.GET, consumes = "application/json; charset=utf-8")
//	public ResponseResult<FileInfo> fileDownloadById(@PathVariable("id") Long fileId) {
//
//		FileInfo fileInfo = new FileInfo();
//		fileInfo = fileInfoService.findById(fileId);
//
//		String fileName = fileInfo.getFileName();
//		String filepath = fileInfo.getFilePath();
//		File file = new File(filepath + "/" + fileName);
//		byte[] buff = new byte[1024];
//		BufferedInputStream bis = null;
//		OutputStream os = null;
//		try {
//			os = response.getOutputStream();
//			bis = new BufferedInputStream(new FileInputStream(file));
//			int i = bis.read(buff);
//			while (i != -1) {
//				os.write(buff, 0, buff.length);
//				os.flush();
//				i = bis.read(buff);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "文件上传失败";
//		} finally {
//			if (bis != null) {
//				try {
//					bis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return "文件上传成功";
//	}
}
