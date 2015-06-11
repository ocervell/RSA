/** This program will encrypt a plaintext into a ciphertext, using a   **/
/** public key (n, e) as a parameter.                                  **/

import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class decrypt
{
  /** Decrypt a ciphertext into a plaintext **/
  public static BigInteger decrypt (BigInteger n, BigInteger d, BigInteger c){
    return c.modPow(d, n);
  }

  /**===============**/
  /** Main function **/
  /**===============**/
  public static void main (String[] args){
    if (args.length != 3){
      System.out.println("Usage: encrypt <n> <e> <plaintext>");
      return;
    }
    BigInteger n = new BigInteger(args[0]);
    BigInteger e = new BigInteger(args[1]);
    BigInteger c = new BigInteger(args[2]);

    decrypt d = new decrypt();
    BigInteger m = d.decrypt(n, e, c);
    System.out.println(m);
  }
}
