package 串;

import java.io.Serializable;

/**
 *
 * （1） 实现串的基本操作: 串的构造方法，串比较，求串长，串连接和求子串；
 *
 *（2）利用基本操作，实现串插入操作，MyStringBuffer StrInsert(MyStringBuffer t,  int pos)在主串中第pos(pos为从1开始编号)个位置插入一个子串t的操作。
 *
 * （3）利用基本操作，实现串的替换操作, MyStringBuffer StrReplaceAll( MyStringBuffer t, MyStringBuffer v), 将串中的所有子串t用串v替换.
 * */

public final class MyString implements Comparable<MyString>, Serializable {

    private final char[] value;

    public MyString() {
        this.value = new char[0];
    }

    public MyString(java.lang.String s) {
        this.value = new char[s.length()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = s.charAt(i);
        }
    }

    public MyString(char[] value, int i, int n){
        if (i >= 0 && n >= 0 && i + n <= value.length) {
            this.value = new char[n];
            for (int j = 0; j < n; j++) {
                this.value[j] = value[i + j];
            }
        }else
            throw  new StringIndexOutOfBoundsException("i = " + i + ", n = " + n + ", i + n = " + (i + n));
    }

    public MyString(char[] value) {
        this(value, 0, value.length);
    }

    public MyString(MyString s){
        this(s.value);
    }

    public java.lang.String toString(){
        return new String(this.value);
    }

    public int length(){
        return this.value.length;
    }

    public int compareTo(MyString string) {
        for (int i = 0; i < this.value.length && i < string.value.length; i++)
            if(this.value[i] != string.value[i])
                return this.value[i] - string.value[i];
        return this.value.length - string.value.length;
    }

    public MyString concat(MyString s){
        if (s == null || s.equals(""))
            s = new MyString(this.value);
        char[] buffer = new char[this.value.length + s.length()];
        int i;
        for (i = 0; i < this.value.length; i++)
            buffer[i] = this.value[i];
        for (int j = 0; j < s.value.length; j++)
            buffer[i + j] = s.value[j];
        return new MyString(buffer);
    }

    public MyString substring(int begin, int end){
        if (begin == 0 && end == this.value.length)
            return this;
        return new MyString(this.value, begin, end-begin);
    }

    public MyString substring(int begin){
        return substring(begin, this.value.length);
    }

}
