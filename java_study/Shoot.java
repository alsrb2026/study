/*
package study;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
public class Shoot extends JFrame implements Runnable, KeyListener {
	 private BufferedImage bi = null;
	 private ArrayList msList = null;
	 private ArrayList enList = null;
	 private boolean left = false, right = false, up = false, down = false, fire = false;
	 private boolean start = false, end = false;
	 private int w = 1200, h = 500, x = 300, y = 300, xw = 15, xh = 15; //w는 맵 가로크기 h는 세로크기 x는 캐릭터 시작위치 y도 시작위치 xw,xh는 캐릭터크기
	 static int sel = 0;
	 public Shoot() {
	  bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	  msList = new ArrayList();
	  enList = new ArrayList();
	  this.addKeyListener(this);
	  this.setSize(w, h); //맵 사이즈 정하기
	  this.setTitle("Dodge Game");
	  this.setResizable(false);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);  
	 }
	 
	 public void run() {
	  try {
	   int msCnt = 0;
	   int enCnt = 0;
	   while(true) {
	    Thread.sleep(10);
	    
	    if(start) {
	     if(enCnt > 2000) {
	      upenCreate();
	      downenCreate();
	      leftenCreate();
	      rightenCreate();
	      enCnt = 0;
	     }
	     if(msCnt >= 100) {
	      fireMs();
	      msCnt = 0;
	     }
	     msCnt += 10;
	     enCnt += 10;
	     keyControl();
	     crashChk();
	    }
	    draw();
	   }
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	 }
	 public void fireMs() {
	  if(fire) {
	   if(msList.size() < 100) {
	    Ms m = new Ms(this.x, this.y);
	    msList.add(m);
	   }
	  }
	 }
	 public void upenCreate() { //적 생성 메소드
	  for(int i = 0; i < 1; i++) { //i 적의 개수
	   double rx = Math.random() *  1200;//좌우 범위
	   double ry = ((Math.random() * 30)+20); //상하 범위
	   Enemy en = new Enemy((int)rx, (int)ry); //enemy인자에 생성위치를 입력함
	   sel = 1;
	   enList.add(en); //이 부분을 각각 만들어야함
	  }
	 }
	 public void downenCreate() { //적 생성 메소드
		  for(int i = 0; i < 1; i++) { //i 적의 개수
		   double rx = Math.random() * (w - xw);//좌우 범위
		   double ry = ((Math.random() * 30)-500); 
		   Enemy en = new Enemy((int)rx, (int)-ry); //enemy인자에 생성위치를 입력함
		   sel = 2;
		   enList.add(en);
		  }
		 }
	 public void leftenCreate() { //적 생성 메소드
		  for(int i = 0; i < 1; i++) { //i 적의 개수
		   double rx = (Math.random() * 10);//좌우 범위
		   double ry = Math.random() * 500; //상하 범위
		   Enemy en = new Enemy((int)rx, (int)ry); //enemy인자에 생성위치를 입력함
		   sel = 3;
		   enList.add(en); // 이걸 통해서 위치가 바뀜 이걸 조작해야함
		  }
		 }
	 public void rightenCreate() { //적 생성 메소드
		  for(int i = 0; i < 1; i++) { //i 적의 개수
		   double rx = (Math.random() * 10)+w-20;// 맨 오른쪽부터 나오게 w-20 으로
		   double ry = Math.random() * 500; //상하 범위
		   Enemy en = new Enemy((int)rx, (int)ry); //enemy인자에 생성위치를 입력함
		   sel = 4;
		   enList.add(en);
		  }
		 }
	 public void crashChk() { //충돌 확인
	  Graphics g = this.getGraphics();
	  Polygon p = null;
	  for(int i = 0; i < msList.size(); i++) {
	   Ms m = (Ms)msList.get(i);
	   for(int j = 0; j < enList.size(); j++) {
	    Enemy e = (Enemy)enList.get(j);
	    int[] xpoints = {m.x, (m.x + m.w), (m.x + m.w), m.x};
	    int[] ypoints = {m.y, m.y, (m.y + m.h), (m.y + m.h)};
	    p = new Polygon(xpoints, ypoints, 4);
	    if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) { //만약 충돌하면 그 적은 remove
	     msList.remove(i);
	     enList.remove(j);
	    }
	   }
	  }
	  for(int i = 0; i < enList.size(); i++) { //충돌 범위
	   Enemy e = (Enemy)enList.get(i);
	   int[] xpoints = {x, (x+ + xw), (x + xw), x}; 
	   int[] ypoints = {y, y, (y + xh), (y + xh)};
	   p = new Polygon(xpoints, ypoints, 4);
	   if(p.intersects((double)e.x, (double)e.y, (double)e.w, (double)e.h)) {
	    enList.remove(i);
	    start = false;
	    end = true;
	   }
	  }
	 }
	 
	 
	 public void draw() {
	  Graphics gs = bi.getGraphics();
	  gs.setColor(Color.white); // 게임 바탕색깔
	  gs.fillRect(0, 0, w, h);
	  gs.setColor(Color.black); //내 캐릭터 색깔 + 글자 색깔
	  gs.drawString("적 개수 : " + enList.size(), w-120, 50); //숫자는 글자 배치 유동적으로 움직이기 위해 w로 지정
	  gs.drawString("게임시작 : Enter", w-120, 70);
	  
	  if(end) {
	   gs.setFont(new Font("궁서",Font.BOLD,100));
	   gs.drawString("패배", 100, 250); // 충돌 판정 시 메세지
	  }
	  
	  gs.fillRect(x, y, xw, xh); //내 캐릭터 크기
	   
	  for(int i = 0; i < msList.size(); i++) {
	   Ms m = (Ms)msList.get(i);
	   gs.setColor(Color.blue);
	   gs.drawOval(m.x, m.y, m.w, m.h);
	   if(m.y < 0) msList.remove(i);
	   m.moveMs();
	  }
	  gs.setColor(Color.black);
	  for(int i = 0; i < enList.size(); i++) {
	   Enemy e = (Enemy)enList.get(i);
	   gs.fillRect(e.x, e.y, e.w, e.h);
	   if(e.y > h) enList.remove(i);
	   e.moveEn(); //적 위치 이동
	  }
	  
	  Graphics ge = this.getGraphics();
	  ge.drawImage(bi, 0, 0, w, h, this);
	 }
	 
	 public void keyControl() { //캐릭터 움직이는 속도
	  if(0 < x) {
	   if(left) x -= 3;
	  }
	  if(w > x + xw) {
	   if(right) x += 3;
	  }
	  if(25 < y) {
	   if(up) y -= 3;
	  }
	  if(h > y + xh) {
	   if(down) y += 3;
	  }
	 }
	 
	 public void keyPressed(KeyEvent ke) { //키 반응
	  switch(ke.getKeyCode()) {
	  case KeyEvent.VK_LEFT:
	   left = true;
	   break;
	  case KeyEvent.VK_RIGHT:
	   right = true;
	   break;
	  case KeyEvent.VK_UP:
	   up = true;
	   break;
	  case KeyEvent.VK_DOWN:
	   down = true;
	   break;
	  case KeyEvent.VK_A:
	   fire = true;
	   break;
	  case KeyEvent.VK_ENTER:
	   start = true;
	   end = false;
	   break;
	  }
	 }
	 
	 public void keyReleased(KeyEvent ke) { //키 반응
	  switch(ke.getKeyCode()) {
	  case KeyEvent.VK_LEFT:
	   left = false;
	   break;
	  case KeyEvent.VK_RIGHT:
	   right = false;
	   break;
	  case KeyEvent.VK_UP:
	   up = false;
	   break;
	  case KeyEvent.VK_DOWN:
	   down = false;
	   break;
	  case KeyEvent.VK_A:
	   fire = false;
	   break;
	  }
	 }
	 
	 public void keyTyped(KeyEvent ke) {}
	 


	class Ms {
	 int x;
	 int y;
	 int w = 50;
	 int h = 50;
	 public Ms(int x, int y) {
	  this.x = x;
	  this.y = y;
	 }
	 public void moveMs() {
	  y--;
	 }
	}

	class Enemy { //적 크기 + 생성 위치
	 int x;
	 int y;
	 int w = 10;
	 int h = 10;
	 public Enemy(int x, int y) { //생성을 어느쪽으로 치우쳐서 할 것인지
	  this.x = x; 
	  this.y = y;
	 }
	 public void moveEn() { //움직이는 방향 한개한개 컨트롤하고 랜덤으로 움직이게 해야함
		 if(sel==1){
		 y++;
		 }
	 }
		 
	}
}
//	 public void leftmoveEn(){
//		 x--;
//	 }*/


 //여기까지 닷지 게임 위에서 적생성 up 아래서 적 생성 down 옆 left right 이런식으로 적 생성 메소드를 4개 만들어야하나? ->다른 곳에서 공통으로 쓰이는 것들은 어떻게 해결하나
//enList.add(en);로 공통적으로 움직임 조작하는데 분리할 방법
//생성 위치 기준은 뭐로 잡을건가? (아래꺼)
//적 움직임 한개한개 랜덤으로 움직여야함
//패널에 넣기
