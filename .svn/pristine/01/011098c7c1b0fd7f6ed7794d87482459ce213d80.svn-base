package bd.nmam.history.business.serviceimp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.history.business.dao.StaticSourceDao;
import bd.nmam.history.business.pojo.AreaPojo;
import bd.nmam.history.business.pojo.FirmwarePojo;
import bd.nmam.history.business.pojo.ResponsePojo1;
import bd.nmam.history.business.pojo.SourceMessagePojo;
import bd.nmam.history.business.service.IStaticSourceManagerService;
import bd.nmam.history.config.AppConfigure;


@Service("StaticSourceManagerImp")
public class StaticSourceManagerImp implements IStaticSourceManagerService{
	@Autowired
	private StaticSourceDao ssDao;
	

	@Override
	public String uploadOperate(MultipartFile[] files, HttpServletRequest request) {
		// TODO Auto-generated method stub
//		String result = "";
		ResponsePojo rp = new ResponsePojo();
		try{
			rp.setUrls(new ArrayList<String>());
			for(MultipartFile file : files){
				JSONObject js = JSONObject.parseObject(request.getParameter("message"));
				String fileName = AppConfigure.tokenParse(request.getHeader("bd-token"), "account") + "_" + 
						System.currentTimeMillis() + "_" + file.getOriginalFilename();
				String path = ResourceUtils.getURL("classpath:").getPath() + "static/" + js.getString("sourceType") + "/" + fileName;
				File f = new File(path.substring(1));
				if(!f.exists()){
					f.getParentFile().mkdirs();
					f.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(file.getBytes());
				fos.flush();
				fos.close();
				String result = "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath() + "/" + 
						js.getString("sourceType") + "/" + fileName;
				rp.getUrls().add(result);
				rp.setFileName(fileName);
				//========固件处理开始============
				if(js.getString("sourceType").equals("firmware")){
					String[] fileNames = fileName.split("_");
					String[] parameters = {"history", "firmware", fileNames[0], fileNames[1], fileNames[2], "add"};
					firmwareOperate(parameters);
				}
				//========固件处理结束============
			}
			rp.setState("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONObject.toJSONString(rp);
	}
	//上传固件处理
	/*
	 * 参数 1：应用名称，2：servletPath, 3:上传用户， 4:上传时间,5:固件名称，6：文件操作[增加，删除]
	 * */
	private void firmwareOperate(String[] parameters){
		FirmwarePojo fp = new FirmwarePojo();
		fp.setServerName(parameters[0]);
		fp.setServletPath(parameters[1]);
		fp.setUploadUser(parameters[2]);
		fp.setUploadTime(parameters[3]);
		fp.setFilewareName(parameters[4]);
		fp.setOperate(parameters[5]);
		ssDao.firmwareOperate(fp);
	}
	@Override
	public String removeOperate(SourceMessagePojo sourceMessagePojo, HttpServletRequest request) {
		// TODO Auto-generated method stub
		ResponsePojo1 rp = new ResponsePojo1();
		
		try{
			String rd = "";
			if(sourceMessagePojo.getSourceType().equals("firmware")){
				rd = sourceMessagePojo.getUploadUser() + "_" + sourceMessagePojo.getUploadTime() + "_" + sourceMessagePojo.getResultData();
			}else{
				rd = sourceMessagePojo.getResultData();
			}
			String path = ResourceUtils.getURL("classpath:").getPath() + "static/" + sourceMessagePojo.getSourceType() + "/" + 
					rd;
			System.out.println(sourceMessagePojo.getId());
			
			
			String path1 = "http://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath() + "/" +
					sourceMessagePojo.getSourceType() + "/" + rd;
			System.out.println(path1);
			if(sourceMessagePojo.getId() > 0){
				AreaPojo ap = ssDao.findAreaById(sourceMessagePojo.getId());
				String op = ap.getImgUrl();
				System.out.println(op);
				if(op.contains(path1 + ";")){
					ap.setImgUrl(op.replace(path1 + ";", ""));
					System.out.println(";;;;");
				}else if(!op.contains(path1 + ";") && op.contains(path1)){
					ap.setImgUrl(op.replace(path1, ""));
					System.out.println("-----;;;;");
				}
//				ap.setImgUrl(op);
				System.out.println(ap.getImgUrl());
				ssDao.modifyDB(ap);
			}
			File f = new File(path.substring(1));
			if(f.exists()){
				f.delete();
			}
			sourceMessagePojo.setState("success");
			rp.setAction("history/staticSource/remove");
			rp.setMessage("文件删除成功");
			rp.setState("success");
			//========固件处理开始============
			if(sourceMessagePojo.getSourceType().equals("firmware")){
				String fileName = sourceMessagePojo.getResultData();
				String time = sourceMessagePojo.getUploadTime();
				String user = sourceMessagePojo.getUploadUser();
				String[] parameters = {"history", "firmware", user, time, fileName, "remove"};
				firmwareOperate(parameters);
			}
			//========固件处理结束============
		}catch(Exception e){
			e.printStackTrace();
			sourceMessagePojo.setState("fail");
			rp.setAction("history/staticSource/remove");
			rp.setMessage("文件删除失败");
			rp.setState("success");
		}
		return JSONObject.toJSONString(rp);
	}

	class ResponsePojo{
		private String state;
		private List<String> urls;
		private String fileName;
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public List<String> getUrls() {
			return urls;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public void setUrls(List<String> urls) {
			this.urls = urls;
		}
	}
}
