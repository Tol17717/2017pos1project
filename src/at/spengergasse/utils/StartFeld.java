package at.spengergasse.utils;

public class StartFeld {
	private boolean isbesetzt;
	private boolean kannRaus;
	private Spielfigur figureOnSpot;

	
	public StartFeld() {
		super();
		setFigureOnSpot(null);
		this.isbesetzt = istBesetzt();
		
	}
	
	public StartFeld(Spielfigur sf) {
		super();
		setFigureOnSpot(sf);
		this.isbesetzt = istBesetzt();
	}


	public boolean istBesetzt() {
		if(this.figureOnSpot == null) {
			return false;
		}
		else {
			return true;
		}
	}

	
	public void setFigureOnSpot(Spielfigur figureOnSpot) {
		if(this.figureOnSpot == null && figureOnSpot != null) {
			this.figureOnSpot = figureOnSpot;
		}
		this.figureOnSpot = null;
	}
	
	public void removeFigurefromSpot() {
		this.figureOnSpot = null;
	}


	@Override
	public String toString() {
		return "StartFeld [isbesetzt=" + isbesetzt + ", kannRaus=" + kannRaus + ", figureOnSpot=" + figureOnSpot + "]";
	}
	
	
	
	

}
