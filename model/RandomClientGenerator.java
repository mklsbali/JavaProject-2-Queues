package ro.utcn.tp.assig2.model;


import java.util.Random;

public class RandomClientGenerator {
	private Random nr=new Random();
	private int minArrivingTime=20;
	private int maxArrivingTime=20;
	private int id=0;
	private int minServiceTime=40;
	private int maxServiceTime=40;
	
	public Client generateRandomClient() {
		
		int randomServiceTime=minServiceTime+nr.nextInt(maxServiceTime-minServiceTime+1);
		int randomArrivingTime=minArrivingTime+nr.nextInt(maxArrivingTime-minArrivingTime+1);
		
		Client c=new Client(id,randomServiceTime,randomArrivingTime);
		id++;
		
		return c;
	}
	

	public void setMinArrivingTime(int minArrivingTime) {
		this.minArrivingTime = minArrivingTime;
	}


	public void setMaxArrivingTime(int maxArrivingTime) {
		this.maxArrivingTime = maxArrivingTime;
	}


	public void setMinServiceTime(int minServiceTime) {
		this.minServiceTime = minServiceTime;
	}

	public void setMaxServiceTime(int maxServiceTime) {
		this.maxServiceTime = maxServiceTime;
	}


	
	
	
	
}
