package demo.netty.Handler;

import demo.netty.Message.Message;
import demo.netty.Server.NettyChannelMap;
import io.netty.channel.Channel;


public class RequestHandler {
    public static void request(short agvid, Message message){
        Channel channel = NettyChannelMap.getChannel(agvid);
        channel.writeAndFlush(message);
    }
}
