package demo.netty.Server;

import demo.netty.Handler.LoginHandler;
import demo.netty.Handler.ResponseHandler;
import demo.netty.Message.ConstantValue;
import demo.netty.Message.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageHandler extends  SimpleChannelInboundHandler<Message> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
        handlerMessage(ctx.channel(), message);
    }

    private void handlerMessage(Channel channel, Message message){
        short msgType = message.getType();
        System.out.println("channel: " + channel.id() + " 消息类型: " + msgType);
        switch (msgType) {
            case ConstantValue.LOGIN:
                LoginHandler.login(channel,message);
                break;
            case ConstantValue.CONFIGREPLY:
                System.out.println("Config");
                break;
            case ConstantValue.STATE:
                System.out.println("State");
                break;
            case ConstantValue.BASEMOVEREPLY:
                System.out.println("BASEMOVEREPLY");
                break;
            case ConstantValue.CURVEMOVEREPLY:
                System.out.println("CURVEMOVEREPLY");
                break;
            case ConstantValue.AVOIDREPLY:
                System.out.println("AVOIDREPLY");
                break;
            case ConstantValue.POWERREPLY:
                System.out.println("POWERREPLY");
                break;
            case ConstantValue.CANCELREPLY:
                System.out.println("CANCELREPLY");
                break;
            case ConstantValue.APPLY:
                ResponseHandler.ResSuccess(channel,message);;
                break;
            case ConstantValue.UNLOCK:
                ResponseHandler.ResSuccess(channel,message);;
                break;
            case ConstantValue.PODTASKREPLY:
                System.out.println("PODTASKREPLY");
                break;
            case ConstantValue.SORTFLIPREPLY:
                System.out.println("SORTFLIPREPLY");
                break;
            case ConstantValue.PODDETECTREPLY:
                System.out.println("PODDETECTREPLY");
                break;
            case ConstantValue.SORTBELTREPLY:
                System.out.println("SORTBELTREPLY");
                break;
            case ConstantValue.ROLLREPLY:
                System.out.println("ROLLREPLY");
                break;
            case ConstantValue.IOACTREPLY:
                System.out.println("IOACTREPLY");
                break;
            default:
                System.out.println("Unknown Message!!!");
                break;
        }

    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        NettyChannelMap.removeChannel(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        NettyChannelMap.removeChannel(ctx.channel());
        //关闭
        ctx.channel().close();
    }
}
