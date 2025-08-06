package Section7.OOPpart1.example;

public class Point {
    private int x,y;

    public Point(){

    }

    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public double distance(){
        return Math.sqrt(this.x*this.x+this.y*this.y);
    }
    public double distance(Point a){
        return Math.sqrt(((this.x-a.getX())*(this.x-a.getX()))+((this.y-a.getY())*(this.y-a.getY())));
    }
    public double distance(int x,int y){
        return Math.sqrt((this.x-x*this.x-x)+(this.y-y*this.y-y));
    }
}
