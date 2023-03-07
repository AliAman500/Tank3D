package networking;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class Packet {

	public ID id;
	public InetAddress address;
	public int port;
	
	public enum ID {
		CONNECT, CREATE_ROOM, JOIN_ROOM;
	}
	
	public static Packet parse(DatagramPacket dataPacket) {
		byte[] dataBytes = dataPacket.getData();
		int offset = dataPacket.getOffset();
		int length = dataPacket.getLength();
		String dataString = new String(dataBytes, offset, length);
		String data[] = dataString.split(" ");
		
		ID packetID = ID.valueOf(data[0]);
		switch(packetID) {
		case CONNECT:
			String username = data[1];
			return new ConnectPacket(username, dataPacket.getAddress(), dataPacket.getPort());
		case CREATE_ROOM:
			break;
		case JOIN_ROOM:
			break;
		default:
			break;
		}
		
		return null;
	}
	
	public byte[] getData() {
		return null;
	}
	
	public int length() {
		return getData().length;
	}
}