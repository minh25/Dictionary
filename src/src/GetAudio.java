import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class GetAudio {
    /**
     * if there is no file word.mp3 in data, it load data form the Internet, else do nothing.
     */
    public GetAudio (String key) throws IOException {
        String path = "data\\" + key + ".mp3";
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("getting data from internet");
            String url = "https://ssl.gstatic.com/dictionary/static/sounds/20180430/"
                    + key.toLowerCase()
                    + "--_us_1.mp3";
            URLConnection conn = new URL(url).openConnection();
            InputStream is = conn.getInputStream();

            OutputStream outstream = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();
        } else {
            System.out.println("local data");
        }
    }


}
