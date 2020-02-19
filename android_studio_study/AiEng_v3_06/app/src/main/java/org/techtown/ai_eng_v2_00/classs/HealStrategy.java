package org.techtown.ai_eng_v2_00.classs;

public class HealStrategy implements ActStrategy {

	@Override
	public void act(int atk,int heal) {
		System.out.println("힐! 힐량"+ heal);
	}

}
