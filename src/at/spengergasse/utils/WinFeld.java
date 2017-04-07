/**
 * 
 */
package at.spengergasse.utils;

/**
 * @author Raphael
 *
 */
public class WinFeld {
	private boolean isbesetzt;
	private Spielfigur figureOnSpot;

	/**
	 * 
	 */
	public WinFeld(Spielfigur sf) {
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
		return "WinFeld [isbesetzt=" + isbesetzt + ", figureOnSpot=" + figureOnSpot + "]";
	}
	
	

}
