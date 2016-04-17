import java.util.Random;
import java.lang.*;

public class RandomPrime 
   {
	   private long max = 10000;
	   RandomNumber randomNo = new RandomNumber(max);
       long num;
	    
	   long generatePrime()
		{
			do
			{
			   num = randomNo.nextValue();
//			   System.out.println(num);
			   
			}while(checkPrime(num)==false);
				
			return num;
		}
	    
	   boolean checkPrime(long num)
	    {
	    	boolean result = false;
	    	if(num%2!=0)
	    	{
	    	   if(fermatPrimariltyTest(num) && millerRabinTest(num))
	    	    {
	    	       result = true;
	    	    }
	    	   
	        }
	    	return result;
	    }
		
	    boolean fermatPrimariltyTest(long p)
		{
		   boolean result = false;
		   long a = 2;
		  // long temp = (long) java.lang.Math.pow(a,p-1);
		   if(modPow(a,p-1,p)==1)
		   {
			   result = true;
		   }
		   return result;
		}
		
		
	    boolean millerRabinTest(long n)
		{
		    if (n == 0 || n == 1)
	            return false;
	        if (n == 2)
	            return true;
	        if (n % 2 == 0)
	            return false;
		
	       boolean result = false;
		   long k = 20,a,i=0,up,low,x,d,s = 0,temp;
		   Random random = new Random();
		   up = n;
		   low = 2;
		   temp = n-1;
		   while(temp%2==0)
		   {
			  temp =  temp/2;
			  s++;
		   }
		   d = temp;
//		   System.out.println("2^"+s+" X "+d);
//		    n-1 = 2^s x d
		   
		   for(i=0;i<k;i++)
		   {
			   a = random.nextInt((int) ((up - low)+1)) + low;
		       x = modPow(a, d, n);
		       if(x==1 || x==n-1)
		       {result=true;}
		       for(int r=1;r<s;r++)
		         {
		        	 x = (x*x) % n;
		    	     if(x==n-1)
		    	        {result=true;}
		         }
		    }
		   
		   return result;
		}
		
		public long modPow(long a, long d, long n)
		{
			//  output = a^d mod n
			long res = 1;
			for(int i=0;i<d;i++)
			{
				res= res* a;
				res = res%n;
				
			}
			return res % n;
		}
		
		

}
