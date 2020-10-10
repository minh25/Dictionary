
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;



public class math {
    public static final float acceptable =(float) 1;

    public static void save(JSONArray t) throws IOException {
        String path = "data\\ENVN.json";
        FileWriter f = new FileWriter(path);
        t.writeJSONString(f);
        f.flush();
        f.close();
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



    public static void  main( String[] args) throws IOException, ParseException {


    }

}
