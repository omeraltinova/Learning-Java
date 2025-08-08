package Section8.Example1;

public class Bed{
    private String style;
    private int pillows,height,sheets,quilt;

    public Bed(String style,int pillows,int height,int sheets,int quilt){
        this.style=style;
        this.pillows=pillows;
        this.height=height;
        this.sheets=sheets;
        this.quilt=quilt;
    }
    public void make(){
        // Print in the exact format expected by tests, no newline here
        System.out.print("Bed -> Making | ");
    }
    public String getStyle(){
        return style;
    }
    public int getPillows(){
        return pillows;
    }
    public int getHeight(){
        return height;
    }
    public int getSheets(){
        return sheets;
    }
    public int getQuilt(){
        return quilt;
    }
}
