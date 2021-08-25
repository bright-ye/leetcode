package 动态规划;

public class 爬楼梯 {

    public static void main(String[] args) {
        爬楼梯 instance = new 爬楼梯();
        System.out.println(instance.climbStairs(5));
    }

    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int a = 1,b=2,sum = 0;
        for(int i = 3;i<=n;i++){
            sum = a + b;
            b = sum;
            a = b;
        }
        return b;
    }
}
