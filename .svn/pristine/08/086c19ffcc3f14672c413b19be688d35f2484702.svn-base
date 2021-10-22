package bd.nmam.collection.config.channelinitializer;

import bd.nmam.collection.business.handler.jiangxi.BeidianHttpDecoder;
import bd.nmam.collection.business.handler.jiangxi.BeidianMenjingHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;

public class JXHttpBusinessInitializer extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ch.pipeline().addLast(new HttpServerCodec())
			.addLast(new HttpResponseEncoder())
			.addLast(new HttpObjectAggregator(1024*1024))
			.addLast(new BeidianHttpDecoder())
			.addLast(new BeidianMenjingHandler());
			
	}

}
