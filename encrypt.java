/** This program will encrypt a plaintext into a ciphertext, using a   **/
/** public key (n, e) as a parameter.                                  **/

import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class encrypt
{
  /** Encrypt a plaintext into a ciphertext **/
  public static BigInteger encrypt (BigInteger n, BigInteger e, BigInteger m){
    return m.modPow(e, n);
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
    BigInteger m = new BigInteger(args[2]);

    encrypt en = new encrypt();
    BigInteger c = en.encrypt(n, e, m);
    System.out.println(c);
  }
}
