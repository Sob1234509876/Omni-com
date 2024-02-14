package Codes.Utils;

public class Math {

    static long powl(long a, long n)
    {
        if(n > 0){
            return a*powl(a, (n-1));
        } else if(n < 0){
            return (long)(0);
        } else {
            return (long)(1);
        }
    }

}