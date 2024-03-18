public class TDA2 {
    public static void main(String[] args) {
        
        int [][] newArray = {{100,70} , {80,30} , {20,60} , {30,100}};

        int max = 0;
        int largestNumberInRow = 0;

        for(int i = 0; i < newArray[0].length; i++) {

            max += newArray[0][i];
        }

        for(int j = 0; j < newArray.length; j++) {

           int sumofRow = 0;

           for(int i = 0; i < newArray[j].length; i++) {

            sumofRow += newArray[i][j];
           }

           if(sumofRow > max) {

            max = sumofRow;
            largestNumberInRow = j;
           }
        }

        System.out.println("Max is : " + max);
        System.out.println("Row has the largest sum is : " + largestNumberInRow);

        for(int i = 0; i < newArray.length; i++) {

            for(int j = 0; j < newArray[i].length; j++){

                System.out.println(newArray[i][j] + " ");
            }
        }

    }
}
