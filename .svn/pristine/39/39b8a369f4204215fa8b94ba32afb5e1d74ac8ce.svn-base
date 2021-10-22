package bd.nmam.collection.business.task.jiangxi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.DataPojo;
import bd.nmam.collection.business.pojo.jiangxi.DevicePojo;
import bd.nmam.collection.business.pojo.jiangxi.JXACKPojo;
import bd.nmam.collection.util.jiangxi.ContainerUtil;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class AxleTemperHumDataThread implements Runnable{
	private Object msg;
	private ChannelHandlerContext ctx;
	private final String[] fType = {"axleTemperHumData", "dosageTwhReport", "dosageAsrReport", "temperHumData", "freeElectric", "faceData"};
	private List<String> fTypes = new ArrayList<String>();
	public AxleTemperHumDataThread(ChannelHandlerContext ctx, Object msg){
		this.msg = msg;
		this.ctx = ctx;
		for(String s : fType){
			fTypes.add(s);
		}
	}
	public void run(){
		String data = (String)msg;
		JSONObject jb = JSONObject.parseObject(data);
		String jc1 = jb.getString("fType");
		try{
		if(jc1 != null && fTypes.contains(jc1)){
			ctx.writeAndFlush(Unpooled.copiedBuffer(dataOperate(jb)));
			if(jc1.equals(fTypes.get(0))){
				String gID = jb.getString("gID");
				String dID = jb.getString("dID");
				String fTime = jb.getString("fTime");
				fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
				String temperature = jb.getString("temperature");
				String revolutionspeed = jb.getString("revolutionspeed");
				String electriccurA = jb.getString("electriccurA");
				String electriccurB = jb.getString("electriccurB");
				String electriccurC = jb.getString("electriccurC");
				String totalworktime = jb.getString("totalworktime");
				String worktime = jb.getString("worktime");
				DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
				DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
				dev.setRefreshTime(System.currentTimeMillis());
				p_dev.setRefreshTime(System.currentTimeMillis());
				String[] aikeys = {"temperature","revolutionspeed","electriccurA","electriccurB","electriccurC","totalworktime"};
				DataPojo dp = new DataPojo();
				dp.setDeviceId(dID);
				dp.setParentId(p_dev.getDev_id());
				dp.setDeviceType("" + dev.getDevType());
				dp.setDataModel("AI");
				dp.setDataType(ContainerUtil.getSignal().get(aikeys[0]));
				dp.setDataValue(temperature);
				dp.setDataTime(fTime);
				dp.setAlarmStatus("0");
				dp.setAlarmLv("1");
				DataPojo dp1 = dp.clone();
				dp1.setDataType(ContainerUtil.getSignal().get(aikeys[1]));
				dp1.setDataValue(revolutionspeed);
				DataPojo dp2 = dp.clone();
				dp2.setDataType(ContainerUtil.getSignal().get(aikeys[2]));
				dp2.setDataValue(electriccurA);
				DataPojo dp3 = dp.clone();
				dp3.setDataType(ContainerUtil.getSignal().get(aikeys[3]));
				dp3.setDataValue(electriccurB);
				DataPojo dp4 = dp.clone();
				dp4.setDataType(ContainerUtil.getSignal().get(aikeys[4]));
				dp4.setDataValue(electriccurC);
				DataPojo dp5 = dp.clone();
				dp5.setDataType(ContainerUtil.getSignal().get(aikeys[5]));
				dp5.setDataValue(totalworktime);
				DataPojo dp6 = dp.clone();
				dp6.setDataModel("DI");
				dp6.setDataType(ContainerUtil.getSignal().get("worktime"));
				dp6.setDataValue(worktime);
				JiangXIContainerUtil.dataOperate(dp);
				JiangXIContainerUtil.dataOperate(dp1);
				JiangXIContainerUtil.dataOperate(dp2);
				JiangXIContainerUtil.dataOperate(dp3);
				JiangXIContainerUtil.dataOperate(dp4);
				JiangXIContainerUtil.dataOperate(dp5);
				JiangXIContainerUtil.dataOperate(dp6);
			}else if(jc1.equals(fTypes.get(1))){
				String pID = jb.getString("pID");
				String _fType = fType[1];
				String gID = jb.getString("gID");
				String dID = jb.getString("dID");
				String fTime = jb.getString("fTime");
				fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
				String drug1Val = jb.getString("drug1Val");
				String drug2Val = jb.getString("drug2Val");
				String drug3Val = jb.getString("drug3Val");
				String drug4Val = jb.getString("drug4Val");
				DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
				DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
				dev.setRefreshTime(System.currentTimeMillis());
				p_dev.setRefreshTime(System.currentTimeMillis());
				String[] aikeys = {"drug1Val","drug2Val","drug3Val","drug4Val"};
				DataPojo dp = new DataPojo();
				dp.setDeviceId(dID);
				dp.setParentId(p_dev.getDev_id());
				dp.setDeviceType("" + dev.getDevType());
				dp.setDataModel("AI");
				dp.setDataType(ContainerUtil.getSignal().get(aikeys[0]));
				dp.setDataValue(drug1Val);
				dp.setDataTime(fTime);
				dp.setAlarmStatus("0");
				dp.setAlarmLv("1");
				DataPojo dp1 = dp.clone();
				dp1.setDataType(ContainerUtil.getSignal().get(aikeys[1]));
				dp1.setDataValue(drug2Val);
				DataPojo dp2 = dp.clone();
				dp2.setDataType(ContainerUtil.getSignal().get(aikeys[2]));
				dp2.setDataValue(drug3Val);
				DataPojo dp3 = dp.clone();
				dp3.setDataType(ContainerUtil.getSignal().get(aikeys[3]));
				dp3.setDataValue(drug4Val);
				JiangXIContainerUtil.dataOperate(dp);
				JiangXIContainerUtil.dataOperate(dp1);
				JiangXIContainerUtil.dataOperate(dp2);
				JiangXIContainerUtil.dataOperate(dp3);
			}else if(jc1.equals(fTypes.get(2))){
				String pID = jb.getString("pID");
				String _fType = fType[2];
				String gID = jb.getString("gID");
				String dID = jb.getString("dID");
				String fTime = jb.getString("fTime");
				fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
				String drug1Val = jb.getString("drug1Val");
				String drug2Val = jb.getString("drug2Val");
				String drug3Val = jb.getString("drug3Val");
				String drug4Val = jb.getString("drug4Val");
				DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
				DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
				dev.setRefreshTime(System.currentTimeMillis());
				p_dev.setRefreshTime(System.currentTimeMillis());
				String[] aikeys = {"_drug1Val","_drug2Val","_drug3Val","_drug4Val"};
				DataPojo dp = new DataPojo();
				dp.setDeviceId(dID);
				dp.setParentId(p_dev.getDev_id());
				dp.setDeviceType("" + dev.getDevType());
				dp.setDataModel("AI");
				dp.setDataType(ContainerUtil.getSignal().get(aikeys[0]));
				dp.setDataValue(drug1Val);
				dp.setDataTime(fTime);
				dp.setAlarmStatus("0");
				dp.setAlarmLv("1");
				DataPojo dp1 = dp.clone();
				dp1.setDataType(ContainerUtil.getSignal().get(aikeys[1]));
				dp1.setDataValue(drug2Val);
				DataPojo dp2 = dp.clone();
				dp2.setDataType(ContainerUtil.getSignal().get(aikeys[2]));
				dp2.setDataValue(drug3Val);
				DataPojo dp3 = dp.clone();
				dp3.setDataType(ContainerUtil.getSignal().get(aikeys[3]));
				dp3.setDataValue(drug4Val);
				JiangXIContainerUtil.dataOperate(dp);
				JiangXIContainerUtil.dataOperate(dp1);
				JiangXIContainerUtil.dataOperate(dp2);
				JiangXIContainerUtil.dataOperate(dp3);
			}else if(jc1.equals(fTypes.get(3))){
				String pID = jb.getString("pID");
				String _fType = fType[3];
				String gID = jb.getString("gID");
				String dID = jb.getString("dID");
				String fTime = jb.getString("fTime");
				fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
				String temperature = jb.getString("temperature");
				String humidity = jb.getString("humidity");
				DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
				DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
				dev.setRefreshTime(System.currentTimeMillis());
				p_dev.setRefreshTime(System.currentTimeMillis());
				String[] aikeys = {"_temperature","humidity"};
				DataPojo dp = new DataPojo();
				dp.setDeviceId(dID);
				dp.setParentId(p_dev.getDev_id());
				dp.setDeviceType("" + dev.getDevType());
				dp.setDataModel("AI");
				dp.setDataType(ContainerUtil.getSignal().get(aikeys[0]));
				dp.setDataValue(temperature);
				dp.setDataTime(fTime);
				dp.setAlarmStatus("0");
				dp.setAlarmLv("1");
				DataPojo dp1 = dp.clone();
				dp1.setDataType(ContainerUtil.getSignal().get(aikeys[1]));
				dp1.setDataValue(humidity);
				JiangXIContainerUtil.dataOperate(dp);
				JiangXIContainerUtil.dataOperate(dp1);
			}else if(jc1.equals(fTypes.get(4))){
				String pID = jb.getString("pID");
				String _fType = fType[3];
				String gID = jb.getString("gID");
				String dID = jb.getString("dID");
				String fTime = jb.getString("fTime");
				fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
				String freeStatus = jb.getString("freeStatus");
				DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
				DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
				dev.setRefreshTime(System.currentTimeMillis());
				p_dev.setRefreshTime(System.currentTimeMillis());
				DataPojo dp = new DataPojo();
				dp.setDeviceId(dID);
				dp.setParentId(p_dev.getDev_id());
				dp.setDeviceType("" + dev.getDevType());
				dp.setDataModel("AI");
				dp.setDataType(ContainerUtil.getSignal().get("freeStatus"));
				dp.setDataValue(freeStatus);
				dp.setDataTime(fTime);
				dp.setAlarmStatus("0");
				dp.setAlarmLv("1");
				JiangXIContainerUtil.dataOperate(dp);
			}
		}else{
			ctx.fireChannelRead(msg);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private byte[] dataOperate(JSONObject jb) {
		String pID = jb.get("pID").toString();
		String fType = "sensorData_ack";
		String gID = jb.getString("gID").toString();
		String dID = jb.getString("dID").toString();
		String status = "OK";
		String rtnCode = "0";
		JXACKPojo jxa = new JXACKPojo();
		jxa.setpID(pID);
		jxa.setfType(fType);
		jxa.setgID(gID);
		jxa.setdID(dID);
		jxa.setStatus(status);
		jxa.setRtnCode(rtnCode);
		JSONObject json = (JSONObject) JSONObject.toJSON(jxa);
		String jsonStr = json.toString();
		return jsonStr.getBytes();
	}
	public String dateTrans(SimpleDateFormat oldFormat, SimpleDateFormat newFormat, String date) throws Exception{
		  return newFormat.format(oldFormat.parse(date));
	}
}
