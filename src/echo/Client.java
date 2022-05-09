package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//연결시작
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=========================");
		System.out.println("[서버에 연결을 요청합니다.]");
		
		socket.connect(new InetSocketAddress("192.168.0.58",10001));
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		//메세지보내기용 스트림 
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		
		
		
		//
		while(true) {
		//키보드입력
			String str = sc.nextLine();
			if(str.equals("/q")) {
				break;
			}
			
		//메세지 보내기
			bw.write("[김려경]"+str);
			bw.newLine();
			bw.flush();
		//메세지 받기
		String reMsg = br.readLine();
		System.out.println("server:["+reMsg +"]");
		
		}
		
        /*		String str = sc.nextLine(); */
		
		System.out.println("=========================");
		System.out.println("<클라이언트 종료>");
		
		sc.close();
		bw.close();
		socket.close();
		
		
		
		
		
		
		
		
	}
	
}
