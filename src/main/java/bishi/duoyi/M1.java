package bishi.duoyi;

public class M1 {
    public static void main(String[] args){
        for(int i = 0; i <= 1000; i++){
            if(isPrime(i) && isAddedEven(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isAddedEven(int num){
        int res = 0;
        while(num!=0){
            res += num % 10;
            num /= 10;
        }
        return res % 2 == 0;
    }

    public static boolean isPrime(int num){
        if( num < 2 ){
            return false;
        }
        for( int i = 2 ; i*i <= num; i++){
            if( num % i == 0)
                return false;
        }
        return true;
    }


}
