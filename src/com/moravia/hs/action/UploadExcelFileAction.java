package com.moravia.hs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller("uploadExcelFileAction")
public class UploadExcelFileAction extends BaseAction {
	
	//固定写法，可参考帮助文档file-upload.html
    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    public File getUpload() {
           return upload;
    }

    public void setUpload(File upload) {
           this. upload = upload;
    }

    public String getUploadContentType() {
           return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
           this. uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
           return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
           this. uploadFileName = uploadFileName;
    }

    public String doUpload() throws IOException {
          System.out.println(upload);
          System.out.println(uploadContentType);
          System.out.println(uploadFileName);
          
//        if(uploadFileName.endsWith(".xlsx")) {
          File uploadPath = new File(ServletActionContext.getServletContext().getRealPath("/") + "/upload/");
          if(!uploadPath.exists()) {
        	  // System.out.println("Directory is not exist...");
        	  // System.out.println("Make directory...");
        	  uploadPath.mkdir();
          }
          
          String savePath = ServletActionContext.getServletContext().getRealPath("/upload/" + this.uploadFileName);
          
//        FileInputStream fis = new FileInputStream(upload);
//        FileOutputStream fos = new FileOutputStream(savePath);
//        IOUtils.copy(fis, fos);
//        fos.flush();
//        fos.close();
//        fis.close();
          
//        或者用以下方法实现文件copy操作
	      File saveFile = new File(savePath);
	      FileUtils.copyFile(upload, saveFile);
          
          return SUCCESS;
         /* }
          // System.out.println("Uploaded file is not a .xlsx file");
          return ERROR;*/
    }

}
