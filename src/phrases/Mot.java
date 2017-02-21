package phrases;

public class Mot {
	String mot;
	int x;
	int y;
	int xMax;
	int yMin;
	
	public Mot(String mot){
		this.mot = mot;
	}
	
	public String toStr(){
		return mot;
	}
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getXMax(){
		return xMax;
	}
	public void setXMax(int x){
		this.xMax = x;
	}
	public int getYMin(){
		return yMin;
	}
	public void setYMin(int y){
		this.yMin = y;
	}
}
