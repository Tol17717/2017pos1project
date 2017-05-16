package at.spengergasse.utils;

public class FarbeCompare {

	public FarbeCompare() {
		
	}

	public void start(Farbe a, Farbe b, Farbe c, Farbe d)
    {
        Farbe[] farben = new Farbe[4];
       
        for(int i = 0; i<4; i++)
        {
            Farbe currentRead = getSelectedColorInRow(i, a, b, c, d);
            System.out.println(currentRead);
            if(enumArrayContains(farben, currentRead)) throw new IllegalArgumentException("Double occurence!");
            else farben[i] = currentRead;
        }
    }
   
    public boolean enumArrayContains(Farbe[] fArray, Farbe contain)
    {
        boolean val = false;
       
        for (Farbe farbe : fArray) {
            if(farbe!=null&&farbe.equals(contain)) val = true;
        }
        return val;
    }
   
    public Farbe getSelectedColorInRow(int row, Farbe a, Farbe b, Farbe c, Farbe d)
    {
        if(row==0) return a;
        if(row==1) return b;
        if(row==2) return c;
        if(row==3) return d;
       
        return null;
    }
}
