import java.util.ArrayList;

public class DecimalGenerator 
{

	long decimal = 0;
	long power = 0;
	
	
	public long getPresetAddedDecimal(ArrayList<Integer> bits)
	{
		for(int i = bits.size()-1;i>= 0;i--)
		{
		    power = i+3;
		    decimal += (int)bits.get(i)*Math.pow(2,power);
		}
		return decimal;
	}
	
	//Generate Decimal
	public long getDecimal(ArrayList<Integer> bits)
	{
		for(int i = bits.size()-1;i>=0;i--)
		{
		    power = bits.size()-i-1;
		    decimal += (int)bits.get(i)*Math.pow(2,power);
		}
	   return decimal;
	}
}