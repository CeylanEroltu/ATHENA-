public class testException {

    // exception deneme

    public static void main(String[] args) {

        try {
            System.out.println(sum(new int[] {1, 2, 3, 4, 5}));
          }
          catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\n" + ex.getMessage());
            System.out.println("\n" + ex.toString());
      
            System.out.println("\nTrace Info Obtained from getStackTrace");
            StackTraceElement[] traceElements = ex.getStackTrace();
            for (int i = 0; i < traceElements.length; i++) {
              System.out.print("method " + traceElements[i].getMethodName());
              System.out.print("(" + traceElements[i].getClassName() + ":");
              System.out.println(traceElements[i].getLineNumber() + ")");

              try {
                fun();
              }
              catch (NullPointerException e) {
                System.out.println("Caught in main.");
              }
            }
          }
        }
      
        private static int sum(int[] list) {
          int result = 0;
          for (int i = 0; i <= list.length; i++)
            result += list[i];
          return result;
        
    }
}

class TestCircleWithException {
    public static void main(String[] args) {
      try {
        testException c1 = new testException(5);
        testException c2 = new testException(-5);
        testException c3 = new testException(0);
      }
      catch (IllegalArgumentException ex) {
        System.out.println(ex);
      }
  
      System.out.println("Number of objects created: " +
      testException.getNumberOfObjects());
    }
  }

  // Java program that demonstrates the use of throw
class ThrowExcep {
	static void fun()
	{
		try {
			throw new NullPointerException("demo");
		}
		catch (NullPointerException e) {
			System.out.println("Caught inside fun().");
			throw e; // rethrowing the exception
		}
	}
}

  