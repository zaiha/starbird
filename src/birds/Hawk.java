package birds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Hawk extends BirdManager{


	public Hawk(int spawnSize, int spawnDeviation, int spawnDistance){
		super(spawnSize, spawnDeviation, spawnDistance);
		spawn();
	}
	
	public void spawn(){
		for(int i=0; i < spawnSize; i++){
			int xspawn = ((int)(Math.random() * spawnDeviation) + spawnDistance);
			int yspawn = ((int)(Math.random()*500) + 100);
			spawnList.add(new HawkBird(xspawn, yspawn));
		}
	}
}

class HawkBird extends BirdEntity{

	ImageIcon imgIC = new ImageIcon("resources//bbird2.png");
	static int maxhp 	= 10;
	static int damage 	= 30;
	static int xspeed 	= 12;
	static int yspeed 	= 0;
	static int size 	= 50;

	public HawkBird(int x, int y) {
		super(x, y);
		img = imgIC.getImage();
		hitbox = new Rectangle(x + 10, y +10 , 2 * size, size);
		hp = maxhp;
		dmg = damage;
	}

	public void draw(Graphics g){
		g.setColor(Color.blue);
		g.drawImage(img, xpos, ypos, null);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);

		g.setColor(Color.red);
		g.fillRect(xpos + 50, ypos + 70, maxhp, 5);

		g.setColor(Color.green);
		g.fillRect(xpos + 50, ypos + 70, hp, 5);

	}

	public void move() {
		xpos -= xspeed;
		hitbox.setLocation(xpos - xspeed + 10, ypos + 10);
	}


	public void bulletHit(int bulletDamage){
		if(hp - bulletDamage > 0){
			hp -= bulletDamage;
		}
		else{
			hp = 0;
		}
	}
}


