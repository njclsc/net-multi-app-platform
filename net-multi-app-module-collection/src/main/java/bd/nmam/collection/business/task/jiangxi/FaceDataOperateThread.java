package bd.nmam.collection.business.task.jiangxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.FaceDataPojo;
import bd.nmam.collection.business.pojo.jiangxi.FaceModePojo;
import bd.nmam.collection.business.pojo.jiangxi.JXACKPojo;
import bd.nmam.collection.config.Configuer;
import bd.nmam.collection.util.jiangxi.JiangXIContainerUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class FaceDataOperateThread implements Runnable{
	private ChannelHandlerContext ctx;
	private Object msg;
	private final String fType1 = "faceData";
	private final String fType2 = "faceModeGet_ack";
	private DataSource dataSource;
	private Connection con;
	public FaceDataOperateThread(ChannelHandlerContext ctx, Object msg){
		this.ctx = ctx;
		this.msg = msg;
		this.dataSource = Configuer.getDataSource();
		
	}
	public void run(){
		try{
			this.con = dataSource.getConnection();
			String data = (String)msg;
			JSONObject jb = JSONObject.parseObject(data);
			String fType = jb.getString("fType");
			if(fType != null && !fType.equals(fType1) && !fType.equals(fType2)){
				ctx.fireChannelRead(msg);
			}else{
				
				if(fType.equals(fType1)){
					String fTime = JiangXIContainerUtil.sdfStand.format(JiangXIContainerUtil.sdfHard.parse(jb.getString("fTime")));
					JSONArray jarry = JSONArray.parseArray(jb.getString("faceDetection"));
					JSONObject jb1 = JSONObject.parseObject(JSONObject.toJSONString(jarry.get(0)));
					if(jb1 != null){
						String dID = jb1.getString("dID");
						String result = jb1.getString("result");
						String name = jb1.getString("name");
						FaceDataPojo fdp = new FaceDataPojo();
						fdp.setdID(dID);
						fdp.setName(name);
						fdp.setResult(result);
						fdp.setfTime(fTime);
						saveFaceData(fdp);
					}
					ctx.writeAndFlush(Unpooled.copiedBuffer(dataOperate(jb)));
				}else if(fType.equals(fType2)){
					JSONObject jb1 = JSONObject.parseObject(jb.getString("faceMode"));
					JSONArray jarry = JSONArray.parseArray(jb1.getString("people"));
					if(jarry.size() > 0){
						StringBuffer sql = new StringBuffer();
						sql.append("insert into tb_facemode (name) values ");
						for(int i = 0; i < jarry.size(); i++){
							JSONObject jb2 = JSONObject.parseObject(jarry.getString(i));
							String name = jb2.getString("name");
//							FaceModePojo fmp= new FaceModePojo();
//							fmp.setName(name);
							sql.append("('");sql.append(name);sql.append("'),");
						}
						System.out.println(sql.toString());
						sql.deleteCharAt(sql.lastIndexOf(","));
						System.out.println(sql.toString());
						saveFaceModel(sql.toString());
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void saveFaceModel(String sql) throws Exception{
		Statement stat = con.createStatement();
		stat.executeUpdate(sql);
		stat.close();
	}
	private void saveFaceData(FaceDataPojo fdp) throws Exception{
		String tableName = JiangXIContainerUtil.sdfTableName.format(new Date());
		tableName = JiangXIContainerUtil.createTable_FaceData(con, tableName);
		Statement stat = con.createStatement();
		String sql = "insert into " + tableName + "(dID, result, name, fTime) values ('" + 
				fdp.getdID() + "', '" + fdp.getResult() + "', '" + fdp.getName() + "', '" + 
				fdp.getfTime() + "')";
		stat.executeUpdate(sql);
		stat.close();
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
