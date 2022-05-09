package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.28",10001));
		// 감시중....
		System.out.println("<서버시작>");
		System.out.println("==========================");
		System.out.println("[연결을 기다리고 있습니다.]");
		//대기중				
		
		
		
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결 되었습니다.]");
		//연결시작
		
		
		
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader 	br = new BufferedReader(isr);
		
		// 보내기 용 스트림 
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
	
		//
		while(true) {
			String msg = br.readLine();
			if(msg==null) {
				break;
			}
			System.out.println("받은메세지:"+msg);	
		
		//메시지보내기 
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		
		
		//ip주소 알아내기 명령프롬프트에 ipconfig검색 
		//192.168.0.28
		
		System.out.println("==========================");
		System.out.println("<서버종료>");
	
		
		br.close();
		serverSocket.close();
		socket.close();
		
		
		System.out.println("test2");
	}

	
	
}
