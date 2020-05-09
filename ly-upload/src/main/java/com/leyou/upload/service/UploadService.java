package com.leyou.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    /**
     * 文件上传方法
     * @param multipartFile 上传的文件内容
     * @return 文件在fastdfs上的存储路径
     * @throws Exception
     */
    public String uploadFile(MultipartFile multipartFile)throws Exception;
}
