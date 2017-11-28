package classes;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Enemy.*;

//Projectile Class
//Projectile that is created by Tower class

public class Projectile {
	

	
	private String projectileImageBuffer;
	public BufferedImage projectileImage;
	private int spawnLocationX;
	private int spawnLocationY;
	private int locX;
	private int locY;
	private int damage = 25;
	private int damageType;
	private int slowRate= 0;
	private int armorReduce= 0;
	private int damagePerSec = 0;
	private Enemy target;
	private int speed = 10;
	private int targetLocX;
	private int targetLocY;
	public boolean isAlive = true;
	// private onhit effect2d :: 2d image

	// projectile animation :: 2dimage sequence

	// projectile brigtness : float

	//projectile sound effect :: sound2d

	

	public Projectile(int x,int y,int damage,int damageType,int slowRate,int armorReduce,int damagePerSec,Enemy target, String projectileImageBuffer){

		this.projectileImageBuffer = projectileImageBuffer;
		
		try {
			projectileImage = ImageIO.read(getClass().getResourceAsStream(projectileImageBuffer));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		
		this.locX = x;
		this.locY = y;
		this.damage = damage;
		this.damageType = damageType;
		this.slowRate = slowRate;
		this.armorReduce = armorReduce;
		this.damagePerSec = damagePerSec;
		this.target = target;
		targetLocX = target.locX-locX;
		targetLocY =  target.locY-locY;
	}
	
	public Projectile(int x, int y, Enemy target){
		projectileImageBuffer = "/images/projectiles/ex0.png";
		this.locX = x;

		this.locY = y;
		
		spawnLocationX = this.locX;
		spawnLocationY = this.locY;
		this.target = target;
		
		try {
			projectileImage = ImageIO.read(getClass().getResourceAsStream(projectileImageBuffer));
		}	catch(IOException exc) {
				exc.printStackTrace();
		}
		
		targetLocX = target.locX-locX;
		targetLocY =  target.locY-locY;
	}

	public void move(){
		System.out.println("locX 1: " + locX);
		locX = spawnLocationX + ((targetLocX-locX)/10) * 1;
		System.out.println("locX 2: " + locX);
		locY = spawnLocationY + ((targetLocY-locY)/10) * 1;
		targetLocX = target.locX-locX;
		targetLocY =  target.locY-locY;
		//System.out.println(locX);
		
		/*if(Math.abs(locX - target.locX) < 20 && Math.abs(target.locY - locY) < 20)
		{
			dealDamage();
			isAlive = false;
			targetLocX = 0;
			targetLocY = 0;
		}*/
	}
	
	public void dealDamage(){
		target.takeDamage(damage);
	}

	public void update(){
		// update x and y to the target's x y
		if(target.getLocX() == this.getLocX() && target.getLocY() == this.getLocY())
			collision();
	}

	public void collision(){
		//if x and y is equal to the enemy's x y // enemy's healt/armor etc is reduced
		onHitDebuff();
	}

	public void onHitDebuff(){
		this.target.setSpeed(this.target.getSpeed() - this.slowRate); //updating target's speed
		this.target.setArmor(this.target.getArmor() - this.armorReduce); //updating target's armor
		this.target.setDebuffDPS(this.target.getDebuffDPS() + this.damagePerSec); // updating damage over time
		// damage koy
	}
	
	/////Getters
	public int getLocX(){
		return this.locX;
	}
	public int getLocY(){
		return this.locY;
	}
	public int getDamage(){
		return this.damage;
	}
	public int getDamageType(){
		return this.damageType;
	}
	public int getSlowRate(){
		return this.slowRate;
	}
	public int getArmorReduce(){
		return this.armorReduce;
	}
	public int getDamagePerSec(){
		return this.damagePerSec;
	}
	public Enemy getTarget(){
		return this.target;
	}
	
}
