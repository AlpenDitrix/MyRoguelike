package com.avapir.roguelike.game.world.character.ai;

import com.avapir.roguelike.core.Game;
import com.avapir.roguelike.game.world.character.Mob;
import com.avapir.roguelike.game.world.map.Tile;

import java.awt.*;

public class SlimeAI extends EasyAI {

    private static final SlimeAI instance = new SlimeAI();

    public static AbstractAI getInstance() {
        return instance;
    }

    @Override
    public void computeAI(final Mob m, final Game g) {
        final int x = m.getLoc().x;
        final int y = m.getLoc().y;
        final Point p = new Point(random.nextInt(3) - 1, random.nextInt(3) - 1);
        for (int i = x - 4; i < x + 4; i++) {
            for (int j = y - 4; j < y + 4; j++) {
                final Tile t = g.getMap().getTile(i, j);
                if (t != null && t.getMob() != null && t.getMob() == g.getHero()) {
                    p.move(i < x ? -1 : i > x ? 1 : 0, j < y ? -1 : j > y ? 1 : 0);
                }
            }
        }
        final Tile t = g.getMap().getTile(m.getX() + p.x, m.getY() + p.y);
        if (t != null && t.getMob() != null) {
            if (t.getMob().getName().equals(m.getName())) {
                m.move(new Point(0, 0), g);
            }
        }
        m.move(p, g);
    }

}