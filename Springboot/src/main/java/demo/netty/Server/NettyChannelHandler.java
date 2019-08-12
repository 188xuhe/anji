package demo.netty.Server;

import demo.netty.Coder.MessageDecoder;
import demo.netty.Coder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new MessageEncoder());

        pipeline.addLast(new IdleStateHandler(100, 100, 200));
        // 自定义的空闲状态检测
        pipeline.addLast(new HeartBeatHandler());
        //消息处理
        pipeline.addLast(new MessageHandler());

    }
}
