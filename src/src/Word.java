import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Objects;
import java.util.Scanner;

public class Word implements Comparable<Word> {

  String _target, _content;
  Word left, right;

  public Word(String _target) {
    this._target = _target;
  }

  public Word(String _target, String _content, Word left, Word right) {
    this._target = _target;
    this._content = _content;
    this.left = left;
    this.right = right;
  }

  public Word(String _target, String _content) {
    this._target = _target;
    this._content = _content;
  }

  public Word(JSONObject o) {
    this._target = (String) o.get("word");
    this._content = (String) o.get("detail");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String word = in.next();

    Word W = new Word(word);
    for (int i = 0; i < 10; i++) {
      String key = in.next();
      System.out.println(W.comareTo(key));
    }
    in.close();
  }

  public boolean isLeaf() {
    return (left == null && right == null);
  }

  public Word getLeft() {
    return left;
  }

  public void setLeft(Word left) {
    this.left = left;
  }

  public Word getRight() {
    return right;
  }

  public void setRight(Word right) {
    this.right = right;
  }

  public int comareTo(String key) {
    return this._target.toLowerCase().compareTo(key.toLowerCase());
  }

  public String get_target() {
    return _target;
  }

  public void set_target(String _target) {
    this._target = _target;
  }

  public String get_content() {
    return _content;
  }

  public void set_content(String type, String pronunciation,String note, String meaning) {
    this._content = "<C><F><I><N><Q>@"+_target+" /"+pronunciation+"<br />*  "+type+"/<br />- ("+note+") "+meaning+"</Q></N></I></F></C>";
  }
  public void set_content(String _content){
    this._content=_content;
  }

  public float Match(String key) {
    String _t = _target.toLowerCase();
    key= key.toLowerCase();
    float result = 0, len = (float) key.length(), bI = -1, weight = 1;
    for (int i = 0; i < key.length(); i++) {
      int I = _t.indexOf(key.charAt(i), (int) bI + 1);
      if (I != -1) {
        if (I == bI + 1) {
          result += 1 / len * weight;
        } else {
          weight /= 2;
          result += 1 / len * weight;
        }
      }
      bI = I;
    }

    return result;
  }

  @Override
  public String toString() {
    return "{word:\"" + _target.toLowerCase() + "\"" + ",detail:\"" + _content + "\"" + '}';
  }

  public JSONObject toJson() throws ParseException {
    JSONObject result = new JSONObject();
    result.put("word",this._target);
    result.put("detail",this._content);
    //  System.out.println(result);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof String) {
      return this._target.toLowerCase().equals(((String) o).toLowerCase());
    }
    if (!(o instanceof Word)) return false;
    Word word = (Word) o;
    return Objects.equals(get_target().toLowerCase(), word.get_target().toLowerCase())
            && Objects.equals(get_content().toLowerCase(), word.get_content().toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(get_target(), get_content());
  }

  @Override
  public int compareTo(Word o) {
    String _t = _target.toLowerCase();
    String key = o._target.toLowerCase();
    return _t.compareTo(key);
  }
}
