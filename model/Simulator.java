package ro.utcn.tp.assig2.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import ro.utcn.tp.assig2.interfacce.Window;

public class Simulator extends Thread{
	
	private int maxTimp=1000;
	private int currentTimp=0;
	private int nrOfQueues=6;
	public static  boolean running;
	private RandomClientGenerator r;
	private  LinkedList<Coada> queues=new LinkedList<Coada>();
	
	public Simulator() {
		new Window();
		r = new RandomClientGenerator();
		running=false;
		Window.OK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				start();
				
			}
		});
		Window.SET.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int values[]=new int[4];
				for (int i=0;i<4;i++) 
					values[i]=Integer.parseInt(Window.textFields[i].getText());
				r.setMinArrivingTime(values[0]);
				r.setMaxArrivingTime(values[1]);
				r.setMinServiceTime(values[2]);
				r.setMaxServiceTime(values[3]);
				
			}
		});
	}

	public void run() {
		running=true;
		for (int i=0;i<nrOfQueues;i++) {
			Coada q=new Coada(i+1);
			queues.add(q);
			q.start();
		}
		while (true) {
			Client client=r.generateRandomClient();
			int QID=returnIDOfMostGoalQueue();
			for (Coada q:queues) {
				if (q.getID()==QID) {
					try {
						sleep(10*client.getArrivalTime());
					} catch (Exception e) {
						e.printStackTrace();
					}
					q.getCoada().addFirst(client);
					System.out.println("Client "+client.getID()+" added to coada "+q.getID()+" in timpul "+currentTimp);
					currentTimp+=client.getArrivalTime();
				}
			}
			
			if (currentTimp>=maxTimp)
			{
				running=false;
				break;
			}
		}
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getAvgTime());
		JOptionPane.showMessageDialog(null,"The avarage service time of all clients: "+getAvgTime()
		+"\nThe last queue finished in time: "+getFinishtime(), null, JOptionPane.WARNING_MESSAGE);
	}
		
	
	public int returnIDOfMostGoalQueue() {
		int coadaSize=50000;
		int minID=0;
		for (Coada c:queues) {
			if (c.getCoada().size()<coadaSize)
			{
				coadaSize=c.getCoada().size();
				minID=c.getID();
			}
		}
		return minID;
	}	
	public int getFinishtime() {
		int max=0;
		for (Coada q:queues) {
			if (q.getFinishTime()>max)
				max=q.getFinishTime();
		}
		return max;
	}
	public float getAvgTime() {
		float sum=0;
		for (Coada q:queues) {
			if (q.x==1)
				sum+=q.getAvarageWaitingTime();
		}
		sum/=(float)nrOfQueues;
		return sum;
	}



	
}
	



