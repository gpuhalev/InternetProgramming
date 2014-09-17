import java.util.Random;

class Main{
	static Random r = new Random();
	 public static void main(String args[]){
		 System.out.println("I'm thinking of a number between 0 and 100! Can you guess it?");
		 int num=r.nextInt(100);
		 new Game(num);
	 }
}