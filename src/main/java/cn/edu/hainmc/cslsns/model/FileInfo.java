package cn.edu.hainmc.cslsns.model;

import java.sql.Timestamp;

public class FileInfo {

	private long id;// 文件ID
	private String fileName;// 文件名
	private String flieext; // 文件扩展名
	private String filePath;// 文件保存路径
	private Long filesize;// 文件大小，单位比特
	private Timestamp creationDate;
	private String createdBy;
	private Timestamp lastUpdateDate;
	private String lastUpdatedBy;
	private Timestamp lastLoginDate;
	private String lastUpdateLogin;

	public FileInfo() {
		super();
	}

	public FileInfo(long id, String fileName, String flieext, String filePath, Long filesize, Timestamp creationDate,
			String createdBy, Timestamp lastUpdateDate, String lastUpdatedBy, Timestamp lastLoginDate,
			String lastUpdateLogin) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.flieext = flieext;
		this.filePath = filePath;
		this.filesize = filesize;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastLoginDate = lastLoginDate;
		this.lastUpdateLogin = lastUpdateLogin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFlieext() {
		return flieext;
	}

	public void setFlieext(String flieext) {
		this.flieext = flieext;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setLastUpdateLogin(String lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

}
