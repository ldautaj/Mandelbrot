public class Mandlebrot
{
   public static void main(String[] args)
   {
      Turtle t = new Turtle();
      t.color(0, 0, 255);
      t.fill();
      t.forward(100);
      t.delay(0);
      t.color(0, 0, 0);
      for(int i = -2000;i < 2000;i++)
      {
         for(int j = -2000;j < 2000;j++)
         {
            double[] c = new double[]{i/1000.0, j/1000.0};
            
            if(mandlebrot(c))
            {
               t.penup();
               t.forward(300*c[0]);
               t.left(90);
               t.forward(300*c[1]);
               t.pendown();
               if(mandlebrotColor(c) <= 255)
               {
                  t.color(0, 0, 0);
               }
               else if(mandlebrotColor(c) <= 510)
                  {
                     t.color(255, mandlebrotColor(c) - 255, 0);
                  }
                  else
                  {
                     t.color(0, 255, mandlebrotColor(c) - 510);
                  }
               t.forward(0.25);
               t.penup();
               t.backward(0.25);
               t.backward(300*c[1]);
               t.right(90);
               t.backward(300*c[0]);
               t.pendown();
            };
          }
      }
  }
  
  public static boolean mandlebrot(double[] c)
  {
      double[] z = new double[]{0,0};
      for(int i = 0;i < 100;i++)
      {
         z = sumArray(squaredArray(z), c);
      }
      return z[0]*z[0] + z[1]*z[1] <= 2;
  }
  
  public static int mandlebrotColor(double[] c)
  {
      double[] z = new double[]{0,0};
      int count = 0;
      for(int i = 0;i < 9999;i++)
      {
         z = sumArray(squaredArray(z), c);
         if(z[0]*z[0] + z[1]*z[1] <= 2)
         {
            count++;
         };
      }
      return (int)(count*255/3333);
  }
  
  public static double[] sumArray(double[] x, double[] y)
  {
      double[] result = new double[2];
      result[0] = x[0] + y[0];
      result[1] = x[1] + y[1];
      return result;
  }
  
  public static double[] squaredArray(double[] x)
  {
      double[] result = new double[2];
      result[0] = x[0]*x[0] - x[1]*x[1];
      result[1] = 2*x[0]*x[1];
      return result;
  }
  
  public static void printArray(double[] x)
  {
      System.out.println("["+x[0]+", "+x[1]+"]");
  }
}