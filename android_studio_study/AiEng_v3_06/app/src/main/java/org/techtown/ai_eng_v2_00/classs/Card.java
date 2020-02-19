package org.techtown.ai_eng_v2_00.classs;

public abstract class Card {
	
	private String cardname;
	private ActStrategy actStrategy;
	int hp;
	int atk;
	int heal;
	
	public Card(String cardname, int hp, int atk, int heal) {
		this.cardname = cardname;
		this.hp = hp;
		this.atk = atk;
		this.heal = heal;
	}
	
	public String getName() {
		return cardname;
	}
	
	public int getAtk() {
		return atk;
	}
	
	public void act() {
		actStrategy.act(atk,heal);
	}
	
	public void setActStrategy(ActStrategy actStrategy) {
		this.actStrategy = actStrategy;
	}
	
	
}
