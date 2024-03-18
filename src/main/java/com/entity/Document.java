package com.entity;
import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
//@Entity
//@Table(name="docs")
public class Document {
		//@Id
		//@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private Integer id;
		private String docName;
		private String docType;
		private Date createdon;
		@Transient
		private MultipartFile BrowseFile;
		private String ErrorMsg;
		private File TempFile;
		
		
		public File getTempFile() {
			return TempFile;
		}

		public void setTempFile(File tempFile) {
			TempFile = tempFile;
		}

		public String getErrorMsg() {
			return ErrorMsg;
		}

		public void setErrorMsg(String errorMsg) {
			ErrorMsg = errorMsg;
		}

		@Lob
		private byte[] data;
		
		

		public MultipartFile getBrowseFile() {
			return BrowseFile;
		}

		public void setBrowseFile(MultipartFile browseFile) {
			BrowseFile = browseFile;
		}

		@Override
		public String toString() {
			return "Doc [id=" + id + ", docName=" + docName + ", docType=" + docType + ", createdon=" + createdon
					+ ", data=" + Arrays.toString(data) + "]";
		}

		public Date getCreatedon() {
			return createdon;
		}

		public void setCreatedon(Timestamp createdon) {
			this.createdon = createdon;
		}

		public Document(Integer id, String docName, String docType, Timestamp createdon, byte[] data) {
			super();
			this.id = id;
			this.docName = docName;
			this.docType = docType;
			this.createdon = createdon;
			this.data = data;
		}

		public Document() {
			super();
			// TODO Auto-generated constructor stub
		}

		/*
		 * public Document(String docName, String docType, byte[] data) { super();
		 * this.docName = docName; this.docType = docType; this.data = data; }
		 */
		

		public Integer getId() {
			return id;
		}

		public Document(String docName, String contentType, byte[] data) {
			super();
			this.docName = docName;
			this.docType = contentType;
			this.data = data;
		}

		

		

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDocName() {
			return docName;
		}

		public void setDocName(String docName) {
			this.docName = docName;
		}

		public String getDocType() {
			return docType;
		}

		public void setDocType(String docType) {
			this.docType = docType;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		
	}


