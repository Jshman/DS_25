public class HW3_202202590_박종현 {

    public void main(String[] args) {
        System.out.println("202202590 박종현");
        int x = 312303;
        int y = 45612;
        int result = gcd(x, y);
        System.out.printf("%d와 %d의 최대공약수 : "+result+"\n", x, y);
        System.out.println(pow(2,14));
        System.out.println(pow(3,8));
    }

    public long pow(int n, int x) {
        if (x == 0) { return 1; }
        if (x == 1) {return n;}
        if (x%2 == 0){
            return pow(n*n, x/2);
        } else if (x%2 == 1){
            return n * pow(n*n, (x-1)/2);
        }

        return n;
    }
    
    public int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}