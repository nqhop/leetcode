import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for(int i = 1; i < numRows; i++){
            List<Integer> presentRow = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                int cell = 0;
                try {
                    cell += result.get(i - 1).get(j - 1);
                }catch (IndexOutOfBoundsException e){}
                try {
                    cell += result.get(i - 1).get(j);
                }catch (IndexOutOfBoundsException e){}
                presentRow.add(cell);
            }
            result.add(presentRow);
        }
        return result;
    }


    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int row = 0; row < numRows; row++){
            List<Integer> currentRow = new ArrayList<>();
            for(int col = 0; col <= row; col++){
                if(col == 0 || col == row){
                    currentRow.add(1);
                }else {
                    int value = result.get(row - 1).get(col - 1) + result.get(row - 1).get(col);
                    currentRow.add(value);
                }
            }
            result.add(currentRow);
        }
        return result;
    }


    public static void main(String[] args) {
        int numrows = 1000;
        long startTime = System.nanoTime();

        List<List<Integer>> res = new PascalTriangle_118().generate(numrows);
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");


        long startTime2 = System.nanoTime();

        List<List<Integer>> res2 = new PascalTriangle_118().generate2(numrows);
        long endTime2 = System.nanoTime();
        System.out.println("Execution time: " + (endTime2 - startTime2) + " ns");
    }
}
