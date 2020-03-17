package com.zwb;

import com.entity.WaterVideo;
import com.service.WaterVideoService;
import com.util.SL651_2014;

import java.io.*;
import java.net.Socket;
//7e7e000010000000c95932002b0224f3200314191856f1f1001000000050f0f020031419183923099999992019000000261900000038122400035e89
//7e7e000010000000c95932002b02230d200314120000f1f1001000000050f0f02003141200392309999999201900000026190000003812240003db78
public class ServerThread extends Thread {
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端请求
	@Override
	public void run() {
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		OutputStream os = null;
		BufferedReader bf = null;
		PrintWriter pwWriter = null;
		try {
			inputStream = socket.getInputStream();
			//inputStreamReader = new InputStreamReader(inputStream);
			//bf = new BufferedReader(inputStreamReader);
			//String info = null;
			System.out.println("进程开始读取数据" );

			int i= 0;
			byte[] bytes = new byte[60];
			while ((i = inputStream.read(bytes,0,25)) != -1) {

				if(bytes[10] != 50)
				{

					i = i + inputStream.read(bytes,25,35);
					System.out.println("定时报告：" + i);

					SL651_2014 mySL651_2014 = new SL651_2014();
					WaterVideo waterVideo = mySL651_2014.readString(bytes);
					System.out.println("中心站地址：" + waterVideo.getCenterAddress());
					System.out.println("遥测站地址：" + waterVideo.getClientAddress());
					System.out.println("发报时间：" + waterVideo.getSendTime());
					System.out.println("瞬时水位：" + waterVideo.getWaterLevel());
					System.out.println("当前降雨量：" + waterVideo.getDayRainfall());
					System.out.println("累计降雨量：" + waterVideo.getYearRainfall());
					System.out.println("电源电压：" + waterVideo.getVolt());

					WaterVideoService waterVideoService = new WaterVideoService();
					System.out.println("所有：" + waterVideo.toString());
					System.out.println("waterVideoService.getAllPage()：" + waterVideoService.get());

				}
				else
				{
					System.out.println("心跳：" + i);
				}

				for (int j = 0; j < i; j++) {
					System.out.print(" " + Integer.toHexString(bytes[j] & 0xFF ));
					//System.out.print((char)bytes[j]);
				}
				System.out.println();

			}

			/*while ((info = bf.readLine()) != null) {
				System.out.println("我是服务器端，客户端发送过来是：" + info);
			}*/
			os = socket.getOutputStream();
			pwWriter = new PrintWriter(os);
			pwWriter.write("欢迎亲登录。。。");
			pwWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pwWriter != null)
					pwWriter.close();
				if (os != null)
					os.close();
				if (bf != null)
					bf.close();
				if (inputStreamReader != null)
					inputStreamReader.close();
				if (inputStream != null)
					inputStream.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}

}
