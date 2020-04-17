package com.zwb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class Server {
	public  Server() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8888);
		int count = 0;
		while (true) {
			System.out.println("我是服务器端，我正在监听客户端请求...sss");
			Socket socket = serverSocket.accept();
			count++;
			ServerThread serverThread = new ServerThread(socket);
			serverThread.start();
			System.out.println("客户IP：" + socket.getInetAddress());
			System.out.println("目前登录人数：" + count);
		}
	}

	public static void main(String[] args) throws IOException {

		SpringApplication.run(Server.class, args);

	}
}
