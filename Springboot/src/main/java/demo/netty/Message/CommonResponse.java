package demo.netty.Message;


import demo.netty.serial.Serializer;

public class CommonResponse extends Serializer {
    //长度
    public short length = 8;

    //结果码
    private int result;

    //异常代码
    private byte errCode;

    //保留字节
    private byte[] last = new byte[3];

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }

    public byte getErrCode() {
        return errCode;
    }
    public void setErrCode(byte errCode){
        this.errCode = errCode;
    }

    public byte[] getLast() {
        return last;
    }
    public void setLast(byte[] last) {
        this.last = last;
    }

    @Override
    protected void read() {
        this.result = readInt();
        this.errCode = readByte();
        this.last = readBytes(3);
    }

    @Override
    protected void write() {
        writeInt(result);
        writeByte(errCode);
        writeBytes(last);
    }
}
