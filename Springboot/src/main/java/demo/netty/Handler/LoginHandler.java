package demo.netty.Handler;

import demo.netty.Message.LoginRequest;
import demo.netty.Message.Message;
import demo.netty.Server.NettyChannelMap;
import io.netty.channel.Channel;

import static demo.netty.Server.NettyChannelMap.printChannel;


public class LoginHandler {

    public static void login(Channel channel, Message message){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.readFromBytes(message.getData());

        short agvId = loginRequest.getAgvId();
        NettyChannelMap.addChannel(agvId,channel);
        System.out.println("agvId:" + agvId + " channel:" + channel + "  已上线");

        display();

        ResponseHandler.ResSuccess(channel,message);

    }

    public static void display(){
        printChannel();
        System.out.println();
    }

}
