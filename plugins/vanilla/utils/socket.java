package vanilla.utils;

import java.io.*;

import java.net.*;

import game.main.*;
import game.io.*;

/**
 * UDP without any changes.
 */
public class socket {

    public static final int DEF_DP_LEN  = 65536;
    public static final int DEF_TIMEOUT = 4000;

    private DatagramPacket DP;
    private DatagramSocket S;
    private byte[]         Buffer;
    
    /**
     * Make a new binded UDP socket.
     * 
     * @param PORT the binded port to another socket
     * @param IA the inet adress of another socket
     * @throws SocketException
     */
    public socket(int PORT, InetAddress IA) throws SocketException {
        S = new DatagramSocket(PORT, IA);
        S.setSoTimeout(DEF_TIMEOUT);
    }

    /**
     * Connects to another socket.
     * 
     * @param PORT the port of the other socket
     * @param IA the inet address of the other socket
     */
    public void connect(int PORT, InetAddress IA) {
        S.connect(IA, PORT);
    }

    /**
     * Uses the {@code DEF_DP_LEN} as the lenth of the data pack.
     * @return the data packs
     * @throws IOException
     * @see {@link socket#read(int)}
     */
    public String read() throws IOException {
        return read(DEF_DP_LEN);
    }

    /**
     * Uses the {@code DEF_DP_LEN} as the lenth of the data pack.
     * @param Data the string
     * @throws IOException
     * @see {@link socket#write(String, int)}
     */
    public void write(String Data) throws IOException {
        write(Data, DEF_DP_LEN);
    }

    public String read(int dp_len) throws IOException {
        Buffer = new byte[dp_len];
        DP = new DatagramPacket(Buffer, dp_len);

        try {

            S.receive(DP);
            return new String(Buffer, Main.DEF_CHARSET).replace("\0", "");
            
        } catch (SocketTimeoutException e) {
            
            return null;

        }
    }


    public void write(String Data, int dp_len) throws IOException {
        Buffer = Data.getBytes(Main.DEF_CHARSET);
        DP = new DatagramPacket(Buffer, Buffer.length);
        S.send(DP);
    }

    /**
     * Closes this socket.
     * @see java.net.DatagramSocket#close()
     */
    public void close() {
        S.close();
    }

}
