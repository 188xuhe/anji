package demo.netty.Message;

import demo.netty.serial.Serializer;

public class LoginRequest extends Serializer {
    //agv_id
    private short agvId;

    //model
    private byte model;

    //state
    private byte state;

    //version
    private int version;

    //serial
    private byte[] serial = new byte[48];

    //chang
    private short chang;

    //width
    private short width;

    //height
    private short height;

    //diameter
    private short diameter;

    public short getAgvId() {
        return agvId;
    }

    public byte getModel() {
        return model;
    }

    public byte getState() {
        return state;
    }

    public int getVersion() {
        return version;
    }

    public byte[] getSerial() {
        return serial;
    }

    public short getChang() {
        return chang;
    }

    public short getWidth() {
        return width;
    }

    public short getHeight() {
        return height;
    }

    public short getDiameter() {
        return diameter;
    }

    @Override
    protected void read() {
        this.agvId = readShort();
        this.model = readByte();
        this.state = readByte();
        this.version = readInt();
        this.serial = readBytes(48);
        this.chang = readShort();
        this.width = readShort();
        this.height = readShort();
        this.diameter = readShort();

    }

    @Override
    protected void write() {

    }
}
