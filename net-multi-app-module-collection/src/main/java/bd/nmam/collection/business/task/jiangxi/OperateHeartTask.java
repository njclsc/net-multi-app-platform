package bd.nmam.collection.business.task.jiangxi;

import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.JXHeartACKDataPojo;
import bd.nmam.collection.business.pojo.jiangxi.JXHeartACKPojo;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class OperateHeartTask implements Runnable{
	private Object msg;
	private ChannelHandlerContext ctx;
	private final String fType = "heartBeat";
	public OperateHeartTask(ChannelHandlerContext ctx, Object msg){
		this.msg = msg;
		this.ctx = ctx;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String data = (String)msg;
		JSONObject jb = JSONObject.parseObject(data);
		String jc1 = jb.getString("fType");
		if((jc1 != null) && (!jc1.equals(fType))){
			ctx.fireChannelRead(msg);
		}else{
			ctx.writeAndFlush(Unpooled.copiedBuffer(operate(jb)));
		}
	}
	private byte[] operate(JSONObject jb) {
		String pID = jb.get("pID").toString();
		String fType = "heartBeat_ack";
		String gID = jb.getString("gID").toString();
		String status = "OK";
		String rtnCode = "0";
		String fwVer = "1.0.0";
		String upgrade = "N";
		JXHeartACKDataPojo data = new JXHeartACKDataPojo();
		data.setFwVer(fwVer);
		data.setUpgrade(upgrade);
		JXHeartACKPojo jxha = new JXHeartACKPojo();
		jxha.setpID(pID);
		jxha.setfType(fType);
		jxha.setgID(gID);
		jxha.setStatus(status);
		jxha.setRtnCode(rtnCode);
		jxha.setData(data);
		JSONObject json = (JSONObject) JSONObject.toJSON(jxha);
		String jsonStr = json.toString();
		return jsonStr.getBytes();
	}
}
