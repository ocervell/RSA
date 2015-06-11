/** This program is a prime check of an arbitraty long number       **/
/** Using the BigInteger library allows to manipulate large numbers **/

import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

/** Class primecheck **/
public class primecheck
{
	BigInteger ZERO = BigInteger.valueOf(0);
    BigInteger ONE = BigInteger.valueOf(1);
    BigInteger TWO = BigInteger.valueOf(2);

    /** Function to check if prime or not **/
    public boolean isPrime(BigInteger n, int iteration)
    {
        /** base case **/
        if (n.equals(ZERO) || n.equals(ONE))
            return false;
        /** base case - 2 is prime **/
        if (n.equals(TWO))
            return true;
        /** an even number other than 2 is composite **/
        if (n.mod(TWO).equals(ZERO))
            return false;

        BigInteger s = n.subtract(ONE);
        while (s.mod(TWO).equals(ZERO)){ // s mod(2) == 0 ?
            s = s.divide(TWO); // s /= 2
		}
        Random rand = new Random();
        BigInteger p = n.subtract(ONE); // p = n - 1

        /** Perform iteration times passes **/
        for (int i = 0; i < iteration; i++)
        {
            long r = Math.abs(rand.nextLong());
            BigInteger a = BigInteger.valueOf(r).mod(p).add(ONE);;
            BigInteger temp = s;
            BigInteger mod = modPow(a, temp, n);

            /** Loop while temp != s and mod != 1 and mod != n - 1 **/
            while (!temp.equals(s) && !mod.equals(ONE) && !mod.equals(p))
            {
                mod = mulMod(mod, mod, n); // mod = mod*mod mod(n)
                temp.multiply(TWO);        // temp *= 2
            }
            if (!mod.equals(p) && temp.mod(TWO).equals(ZERO))
                return false;
        }
        return true;
    }

    /** Modular exponentiation **/
    /** Computes (a ^ b) % c   **/
    public BigInteger modPow(BigInteger a, BigInteger b, BigInteger c)
    {
        BigInteger res = ONE;
        for (int i = 0; i < b.intValue(); i++)
        {
            res.multiply(a);
            res.divide(c);
        }
        return res.mod(c);
    }

    /** Modular multiplication **/
    /** Computes (a * b) % c   **/
    public BigInteger mulMod(BigInteger a, BigInteger b, BigInteger mod)
    {
        return a.multiply(b.mod(mod));
    }

    /**===============**/
    /** Main function **/
    /**===============**/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n=====================================");
        System.out.println("Miller Rabin Primality Algorithm Test");
        System.out.println("=====================================");
        int k = 10;
        if (args.length < 1){
          System.out.println("Usage: primecheck <number> <passes (optional)>");
          return;
        }
        else if (args.length == 2)
          k = Integer.parseInt(args[1]);

        System.out.println("Input:  " + args[0]);
        System.out.println("Passes: " + k + "\n");
        /** Make an object of primecheck class **/
        primecheck mr = new primecheck();

        /** Accept number **/
        BigInteger num = new BigInteger(args[0]);

        /** Check if prime or not **/
        boolean prime = mr.isPrime(num, k);
        if (prime)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
