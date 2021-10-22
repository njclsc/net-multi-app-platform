package bd.nmam.collection.business.handler.jiangxi;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.CharsetUtil;
//自定义假性decoder 方便数据处理而已
public class BeidianHttpDecoder extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// TODO Auto-generated method stub
		if(msg instanceof FullHttpRequest){
			FullHttpRequest req = (FullHttpRequest)msg;
			ByteBuf buf = req.content();
//			String data = buf.toString(CharsetUtil.US_ASCII);
			String data = buf.toString(CharsetUtil.UTF_8);
			ctx.fireChannelRead(data);
			req.release();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
//		super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
	}

}
