package main.model.players.packets;

import main.Server;
import main.model.players.Client;
import main.model.players.PacketType;

public class FollowPlayer implements PacketType {
	
	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int followPlayer = c.getInStream().readUnsignedWordBigEndian();
		if(Server.playerHandler.players[followPlayer] == null) {
			return;
		}
		c.playerIndex = 0;
		c.npcIndex = 0;
		c.mageFollow = false;
		c.usingBow = false;
		c.usingRangeWeapon = false;
		c.followDistance = 1;
		c.followId = followPlayer;
	}	
}