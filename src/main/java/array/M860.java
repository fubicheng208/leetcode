package array;

public class M860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int num : bills){
            if(num == 5){
                five++;
            }else if(num == 10){
                if(five == 0){
                    return false;
                }else{
                    ten++;
                    five--;
                }
            }else{
                if(ten > 0 && five > 0){
                    five--;
                    ten--;
                }else if(ten == 0 && five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
