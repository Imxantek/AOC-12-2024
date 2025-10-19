import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void load(ArrayList<ArrayList<Field>>list){
        String line="";
        try{
            BufferedReader br = new BufferedReader(new FileReader("AOC12.txt"));
            while((line=br.readLine())!=null){
                char[] chars = line.toCharArray();
                ArrayList<Field> fields = new ArrayList<>();
                for(int i=0; i<chars.length; i++){
                    Field f = new Field(chars[i]);
                    fields.add(f);
                }
                list.add(fields);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Field>> list = new ArrayList<>();
        load(list);
        int totalFence = 0;
        int totalField = 0;
        int total = 0;
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(0).size(); j++){
                Field f = list.get(i).get(j);
                if(i==0){
                    f.up=null;
                }else{
                    if(f.getType()!=list.get(i-1).get(j).getType()){
                        f.up=null;
                    }else{
                        f.up=list.get(i-1).get(j);
                    }
                }
                if(j==0){
                    f.left=null;
                }else{
                    if(f.getType()!=list.get(i).get(j-1).getType()){
                        f.left=null;
                    }else{
                        f.left=list.get(i).get(j-1);
                    }
                }
                if(i==list.size()-1){
                    f.down=null;
                }else{
                    if(f.getType()!=list.get(i+1).get(j).getType()){
                        f.down=null;
                    }else{
                        f.down=list.get(i+1).get(j);
                    }
                }
                if(j==list.get(0).size()-1){
                    f.right=null;
                }else{
                    if(f.getType()!=list.get(i).get(j+1).getType()){
                        f.right=null;
                    }
                    else{
                        f.right=list.get(i).get(j+1);
                    }
                }
                list.get(i).set(j,f);
            }
        }
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                Field f = list.get(i).get(j);
                if(!f.visitedField){
                    System.out.println(f.toString());
                    totalField=f.countFields();
                    System.out.println(totalField);
                    totalFence=f.countFences();

                    total+=(totalField*totalFence);
                }
            }
        }

        System.out.println(total);
    }
}