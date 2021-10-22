package bd.nmam.history.business.serviceimp;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import bd.nmam.history.business.pojo.FirmwarePojo;
import bd.nmam.history.business.service.IFirmWareOperateService;
import bd.nmam.history.feign.FirwareOperateFeign;

@Service("FirmwareOperateServiceImp")
public class FirmwareOperateServiceImp implements IFirmWareOperateService{
	
	@Autowired
	private FirwareOperateFeign fof;
	
	@Override
	public String firmwareUpgrade(FirmwarePojo fp, HttpServletRequest request) {
		// TODO Auto-generated method stub
		fp.setUrl("http://" + request.getLocalAddr() + ":" + request.getLocalPort() + "/history/firmOperate/firmwareDownload");
		return fof.upgrade(fp);
	}

	@Override
	public String firmwareDownload(FirmwarePojo fp, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		try {
			String url = fp.getUrl();
			String firmwareName = fp.getFilewareName();
			String user = fp.getUploadUser();
			String time = fp.getUploadTime();
//			System.out.println(url + "/------" + user + "_" + time + "_" + firmwareName);
			URL lUrl = ClassUtils.getDefaultClassLoader().getResource("");
			File f = new File(lUrl.getPath() + "/static/firmware/" + user + "_" + time + "_" + firmwareName);
			System.out.println(lUrl + "---->>>>" + f.exists());
			
			FileInputStream fis = new FileInputStream(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			while((len = fis.available()) > 0){
				byte[] bit = new byte[len];
				fis.read(bit);
				baos.write(bit, 0, len);
			}
			reponse.reset();
			reponse.addHeader("Content-Length", "" + baos.size());
			reponse.setContentType("application/octet-stream");
			OutputStream os = reponse.getOutputStream();
			os.write(baos.toByteArray());
			os.flush();
			baos.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
