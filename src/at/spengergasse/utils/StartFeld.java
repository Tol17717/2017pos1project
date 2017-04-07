package at.spengergasse.utils;

public class StartFeld {
	private boolean isbesetzt;
	private boolean kannRaus;
	private Spielfigur figureOnSpot;

	
	public StartFeld() {
		super();
		figureOnSpot = null;
	}


	public boolean isbesetzt() {
		return isbesetzt;
	}

	
	public void setFigureOnSpot(Spielfigur figureOnSpot) {
		if(this.figureOnSpot == null && figureOnSpot != null) {
			this.figureOnSpot = figureOnSpot;
		}
	}
	
	

}
