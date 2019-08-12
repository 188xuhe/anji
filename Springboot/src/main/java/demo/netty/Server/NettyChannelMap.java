package demo.netty.Server;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;


public class NettyChannelMap  {
    private static ConcurrentHashMap<Short, Channel> onlineMap = new ConcurrentHashMap<>();

    public static void addChannel(short clientId, Channel socketChannel){
        if(!onlineMap.containsKey(clientId))
            onlineMap.put(clientId,socketChannel);
    }

    public static Channel getChannel(short clientId){
        return onlineMap.get(clientId);
    }

    public static boolean containsChannnel(short clientId){
        return onlineMap.containsKey(clientId);
    }

    public static void removeChannel(Channel socketChannel){
        for (ConcurrentHashMap.Entry entry:onlineMap.entrySet()) {
            if (entry.getValue() == socketChannel) {
                onlineMap.remove((Short) entry.getKey());
            }
        }
    }

    public static void printChannel(){
        System.out.print("Current Channel: {");
        for(ConcurrentHashMap.Entry<Short, Channel> entry:onlineMap.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue().id().asShortText() + ";");
        }
        System.out.print("}\n");

    }

}
