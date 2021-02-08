package com.kw.cine.service;

import java.io.File;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kw.cine.domain.entity.Files;
import com.kw.cine.domain.repository.FileRepository;
import com.kw.cine.dto.FilesDto;
import com.kw.cine.util.MD5Generator;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileService {
	
	private static final Logger logger = LogManager.getLogger(FileService.class);
	private FileRepository fileRepo;
	
	
	// 파일 업로드 직전에 파일 이름 및 경로 설정
	@Transactional
	public FilesDto createFilePathAndSave(MultipartFile files) {
		String filename = "";
		try {
		String oriFilename = files.getOriginalFilename(); // 파일 원래 이름
		filename = new MD5Generator(oriFilename).toString(); // 파일 변환 이름
		String sourceFileNameExtension = FilenameUtils.getExtension(oriFilename).toLowerCase(); // 파일 확장자
		filename = filename + "." + sourceFileNameExtension; // 변환된 파일 이름에 확장자를 붙인다
		String savePath = System.getProperty("user.dir") + "\\images"; // 실행되는 위치의 'images' 폴더에 파일이 저장된다.
		
		// 파일이 저장되는 폴더가 없다면 폴더를 생성
		if (!new File(savePath).exists()) {
			try {
				new File(savePath).mkdir();
			} catch (Exception e) { // 이미지 파일을 저장할 폴더가 제대로 생성되지 않은 경우
				logger.error("[파일 경로 생성 오류] 정상적으로 "+ savePath + "이(가) 생성되지 않았습니다.");
				logger.error(e.getMessage());
				e.getStackTrace();
				return null;
			}
		}
		 
		// 파일 경로 저장
		String filePath = savePath + "\\" + filename;
		files.transferTo(new File(filePath));
		
		// Dto에 저장
		FilesDto fileDto = new FilesDto();
		fileDto.setOrifilename(oriFilename);
		fileDto.setFilename(filename);
		fileDto.setFilepath(filePath);
		
		logger.info("[파일 생성 완료] 경로: "+ filePath);
		logger.info("[파일 생성 완료] 이름: "+ filename);
		return fileDto;
		
		} 
		catch(Exception e) {
			logger.error("[파일 생성 오류] 정상적으로 " + filename + "이 생성되지 않았습니다.");
			logger.error(e.getMessage());
			e.getStackTrace();
			return null;
		}
		
	}
	
	// 파일 업로드
	@Transactional
	public Long saveFile(FilesDto fileDto) {
		try {
			return fileRepo.save(fileDto.toEntity()).getId();

		} catch (Exception e) {
			logger.error("[파일 저장 오류] 정상적으로 파일이 저장되지 않았습니다.");
			logger.error(e.getMessage());
			e.getStackTrace();
			return null;
		}

	}
	
	// 파일 다운로드
	@Transactional
	public FilesDto getFile(Long id) {
		// 엔터티로 받고
		Files file = fileRepo.findById(id).get();
		// Dto로 변환
		FilesDto fileDto = FilesDto.builder()
				.id(file.getId())
				.orifilename(file.getOrifilename())
				.filename(file.getFilename())
				.filepath(file.getFilepath())
				.build();
		
		return fileDto;
				
	}

	// 파일 삭제
	@Transactional
	public void fileDelete(Long imgfileId, String imgfileName) {
		// TODO Auto-generated method stub
		// 실제 로컬에 저장한 파일을 삭제한 뒤, 파일을 매핑한 DB를 제거한다.
		String filePath = System.getProperty("user.dir") + "\\images";
		java.io.File deleteFile = new java.io.File(filePath + "\\" + imgfileName);
		if(deleteFile.exists()) {
			deleteFile.delete();
			fileRepo.deleteById(imgfileId);
			logger.info(imgfileName + "파일을 정상 삭제하였습니다.");
		}
		else {
			logger.error(imgfileName + "파일이 없거나 삭제하지 못했습니다.");
		}
	}

}
