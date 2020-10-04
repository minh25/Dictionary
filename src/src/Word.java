
public class Word {
    private String content, meaning;
    static public String[] Split(String input) {
        int count =0;
        String[] result=new String[2];
        return result;

    }
    public Word() {}
    public Word(String Content, String Meaning) {
        content = Content;
        meaning = Meaning;
    }
    public Word(String raw) {
        content = raw;
    }
    public void setMeaning(String Meaning) {
        this.meaning=Meaning;
    }
    public void setContent(String Content) {
        this.content=Content;
    }
    public String getMeaning() {
        if(this.meaning==null) {
            return new String("empty!");
        }
        return this.meaning;
    }
    public String getContent() {
        if(this.content==null) {
            return new String("empty!");
        }
        return this.content;
    }
    public boolean equals(Object another){
        String temp;
        if(another instanceof String) {
            temp=(String) another;
        } else if(another instanceof Word) {
            temp=((Word) another).content;
        } else return false;
        return (this.content==temp);
    }
}

