
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;



public class math {
    public static final float acceptable =(float) 1;
    static public int IndexOfMax(float[] in){

        float[] temp=new float[in.length];
        temp=in.clone();
        Arrays.sort(temp);
        float value= temp[temp.length-1];
        return Arrays.binarySearch(temp,value);

    }
    public static void save(JSONArray t) throws IOException {
        File myObj = new File("data\\ENVN.json");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
        String path = "data\\ENVN.json";
        FileWriter f = new FileWriter(path);
        t.writeJSONString(f);
        f.flush();
        f.close();
        System.out.println("Changes have been saved!");
    }
    public static Dictionary LoadJson() throws IOException, ParseException {
        Dictionary result = new Dictionary();
        String path = "data\\ENVN.json";
        JSONParser parser= new JSONParser();
        JSONArray obj = (JSONArray) parser.parse(new FileReader(path));
        int Z=0;
        Iterator<JSONObject> iter = obj.iterator();
        for (Object o : obj){
            JSONObject temp = (JSONObject)o;
            if(o instanceof JSONObject){
                Z++;

                //System.out.println(iter);
                Word i = new Word(temp);
                result.push(i);
            }
        }
        result.sort();
        return result;

    }
    public static int binarySearch(Dictionary dic, int l, int r, String x)
    {

        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (dic.get(mid).equals(x))
                return mid;

            if (dic.get(mid).comareTo(x)>0)
                return binarySearch(dic, l, mid - 1, x);

            return binarySearch(dic, mid + 1, r, x);
        }

        return -1;
    }

    public static Dictionary FindIn(String key, Dictionary dic){
        Dictionary result = new Dictionary();
        int pos = binarySearch(dic,0,dic.getSize()-1,key);
        if(pos ==-1) {
            pos=0;
            System.out.println("binary search is not active");
        }
        for (int i = pos; i<dic.getSize();i++ ){
            if(dic.get(i).Match(key)>=acceptable){
                result.push(dic.get(i));
            }
        }
        return result;
    }

    public int valid_pos_insert(Dictionary dic, String key){

        if(dic.getSize()==0 || dic.get(0).comareTo(key)<0){
            return -1;
        } else {
            if(dic.get(dic.getSize()-1).comareTo(key)>0){
                return dic.getSize();
            }
            else{
                return -1;
            }
        }
    }



    public static void  main( String[] args) throws IOException, ParseException {


    }

}
