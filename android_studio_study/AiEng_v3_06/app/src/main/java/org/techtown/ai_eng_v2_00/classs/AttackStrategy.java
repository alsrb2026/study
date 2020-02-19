package org.techtown.ai_eng_v2_00.classs;

public class AttackStrategy implements ActStrategy {
	
	@Override
	public void act(int atk,int heal) {
		System.out.println("공격! 데미지" + atk);
	}

}
