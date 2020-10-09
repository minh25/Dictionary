import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
  private int MAX_SIZE = 1000;
  private int size = 0;
  private Word[] list = new Word[MAX_SIZE];
  public boolean delete(String key){
    return false;
  }

  public Dictionary(Word[] list) {
    this.list = list;
  }

  public Dictionary() {}

  public static void main(String[] args) throws IOException, ParseException {
    Dictionary x;
    x = math.LoadJson();
    Scanner in = new Scanner(System.in);
    while (true) {
      String key = in.next();
      x.Find(key).print();
    }
  }

  public Word get(final int index) {
    return this.list[index];
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void Expand() {
    this.MAX_SIZE *= 2;
    Word[] x = this.list.clone();
    this.list = new Word[this.MAX_SIZE];
    System.arraycopy(x, 0, this.list, 0, x.length);
  }

  public Word[] Find(String key, float acceptable) {
    int first = 0, last = size;
    Word[] result = new Word[10];
    int index = Arrays.binarySearch(this.list, key);
    if (index >= 0) {
      System.arraycopy(this.list, index, result, 0, 10);
    } else {
      float[] value = new float[size];
      for (int i = 0; i < value.length; i++) {
        value[i] = this.list[i].Match(key);
      }
      int inD = math.IndexOfMax(value);
    }
    return result;
  }


  public Dictionary Find(String key) {
    return math.FindIn(key, this);
  }

  public boolean add(Object o) {
    if (o instanceof Word) {
      Word x = (Word) o;
      if (size == MAX_SIZE) {
        this.Expand();
      }
      list[size] = x;
      size += 1;
      return true;
    }
    return false;
  }

  public boolean push(String _target, String _content){
    return false;
  }

  public void print() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(this.list[i].get_target() + " : " + this.list[i].get_content());
    }
  }
}
