public class Main {
    public static void main(String[] args) {
        int vector[]={1,2,0,1,-1,-1,0,3,4,5};
        int matrix[][]={
                {1,1,0,1,1},
                {1,2,0,1,1},
                {1,1,0,1,-1},
                {2,4,8,16,32},
                {1,2,3,4,5}
        };
        System.out.println(GetMaxIndex(vector));
        System.out.println(GetProductBetweenZeroes(vector));
        System.out.println(GetNegativeRowsSum(matrix));
        GetMonotonicRowsIndexes(matrix);
    }

    public static int GetMaxIndex(int vec[]){
        int maxIndex=0;
        int max=vec[0];
        for (int i = 0; i<vec.length; i++){
            if(vec[i]>max){
                maxIndex=i;
                max=vec[i];
            }
        }
        return maxIndex;
    }

    public static int GetProductBetweenZeroes(int vec[]){
        int product = 1;
        boolean shouldMultiplie = false;
        for (int i = 0; i<vec.length; i++){
            if(vec[i]==0){
                if(shouldMultiplie){
                    return product;
                }
                else {
                    shouldMultiplie=true;
                    continue;
                }
            }
            if(shouldMultiplie){
                product*=vec[i];
            }
        }
        return product;
    }

    public static int GetNegativeRowsSum(int matrix[][]){
        int counter[]=new int[matrix.length];
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]<0){
                    counter[i]++;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(counter[i]>0){
                for(int j=0;j<matrix[i].length;j++){
                    sum+=matrix[i][j];
                }
            }
        }
        return sum;
    }
    public static void GetMonotonicRowsIndexes(int matrix[][]){
        System.out.println("Row numbers, all elements of which are sorted in ascending order:");
        for(int i=0;i<matrix.length;i++){
            if(IsMonotonic(matrix[i])){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean  IsMonotonic(int[] array){
        for (int i =1; i<array.length; i++){
            if(array[i]<array[i-1]){
                return false;
            }
        }
        return true;
    }
}