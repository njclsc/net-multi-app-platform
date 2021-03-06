package bd.nmam.history.business.service;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import bd.nmam.history.business.pojo.SourceMessagePojo;

public interface IStaticSourceManagerService {

	public String uploadOperate(MultipartFile[] files, HttpServletRequest request);
	public String removeOperate(SourceMessagePojo sourceMessagePojo, HttpServletRequest request);
}
