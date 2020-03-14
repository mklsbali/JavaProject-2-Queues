package ro.utcn.tp.assig2.model;

public class Client extends  Thread{
	private int ID;
	private int ServiceTime;
	private int ArrivalTime;
	public Client(int ID,int ServiveTime,int ArrivalTime)
	{
		this.setID(ID);
		this.setArrivalTime(ArrivalTime);
		this.setServiceTime(ServiveTime);
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getServiceTime() {
		return ServiceTime;
	}
	public void setServiceTime(int serviceTime) {
		ServiceTime = serviceTime;
	}
	public int getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	
	
}
