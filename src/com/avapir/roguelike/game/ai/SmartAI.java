package com.avapir.roguelike.game.ai;

public abstract class SmartAI extends AbstractAI {

	/**
	 * Every instance of {@link SmartAI} must always return new object of itself, beacause all of
	 * them have some individual variables
	 * 
	 * @return new object of heritor
	 */
	public static final SmartAI getNewInstance() {
		throw new IllegalStateException("Every SmartAI must have it's instance generation");
	}

}