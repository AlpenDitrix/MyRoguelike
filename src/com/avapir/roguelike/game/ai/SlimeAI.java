package com.avapir.roguelike.game.ai;

import java.awt.Point;

import com.avapir.roguelike.core.Game;
import com.avapir.roguelike.game.Tile;
import com.avapir.roguelike.locatable.Mob;

public class SlimeAI implements AI {

	@Override
	public void computeAI(final Mob m, Game g) {
		System.out.println("slime");
		final int x = m.getX();
		final int y = m.getY();
		Point p = new Point(r.nextInt(2) - 1, r.nextInt(2) - 1);
		for (int i = x - 4; i < x + 4; i++) {
			for (int j = y - 4; j < y + 4; j++) {
				Tile t = g.getMap().getTile(i, j);
				if (t != null && t.getMob() != null && t.getMob().mobID == 0) {
					p.move(i < x ? -1 : i > x ? 1 : 0, j < y ? -1 : j > y ? 1 : 0);
				}
			}
		}
		m.move(p, g);
	}
}