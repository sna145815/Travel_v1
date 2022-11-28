package controller;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//(김진홍)
@ServerEndpoint("/chat")
public class chatcontroller {
	//연결된 클라이언트 관리 세션
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	//클라이언트가 연결 되면 호출
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen 호출");
		// Add session to the connected sessions set
		System.out.println(session);
		clients.add(session);
	}
	//클라이언트 연결 해제시 호출
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose 호출");
		// Remove session from the connected sessions set
		clients.remove(session);
	}

	//클라이언트가 메시지를 보내면 다른 클라이언트 들에게 send
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("onMessage 호출");
		System.out.println("클라이언트 크기 : "+clients.size());
		System.out.println(message);
		synchronized (clients) {
			// Iterate over the connected sessions
			// and broadcast the received message
			for (Session client : clients) {
				if (!client.equals(session)) {
					
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	

	
}
