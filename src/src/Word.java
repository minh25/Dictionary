
public class Word {
    private String word_target, word_explain;
    static public String[] Split(String input) {
        int count =0;
        String[] result=new String[2];
        return result;

    }
    public Word() {}
    public Word(String word_target, String word_explain) {
        word_target = word_target;
        word_explain = word_explain;
    }
    public Word(String raw) {
        word_target = raw;
    }
    public void setWord_explain(String word_explain) {
        this.word_explain=word_explain;
    }
    public void setWord_target(String word_target) {
        this.word_target=word_target;
    }
    public String getWord_explain() {
        if(this.word_explain==null) {
            return new String("empty!");
        }
        return this.word_explain;
    }
    public String getWord_target() {
        if(this.word_target==null) {
            return new String("empty!");
        }
        return this.word_target;
    }
    public boolean equals(Object another){
        String temp;
        if(another instanceof String) {
            temp=(String) another;
        } else if(another instanceof Word) {
            temp=((Word) another).word_target;
        } else return false;
        return (this.word_target.equals(temp));
    }
}

