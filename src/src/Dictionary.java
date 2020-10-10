import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
  private int MAX_SIZE = 200000;
  private int size = 0;
  private Word[] list = new Word[MAX_SIZE];

  public Dictionary(Word[] list) {
    this.list = list;
  }

  public Dictionary() {}

  public static void main(String[] args) throws IOException, ParseException {
    Dictionary x;
    x = math.LoadJson();
    System.out.println(x.getSize());
    Scanner in = new Scanner(System.in);
    while (true) {
      String key = in.next();
      if (key.toLowerCase().equals("add")) {
        String t = in.next();
        String content = in.nextLine();
        Word X = new Word(t, content);
        System.out.println(X);
        System.out.println(math.binarySearch(x, 0, x.getSize() - 1, X.get_target()));
        x.add(X);
        x.save();
      } else {
        x.Find(key).print();
      }
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

  public void sort() {
    Arrays.sort(list, 0, size - 1);
  }

  private void Expand() {
    this.MAX_SIZE *= 2;
    Word[] x = this.list.clone();
    this.list = new Word[this.MAX_SIZE];
    System.arraycopy(x, 0, this.list, 0, x.length);
  }

  public Dictionary Find(String key) {
    return math.FindIn(key, this);
  }
  /** push a word to dictionary without checking, just for loading from file */
  public boolean push(Object o) {
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
  /** delete a word from dictionary */
  public boolean delete(Word key) {
    int pos = math.binarySearch(this, 0, size - 1, key.get_target().toLowerCase());
    if (pos == -1) {
      return false;
    }
    for (int i = pos; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    size--;
    return true;
  }
  /** add a word to dictionary or fix content of a word */
  public boolean add(Word src) {
    int pos = math.binarySearch(this, 0, size - 1, src.get_target().toLowerCase());
    System.out.println(src.get_target().toLowerCase());
    if (pos != -1) {
      System.out.println(
          "the content of word " + src.get_target() + " will be changed into " + src.get_content());
      list[pos].set_content(src.get_content());
      return false;
    } else {
      System.out.println("the word " + src.get_target() + " will be added to the data");
      this.push(src);
      this.sort();
      return true;
    }
  }

  public void save() throws ParseException, IOException {
    JSONArray t = new JSONArray();
    for (int i = 0; i < size; i++) {
      t.add(list[i].toJson());
    }
    math.save(t);
  }

  public void print() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(this.list[i].get_target() + " : " + this.list[i].get_content());
    }
  }
}
