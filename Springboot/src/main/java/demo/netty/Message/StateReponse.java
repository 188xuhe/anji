package demo.netty.Message;

import demo.netty.serial.Serializer;

public class StateReponse extends Serializer {

    private short agvid;
    private short task_id;
    private byte sub_task_id;
    private byte agv_status;
    private byte battery_level;
    private byte actuator_idx;
    private int pos_x;
    private int pos_y;
    private short pos_theta;
    private short res;
    private int vel;
    private int rot_vel;
    private int line_acc;
    private int rot_acc;
    private int line_dece;
    private int extra_status;
    private short code_type;
    private byte alarm_main;
    private byte alarm_sub;
    private byte[] actuator_status = new byte[40];


    public short getAgvid() {
        return agvid;
    }

    public void setAgvid(short agvid) {
        this.agvid = agvid;
    }

    public short getTask_id() {
        return task_id;
    }

    public void setTask_id(short task_id) {
        this.task_id = task_id;
    }

    public byte getSub_task_id() {
        return sub_task_id;
    }


    public void setSub_task_id(byte sub_task_id) {
        this.sub_task_id = sub_task_id;
    }

    public byte getAgv_status() {
        return agv_status;
    }

    public void setAgv_status(byte agv_status) {
        this.agv_status = agv_status;
    }

    public byte getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(byte battery_level) {
        this.battery_level = battery_level;
    }

    public byte getActuator_idx() {
        return actuator_idx;
    }

    public void setActuator_idx(byte actuator_idx) {
        this.actuator_idx = actuator_idx;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public short getPos_theta() {
        return pos_theta;
    }

    public void setPos_theta(short pos_theta) {
        this.pos_theta = pos_theta;
    }

    public short getRes() {
        return res;
    }

    public void setRes(short res) {
        this.res = res;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public byte getAlarm_main() {
        return alarm_main;
    }

    public void setAlarm_main(byte alarm_main) {
        this.alarm_main = alarm_main;
    }

    public byte getAlarm_sub() {
        return alarm_sub;
    }

    public void setAlarm_sub(byte alarm_sub) {
        this.alarm_sub = alarm_sub;
    }

    public int getExtra_status() {
        return extra_status;
    }

    public void setExtra_status(int extra_status) {
        this.extra_status = extra_status;
    }

    public int getLine_acc() {
        return line_acc;
    }

    public void setLine_acc(int line_acc) {
        this.line_acc = line_acc;
    }

    public int getLine_dece() {
        return line_dece;
    }

    public void setLine_dece(int line_dece) {
        this.line_dece = line_dece;
    }

    public int getRot_acc() {
        return rot_acc;
    }

    public void setRot_acc(int rot_acc) {
        this.rot_acc = rot_acc;
    }

    public int getRot_vel() {
        return rot_vel;
    }

    public void setRot_vel(int rot_vel) {
        this.rot_vel = rot_vel;
    }

    public short getCode_type() {
        return code_type;
    }

    public void setCode_type(short code_type) {
        this.code_type = code_type;
    }

    /*
    public ActuatorStatus getActuator_status() {
        return actuator_status;
    }

    public void setActuator_status(ActuatorStatus actuator_status) {
        this.actuator_status = actuator_status;
    }

     */

    @Override
    protected void read() {
        agvid = readShort();
        task_id = readShort();
        sub_task_id = readByte();
        agv_status = readByte();
        battery_level = readByte();
        actuator_idx = readByte();
        pos_x = readInt();
        pos_y = readInt();
        pos_theta = readShort();
        res = readShort();
        vel = readInt();
        rot_vel = readInt();
        line_acc = readInt();
        rot_acc = readInt();
        line_dece = readInt();
        extra_status = readInt();
        code_type = readShort();
        alarm_main = readByte();
        alarm_sub = readByte();
        actuator_status = readBytes(40);
        /*
        switch (actuator_idx){
            case 0:
                actuator_status.setTemperature(readByte());
                actuator_status.setCurrent(readByte());
            case 1:
                actuator_status.setRoll_status(readByte());
            case 2:
                actuator_status.setIo_in_out_status(readByte());
            case 3:
                actuator_status.setPos_id_stat(readInt());
            case 4:
                actuator_status.setPod_id(readInt());
                actuator_status.setPod_dir(readShort());
                actuator_status.setRes(readShort());
                actuator_status.setPod_str(readString(32));
        }

         */
    }

    @Override
    protected void write() {

    }
}


