import java.util.Scanner;


public class Game {
	public Game(int num){
		Scanner scan=new Scanner(System.in);
		int i = 0;
		
		while(true){
			System.out.println("Your guess is...?");
			i = scan.nextInt();
			if(i > num){
				System.out.println("A little bit lower...");
			}else if(i < num){
				System.out.println("A little bit higher...");
			}else if(i == num){
				System.out.println("That's right! You win!");
				String myNum = Integer.toString(num);
				String yourNum = Integer.toString(i);
				if(myNum.equals(yourNum)){
					System.out.println("My number is the same as your number");
				}else{
					System.out.println("My number is not the same as your number");
				}
				if(myNum != yourNum){
					System.out.println("But they are not the same object");
				}else{
					System.out.println("And they are the same object");
				}
				break;
			}
		}
	}
}
