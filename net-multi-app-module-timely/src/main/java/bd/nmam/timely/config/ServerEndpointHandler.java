package bd.nmam.timely.config;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
@Component
@ServerEndpoint(value = "/websocket/handler", configurator = RegistServerEndpoint.class)
public class ServerEndpointHandler {
	private static CopyOnWriteArraySet<ServerEndpointHandler> webSocketSet = new CopyOnWriteArraySet<ServerEndpointHandler>();
	private Session session;

	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		webSocketSet.add(this);
		System.out.println(webSocketSet.size());
	}
	@OnClose
	public void onClose(){
		webSocketSet.remove(this);
		System.out.println(webSocketSet.size());
	}
	@OnMessage
	public void onMessage(String message, Session session){
		System.out.println("client message --->" + message);
		
	}
	@OnError
	public void onError(Session session, Throwable error){
		error.printStackTrace();
	}
	public void sendMessage(String message) throws Exception {
		this.session.getBasicRemote().sendText(message);
	}
	public static void sendInfo(String message){
		for(ServerEndpointHandler item: webSocketSet){
			try {
				item.sendMessage(message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
		}
	}
}
