package demo.netty.Message;

public class Message {
	/**
	 * 消息长度
	 */
	private short len;

	/**
	 * 消息类型
	 */
	private short type;

	/**
	 * 消息序号
	 */
	private int serial;

	/**
	 * 消息版本号
	 */
	private byte version = 0x01;

	/**
	 * 消息加密类型
	 */
	private byte secType = 0;

	/**
	 * 保留字节
	 */
	private short remain = 0x0000;

	/**
	 * 数据部分
	 */
	private byte[] data;

	public short getLen() {
		return len;
	}
	public void setLen(short len){
		this.len = len;
	}

    //自动计算数据包长度
	public short getLength(){
		return  (short) (data != null ? data.length + 16 : 16);
	}

	public short getType() {
		return type;
	}
	public void setType(short type){
		this.type = type;
	}

	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial){
		this.serial = serial;
	}

	public byte getSecType() {
		return secType;
	}
	public void setSecType(byte secType){
		this.secType = secType;
	}

	public byte getVersion() {
		return version;
	}
	public void setVersion(byte version){
		this.version = version;
	}

	public short getRemain() {
		return remain;
	}
	public void setRemain(short remain){
		this.remain = remain;
	}

	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
}
