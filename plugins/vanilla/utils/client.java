package vanilla.utils;

import java.io.*;

import java.net.*;

import game.main.*;

/**
 * Creates a IPv6 client for some purpose, might be deleted in the future.
 * <p>
 * To interact with the client, you can add plugins or threads to change the
 * {@code client.RETURN_CMD} runnable type for sending data, cmds and other
 * things to the server.
 * <p>
 * This thing is just a mask, a interface for contacting with the server socket.
 * <p>
 * 
 * @since 1.2.0a
 * @version 1.1.1a
 */
public class client {

    private Socket S;

    private int port;
    private InetAddress ip;

    private InputStream SIS;
    private OutputStream SOS;

    public client(int port, InetAddress ip) throws Exception {
        this.port = port;
        this.ip = ip;
        S = new Socket(this.ip, this.port);
    }

    public void connect(SocketAddress SA) throws Exception {
        S.connect(SA);
    }

    public String read() throws Exception {

        SIS = S.getInputStream();
        byte[] buffer = new byte[65536];

        // Read from stream
        SIS.read(buffer);

        return new String(buffer, Main.DEF_CHARSET);
    }

    public void write(String data) throws Exception {

        SOS = S.getOutputStream();
        byte[] BA = data.getBytes(Main.DEF_CHARSET);
        SOS.write(BA);

    }

    public void close() throws Exception {
        S.close();
    }

    public SocketAddress getLocalSocketAddress() {
        return S.getLocalSocketAddress();
    }

    public InetAddress getInetAddress() {
        return S.getInetAddress();
    }

    public int getLocalPort() {
        return S.getLocalPort();
    }
}
