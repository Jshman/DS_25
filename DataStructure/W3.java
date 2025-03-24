
public class W3{
    public void main(String args[]) {
        System.out.println("Hello, World!");

        // sol1(20);
        // System.out.println("");
        // System.out.println(sol2(10));
        // System.out.println(sol3(1234567));
        // System.out.println(sol4(1234567890));
        // System.out.println(sol5(1234567890));

        System.out.println(pow(2, 10));

    }

    public void sol1(int x) {
        if (x==1){
            System.out.printf("%d ",x);
            return;
        }
        sol1(x-1);
        System.out.printf("%d ",x);
    }

    public int sol2(int x) {
        if (x == 1) {
            return 1;
        }
        return x + sol2(x-1);
    }

    public int sol3(long n) {
        int ret = 0;
        while (n>0) {
            n /= 10;
            ret++;
        }
        return ret;
    }

    public int sol4(long n) {
        int ret = 0;
        while (n>0) {
            ret += n%10;
            n/=10;
        }
        return ret;
    }

    public int sol5(long n) {

        return 0;
    }

    public long pow(int n, int x) {
        if (x == 0) { return 1; }

        if (x%2 == 0){
            return pow(n*n, x/2);
        } else if (x%2 == 1){
            return n * pow(n*n, (x-1)/2);
        }

        return n;
    }


}