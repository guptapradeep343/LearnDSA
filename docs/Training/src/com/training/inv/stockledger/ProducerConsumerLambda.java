package com.training.inv.stockledger;

class Job{
	String job=null;
	public void createJob(){
		job = "job created";
		System.out.println("job created..");
	}
	public void consumeJob(){
		job = null;
		System.out.println("job consumed..");
	}

	public boolean isJobFinished(){
		return job==null;
	}
}
public class ProducerConsumerLambda {
	Job j = new Job();
	public void consumerTask(){
		while(true){
			synchronized(j){
				if(!j.isJobFinished()){
					j.consumeJob();
					j.notify();
				}else{
					try {
						j.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public void producerTask(){
		while(true){
			synchronized(j){
				if(j.isJobFinished()){
					j.createJob();
					j.notify();
				}else{
					try {
						j.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ProducerConsumerLambda pcl = new ProducerConsumerLambda();
		Thread producer = new Thread(()->pcl.producerTask());
		Thread consumer = new Thread(pcl::consumerTask);
		producer.start();
		consumer.start();
	}
}
