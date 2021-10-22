package bd.nmam.collection.util.jiangxi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import bd.nmam.collection.business.pojo.jiangxi.AlarmPojo;
import bd.nmam.collection.business.pojo.jiangxi.DataPojo;
import bd.nmam.collection.business.pojo.jiangxi.FaceDataPojo;
import bd.nmam.collection.business.pojo.jiangxi.FaceModePojo;

public class ContainerUtil {
	//实时报警缓存
	private static HashMap<String, AlarmPojo> timelyAlarmBuf = new HashMap<String,AlarmPojo>();
	//实时数据缓存
	private static HashMap<String, DataPojo> timelyDataBuf = new HashMap<String, DataPojo>();
	//报警级别缓存
//	private static HashMap<String, String> alarmLVBuf = new HashMap<String,String>();
	//报警信号映射缓存
	private static HashMap<String, String> signal = new HashMap<>();
	// 江西项目硬件设备人脸推送数据
	private static List<FaceDataPojo> FaceDataBuf1 = new ArrayList<FaceDataPojo>();
	private static ReentrantLock faceLock1 = new ReentrantLock();

	private static List<FaceModePojo> FaceModeBuf1 = new ArrayList<FaceModePojo>();
	private static ReentrantLock faceLock2 = new ReentrantLock();
	public static List<FaceDataPojo> getFaceDataBuf1() {
		return FaceDataBuf1;
	}
	public static void setFaceDataBuf1(List<FaceDataPojo> faceDataBuf1) {
		FaceDataBuf1 = faceDataBuf1;
	}

	public static ReentrantLock getFaceLock1() {
		return faceLock1;
	}
	public static void setFaceLock1(ReentrantLock faceLock1) {
		ContainerUtil.faceLock1 = faceLock1;
	}
	public static ReentrantLock getFaceLock2() {
		return faceLock2;
	}
	public static void setFaceLock2(ReentrantLock faceLock2) {
		ContainerUtil.faceLock2 = faceLock2;
	}
	public static HashMap<String, AlarmPojo> getTimelyAlarmBuf() {
		return timelyAlarmBuf;
	}
	public static void setTimelyAlarmBuf(HashMap<String, AlarmPojo> timelyAlarmBuf) {
		ContainerUtil.timelyAlarmBuf = timelyAlarmBuf;
	}

	public static List<FaceModePojo> getFaceModeBuf1() {
		return FaceModeBuf1;
	}
	public static void setFaceModeBuf1(List<FaceModePojo> faceModeBuf1) {
		FaceModeBuf1 = faceModeBuf1;
	}

	public static HashMap<String, String> getSignal() {
		return signal;
	}
//	public static HashMap<String, String> getAlarmLVBuf() {
//		return alarmLVBuf;
//	}
//	public static void setAlarmLVBuf(HashMap<String, String> alarmLVBuf) {
//		ContainerUtil.alarmLVBuf = alarmLVBuf;
//	}
	public static void setSignal(HashMap<String, String> signal) {
		ContainerUtil.signal = signal;
	}
	public static HashMap<String, DataPojo> getTimelyDataBuf() {
		return timelyDataBuf;
	}
	public static void setTimelyDataBuf(HashMap<String, DataPojo> timelyDataBuf) {
		ContainerUtil.timelyDataBuf = timelyDataBuf;
	}
	
	
	
	
	
	
	
}
