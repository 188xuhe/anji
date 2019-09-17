package demo.netty.Message;

public class ActuatorStatus{
    //idx = 0
    private byte temperature;
    private byte current;

    //idx = 1
    private byte roll_status;

    //idx = 2
    private byte io_in_out_status;


    //idx = 3
    private int pos_id_stat;


    //idx = 4
    private int pod_id;
    private short pod_dir;
    private short res;
    private String pod_str; //32 byte

    void setCurrent(byte current) {
        this.current = current;
    }

    public byte getCurrent() {
        return current;
    }

    public byte getTemperature() {
        return temperature;
    }

    public void setTemperature(byte temperature) {
        this.temperature = temperature;
    }

    public void setRoll_status(byte roll_status) {
        this.roll_status = roll_status;
    }

    public byte getRoll_status() {
        return roll_status;
    }

    public byte getIo_in_out_status() {
        return io_in_out_status;
    }

    public void setIo_in_out_status(byte io_in_out_status) {
        this.io_in_out_status = io_in_out_status;
    }

    public int getPos_id_stat() {
        return pos_id_stat;
    }

    public void setPos_id_stat(int pos_id_stat) {
        this.pos_id_stat = pos_id_stat;
    }

    public int getPod_id() {
        return pod_id;
    }

    public void setPod_id(int pod_id) {
        this.pod_id = pod_id;
    }

    public short getPod_dir() {
        return pod_dir;
    }

    public void setPod_dir(short pod_dir) {
        this.pod_dir = pod_dir;
    }

    public short getRes() {
        return res;
    }

    public void setRes(short res) {
        this.res = res;
    }

    public String getPod_str() {
        return pod_str;
    }

    public void setPod_str(String pod_str) {
        this.pod_str = pod_str;
    }
}
