package br.com.jnsdevs.RestWithSpringBootJNS.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Autor Jairo Nascimento
 * @Created 21/08/2023 - 07:39
 */
@Configuration
@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
