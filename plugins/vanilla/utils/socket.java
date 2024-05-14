package vanilla.utils;

import java.io.*;

import java.net.*;

import game.main.*;

/**
 * UDP with little changes, including hash corrections and flow-number based
 * connection reliability. (For in-game use of checking is a packet been sent
 * due to the server didn`t reply or the user sent a new in-game command).
 */
public class socket {

    /**
     * Default datagram packet lenth.
     * 
     * @see {@link DatagramPacket#DatagramPacket(byte[], int)}
     */
    public static final int DEF_DP_LEN = 8192;
    /**
     * Default timeout for sockets.
     * 
     * @see {@link DatagramSocket#setSoTimeout(int)}
     */
    public static final int DEF_TIMEOUT = 1000;

    /**
     * The maxium amount of retries.
     * 
     * @see {@link socket#read(int)}
     */
    public static final int MAX_RETRY = 2;

    private DatagramPacket DP;
    private DatagramSocket S;
    private byte[] Buf;

    private int Curr_Retry;

    /**
     * Make a new binded UDP socket.
     * 
     * @param PORT the binded port to another socket
     * @param IA   the inet adress of another socket
     * @throws SocketException
     * 
     * @see {@link DatagramSocket#DatagramSocket(int, InetAddress)}
     * @see {@link DatagramSocket#setSoTimeout(int)}
     */
    public socket(int PORT, InetAddress IA) throws SocketException {
        S = new DatagramSocket(PORT, IA);
        S.setSoTimeout(DEF_TIMEOUT);
    }

    /**
     * Connects to another socket.
     * 
     * @param PORT the port of the other socket
     * @param IA   the inet address of the other socket
     * @see DatagramSocket#connect(InetAddress, int)
     */
    public void connect(int PORT, InetAddress IA) {
        S.connect(IA, PORT);
    }

    /**
     * Uses the {@code DEF_DP_LEN} as the lenth of the data pack.
     * 
     * @return the data packs
     * @throws IOException
     * @see {@link socket#read(int)}
     */
    public String read() throws IOException {
        return read(DEF_DP_LEN);
    }

    /**
     * Uses the {@code DEF_DP_LEN} as the lenth of the data pack.
     * 
     * @param Data the string
     * @throws IOException
     * @see {@link socket#write(String, int)}
     */
    public void write(String Data) throws IOException {
        write(Data, DEF_DP_LEN);
    }

    /**
     * Gets the data from the connected socket, decodes using
     * {@link Main#DEF_CHARSET}.
     * 
     * @param dp_len the lenth of the datagram packet
     * @return the string using the charset of {@link Main#DEF_CHARSET}
     * @throws IOException
     * 
     * @see {@link DatagramSocket#receive(DatagramPacket)}
     * @see {@link socket#connect(int, InetAddress)}
     * @see {@link socket#read()}
     * @see {@link Main#DEF_CHARSET}
     */
    public String read(int dp_len) throws IOException {
        Buf = new byte[dp_len];
        DP = new DatagramPacket(Buf, dp_len);
        // Creates some temporary things.

        while (Curr_Retry < MAX_RETRY) {
            try {

                S.receive(DP);
                // Recieves the message.

                return new String(Buf, Main.DEF_CHARSET).replace("\0", "");
                // Replaces the nulls in the String and returns.

            } catch (SocketTimeoutException e) {
            }
        }

        throw new SocketTimeoutException("Reached maxium amount of retries.");

    }

    /**
     * Writes the data in string to the connected socket, encodes using
     * {@link Main#DEF_CHARSET}.
     * Message assemble format :
     * <p>
     * {@code | Raw data (N bytes) | Flow number (4 bytes) | Hash code (4 bytes) |}
     * <p>
     * Raw data : the data in bytes;
     * <p>
     * Flow number : for knowing is this packet the same as other packets, and save
     * memory (?);
     * <p>
     * Hash code : {@link String#hashCode()}, the orignal sent string data`s hash
     * code.
     * <p>
     * 
     * @param Data   the data to send, in string, encodes using
     *               {@link Main#DEF_CHARSET}.
     * @param dp_len the lenth of the datagram packet.
     * @throws IOException see {@link DatagramSocket#send(DatagramPacket)}
     * 
     * @see {@link socket#connect(int, InetAddress)}
     * @see {@link socket#write(String)}
     * @see {@link Main#DEF_CHARSET}
     */
    public void write(String Data, int dp_len) throws IOException {

        Buf = Data.getBytes(Main.DEF_CHARSET);
        // Inits

        DP = new DatagramPacket(Buf, Buf.length);
        S.send(DP);

    }

    /**
     * Closes this socket.
     * 
     * @see java.net.DatagramSocket#close()
     */
    public void close() {
        S.close();
    }

}
