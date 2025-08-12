package com.ui.Utilis.Android;

import java.net.ServerSocket;

public class AvailablePorts {

    public  int getPort() {
        ServerSocket socket = null;
        int Port = 0;
        try {
            socket = new ServerSocket(0);
            socket.setReuseAddress(true);
            Port = socket.getLocalPort();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return Port;
    }
}
