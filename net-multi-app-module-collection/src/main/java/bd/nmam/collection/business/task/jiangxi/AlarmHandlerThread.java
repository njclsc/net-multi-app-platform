package bd.nmam.collection.business.task.jiangxi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.AlarmPojo;
import bd.nmam.collection.business.pojo.jiangxi.DataPojo;
import bd.nmam.collection.business.pojo.jiangxi.DevicePojo;
import bd.nmam.collection.business.pojo.jiangxi.JXACKPojo;
import bd.nmam.collection.util.jiangxi.ContainerUtil;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class AlarmHandlerThread implements Runnable{
	private Object msg;
	private ChannelHandlerContext ctx;
	private final String[] _fType = {"axleTemperHumAlarm", "dosageTwhAlarm", "dosageAsrTwhAlarm", "temperHumAlarm", "freeElectricAlarm"};
//	private Connection con;
	private List<String> fType = new ArrayList<String>();
	public AlarmHandlerThread(ChannelHandlerContext ctx, Object msg) {
		this.msg = msg;
		this.ctx = ctx;
		for(String s : _fType){
			fType.add(s);
		}
//		System.out.println("xxx" + fType.get(0));
	}
	public void run(){
		try{
			String data = (String)msg;
			JSONObject jb = JSONObject.parseObject(data);
			String jc1 = jb.getString("fType");
//			System.out.println(jc1 + "  " + fType.contains(jc1));
			if(jc1 != null && fType.contains(jc1)){
				ctx.writeAndFlush(Unpooled.copiedBuffer(alarmOperate(jb)));
				if(jc1.equals(fType.get(0))){
					String pID = jb.getString("pID");
					String _fType = fType.get(0);
					String gID = jb.getString("gID");
					String dID = jb.getString("dID");
					String fTime = jb.getString("fTime");
					fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
					String temperature = jb.getString("temperature");
					String tempWarFlag = jb.getString("tempWarFlag");
					String totalworktime = jb.getString("totalworktime");
					String totalworkOverTimeFlag = jb.getString("totalworkOverTimeFlag");
					String worktime = jb.getString("worktime");
					String workTimeoutWarFlag = jb.getString("workTimeoutWarFlag");
					DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
					DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
					//报警
					String[] alkeys = {"tempWarFlag","totalworkOverTimeFlag","workTimeoutWarFlag"};
					String alarmLv = "1";
					String manage_state = "0";
					if(tempWarFlag.equals("0")){
						manage_state = "1";
					}
					if(ContainerUtil.getSignal().containsKey(alkeys[0])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[0]));
					}
					AlarmPojo ap = new AlarmPojo();
					ap.setDeviceId(dID);
					ap.setParentId(p_dev.getDev_id());
					ap.setDeviceType("" + dev.getDevType());
					ap.setAlarmType(ContainerUtil.getSignal().get(alkeys[0]));
					ap.setAlarmStatus(tempWarFlag);
					ap.setManageState(manage_state);
					ap.setAlarmTime(fTime);
					ap.setAlarmImg(null);
					ap.setAlarmLv(alarmLv);
					ap.setAlarmDuration("0秒");
					AlarmPojo ap1 = ap.clone();
					String alarmLv1 = "1";
					if(ContainerUtil.getSignal().containsKey(alkeys[1])){
						alarmLv1 = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[1]));
					}
					ap1.setAlarmLv(alarmLv1);
					ap1.setAlarmType(ContainerUtil.getSignal().get(alkeys[1]));
					ap1.setAlarmStatus(totalworkOverTimeFlag);
					
					AlarmPojo ap2 = ap.clone();
					String alarmLv2 = "1";
					if(ContainerUtil.getSignal().containsKey(alkeys[2])){
						alarmLv2 = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[2]));
					}
					ap2.setAlarmLv(alarmLv2);
					ap2.setAlarmType(ContainerUtil.getSignal().get(alkeys[2]));
					ap2.setAlarmStatus(workTimeoutWarFlag);
					
					dev.setRefreshTime(System.currentTimeMillis());
					p_dev.setRefreshTime(System.currentTimeMillis());
					JiangXIContainerUtil.alarmOperate(ap);
					JiangXIContainerUtil.alarmOperate(ap1);
					JiangXIContainerUtil.alarmOperate(ap2);
					//数据AI
					DataPojo dp = new DataPojo();
					String[] aikeys = {"temperature","totalworktime", "worktime"};
					dp.setParentId(p_dev.getDev_id());
					dp.setDeviceId(dID);
					dp.setDeviceType("" + dev.getDevType());
					dp.setDataModel("AI");
					dp.setDataType(ContainerUtil.getSignal().get(aikeys[0]));
					dp.setDataValue(temperature);
					dp.setDataTime(fTime);
					DataPojo dp1 = dp.clone();
					dp1.setDataType(ContainerUtil.getSignal().get(aikeys[1]));
					dp1.setDataValue(totalworktime);
					//数据DI
					DataPojo dp2 = dp.clone();
					dp2.setDataModel("DI");
					dp2.setDataType(ContainerUtil.getSignal().get(aikeys[2]));
					dp2.setDataValue(worktime);
					System.out.println(dp.getDeviceType());
					JiangXIContainerUtil.dataOperate(dp);
					JiangXIContainerUtil.dataOperate(dp1);
					JiangXIContainerUtil.dataOperate(dp2);
				}else if(jc1.equals(fType.get(1))){
					String pID = jb.getString("pID");
					String _fType = fType.get(1);
					String gID = jb.getString("gID");
					String dID = jb.getString("dID");
					String fTime = jb.getString("fTime");
					fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
					String drug1Val = jb.getString("drug1Val");
					String drug2Val = jb.getString("drug2Val");
					String drug3Val = jb.getString("drug3Val");
					String drug4Val = jb.getString("drug4Val");
					String drug1WarFlag = jb.getString("drug1WarFlag");
					String drug2WarFlag = jb.getString("drug2WarFlag");
					String drug3WarFlag = jb.getString("drug3WarFlag");
					String drug4WarFlag = jb.getString("drug4WarFlag");
					DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
					DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
					String[] alkeys = {"drug1WarFlag","drug2WarFlag","drug3WarFlag","drug4WarFlag"};
					String alarmLv = "1";
					String manage_state = "0";
					if(drug1WarFlag.equals("0")){
						manage_state = "1";
					}
					if(ContainerUtil.getSignal().containsKey(alkeys[0])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[0]));
					}
					AlarmPojo ap = new AlarmPojo();
					ap.setDeviceId(dID);
					ap.setParentId(p_dev.getDev_id());
					ap.setDeviceType("" + dev.getDevType());
					ap.setAlarmType(ContainerUtil.getSignal().get(alkeys[0]));
					ap.setAlarmStatus(drug1WarFlag);
					ap.setManageState(manage_state);
					ap.setAlarmTime(fTime);
					ap.setAlarmImg(null);
					ap.setAlarmLv("1");//*************************************************
					ap.setAlarmDuration("0秒");
					AlarmPojo ap1 = ap.clone();
					ap1.setAlarmType(ContainerUtil.getSignal().get(alkeys[1]));
					ap1.setAlarmStatus(drug2WarFlag);
					String manage_state2 = "0";
					if(drug2WarFlag.equals("0")){
						manage_state2 = "1";
					}
					if(ContainerUtil.getSignal().containsKey(alkeys[1])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[1]));
					}
					ap1.setManageState(manage_state2);
					ap1.setAlarmLv("1");//*************************************************
					
					AlarmPojo ap2 = ap.clone();
					ap2.setAlarmType(ContainerUtil.getSignal().get(alkeys[2]));
					ap2.setAlarmStatus(drug3WarFlag);
					String manage_state3 = "0";
					if(drug3WarFlag.equals("0")){
						manage_state3 = "1";
					}
					if(ContainerUtil.getSignal().containsKey(alkeys[2])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[2]));
					}
					ap1.setManageState(manage_state3);
					ap1.setAlarmLv("1");//*************************************************
					
					AlarmPojo ap3 = ap.clone();
					ap3.setAlarmType(ContainerUtil.getSignal().get(alkeys[3]));
					ap3.setAlarmStatus(drug4WarFlag);
					String manage_state4 = "0";
					if(drug4WarFlag.equals("0")){
						manage_state4 = "1";
					}
					if(ContainerUtil.getSignal().containsKey(alkeys[3])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[3]));
					}
					ap3.setManageState(manage_state4);
					ap3.setAlarmLv("1");//*************************************************
					dev.setRefreshTime(System.currentTimeMillis());
					p_dev.setRefreshTime(System.currentTimeMillis());
					JiangXIContainerUtil.alarmOperate(ap);
					JiangXIContainerUtil.alarmOperate(ap1);
					JiangXIContainerUtil.alarmOperate(ap2);
					JiangXIContainerUtil.alarmOperate(ap3);
					
					String[] aikeys = {"drug1Val","drug2Val","drug3Val","drug4Val"};
					DataPojo dp = new DataPojo();
					dp.setDeviceId(dID);
					dp.setParentId(p_dev.getDev_id());
					dp.setDeviceType("" + dev.getDevType());
					dp.setDataModel("AI");
					dp.setDataType(aikeys[0]);
					dp.setDataValue(drug1Val);
					dp.setDataTime(fTime);
					dp.setAlarmLv("1");
					dp.setAlarmStatus("0");
					DataPojo dp1 = dp.clone();
					dp1.setDataType(aikeys[1]);
					dp1.setDataValue(drug2Val);
					DataPojo dp2 = dp.clone();
					dp2.setDataType(aikeys[2]);
					dp2.setDataValue(drug3Val);
					DataPojo dp3 = dp.clone();
					dp3.setDataType(aikeys[3]);
					dp3.setDataValue(drug4Val);
					JiangXIContainerUtil.dataOperate(dp);
					JiangXIContainerUtil.dataOperate(dp1);
					JiangXIContainerUtil.dataOperate(dp2);
					JiangXIContainerUtil.dataOperate(dp3);
				}else if(jc1.equals(fType.get(2))){
					String pID = jb.getString("pID");
					String _fType = fType.get(2);
					String gID = jb.getString("gID");
					String dID = jb.getString("dID");
					String fTime = jb.getString("fTime");
					fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
					String drug1Val = jb.getString("drug1Val");
					String drug2Val = jb.getString("drug2Val");
					String drug3Val = jb.getString("drug3Val");
					String drug4Val = jb.getString("drug4Val");
					String drug1WarFlag = jb.getString("drug1WarFlag");
					String drug2WarFlag = jb.getString("drug2WarFlag");
					String drug3WarFlag = jb.getString("drug3WarFlag");
					String drug4WarFlag = jb.getString("drug4WarFlag");
					DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
					DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
					String[] alkeys = {"_drug1WarFlag","_drug2WarFlag","_drug3WarFlag","_drug4WarFlag"};
					String alarmLv = "1";
					String manage_state = "0";
					if(ContainerUtil.getSignal().containsKey(alkeys[0])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[0]));
					}
					if(drug1WarFlag.equals("0")){
						manage_state = "1";
					}
					AlarmPojo ap = new AlarmPojo();
					ap.setDeviceId(dID);
					ap.setParentId("" + p_dev.getDev_id());
					ap.setDeviceType("" + dev.getDevType());
					ap.setAlarmType(ContainerUtil.getSignal().get(alkeys[0]));
					ap.setAlarmStatus(drug1WarFlag);
					ap.setAlarmTime(fTime);
					ap.setAlarmImg(null);
					ap.setAlarmLv("1");//*************************************************
					ap.setAlarmDuration("0秒");
					ap.setManageState(manage_state);
					dev.setRefreshTime(System.currentTimeMillis());
					p_dev.setRefreshTime(System.currentTimeMillis());
					AlarmPojo ap1 = ap.clone();
					String alarmLv1 = "1";
					String manage_state1 = "0";
					if(ContainerUtil.getSignal().containsKey(alkeys[1])){
						alarmLv1 = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[1]));
					}
					if(drug2WarFlag.equals("0")){
						manage_state1 = "1";
					}
					ap1.setAlarmType(ContainerUtil.getSignal().get(alkeys[1]));
					ap1.setAlarmStatus(drug2WarFlag);
					ap1.setAlarmLv("1");//*************************************************
					ap1.setManageState(manage_state1);
					AlarmPojo ap2 = ap.clone();
					String alarmLv2 = "1";
					String manage_state2 = "0";
					if(ContainerUtil.getSignal().containsKey(alkeys[2])){
						alarmLv2 = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[2]));
					}
					if(drug3WarFlag.equals("0")){
						manage_state2 = "1";
					}
					ap2.setAlarmType(ContainerUtil.getSignal().get(alkeys[2]));
					ap2.setAlarmStatus(drug3WarFlag);
					ap2.setAlarmLv("1");//*************************************************
					ap2.setManageState(manage_state2);
					AlarmPojo ap3 = ap.clone();
					String alarmLv3 = "1";
					String manage_state3 = "0";
					if(ContainerUtil.getSignal().containsKey(alkeys[3])){
						alarmLv3 = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[3]));
					}
					if(drug3WarFlag.equals("0")){
						manage_state3 = "1";
					}
					ap3.setAlarmType(ContainerUtil.getSignal().get(alkeys[3]));
					ap3.setAlarmStatus(drug4WarFlag);
					ap3.setAlarmLv("1");//*************************************************
					ap3.setManageState(manage_state3);
					JiangXIContainerUtil.alarmOperate(ap);
					JiangXIContainerUtil.alarmOperate(ap1);
					JiangXIContainerUtil.alarmOperate(ap2);
					JiangXIContainerUtil.alarmOperate(ap3);
					
					String[] aikeys = {"_drug1Val","_drug2Val","_drug3Val","_drug4Val"};
					DataPojo dp = new DataPojo();
					dp.setDeviceId(dID);
					dp.setParentId(p_dev.getDev_id());
					dp.setDataModel("AI");
					dp.setDeviceType("" + dev.getDevType());
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
				}else if(jc1.equals(fType.get(3))){
					String pID = jb.getString("pID");
					String gID = jb.getString("gID");
					String dID = jb.getString("dID");
					String fTime = jb.getString("fTime");
					fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
					String tempWarFlag = jb.getString("tempWarFlag");
					String temperature = jb.getString("temperature");
					String humdFlag = jb.getString("humdFlag");
					String humidity = jb.getString("humidity");
					DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
					DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
					String[] alkeys = {"_tempWarFlag","humdFlag"};
					String alarmLv = "1";
					String manage_state = "0";
					if(ContainerUtil.getSignal().containsKey(alkeys[0])){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[0]));
					}
					if(tempWarFlag.equals("0")){
						manage_state = "1";
					}
					AlarmPojo ap = new AlarmPojo();
					ap.setDeviceId(dID);
					ap.setParentId("" + p_dev.getDev_id());
					ap.setDeviceType("" + dev.getDevType());
					ap.setAlarmType(ContainerUtil.getSignal().get(alkeys[0]));
					ap.setAlarmStatus(tempWarFlag);
					ap.setAlarmTime(fTime);
					ap.setAlarmImg(null);
					ap.setAlarmLv("1");//*************************************************
					ap.setAlarmDuration("0秒");
					ap.setManageState(manage_state);
					dev.setRefreshTime(System.currentTimeMillis());
					p_dev.setRefreshTime(System.currentTimeMillis());
					AlarmPojo ap1 = ap.clone();
					String alarmLv1 = "1";
					String manage_state1 = "0";
					if(ContainerUtil.getSignal().containsKey(alkeys[1])){
						alarmLv1 = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get(alkeys[1]));
					}
					if(tempWarFlag.equals("0")){
						manage_state1 = "1";
					}
					ap1.setAlarmType(ContainerUtil.getSignal().get(alkeys[1]));
					ap1.setAlarmStatus(humdFlag);
					ap1.setAlarmLv("1");//*************************************************
					ap.setManageState(manage_state);
					JiangXIContainerUtil.alarmOperate(ap);
					JiangXIContainerUtil.alarmOperate(ap1);
					String[] aikeys = {"_temperature","humidity"};
					DataPojo dp = new DataPojo();
					dp.setDeviceId(dID);
					dp.setParentId(p_dev.getDev_id());
					dp.setDataModel("AI");
					dp.setDeviceType("" + dev.getDevType());
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
				}if(jc1.equals(fType.get(4))){
					String pID = jb.getString("pID");
					String gID = jb.getString("gID");
					String dID = jb.getString("dID");
					String fTime = jb.getString("fTime");
					fTime = dateTrans(JiangXIContainerUtil.getSdfHard(), JiangXIContainerUtil.getSdfStand(), fTime);
					String freeFlag = jb.getString("freeFlag");
					String freeStatus = jb.getString("freeStatus");
					DevicePojo p_dev = JiangXIContainerUtil.getDevices().get(gID);
					DevicePojo dev = JiangXIContainerUtil.getDevices().get(gID).getClientDev().get(dID);
					String alarmLv = "1";
					String manage_state = "0";
					if(freeFlag.equals("0")){
						manage_state = "1";
					}
					if(ContainerUtil.getSignal().containsKey("freeFlag")){
						alarmLv = JiangXIContainerUtil.getAlarmLVBuf().get(ContainerUtil.getSignal().get("freeFlag"));
					}
					AlarmPojo ap = new AlarmPojo();
					ap.setDeviceId(dID);
					ap.setParentId("" + p_dev.getDev_id());
					ap.setDeviceType("" + dev.getDevType());
					ap.setAlarmType(ContainerUtil.getSignal().get("freeFlag"));
					ap.setAlarmStatus(freeFlag);
					ap.setAlarmTime(fTime);
					ap.setAlarmImg(null);
					ap.setAlarmLv("1");//*************************************************
					ap.setAlarmDuration("0秒");
					ap.setManageState(manage_state);
					dev.setRefreshTime(System.currentTimeMillis());
					p_dev.setRefreshTime(System.currentTimeMillis());
					JiangXIContainerUtil.alarmOperate(ap);
					DataPojo dp = new DataPojo();
					dp.setDeviceId(dID);
					dp.setParentId(p_dev.getDev_id());
					dp.setDataModel("DI");
					dp.setDeviceType("" + dev.getDevType());
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
	private byte[] alarmOperate(JSONObject jb) {
		String pID = jb.get("pID").toString();
		String fType = "sensorAlarm_ack";
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
