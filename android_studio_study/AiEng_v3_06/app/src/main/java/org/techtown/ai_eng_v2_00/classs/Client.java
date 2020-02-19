package org.techtown.ai_eng_v2_00.classs;

public class Client {
	public static void main(String[] args) {
		
	
	    Card attacker = new Card_Attacker1("딜러카드",20,4,0);
	    attacker.setActStrategy(new AttackStrategy());
	    attacker.act();
	    
	    Card attacker2 = new Card_Attacker2("딜러카드",10,7,0);
	    attacker2.setActStrategy(new AttackStrategy());
	    attacker2.act();
	    
	    
	    Card healler = new Card_Healler("힐러카드",10,2,6);
	    healler.setActStrategy(new HealStrategy());
	    healler.act();
	    
	 
		
		
	
	}

}
