package com.kw.cine.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kw.cine.domain.entity.File;
import com.kw.cine.domain.repository.FileRepository;
import com.kw.cine.dto.FileDto;

@Service
public class FileService {
	
	private static final Logger logger = LogManager.getLogger(FileService.class);
	private FileRepository fileRepo;
	
	// 생성자
	public FileService(FileRepository fileRepo) {
		this.fileRepo = fileRepo;
	}
	
	// 파일 업로드
	@Transactional
	public Long saveFile(FileDto fileDto) {
		return fileRepo.save(fileDto.toEntity()).getId();
	}
	
	// 파일 다운로드
	@Transactional
	public FileDto getFile(Long id) {
		// 엔터티로 받고
		File file = fileRepo.findById(id).get();
		// Dto로 변환
		FileDto fileDto = FileDto.builder()
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
			logger.info(imgfileName + "파일을 정상 삭제하였습니다.");
		}
		else {
			logger.error(imgfileName + "파일이 없거나 삭제하지 못했습니다.");
		}
		fileRepo.deleteById(imgfileId);
	}

}
