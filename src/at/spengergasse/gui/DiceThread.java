package at.spengergasse.gui;

import at.spengergasse.utils.Wuerfeln;
import javafx.scene.control.Button;

public class DiceThread extends Thread {

	private Button a;
	private Wuerfeln wuerfel;
	public int dice;

	public DiceThread() {
		// TODO Auto-generated constructor stub
	}

	public DiceThread(Button b, int dice) {
		// TODO Auto-generated constructor stub
		a = b;
		wuerfel = new Wuerfeln();
		this.dice = dice;
	}

	public DiceThread(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public DiceThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DiceThread(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	public DiceThread(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	public DiceThread(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public DiceThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	public DiceThread(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		float w = 75;
		int c = 0;
		for (int i = 0; i < 12; i++) {
			c = wuerfel.wuerfeln();
			if (c == 1) {
				a.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel1.jpg')");
			}
			if (c == 2) {
				a.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel2.jpg')");
			}
			if (c == 3) {
				a.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel3.jpg')");
			}
			if (c == 4) {
				a.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel4.jpg')");
			}
			if (c == 5) {
				a.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel5.jpg')");
			}
			if (c == 6 || i == 10) {
				a.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel6.jpg')");
			}
			try {
				Thread.sleep((int) w);
				w *= 1.175f;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}