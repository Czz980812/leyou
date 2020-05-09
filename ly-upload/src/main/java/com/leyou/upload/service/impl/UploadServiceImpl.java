package com.leyou.upload.service.impl;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.upload.config.UploadProperties;
import com.leyou.upload.service.UploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("uploadService")
@EnableConfigurationProperties(UploadProperties.class)
public class UploadServiceImpl implements UploadService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private UploadProperties uploadProperties;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {
        //获取文件后缀名
        String extName = StringUtils.substringAfterLast(multipartFile.getOriginalFilename(),".");
        //上传文件名
        StorePath storePath = fastFileStorageClient.uploadFile(multipartFile.getInputStream(),multipartFile.getSize(),extName,null);
        //获取图片存储地址
        String fileId = storePath.getFullPath();
        System.out.println("fileId = " + fileId);
        System.out.println("url = "+ uploadProperties.getBaseUrl()+"/"+fileId);
        return uploadProperties.getBaseUrl()+"/"+fileId;
    }
}
