package com.example.bai_17_toan_b1704780;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.engineio.client.transports.WebSocket;

public class SocketHandler {
    private Socket mSocket;
    {
        try {
            IO.Options opts = new IO.Options();
            opts.transports = new String[] { WebSocket.NAME };
            mSocket = IO.socket("http://bai17.herokuapp.com", opts);
            //mSocket = IO.socket("http://192.168.1.15:3000", opts);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
