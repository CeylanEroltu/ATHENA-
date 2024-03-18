public class TwoDimensionalArray {
    
    public static void main(String[] args) {
        
        int [][] myArray = {{5,2} , {3,7} , {9,14}} ;

        for (int i = 0; i < myArray[0].length; i++) {

            int sumColumn = 0;

            for(int j = 0; j < myArray.length; j++) {

                sumColumn += myArray[i][j];
            }

            System.out.println("Sum for column " + i + "is " + sumColumn);
        
        }

        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {

            for(int j = 0; j < myArray[i].length; j++) {

                sum += myArray[i][j];
            }
    }
        System.out.println("Sum is " + sum);


        for (int i = 0; i < myArray.length; i++) {

            for(int j = 0; j < myArray[i].length; j++) {

               System.out.print(myArray[i][j] + " ");
            }

            System.out.println("");
    }
}

}