package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "author", "launchDate", "price", "title" })
public class UploadFileResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private String fileDounloadUri;
	private String fileType;
	private long size;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDounloadUri() {
		return fileDounloadUri;
	}

	public void setFileDounloadUri(String fileDounloadUri) {
		this.fileDounloadUri = fileDounloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}