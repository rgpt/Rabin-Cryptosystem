import java.io.*;
import java.lang.*;
import java.lang.Math.*;
import java.util.ArrayList;

class Decryption
  {

	
	long p,q,n,invp,invq;
	long r,s;
	long m1,m2,m3,m4;
	ArrayList<Long> message_pieces = new ArrayList<Long>(); 
	long piece;
	long x=0,y=0;
	long i=0,breaksize,nsize;
	
	void Decrypt(ArrayList<Long> c)
	{
        ExtendedEuclid eeuclid = new ExtendedEuclid();
		eeuclid.compute(p, q);
		
		invp = eeuclid.getx();
		if(invp<0){invp = q+ invp;}
		invq = eeuclid.gety();
		if(invq<0){invq = p+ invq;}
		System.out.println("\nEXTENDED EUCLIDEAN : invp = "+invp+" invq ="+invq);
		
		for(i=0;i<c.size();i++)
		{
			System.out.println("c = "+c.get((int) i)+" P+1/4 = "+((p+1)/4)+" q+1/4 ="+((q+1)/4));
			r = modPow( c.get((int) i), (p+1)/4 , p);
			s = modPow( c.get((int) i), (q+1)/4 , q);
			System.out.println("\nvalues : r = c^(p+1/4)mod p = "+r+"\n\t s = c^(q+1/4)mod q = "+s);
			x = (invp*p*s + invq*q*r)%n;
            y = (invp*p*s - invq*q*r)%n;
//          System.out.println("x = "+x+" y = "+y);
            
            //Four value possible
            m1 = x;
            if(m1<0){m1 = n+m1;}
            m2 = - x % n;
            if(m2<0){m2 = n+m2;}
            m3 = y;
            if(m3<0){m3 = n+m3;}
            m4 = - y % n;
            if(m4<0){m4 = n+m4;}
            System.out.println("Decrypted Messages : m1 = "+m1+"  m2 = "+m2+"  m3 = "+m3+"  m4 = "+m4);
            BinaryGenerator binary = new BinaryGenerator();
            DecimalGenerator decimal = new DecimalGenerator();
            ArrayList<Integer> check[] = new ArrayList[4];
            // all are in reverse order
            check[0] = binary.GenerateBinaryFormat(m1); 
            check[1] = binary.GenerateBinaryFormat(m2);
            check[2] = binary.GenerateBinaryFormat(m3);
            check[3] = binary.GenerateBinaryFormat(m4);
            
            
            
            int correct=-1,j=0;
            for(j=0;j<4;j++)
            {
            	if(check[j].size()<breaksize)
      			 {
      				 
      				 while(check[j].size()!=breaksize)
      				 {
      					check[j].add(0);
      				 }
      			 }
            	if(check[j].size()<=breaksize+3)
            	  {
            	    correct = -1;
            	    correct = check[j].get(0) + check[j].get(1) +check[j].get(2);
            	    if(correct == 0)
            	       {
            		       ArrayList<Integer> msg = new ArrayList<Integer>(check[j].subList(3, check[j].size()));
            		       msg = reverse(msg);
            		       piece = decimal.getDecimal(msg);
            		       message_pieces.add( piece );		
            		       System.out.println("DECRYPTED MESSAGE PARTS IS : "+piece);
                           break;  
            	       }
            	    }
               }
            
            
		}
		generateMessage(message_pieces);
		
	}
	
	
	
	void setValues(long p,long q,long n,long breaksize)
	{
		this.p = p;
		this.q = q;
		this.n = n;
		this.breaksize = breaksize;
		
	}
	
	public static <T> ArrayList<T> reverse(ArrayList<T> list) 
	{
           int length = list.size();
           ArrayList<T> result = new ArrayList<T>(length);
           for (int i = length - 1; i >= 0; i--) 
             {
                result.add(list.get(i));
             }
           return result;
    }
	
	
	//Generate message from the Broken Pieces
	
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
	
	void generateMessage(ArrayList<Long> msg)
	{
		int i=0,bin;
		BinaryGenerator binary1 = new BinaryGenerator();
		DecimalGenerator decimal1 = new DecimalGenerator();
		ArrayList<Integer> message = new ArrayList<Integer>();
		for(i=0;i<msg.size();i++)
		{
			 ArrayList<Integer> temp = binary1.GenerateBinaryFormat(msg.get(i));
			 if(temp.size()<breaksize)
			 {
				 
				 while(temp.size()!=breaksize)
				 {
					 temp.add(0);
				 }
			 }
			 temp = reverse(temp);
			 message.addAll(temp);
			 System.out.println(msg.get(i)+" ");
			 System.out.println(temp);
			 
		}
		System.out.println("Message : "+message);
		System.out.println("Message = "+decimal1.getDecimal(message));
	}
}