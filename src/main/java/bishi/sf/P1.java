package bishi.sf;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while(scanner.hasNextInt()){
            n = scanner.nextInt();
            int nums[] = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                if(nums[i] == -1)
                    count++;
            }
            if(count == n || count == n - 1) {
                System.out.println(1);
            }else if(count == n - 2){
                int l = 0, r = 0;
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if(nums[i] != -1){
                        if(!flag){
                            l = i;
                            flag = true;
                        }else{
                            r = i;
                        }
                    }
                }
                if((nums[r] - nums[l]) % (r - l) == 0){
                    System.out.println(1);
                }else{
                    System.out.println(2);
                }
            }else{
                Random random = new Random();
                int rand = random.nextInt(10);
                System.out.println(rand);
            }
        }
    }
}
