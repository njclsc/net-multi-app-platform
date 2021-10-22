package bd.nmam.collection.business.task.jiangxi;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.AlarmPojo;
import bd.nmam.collection.business.pojo.jiangxi.DevicePojo;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.channel.ChannelHandlerContext;

public class CameraDataOperateThread implements Runnable{
	private Object msg;
	private ChannelHandlerContext ctx;
	public CameraDataOperateThread(ChannelHandlerContext ctx, Object msg){
		this.msg = msg;
		this.ctx = ctx;
	}
	public void run(){
		String data = (String) msg;
		for (String s : data.split("\\}\\{")) {
			if (!s.endsWith("}")) {
				s = s + "}";
			} 
			if (!s.startsWith("{")) {
				s = "{" + s;
			}
			System.out.println("--->>>" + s);
			JSONObject jb = JSONObject.parseObject(s);
			String cameraId = jb.getString("cameraId");
			if(cameraId != null && !cameraId.equals("")){
				DevicePojo dp = JiangXIContainerUtil.getDevices().get(cameraId);
				String alarmImg = jb.getString("alarmImage");
				String alarmStatus = jb.getString("msgType");
				String alarmType = jb.getString("alarmType");
				String alarmTime = jb.getString("alarmTime");
				String manageState = "0";
				if(alarmStatus.equals("2")){
					alarmStatus = "1";
				}else if(alarmStatus.equals("3")){
					alarmStatus = "0";
					manageState = "1";
				}
				String alarmLv = "";
				if(JiangXIContainerUtil.getAlarmLVBuf().containsKey(alarmType)){
					alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(alarmType);
				}else{
					alarmLv = "1";
				}
				String deviceType = "视频设备";
				String obj = jb.getString("alarmContent");
				if(obj != null && !obj.equals("")){
					JSONObject jc2 = JSONObject.parseObject(obj);
					String Number = jc2.getString("number");
					String LmtNum = jc2.getString("Lmt_num");
					String OutNum = jc2.getString("Out_num");
					deviceType = deviceType + "_"+Number+"_"+LmtNum+"_"+OutNum;
				}
				AlarmPojo ap = new AlarmPojo();
				ap.setDeviceId(cameraId);
				ap.setParentId("0");
				ap.setDeviceType("3");
				ap.setAlarmType(alarmType);
				ap.setAlarmStatus(alarmStatus);
				ap.setAlarmTime(alarmTime);
				ap.setAlarmImg(alarmImg);
				ap.setAlarmLv(alarmLv);
				ap.setAlarmDuration("0秒");
				ap.setManageState(manageState);
				dp.setRefreshTime(System.currentTimeMillis());
				try {
					JiangXIContainerUtil.alarmOperate(ap);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				ctx.fireChannelRead(msg);
			}
			
		}
	}
}
