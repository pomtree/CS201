// delete this line if this is not in a folder called lab1
package lab1;


public class Stars {


    /**
      Prints a star pyramid with some number of rows:

      5
      *
      **
      ***
      **
      *

      9
      *
      **
      ***
      ****
      *****
      ****
      ***
      **
      *

      6
      *
      **
      ***
      ***
      **
      *

     * @param n
     */
    public static void printStars(int n) {
        int max_stars = (int) Math.floor(n / 2.0 + .5);
        for(int i = 0; i <= n; i++) {
            if(i > max_stars)
                printXstars(2 * max_stars - i);
           else if (n % 2 == 0 && i == max_stars) {
               printXstars(max_stars);
               printXstars(max_stars);
            }
            else
                printXstars(i);
        }


    }
    private  static void printXstars(int x) {
        System.out.println();
        for(int i = 0; i < x; i++) {
            System.out.print("*");
        }
    }

    public static void main(String[] args) {
        int n = 6;
        printStars(n);

        n = 9;
        printStars(n);

        n = 2;
        printStars(n);
    }
}
