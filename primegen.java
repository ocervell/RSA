/** This program will generate a prime number of a number of bits   **/
/** specified by the user.                                          **/

import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class primegen
{
    /** Prime generation **/
    public BigInteger gen (int nbits)
    {
        primecheck pc = new primecheck();
        while (true){ /** Loop until we find a prime number **/
          Random rnd = new Random();
          BigInteger x = new BigInteger(nbits, rnd);
          if (pc.isPrime(x, 20)){
            return x;
          }
        }
    }

    /**===============**/
    /** Main function **/
    /**===============**/
    public static void main (String[] args)
    {
        if (args.length != 1){
          System.out.println("Usage: primegen <nbits>");
          return;
        }

        int nbits = Integer.parseInt(args[0]);

        primegen pg = new primegen();
        BigInteger x = pg.gen(nbits);
        System.out.println(x);
    }
}
