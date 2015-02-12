package pacman;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Scanner;
public class tablero {
	public static int alto=17, ancho=19;
	public static String[][] tablero=new String[alto][ancho];
	private static tablero t;
	private static jugador j;
	private static fantasma f1, f2, f3;
	private static boolean first=true;
	public static void main(String[] args){
		t=new tablero();
		j=new jugador();
		f1=new fantasma();
		f2=new fantasma();
		f3=new fantasma();
		
		setJugadorOn(1,1);
		setFantasmaOn(15,1, f1); //15,1, f1
		setFantasmaOn(5, 17, f2);
		setFantasmaOn(9,9,f3);
		boolean loop=true;
		do{
			t.toString();
			t.getMoveJug();
			randomFantasma(f1);
			randomFantasma(f2);
			randomFantasma(f3);
			if(!j.isIsAlive()){
				loop=false;
				System.out.println("t'a matat un fantasma");
				t.toString();
            }
		}while(loop);
	}
	tablero(){
		this.llenarTablero();
	}
	public static void getMoveJug(){
            boolean loop=false;
            String op;
            do{
                System.out.println("[W,A,S,D]");
                op=new Scanner(System.in).next();
                op=op.toUpperCase();
                if(op.equals("W") || op.equals("A") || op.equals("S") || op.equals("D")){
                    loop=false;
                }else loop=true;
            }while(loop);
            if(op.equals("W")) setJugadorOn(j.getX()-1, j.getY());
            if(op.equals("S")) setJugadorOn(j.getX()+1, j.getY());
            if(op.equals("A")) setJugadorOn(j.getX(), j.getY()-1);
            if(op.equals("D")) setJugadorOn(j.getX(), j.getY()+1);
    }//END-getMoveJug
	public static void llenarTablero(){
		tablero[0] = "###################".split("");
		tablero[1] = "#........#........#".split("");
		tablero[2] = "#.##.###.#.###.##.#".split("");
		tablero[3] = "#.................#".split("");
		tablero[4] = "#.##.#.#####.#.##.#".split("");
		tablero[5] = "#....#...#...#....#".split("");
		tablero[6] = "####.###.#.###.####".split("");
		tablero[7] = "####.#.......#.####".split("");
		tablero[8] = "####...#####...####".split("");
		tablero[9] = "####.#.......#.####".split("");
		tablero[10]= "####.###.#.###.####".split("");
		tablero[11]= "#....#...#...#....#".split("");
		tablero[12]= "#.##.#.#####.#.##.#".split("");
		tablero[13]= "#.................#".split("");
		tablero[14]= "#.##.###.#.###.##.#".split("");
		tablero[15]= "#........#........#".split("");
		tablero[16]= "###################".split("");		
	}	
	@Override
        public String toString(){
            for(int i=0; i<alto; i++){
                for(int u=0; u<ancho; u++){
                    System.out.print(tablero[i][u]);
                }
                System.out.println();
            }
            return "";
        }
        public static void randomFantasma(fantasma f){
            boolean loop=false;
            do{
                loop=false;
                switch(aleatorio(0,4)){
                    case 1: //arriba
                        if(!setFantasmaOn(f.getX()+1, f.getY(), f)) loop=true;
                        break;
                    case 2: //derexa
                        if(!setFantasmaOn(f.getX(), f.getY()+1, f)) loop=true;
                        break;
                    case 3: //izkierda
                        if(!setFantasmaOn(f.getX(), f.getY()-1, f)) loop=true;
                       break;
                    case 4: //abajo
                        if(!setFantasmaOn(f.getX()-1, f.getY(), f)) loop=true;
                        break;                    
                }                
            }while(loop);
        }//end-randomFantasma
        public static boolean setFantasmaOn(Integer x, Integer y, fantasma f){
        	boolean return_value=false;
        	if(tablero[x][y].equals(".") ){ //|| tablero[x][y].equals("C")
        		tablero[x][y]=f.getMarca();
        		if(f.getX()!=null)
        			tablero[f.getX()][f.getY()]=".";
        		f.setMeOn(x, y);
        		return_value= true;
        	}else if(tablero[x][y].equals("C")){
        		tablero[x][y]=f.getMarca();
        		if(f.getX()!=null)
        			tablero[f.getX()][f.getY()]=".";
        		f.setMeOn(x, y);        		
        		j.setIsAlive(false);
        		return_value=true;
        	}else return_value= false;
        	return return_value;
        }//end-setFantasmaOn
        public static int aleatorio(Integer max,Integer min){
        	return (int)(Math.random()*(max-min))+min;		
        }
		public static void setJugadorOn(Integer x, Integer y){
	            if(tablero[x][y].equals(".")){
	                tablero[x][y]=j.getMarca();                
	                if(j.getX()!=null)
	                    tablero[j.getX()][j.getY()]=".";
	                j.setMeOn(x, y);
	            }else if(tablero[x][y].equals("?")){
	            	j.setIsAlive(false);
	            }else System.out.println("Direccio no permesa");
		}//end-setJugadorOn
}