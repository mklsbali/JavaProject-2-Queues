package ro.utcn.tp.assig2.model;

import java.util.LinkedList;

import ro.utcn.tp.assig2.interfacce.Window;

public class Coada extends Thread{
	private boolean wasStarted=false;
	private  LinkedList<Client> coada;
	public static boolean running;
	private  int ID;
	private int finishTime=0;
	private float avarageWaitingTime=0;
	public int x=0;

	public Coada(int ID) {
		this.ID=ID;
		coada=new LinkedList <Client>();
		running=false;
	}
	public void runInteriorThread() {
		Thread t=new Thread(new Runnable() {
			public synchronized void run() {
				while (true) {
					try {
						sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String s=" ";
					if (coada.size()>0)
					{
						for (Client c:coada) {
							
							s=s+c.getID()+" ";
						
					}
					}
					Window.textFields[ID-1].setText(s);
				}
				
			}
		});
		if (wasStarted==false){
			t.start();
			wasStarted=true;
		}
	}
	public void run() {
		runInteriorThread();
		int cnt=0;
		running=true;
		while(Simulator.running || coada.size()>0) {
			
			try {
				sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				sleep(1);
				if (coada.size()>0)
					sleep(10*coada.getLast().getServiceTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (coada.size()>0) {
				avarageWaitingTime+=(float)calculateWaitingTime(coada.getFirst());
				finishTime+=coada.getLast().getServiceTime();
				cnt++;
				System.out.println("Clientul "+coada.getLast().getID()+" has finished in coada "+this.getID());
				coada.removeLast();
				x=1;
			}
				
			
		}
		running=false;
		avarageWaitingTime/=cnt;
	//	System.out.println(avarageWaitingTime);
	}

	public int calculateWaitingTime(Client client)  {
		

		int totalServiceTime=client.getServiceTime();
		int clientIndex=coada.indexOf(client);
		
		for (Client curClient:coada)
		{
			if (coada.indexOf(curClient)>clientIndex)
			totalServiceTime+=curClient.getServiceTime();
		}
		
		return totalServiceTime;
			
		
	}
			
	public LinkedList<Client> getCoada() {
		return coada;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int getFinishTime(){
		return finishTime;
	}
	
	public float getAvarageWaitingTime() {
		return this.avarageWaitingTime;
	}

}
