//import jdk.nashorn.internal.parser.JSONParser;
//import org.graalvm.compiler.word.WordCastNode;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
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
   public static Dictionary LoadJson() throws IOException, ParseException {
        Dictionary result = new Dictionary();
        String path = "BT\\ENVN.json";
        JSONArray obj = (JSONArray) new JSONParser().parse(new FileReader(path));

        Iterator<JSONObject> iter = obj.iterator();
        while(iter.hasNext()){
            Word i = new Word(iter.next());
            result.add(i);
        //    System.out.println(i.toString());
        }
        return result;

    }
    public static Dictionary FindIn(String key, Dictionary dic){
        Dictionary result = new Dictionary();
        for (int i = 0; i<dic.getSize();i++ ){
            if(dic.get(i).Match(key)>=acceptable){
                result.add(dic.get(i));
            }
        }
        return result;
    }

    public static void  main( String[] args) throws IOException, ParseException {
        System.out.println(math.LoadJson());
    }

}
