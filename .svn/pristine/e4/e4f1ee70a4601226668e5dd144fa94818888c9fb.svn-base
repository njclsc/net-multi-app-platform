package bd.nmam.collection.business.mvc.aed.serviceimp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import bd.nmam.collection.business.feign.aed.FirmwareOperateFeign;
import bd.nmam.collection.business.mvc.aed.service.IFirmwareUpgradeService;
import bd.nmam.collection.business.pojo.aed.FirmwarePojo;

@Service("FirmwareUpgradeServiceImp")
public class FirmwareUpgradeServiceImp implements IFirmwareUpgradeService{
	@Autowired
	private FirmwareOperateFeign fof;
	private long len = 0;
	@Override
	public void firmwareDownload(FirmwarePojo fp) {
		// TODO Auto-generated method stub
		System.out.println("固件获取开始....");
		
		new Thread(){
			public void run(){
				byte[] s = fof.firmwareDownload(fp);
				len += s.length;
				String url = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/firmware/";
				System.out.println(url);
				File f = new File(url + fp.getFilewareName());
				try {
					if(!f.getParentFile().exists()){
						f.getParentFile().mkdirs();
						f.createNewFile();
					}
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(s);
					fos.flush();
					fos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}

}
