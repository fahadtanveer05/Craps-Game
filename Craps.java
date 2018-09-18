import java.security.SecureRandom;

public class Craps
 {
   private static final SecureRandom randomNumbers = new SecureRandom();
	
	private enum Status { CONTINUE, WON, LOST };
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

      public static void main(String[] args)
    {    
	     int random = 0;
	     int playerWon = 0;
		 int playerLose = 0;
	     int W = 0;
		 int L = 0;
		 int frequencyW = 0;
		 int frequencyL = 0;
		 int[] State = new int[4];
		 int playerBalance = 2500;
         int casinoBalance = 5000;		 
	
		 
		 for(int n =0; n<=1000 ;n++)
		 {
			
          int myPoint = 0;
          Status gameStatus;
          int bet = randomBet();
          int sumOfDice = rollDice();
        
         switch (sumOfDice)
        {
            case SEVEN:
            case YO_LEVEN:
               gameStatus = Status.WON;
			   W++;
               ++State[0];
			   playerBalance = playerBalance + bet;
			   casinoBalance = casinoBalance - bet;
			   
          break;			   
		    
			case SNAKE_EYES:
			case TREY:
			case BOX_CARS:
			   gameStatus = Status.LOST;
			   L++;
               ++State[1]; 	       
		       playerBalance = playerBalance - bet;
			   casinoBalance = casinoBalance + bet;
			   
		  break;
		 
		 
		 default:
		  
		       gameStatus = Status.CONTINUE;
			   myPoint = sumOfDice;
			   System.out.printf("Point is %d %n", myPoint);
	     
		  break;
		}
		
		
		 while(gameStatus == Status.CONTINUE)
		{
			sumOfDice = rollDice();
			
			 if(sumOfDice == myPoint){
				 gameStatus = Status.WON;
			     frequencyW++;
				 ++State[2];
				 playerBalance = playerBalance + bet;
	             casinoBalance = casinoBalance - bet;		   
				 
			 }
			 else 
			   if(sumOfDice != myPoint){
				 gameStatus = Status.LOST;
			     frequencyL++;
				 ++State[3];
				 casinoBalance = casinoBalance + bet;
			     playerBalance = playerBalance - bet;
			   }
	    }
	
			
		 if(gameStatus == Status.WON)
		  System.out.println("Player wins \n\n\n");
		  
         else
			if(gameStatus != Status.WON)
		  System.out.println("Player loses \n\n\n");
	    
		
		System.out.printf("The player balance now is %d %n", playerBalance);
		System.out.printf("The casino balance now is %d %n", casinoBalance);
	    }
		
		playerWon = W + frequencyW;
		playerLose = L + frequencyL;
		
	  System.out.printf("Player wins %d times in total %n", playerWon);
	  System.out.printf("Casino wins %d times in total %n%n%n", playerLose);
	  System.out.println("The result of the game is :");
	  System.out.printf("Player won %d times at the first turn %n", State[0]);
	  System.out.printf("Casino won %d times at the first turn %n", State[1]);
	  System.out.printf("Player won %d times after the game was continued after the first turn %n", State[2]);
	  System.out.printf("Casino won %d times after the game was continued after the first turn %n", State[3]);
	  System.out.printf("The player's balance at the end is %d %n", playerBalance);
	  System.out.printf("The casino's balance at the end is %d %n", casinoBalance);
	}

		
		public static int rollDice()
		{
			
			int die1 = 1 + randomNumbers.nextInt(6);
			int die2 = 1 + randomNumbers.nextInt(6);
			
			int sum = die1 + die2;
			
			System.out.printf("player rolled %d + %d = %d %n", die1, die2, sum);
			
			return sum;
	    }
		
		 
		public static int randomBet()
		{ 
		   int b = 500 + randomNumbers.nextInt(500);
		   
		  System.out.printf("The bet is %d %n", b);
		   return b;
		} 
		
 }
 