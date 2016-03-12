package com.client.api.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.client.api.utils.Filter;
import com.client.api.wrappers.Player;
import com.client.core.Client;
import com.client.core.Engine;
import com.client.data.Constants;
import com.client.reflection.Objects;

public class Players {
	public static Client client = Engine.client;

	private static final Comparator<Player> NEAREST_SORTER = new Comparator<Player>() {

		@Override
		public int compare(final Player p1, final Player p2) {
			return p1.distanceTo() - p2.distanceTo();
		}

	};
	private static final Filter<Player> ALL_FILTER = new Filter<Player>() {

		@Override
		public boolean accept(final Player p) {
			return true;
		}

	};

	// public static String getMyUsername() {
	// return Strings.getInstance().getString(Constants.mainClass, Constants.getMyUsername,
	// Boot.client);
	// }

	public static Object getMyPlayer() {
		return Objects.getInstance().getObject(Constants.mainClass, Constants.myPlayer,
				client.getClient(), Constants.playerClass);
	}

	public static final Player[] getNearest(final Filter<Player> filter) {
		final Player[] players = getPlayers(filter);
		Arrays.sort(players, NEAREST_SORTER);
		return players;
	}

	public static Object[] getPlayerArray() {
		return Objects.getInstance().getObjectArray(Constants.mainClass, Constants.playerArray,
				client.getClient(), Constants.playerClass);
	}

	public static final Player[] getPlayers() {
		return getPlayers(ALL_FILTER);
	}

	public static final Player[] getPlayers(final Filter<Player> filter) {

		final ArrayList<Player> playerList = new ArrayList<Player>();
		final Object[] oPlayers = getPlayerArray();
		for (int i = 0; i < oPlayers.length; i++) {
			if (oPlayers[i] == null) {
				continue;
			}
			final Player player = new Player(oPlayers[i], i);
			if (filter.accept(player)) {
				playerList.add(player);
			}
		}
		return playerList.toArray(new Player[playerList.size()]);
	}

	public static Player myPlayer() {
		final Object myPlayer = getMyPlayer();
		return new Player(myPlayer, -1);
	}

}
