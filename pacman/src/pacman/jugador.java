package pacman;

public class jugador {
    private Integer x,y;
    private String marca="C";
    private boolean isAlive=true;
    jugador(Integer x, Integer y){
        this.x=x;
        this.y=y;
    }
    jugador(){}
    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }
    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }
    public void setMeOn(Integer x, Integer y){
        this.setX(x);
        this.setY(y);
    }
    public String getMarca(){
        return this.marca;
    }
    public boolean isIsAlive() {
        return isAlive;
    }
    
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
