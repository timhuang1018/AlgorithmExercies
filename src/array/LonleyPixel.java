package array;

/**
 * Given a picture consisting of black and white pixels,
 * find the number of black lonely pixels.
 * The picture is represented by a 2D char array
 * consisting of 'B' and 'W', which means black and white pixels respectively.
 * A black lonely pixel is character 'B' that located at a specific position
 * where the same row and same column don't have any other black pixels.
 *
 * Input:
 * [['W', 'W', 'B'],
 *  ['W', 'B', 'W'],
 *  ['B', 'W', 'W']]
 *
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 */
public class LonleyPixel {

    public static int findLonelyPixel(char[][] picture){
        if (picture==null || picture.length==0) return 0;

        int[] rowCount = new int[picture.length];
        int[] columnCount = new int[picture[0].length];

        for (int i=0; i<picture.length; i++){
            for (int j=0; j<picture[0].length; j++){
                if (picture[i][j]=='B'){
                    rowCount[j]++;
                    columnCount[i]++;
                }
            }
        }

        int result = 0;

        for (int i=0; i<picture.length; i++){
            for (int j=0; j<picture[0].length; j++){
                if (picture[i][j]=='B'){
                    rowCount[j]--;
                    columnCount[i]--;
                    if (rowCount[j]==0 && columnCount[i]==0) result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int t1 = findLonelyPixel(new char[][]{new char[]{'W', 'W', 'B'},
   new char[]{'W', 'B', 'W'},new char[]{'B', 'W', 'W'}});

        System.out.println(t1);
    }
}
