package study;
import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Image; 
import java.awt.Point; 
import java.awt.event.KeyAdapter; 
import java.awt.event.KeyEvent; 
import java.util.ArrayList; 
import java.util.Timer; 
import java.util.TimerTask; 
import javax.swing.JFrame; 
public class Play extends JFrame 
{ 
  Point pos = new Point(250, 250);//주인공 원 위치 
  ArrayList<Bullet> bullets = new ArrayList<Bullet>();//총알들을 저장할 배열 
  boolean key_left = false; 
  boolean key_right = false; 
  boolean key_up = false; 
  boolean key_down = false;//키상태를 저장하기 위해 
  Image img;//더블 버퍼링을 위한 이미지 
  Timer gameLoop;//게임 루프 타이머 
  Timer bulletCreate;//총알을 생성 타이머 
  Timer gamePlayTimeLoop;//플레이 시간을 카운트할 타이머 
  float playTime;//플레이 한 시간 
  boolean isGamePlay = true;//게임상태      
  public Play() 
  { 
    setSize(500, 500); 
    setVisible(true); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setResizable(false); 
    gameStart(); 
 } 
 @Override 
 public void paint(Graphics g) 
 { 
   if (img == null)//이미지를 한번만 만들기 
   { 
     img = createImage(500, 500); 
  } 
  Graphics bg = img.getGraphics();//이미지의 그래픽 얻어오기 
  bg.clearRect(0, 0, 500, 500); 
  bg.setColor(Color.blue); 
  bg.fillOval(pos.x - 10, pos.y - 10, 20, 20);//주인공 원그리기 
  bg.setColor(Color.red); 
  for (int i = 0; i < bullets.size(); i++)//총알 그리기 
  { 
    bg.fillOval(bullets.get(i).pos.x - 5, bullets.get(i).pos.y - 5, 10, 10); 
 } 
 bg.setColor(Color.PINK); 
 bg.drawString("PlayTime : " + playTime, 400, 50);//플레이 시간 출력 
 if (!isGamePlay) 
 { 
   bg.setColor(Color.BLACK); 
   bg.drawString("Press Enter GameStart", 200, 250);//게임 오버일때 
} 
g.drawImage(img, 0, 0, this);//백버퍼를 화면에 보이게 
} 
public void keyMove()//키 상태에 따라 주인공 원 움직이기 
{ 
  if (key_left) 
  { 
    pos.x -= 5; 
 } 
 if (key_right) 
 { 
   pos.x += 5; 
} 
if (key_up) 
{ 
  pos.y -= 5; 
} 
if (key_down) 
{ 
  pos.y += 5; 
} 
} 
public void bulletMove() 
{ 
  for (int i = 0; i < bullets.size(); i++) 
  { 
    Bullet b = bullets.get(i); 
    b.pos.x += b.vec.x; 
    b.pos.y += b.vec.y;//총알 움직이기 
    if (b.pos.x < 0 || b.pos.x > 500)//화면을 벗어나면 
    { 
      bullets.remove(b); 
      break; 
   } 
   if (b.pos.y < 0 || b.pos.y > 500)//화면을 벗어나면 
   { 
     bullets.remove(b); 
     break; 
  } 
} 
} 
void bulletCollision() 
{ 
  for (int i = 0; i < bullets.size(); i++) 
  { 
    Bullet b = bullets.get(i); 
    float dis = (pos.x - b.pos.x) * (pos.x - b.pos.x) + (pos.y - b.pos.y) * (pos.y - b.pos.y); 
    if (dis < 225)//충돌 검사(주인공 원과 총알사이의 거리가 15보다 작다면(225는 15의 제곱) 
    { 
      gameLoop.cancel(); 
      bulletCreate.cancel();//타이머 종료 
      isGamePlay = false; 
   } 
} 
} 
void gameStart() 
{ 
  bullets.clear(); 
  playTime = 0.0f; 
  gamePlayTimeLoop = new Timer(); 
  gamePlayTimeLoop.schedule(new TimerTask() 
  { 
    @Override 
    public void run() 
    { 
      playTime += 0.1;//플레이 시간 카운트 
   } 
}, 100, 100); 
bulletCreate = new Timer(); 
bulletCreate.schedule(new TimerTask() 
{ 
  @Override 
  public void run() 
  { 
    Bullet bullet = new Bullet();//총알 생성 
    switch ((int) (Math.random() * 4))//총알 생성될 위치(좌 우 위 아래) 
    { 
      case 0: 
      bullet.pos.x = 0; 
      bullet.pos.y = (int) (Math.random() * 500); 
      break; 
      case 1: 
      bullet.pos.x = 500; 
      bullet.pos.y = (int) (Math.random() * 500); 
      break; 
      case 2: 
      bullet.pos.x = (int) (Math.random() * 500); 
      bullet.pos.y = 0; 
      break; 
      case 3: 
      bullet.pos.x = (int) (Math.random() * 500); 
      bullet.pos.y = 500; 
      break; 
   } 
   if (bullet.pos.x - pos.x >= 0)//위치에 따라 총알 움직임 변경 
   { 
     bullet.vec.x = -((int) (Math.random() * 3) + 3); 
  } else 
  { 
    bullet.vec.x = (int) (Math.random() * 3) + 3; 
 } 
 if (bullet.pos.y - pos.y >= 0) 
 { 
   bullet.vec.y = -((int) (Math.random() * 3) + 3); 
} else 
{ 
  bullet.vec.y = (int) (Math.random() * 3) + 3; 
} 
bullets.add(bullet);//생성된 총알을 배열에 넣기 
} 
}, 200, 200); 
gameLoop = new Timer(); 
gameLoop.schedule(new TimerTask() 
{ 
  @Override 
  public void run()//게임 루프 
  { 
    keyMove();//키 상태에 따라서 주인공 원 움직이기 
    bulletMove();//총알 움직이기 
    bulletCollision();//충돌 검사 
    repaint(); 
 } 
}, 60, 60); 
addKeyListener(new KeyAdapter() 
{ 
  @Override 
  public void keyPressed(KeyEvent e) 
  { 
    if (!isGamePlay && e.getKeyCode() == KeyEvent.VK_ENTER) 
    { 
      isGamePlay = true; 
      gameStart(); 
   } 
   switch (e.getKeyCode())//키입력 받기 
   { 
     case KeyEvent.VK_LEFT: 
     key_left = true; 
     break; 
     case KeyEvent.VK_RIGHT: 
     key_right = true; 
     break; 
     case KeyEvent.VK_UP: 
     key_up = true; 
     break; 
     case KeyEvent.VK_DOWN: 
     key_down = true; 
     break; 
  } 
} 
@Override 
public void keyReleased(KeyEvent e) 
{ 
  switch (e.getKeyCode()) 
  { 
    case KeyEvent.VK_LEFT: 
    key_left = false; 
    break; 
    case KeyEvent.VK_RIGHT: 
    key_right = false; 
    break; 
    case KeyEvent.VK_UP: 
    key_up = false; 
    break; 
    case KeyEvent.VK_DOWN: 
    key_down = false; 
    break; 
 } 
} 
}); 
} 
public static void main(String[] args) 
{ 
  new Play(); 
} 
} 
class Bullet//총알을 나타내는 클래스 
{ 
  public Point pos = new Point();//총알의 위치 
  public Point vec = new Point();//총알의 움직일 속도 
} 