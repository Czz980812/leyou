package com.leyou.upload.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "leyou.upload")
public class UploadProperties {

    private String baseUrl;
    private List<String> allowImgList;

}
