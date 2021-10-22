package bd.nmam.collection.business.task.jiangxi;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.FaceDataPojo;
import bd.nmam.collection.business.pojo.jiangxi.FaceModePojo;
import bd.nmam.collection.business.pojo.jiangxi.JXACKPojo;
import bd.nmam.collection.config.BusinessOperateConfig;
import bd.nmam.collection.util.jiangxi.ContainerUtil;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class OperateDataTask implements Runnable{
	private final String fType1 = "faceData";
	private final String fType2 = "faceModeGet_ack";
	private Object msg;
	private ChannelHandlerContext ctx;
	public OperateDataTask(ChannelHandlerContext ctx, Object msg){
		this.msg = msg;
		this.ctx = ctx;
	}
	
	public void run(){
//		try{
//		String data = (String)msg;
//		JSONObject jb = JSONObject.parseObject(data);
//		String fType = jb.getString("fType");
//		if((fType != null) && (!fType.equals(fType1)) && (!fType.equals("fType2"))){
//			ctx.fireChannelRead(msg);
//		}else{
//			if(fType.equals(fType1)){
//				String fTime = JiangXIContainerUtil.sdfStand.format(JiangXIContainerUtil.sdfHard.parse(jb.getString("fTime")));
//				JSONArray jarry = JSONArray.parseArray(jb.getString("faceDetection"));
//				JSONObject jb1 = JSONObject.parseObject(JSONObject.toJSONString(jarry.get(0)));
//				if(jb1 != null){
//					String dID = jb1.getString("dID");
//					String result = jb1.getString("result");
//					String name = jb1.getString("name");
//					FaceDataPojo fdp = new FaceDataPojo();
//					fdp.setdID(dID);
//					fdp.setName(name);
//					fdp.setResult(result);
//					fdp.setfTime(fTime);
//					switch (ContainerUtil.getFaceDataFlag()) {
//					case 1:
//						ContainerUtil.getFaceDataBuf1().add(fdp);
//						break;
//					case 2:
//						ContainerUtil.getFaceDataBuf2().add(fdp);
//						break;
//
//					}
//				}
//				ctx.writeAndFlush(Unpooled.copiedBuffer(dataOperate(jb)));
//			}else if(fType.equals(fType2)){
//				JSONObject jb1 = JSONObject.parseObject(jb.getString("faceMode"));
//				JSONArray jarry = JSONArray.parseArray(jb1.getString("people"));
//				if(jarry.size() > 0){
//					for(int i = 0; i < jarry.size(); i++){
//						JSONObject jb2 = JSONObject.parseObject(jarry.getString(i));
//						String name = jb2.getString("name");
//						FaceModePojo fmp= new FaceModePojo();
//						fmp.setName(name);
//						switch (ContainerUtil.getFaceDataFlag()) {
//						case 1:
//							ContainerUtil.getFaceModeBuf1().add(fmp);
//							break;
//						case 2:
//							ContainerUtil.getFaceModeBuf2().add(fmp);
//							break;
//
//						}
//					}
//				}
//			}
//		}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	private byte[] dataOperate(JSONObject jb) {
		String pID = jb.get("pID").toString();
		String fType = "faceData_ack";
		String gID = jb.getString("gID").toString();
		String status = "OK";
		String rtnCode = "0";
		JXACKPojo jxa = new JXACKPojo();
		jxa.setpID(pID);
		jxa.setfType(fType);
		jxa.setgID(gID);
		jxa.setStatus(status);
		jxa.setRtnCode(rtnCode);
		JSONObject json = JSONObject.parseObject(JSONObject.toJSON(jxa).toString());
		String jsonStr = json.toString();
		return jsonStr.getBytes();
	}
}
