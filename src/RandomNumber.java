public class RandomNumber 
{

private long maximum;
private long value;
private long nextvalue;

public RandomNumber(long max)
{
    this.maximum = max;
    value = (System.currentTimeMillis() % maximum);
}

public long nextValue()
  {
     nextvalue = (32719*value  + 2133) % maximum;
	 if(nextvalue%2==0)
         {
             value = (System.currentTimeMillis() % maximum);
	     }
	 else
	     {
	         value = nextvalue % maximum;
         }
	 return value;
    		 
  }

}
