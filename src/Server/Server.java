package Server;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * server class
 *
 * @author  mohammad &amir
 */
public class Server implements Serializable {
    private ServerSocket serverSocket;

    ArrayList<Socket> sockets;

    ArrayList<ClientHandler> clientHandlers;

    static final int PORT = 1337;

    File file;

    /**
     *
     * constructor
     *
     *
     *
     *
     */

    public Server() throws FileNotFoundException {

        sockets = new ArrayList<>();

        file = new File("ServerFile");

        if( file.exists())
        {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        clientHandlers = new ArrayList<ClientHandler>();

        try {
            serverSocket = new ServerSocket(PORT);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void runServer()
    {

        while (true) {
            try {

                System.out.println("server is listening");

                Socket socket = serverSocket.accept();


                sockets.add(socket);

                System.out.println("client :"  + socket.getRemoteSocketAddress().toString() +  " is  connected");

                ClientHandler clientHandler = new ClientHandler(socket,clientHandlers,file);


                clientHandlers.add(clientHandler);

                for (ClientHandler c: clientHandlers) {
                    c.setClientHandlers(clientHandlers);
                }

                new Thread(clientHandler).start();
                System.out.println("client handler ");
            } catch (IOException e) {
            }
        }
    }


    public void run() {
        runServer();

    }


}
