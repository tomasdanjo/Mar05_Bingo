package Bingo;

import java.util.ArrayList;
import java.util.Random;

public class BingoCard {
    public int[][] nums;

    public int id;


    public BingoCard(int id) {
        this.id = id;
         nums = new int[5][5];




        Random random = new Random();

         for(int i=0,min=1,max=15;i<5;i++,min=max+1,max+=15){
             ArrayList<Integer> temp = new ArrayList<>();
             for(int j=0;j<5;j++){

                 while(true){
                     int randomNumber = random.nextInt(max + 1 - min) + min;
                     if(!temp.contains(randomNumber)){
                         nums[j][i] = randomNumber;
                         temp.add(randomNumber);
                         break;

                     }
                 }


             }
         }
        nums[2][2]=0;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0;row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    


}
