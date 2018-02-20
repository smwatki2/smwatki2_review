package main.java;

/**
 *  The <code>RandomNumber</code> class  offers facilities 
 *  for pseudorandom number generation.
 *  <p>
 *  An instance of this class is used to generate a stream of 
 *  pseudorandom numbers. The class uses a long currentSeed, which is 
 *  modified using a linear congruential formula. See <ul>
 *  <li>Donald Knuth, <i>The Art of Computer Programming, 
 *  Volume 2</i>, Section 3.2.1. for general information about
 *  random number gerneration and 
 *  <li>S. Park and K. Miller, Random number generators: Good
 *  ones are hard to find, <i>Comm. ACM</i> 31 (1988) 1192-1201 
 *  for the specific one implemented here.  
 *  </ul>
 *  @see java.util.Random
 *  @see java.lang.Math#random()
 */
public class RandomNumber {
        private static final long MULTIPLIER = 16807;
        private static final long MODULUS =  2147483647;
        // Quotient of MODULUS / MULTIPLIER
        private static final long QUOT = 127773; 
        // Remainder of MODULUS / MULTIPLIER
        private static final long REM  = 2836;   

        /**
         * The current currentSeed of the generator. 
         */
        private long currentSeed;
    
        /**
         * Constructs a RandomNumber object and initializes it
         * with <code>System.currentTimeMillis()</code>
         */
        public RandomNumber() {
                currentSeed = System.currentTimeMillis() % MODULUS;
        }
    
        /**
         * Constructs a RandomNumber object and initializes it
         * with the value <code>currentSeed</code>
         * @param currentSeed A value that permits a controlled 
         * setting of the start currentSeed.
         */
        public RandomNumber(long currentSeed) {
                currentSeed = Math.abs(currentSeed) % MODULUS;
        }
                
        
        /**
         * Generates the next random number in the interval [0,1]
         * @return The next random number in [0,1].
         */
        public double nextDoubleRand() {
                long temp = MULTIPLIER*(currentSeed%QUOT) - 
                                REM*(currentSeed/QUOT);
                currentSeed = (temp > 0) ? temp : temp + MODULUS;
                return (double) currentSeed / (double) MODULUS;
        }
        
        /**
         * Generates a random int value between the given limits.
         * @param lo The lower bound.
         * @param hi The upper bound.
         * @return An integer value in {lo,...,hi}
         * @throws InvalidOperationException if lo > hi     
         */
        public int nextIntRand(int lo, int hi) 
                                throws InvalidOperationException {
                if (lo > hi)
                        throw new InvalidOperationException(
                                "invalid range: " + lo + " > " + hi);
                return (int) (nextDoubleRand() * (hi - lo + 1)  + lo);
        }
}

