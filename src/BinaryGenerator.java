import java.util.ArrayList;

public class BinaryGenerator {

  
    public ArrayList<Integer> GenerateBinaryFormat(long number)
    {

    	ArrayList<Integer> binary = new ArrayList();
        int index = 0;
        int bineq = 0;

        while(number > 0)
         {
          	bineq = (int)number%2;
        	binary.add(new Integer(bineq));
        	number = number/2;
         }
        return binary;
        
    }
}

     
