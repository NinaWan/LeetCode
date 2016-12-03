public class Solution {
    public String convert(String s, int numRows) {
        int numColumns = s.length();
        char[][] zigZag = new char[numRows][numColumns];
        int rowIndex = 0;
        String result = "";
        if(numRows <= 1){
            return s;
        }
        for(int columnIndex = 0; columnIndex<numColumns;){
            if(rowIndex <= 0){
                if(rowIndex<0){
                    rowIndex +=2;
                }
                for(; rowIndex<numRows && columnIndex<numColumns;){
                    zigZag[rowIndex][columnIndex] = s.charAt(columnIndex);
                    columnIndex++;
                    rowIndex++;
                }
            }
            if(rowIndex == numRows){
                rowIndex -= 2;
                for(; rowIndex>=0 && columnIndex<numColumns;){
                    zigZag[rowIndex][columnIndex] = s.charAt(columnIndex);
                    columnIndex++;
                    rowIndex--;
                }
            }
        }

        for(int i=0;i<numRows;i++){
            for(int j=i;j<numColumns;j++){
                if(zigZag[i][j] != '\0'){
                    result = result + zigZag[i][j];
                }
            }
        }
        return result;
    }
}