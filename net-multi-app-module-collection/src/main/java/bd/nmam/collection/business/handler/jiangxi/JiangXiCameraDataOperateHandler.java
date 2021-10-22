package bd.nmam.collection.business.handler.jiangxi;

import bd.nmam.collection.business.task.jiangxi.CameraDataOperateThread;
import bd.nmam.collection.config.BusinessOperateConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class JiangXiCameraDataOperateHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		BusinessOperateConfig.getThreadPool().execute(new CameraDataOperateThread(ctx, msg));
	}

}
