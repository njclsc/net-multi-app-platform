package bd.nmam.collection.business.task.jiangxi;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.JXAlarmPojo;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.channel.ChannelHandlerContext;

public class AlarmOperateTask implements Runnable {
	private Object msg;
	private ChannelHandlerContext ctx;
	public AlarmOperateTask(ChannelHandlerContext ctx, Object msg) {
		this.msg = msg;
		this.ctx = ctx;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String data = (String) msg;
		for (String s : data.split("\\}\\{")) {
			if (!s.endsWith("}")) {
				s = s + "}";
			} 
			if (!s.startsWith("{")) {
				s = "{" + s;
			}
			JSONObject jb = JSONObject.parseObject(s);
			String cameraId = jb.getString("cameraId");
			String fType = jb.getString("fType");
			if(cameraId != null){
				String deviceId = JiangXIContainerUtil.getCameraBandbuf().get(cameraId);
				String alarmImg = jb.getString("alarmImage");
				String alarmStatus = jb.getString("msgType");
				String alarmType = jb.getString("alarmType");
				String alarmTime = jb.getString("alarmTime");
				String manageState = "0";
				//报警状态
				if(alarmStatus.equals("2")){
					alarmStatus = "1";
				}else if(alarmStatus.equals("3")){
					alarmStatus = "0";
					manageState = "1";
				}
				//报警级别
				String alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(alarmType);
				if(alarmLv == null || alarmLv.equals("")){
					 alarmLv = "1";
				}
				//人数告警增加显示参数
				String deviceType = "视频设备";
				JSONObject json = JSONObject.parseObject(jb.getString("alarmContent"));
				if(json != null){
					String number = json.getString("number");
					String lmtNum = json.getString("Lmt_num");
					String outNum = json.getString("Out_num");
					deviceType = deviceType + "_" + number + "_" + lmtNum + "_" + outNum;
				}
				JXAlarmPojo jxap = new JXAlarmPojo();
				jxap.setDEVICE_ID(deviceId);
				jxap.setDEVICE_DID(cameraId);
				jxap.setDEVICE_TYPE(deviceType);
				jxap.setALARM_TYPE(alarmType);
				jxap.setALARM_STATUS(alarmStatus);
				jxap.setALARM_TIME(alarmTime);
				jxap.setALARM_IMG(alarmImg);
				jxap.setALARM_LV(alarmLv);
				jxap.setALARM_DURATION("0秒");
				jxap.setMANAGE_STATE(manageState);
				
			}else if(fType != null){
				ctx.fireChannelRead(msg);
			}
			System.out.println(jb.toJSONString());
		}
	}

}
