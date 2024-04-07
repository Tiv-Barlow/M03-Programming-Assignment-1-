//M03 Programming Assignment (1)
//Ivy Tech Community College
//SDEV 200 - Java
//Professor Bumgardner
//Nativida Muhammad
//07 April 2024

public class Main {
  private long[] r = new long[2]; // Internal representation for numerator and denominator

  public Main() {
    this(0, 1);
  }

  public Main(long numerator, long denominator) {
    long gcd = gcd(numerator, denominator);
    r[0] = (denominator > 0 ? 1 : -1) * numerator / gcd;
    r[1] = Math.abs(denominator) / gcd;
  }

  // Greatest Common Denominator (GCD)
  private long gcd(long numerator, long denominator) {
    return (denominator == 0) ? numerator : gcd(denominator, numerator % denominator);
  }

  // Addition module
  public Main add(Main other) {
    long newNumerator = r[0] * other.r[1] + other.r[0] * r[1];
    long newDenominator = r[1] * other.r[1];
    return new Main(newNumerator, newDenominator);
  }

  // Subtraction module
  public Main subtract(Main other) {
    long newNumerator = r[0] * other.r[1] - other.r[0] * r[1];
    long newDenominator = r[1] * other.r[1];
    return new Main(newNumerator, newDenominator);
  }

  // Multiplication module
  public Main multiply(Main other) {
    long newNumerator = r[0] * other.r[0];
    long newDenominator = r[1] * other.r[1];
    return new Main(newNumerator, newDenominator);
  }

  // Division module
  public Main divide(Main other) {
    long newNumerator = r[0] * other.r[1];
    long newDenominator = r[1] * other.r[0];
    return new Main(newNumerator, newDenominator);
  }

  // Override toString method to return string representation
  @Override
  public String toString() {
    return r[0] + "/" + r[1];
  }

  // Main method, the entry point of the program
  public static void main(String[] args) {
    // You can write code here to test your Main class
    // For example:
    Main mainObject = new Main(3, 4);
    System.out.println(mainObject);
  }
}
