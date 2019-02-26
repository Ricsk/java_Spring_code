package java_niuke;
import java.util.*;
public class TaoTuoShenLing {
    public static void main(String args[]){
        int n;
        String dir[] = {"", "E", "S", "W", "N"};
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1;i <= n;i++){
            String outans = "";
            int m;
            m = scan.nextInt();
            int maps[][] = new int[5][m];
            getMap(m, maps, scan);
            int sum = 0;
            for(int j = 0;j < m;j++){
                int ans[] = new int[5];
                for(int k = 1;k <= 4;k++){
                    ans[k] = maps[k][j];
                }
                int min = ans[1];
                int mark = 1;
                for(int k = 2;k <= 4;k++){
                    if(min > ans[k]){
                        min = ans[k];
                        mark = k;
                    }
                }
                sum += min;
                outans += dir[mark];
            }
            outans += "\n";
            System.out.println(sum);
            System.out.println(outans);
        }
    }
    private static void getMap(int m, int maps[][], Scanner scan){
        for(int i = 1;i <= 4;i++){
            for(int j = 0;j < m;j++){
                maps[i][j] = scan.nextInt();
            }
        }
    }
}
