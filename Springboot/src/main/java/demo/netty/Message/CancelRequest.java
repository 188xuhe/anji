package demo.netty.Message;

import demo.netty.serial.Serializer;

public class CancelRequest extends Serializer {

    private short agvid;
    private short task_id;
    private byte sub_task_id;
    private byte[] res = new byte[3];

    public void setRes(byte[] res) {
        this.res = res;
    }

    public byte[] getRes() {
        return res;
    }

    public void setSub_task_id(byte sub_task_id) {
        this.sub_task_id = sub_task_id;
    }

    public byte getSub_task_id() {
        return sub_task_id;
    }

    public void setTask_id(short task_id) {
        this.task_id = task_id;
    }

    public short getTask_id() {
        return task_id;
    }

    public short getAgvid() {
        return agvid;
    }

    public void setAgvid(short agvid) {
        this.agvid = agvid;
    }


    @Override
    protected void read() {

    }

    @Override
    protected void write() {
        writeShort(agvid);
        writeShort(task_id);
        writeByte(sub_task_id);
        writeBytes(res);
    }
}
