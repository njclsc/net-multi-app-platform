package bd.nmam.collection.business.task.jiangxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import bd.nmam.collection.business.pojo.jiangxi.ACSDataPojo;
import bd.nmam.collection.config.Configuer;
import io.netty.channel.ChannelHandlerContext;

public class MenjingOperateThread implements Runnable{
	private ChannelHandlerContext ctx;
	private Object msg;
	private Connection con;
	public MenjingOperateThread(ChannelHandlerContext ctx, Object msg){
		this.ctx = ctx;
		this.msg = msg;
		try {
			this.con = Configuer.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		String data = (String)msg;
		JSONObject jb = JSONObject.parseObject(data);
		JSONArray ja = JSONArray.parseArray(jb.getString("LibMatInfoList"));
		JSONObject jb1 = JSONObject.parseObject(ja.getString(0));
		if(jb != null && jb1 != null){
			System.out.println(data);
			JSONObject pi = JSONObject.parseObject(jb1.getString("MatchPersonInfo"));
			String time = jb.get("Timestamp").toString();
			String deviceCode = jb.get("DeviceCode").toString();
			String name = pi.get("PersonName").toString();
			String cardId = pi.getString("CardID").toString();
			ACSDataPojo adp = new ACSDataPojo();
			adp.setName(name);
			adp.setDeviceCode(deviceCode);
			adp.setCardId(cardId);
			adp.setTime(time);
			String sql = "insert into tb_acsdata (UPLOADTIME, PERSONNAME, CARDNUM, ACS_NUM) values('" + 
					adp.getTime() + "', '" + adp.getName() + "', '" + adp.getCardId() + "', '" + adp.getDeviceCode() + "')";
			
			try {
				Statement stat = con.createStatement();
				stat.executeUpdate(sql);
				stat.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	}
}
