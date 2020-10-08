import java.util.Objects;
import java.util.Scanner;
import org.json.simple.JSONObject;
public class Word {
  String _target, _content;

  public Word(String _target) {
    this._target = _target;
  }
  public Word(JSONObject o){
    this._target=(String)o.get("word");
    this._content=(String)o.get("detail");
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

  public int comareTo(String key) {
    return this._target.compareTo(key);
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

  public void set_content(String _content) {
    this._content = _content;
  }

  public float Match(String key) {
    float result = 0, len = (float) key.length(), bI = -1, weight = 1;
    for (int i = 0; i < key.length(); i++) {
      int I = this._target.indexOf(key.charAt(i), (int) bI + 1);
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
    return "Word{" +
            "_target='" + _target + '\'' +
            ", _content='" + _content + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof String){
      return this._target.equals(o);
    }
    if (!(o instanceof Word)) return false;
    Word word = (Word) o;
    return Objects.equals(get_target(), word.get_target())
        && Objects.equals(get_content(), word.get_content());
  }

  @Override
  public int hashCode() {
    return Objects.hash(get_target(), get_content());
  }
}
