package at.spengergasse.gui;

public class BotTime extends Thread {
	
	private int i;

	public BotTime() {
		// TODO Auto-generated constructor stub
	}

	public BotTime(int whichBot){
		i = whichBot;
	}
	
	public BotTime(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public BotTime(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public BotTime(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	public BotTime(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	public BotTime(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public BotTime(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	public BotTime(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Bot "+i+" hat gedrückt");
	}
}
