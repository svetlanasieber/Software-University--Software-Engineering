import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LadyBugs {
    public static void main(String[] args) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(read.readLine());
        int[] field = new int[size];
        int[] indexes = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).filter(e->e>=0&&e<size).toArray();

        for (int index : indexes) {
            field[index]=1;
        }

        String input;

        while (!"end".equals(input=read.readLine())){
            String[]com = input.split("\\s+");

            int index = Integer.parseInt(com[0]);
            String command = com[1];
            int jump = Integer.parseInt(com[2]);

            if ((index>=0&&index<field.length)&&field[index]==1){
                field[index]=0;

                switch (command){
                    case "right":
                        index+=jump;
                        if (index<field.length&&index>=0){
                            if (field[index]==1){
                                while (index<field.length&&field[index]==1){
                                    index+=jump;
                                }
                                if (index<field.length){
                                    field[index]=1;
                                }
                            }else {
                                field[index]=1;
                            }
                        }
                        break;
                    case "left":
                        index-=jump;
                        if (index<field.length&&index>=0){
                            if (field[index]==1){
                                while (field[index] == 1){
                                    index-=jump;
                                }
                                field[index]=1;
                            }else {
                                field[index]=1;
                            }
                        }
                        break;
                }
            }

        }
        for (int i : field) {
            System.out.print(i+" ");
        }
    }
}
