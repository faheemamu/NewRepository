package com.service.Impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import com.NSE.NSEUploadAndDownload.ServiceImpl.DocumentServiceImpl;
import com.entity.Document;
import com.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Value("${files_path}")
    private String filepath;
 

    @Value("${other_message}")
    private String other_message;
	
    private final static Logger LOGGER = LogManager.getLogger(DocumentServiceImpl.class.getName());

    
    
	@Override
	public String saveFile(Document dto) {
		
		String filePath;

		try {
		    MultipartFile browseFile = dto.getBrowseFile();

		    if (checkFileNameValidation(dto, browseFile.getOriginalFilename())) {

		        String ext = FilenameUtils.getExtension(browseFile.getOriginalFilename());

		        Date dt = new Date();
		        SimpleDateFormat dateFormat = new
		        SimpleDateFormat("yyyyMMddhhmmss");

		        //Store file to temporary folder 
		       
		        String fileName =  FilenameUtils.removeExtension(browseFile.getOriginalFilename()) + "_" + dateFormat.format(dt) + "." + ext;
		           System.out.println(fileName);
		        fileName = fileName.toUpperCase();
		       
		        File  tempFile = new File(filepath + fileName);
		        browseFile.transferTo(tempFile);

		        dto.setTempFile(tempFile);
		        if (tempFile.length() > 0 && tempFile.exists()) {
		            filePath = filepath + fileName;
		        } else {
		            filePath = null;
		            dto.setErrorMsg("Empty file is not allowed.");
		        }
		    } else {
		        filePath = null;
		        if (dto.getErrorMsg() == null || dto.getErrorMsg().isEmpty()) {
		            dto.setErrorMsg("Invalid file name.");
		        }
		    }
		} catch (IOException |
		    IllegalStateException | IllegalArgumentException e) {
		    //Logger.error(e.getMessage(), e);
		    filePath = null;
		    dto.setErrorMsg(other_message);
		    if (e instanceof IllegalArgumentException) {
		        dto.setErrorMsg("Empty file is not allowed.");
		    }
		} catch (Exception e) {
		    LOGGER.error(e.getMessage(), e);
		    filePath = null;
		    dto.setErrorMsg(other_message);
		}
		return filePath;
			}


		
	
	
	


private boolean checkFileNameValidation(Document dto, String fileName) {
    if (!fileName.matches("(?i).*\\.(csv|txt)$")) {
        dto.setErrorMsg("Please Upload csv OR txt file.");
        return false;
    }
    else if (fileName.length() > 100) {
        dto.setErrorMsg("File name should not be more then 100 character.");
        return false;
    }
    return true;
}


}