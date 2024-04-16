package vanilla.utils;

import game.main.Main;

import java.io.*;

import java.net.*;

/**
 * Creates a IPv6 server for some purpose, might be deleted in the future.
 * <p>
 * To interact with the server, you can add plugins or threads to change the
 * {@code server.RETURN_CMD} runnable type for sending data, cmds and other
 * things to the client.
 * <p>
 * This thing is just a mask, a interface for contacting with the client socket
 * <p>
 * 
 * @since 1.2.0a
 * @version 1.1.1a
 */
public class server {

    private ServerSocket SS;
    private Socket S;

    private int port;
    private InetAddress ip;

    private InputStream SIS;
    private OutputStream SOS;

    public server(int port, InetAddress ip) {
        this.port = port;
        this.ip = ip;
    }

    public void start() throws Exception {
        SS = new ServerSocket(port, 1, ip);
        S = SS.accept();
    }

    public String read() throws Exception {

        SIS = S.getInputStream();
        byte[] buffer = new byte[65536];

        // Read from stream
        SIS.read(buffer);

        // Uses UTF-8 for encoding.
        return new String(buffer, Main.DEF_CHARSET);
    }

    public void write(String data) throws Exception {

        SOS = S.getOutputStream();
        byte[] BA = data.getBytes(Main.DEF_CHARSET);
        SOS.write(BA);

    }

    public void close() throws Exception {
        SS.close();
    }

    public SocketAddress getLocalSocketAddress() {
        return SS.getLocalSocketAddress();
    }

    public InetAddress getInetAddress() {
        return SS.getInetAddress();
    }

    public int getLocalPort() {
        return SS.getLocalPort();
    }

}
