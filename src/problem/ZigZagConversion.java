package problem;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows ){
            return s;
        }
        char[][] character = new char[numRows][100];
        int line = 0, rows = 0;
        for(int i = 0; i<s.length();i++){
            if(rows == 0 && line != numRows){
                character[line][rows] = s.charAt(i);
                line += 1;
            }
            else if(line != numRows && rows % (numRows - 1) != 0 ){
                line -=1;
                rows += 1;
                    character[line][rows] = s.charAt(i);
            }
            else if(rows % (numRows - 1) == 0 && line < numRows-1){
                line += 1;
                character[line][rows] = s.charAt(i);
            }
            else if (line == numRows ){
                line = line - 2;
                rows += 1;
                character[line][rows] = s.charAt(i);
            }

        }
        String newStr = "";
        for(int i = 0 ; i < numRows ; i++){
            for(int j = 0; j< rows ; j++){
                if(character[i][j] != ' '){
                    newStr += character[i][j];
                }
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        ZigZagConversion a = new ZigZagConversion();
        String str = a.convert("PAYPALISHIRING",3);
        System.out.println(str);
    }
}
