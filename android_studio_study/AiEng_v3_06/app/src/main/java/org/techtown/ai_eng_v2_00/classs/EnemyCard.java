package org.techtown.ai_eng_v2_00.classs;

public abstract class EnemyCard {
	String name;
	private ActStrategy actStrategy;
	
	
	public EnemyCard(String name) {
		this.name = name;
	}
}
