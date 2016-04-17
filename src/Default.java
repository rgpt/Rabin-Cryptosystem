import java.io.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Default 
{
    
	public static void main(String[] args) 
       {
		     Scanner scan = new Scanner(System.in);
//     -------------------------------Group-13 TESTING RANDOM NUMBER GENERATOR-----------------------------------------------------------------------------------------------------------------------------------------------------------------      
//		     RandomNumber R = new RandomNumber(1000);
//           System.out.println("Random no Generated = "+R.nextValue()+"\n");
//	    -------------------------------Group-13 TESTING RANDOM PRIME GENERATOR-------------------------------------------------------------------------------------------------------------------------
//           RandomPrime prime = new RandomPrime();
//		     System.out.println("prime : "+prime.generatePrime());
//		---------------------------Group-13 TESTING BINARY GENERATOR-----------------------------------------------------------------------------------------------------------------------------------
//		     BinaryGenerator b = new BinaryGenerator();
//		     long x = 100;
//		     System.out.println("Input = "+x);
//		     ArrayList<Integer> temp = b.GenerateBinaryFormat(x);
//           System.out.println("Binary value = "+temp.toString());
//		     DecimalGenerator d = new DecimalGenerator();
//           long d1 = d.getDecimal(temp);
//           System.out.println("Decimal Value Back Again = "+d1);
//           long d2 = d.getPresetAddedDecimal(temp);
//           System.out.println("Preset Added Decimal = "+d2);
		
//		---------------------------------Group-13 TESTING EXTENDED EUCLIDEAN-----------------------------------------------------------------------------------------       
//				ExtendedEuclid eeuclid = new ExtendedEuclid();
//				long p = 23, q= 31;
//				eeuclid.compute(p, q);
//				long invp = eeuclid.getx();
//				if(invp<0){invp = q+ invp;}
//				long invq = eeuclid.gety();
//				if(invq<0){invq = p+ invq;}
//      ----------------------------------------------------------------------------------------------------------------------------------				
		     
		RandomPrime prime1 = new RandomPrime();
		RandomPrime prime2 = new RandomPrime();
		long n=0,p=0,q=0;
		while(p%4!=3 || q%4!=3)
		{
		      p = prime1.generatePrime();
		      q = prime2.generatePrime();
		
		      while(p==q )
		        { 
			        q = prime2.generatePrime();
		        }
		}
		n = p * q;
		System.out.println("Prime P = "+p+"\n\nPrime Q = "+q+"\n\nn = P X Q = "+n);
		System.out.println("Please Enter Your Message : ");
		long msg = scan.nextLong();
           
//		long p = 79, q= 43;
//		long msg = 200,n=3397;
		Encryption e=new Encryption();
		ArrayList<Long> cipher = e.Encrypt(msg, n);
        Decryption decry=new Decryption();
        decry.setValues(p,q,n,e.getBreakSize());
        decry.Decrypt(cipher);
       }
}
