/** This program will generate a set of public and private key  given two  **/
/** prime numbers.                                                         **/

import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class keygen
{
  /** Find a coprime of input m **/
  public static BigInteger coprime(BigInteger m) {
      Random rnd = new Random();
      primegen pg = new primegen();
      int length = m.bitLength()-1;
      BigInteger e = new BigInteger(length/2, new Random());
      while (!(m.gcd(e)).equals(BigInteger.ONE)) {
      	 e = new BigInteger(length, new Random());
      }
      return e;
   }

  /**===============**/
  /** Main function **/
  /**===============**/
  public static void main (String[] args){
      if (args.length < 2) {
         System.out.println("Usage: keygen <prime 1> <prime 2>");
         return;
      }
      primegen pg   = new primegen();
      primecheck pc = new primecheck();

      /** Step 1: Two prime numbers are entered by the user: p and q. **/
      BigInteger p  = new BigInteger(args[0]);
      BigInteger q  = new BigInteger(args[1]);

      /** Step 2: Calculate n = p*q. **/
      BigInteger n  = p.multiply(q);

      /** Step 3: Calcule phi(n) = (p-1)*(q-1). **/
      BigInteger phiN  = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

      /** Step 4: Find e such as gcd(e, phi(n)) = 1 and 1 < e < phi(n). **/
      /** Such a number is called a coprime, see coprime function.      **/
      BigInteger e  = coprime(phiN);
      while (e.compareTo(phiN) != -1){
          e = coprime(phiN);
      }

      /** Step 5: Calculate d such as e.d = 1 mod(phi(n)).         **/
      /** Such a number is called a modular multiplicative inverse **/
      BigInteger d  = e.modInverse(phiN);

      /** Print public and private key **/
      System.out.println("Public key:  ("+n + ", " +e + ")");
      System.out.println("Private key: ("+n + ", " +d + ")");
  }
}
