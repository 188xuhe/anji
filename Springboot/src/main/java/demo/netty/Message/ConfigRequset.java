package demo.netty.Message;

import demo.netty.serial.Serializer;

public class ConfigRequset extends Serializer {
    private short agvid;
    //data
    private String data ;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAgvid(short agvid) {
        this.agvid = agvid;
    }

    public short getAgvid() {
        return agvid;
    }

    @Override
    protected void read() {

    }

    @Override
    protected void write() {
        writeString(data, 40);
    }
}
