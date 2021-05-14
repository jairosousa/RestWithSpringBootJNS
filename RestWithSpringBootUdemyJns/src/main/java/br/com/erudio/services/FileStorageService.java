package br.com.erudio.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.erudio.config.FileStorageConfig;
import br.com.erudio.exception.FileStorageException;
import br.com.erudio.exception.MyFileNotFoundException;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageConfig fileStorageConfig) {
		this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir())
				.toAbsolutePath().normalize();
		
		/**
		 * Metodo responsavel em criar o diretorio no construtor
		 */
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Não foi possivel criar o diretório", e);
		}

	}
	
	/**
	 * Metodo responsavel em criar o arquivo
	 */
	public String storageFile(MultipartFile file) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			
			if (filename.contains("..")) {
				throw new FileStorageException("O arquivo tem sequencia invalida " + filename);
			}
			
			/**
			 * Salvar arquivo em disco
			 */
			Path targetLocation = this.fileStorageLocation.resolve(filename);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return  filename;
			
		} catch (Exception e) {
			throw new FileStorageException("Não foi possivel criar o arquivo " + filename + ". Por favor tente novamente", e);
		}
	}
	
	public Resource loadFileAsResource(String filename) {
		try {
			Path filePath = this.fileStorageLocation.resolve(filename).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("Arquivo não encontrado " + filename);
			}
		} catch (Exception e) {
			throw new MyFileNotFoundException("Arquivo não encontrado " + filename, e);
		}
	}

}
