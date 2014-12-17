package com.GGI.ForgedDatabase;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;

public class ForgedDatabase extends ApplicationAdapter {
	
	public ArrayList<Connection> clients = new ArrayList<Connection>();
	public ServerSocketHints hints = new ServerSocketHints();
	public ServerSocket rServer;
	public ServerSocket sServer;
	
	@Override
	public void create () {
		rServer = Gdx.net.newServerSocket(Protocol.TCP, 4443, hints);
		sServer = Gdx.net.newServerSocket(Protocol.TCP, 4444, hints);
		
		new Thread(new Connector(this)).start();
	}

	@Override
	public void render () {
		
	}
}
