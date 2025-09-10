package ru.zatelyapin.kiiisdate.back;

import ru.zatelyapin.kiiisdate.back.controller.ProfileController;
import ru.zatelyapin.kiiisdate.back.dao.ProfileDao;
import ru.zatelyapin.kiiisdate.back.service.ProfileService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KiiisDateBackServerRunner {

    public static void main(String[] args) throws IOException {

        ProfileController controller = new ProfileController(new ProfileService(new ProfileDao()));

        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket socket = serverSocket.accept();
             DataInputStream requestStream = new DataInputStream(socket.getInputStream());
             DataOutputStream responseStream = new DataOutputStream(socket.getOutputStream())

        ){
            String request = requestStream.readUTF();
            String response;
            while (!"stop".equals(request)){
                if(request.startsWith("save ")){
                    response = controller.save(request.split("save ")[1]);
                }else {
                    response = "Unsupported operation";
                }
                responseStream.writeUTF(response);
                request = requestStream.readUTF();

            }
        }
    }
}
