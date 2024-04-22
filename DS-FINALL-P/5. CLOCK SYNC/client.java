import java.io.*;
import java.net.*;

public class client {
    private static final int SYNC_INTERVAL_MS = 5000; // Sync interval in milliseconds

    public static void main(String[] args) {
        try {
            while (true) {
                syncWithServer();
                Thread.sleep(SYNC_INTERVAL_MS); // Wait before syncing again
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void syncWithServer() {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 12345);

            // Receive server's time
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            long serverTime = inputStream.readLong();
            long clientTimeAfterReceive = System.currentTimeMillis();
            System.out.println("Server time: " + new java.util.Date(serverTime));

            // Calculate offset and adjust client's time
            long offset = serverTime - clientTimeAfterReceive;
            System.out.println("Offset: " + offset);
            System.out.println("Adjusted client time: " + new java.util.Date(clientTimeAfterReceive + offset));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
