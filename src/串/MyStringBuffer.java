package 串;

import java.io.Serializable;

public final class MyStringBuffer implements Serializable {

    private char[] value;
    private  int n;

    public MyStringBuffer(int capacity){
        this.value = new char[capacity];
        this.n = 0;
    }

    public MyStringBuffer() {
        this(16);
    }

    public MyStringBuffer(String s){
        this(s.length() + 16);
        this.n = s.length();
        for (int i = 0; i < this.n; i++) {
            this.value[i] = s.charAt(i);
        }
    }

    public int length(){
        return this.n;
    }

    public int capacity(){
        return this.value.length;
    }

    public synchronized String toString(){
        return new String(this.value, 0, this.n);
    }

    public synchronized MyStringBuffer insert(String s,  int pos){
        if(this.n==0 && pos==0 || this.n>0 && pos>=0 && pos<=this.n)
        {
            if(s == null)
                s = "";
            char[]  temp = this.value;
            if (this.value.length < this.n + s.length())
            {
                this.value = new char [(this.value.length + s.length()) * 2];
                for(int j = 0; j < pos; j ++)
                    this.value[j] = temp[j];
            }
            for (int j = this.n-1; j >= pos ; j--)
                this.value[j + s.length()] = temp[j];
            for (int j=0; j < s.length(); j++)
                this.value[pos + j] = s.charAt(j);
            this.n += s.length();
            return this;
        }
        else
            throw new StringIndexOutOfBoundsException("i = " + pos);
    }

    public synchronized MyStringBuffer StrInsert(MyStringBuffer t,  int pos){
        return insert(t.toString() , pos);
    }

    public int indexOf(MyStringBuffer pattern,int begin)
    {
        int nu = this.length(),m = pattern.length();
        if(begin < 0)
            begin = 0;
        if(nu == 0 || nu < m || begin > nu)
            return -1;
        int i = begin,j = 0;
        while(i < nu && j < m)
        {
            if(this.value[i] == pattern.value[j])
            {
                i++;
                j++;
            }
            else
            {
                i = i - j + 1;
                j = 0;
                if(i > nu - m)
                    break;
            }
        }
        return j == m ? i - m : -1;
    }

    public int indexOf(MyStringBuffer pattern)
    {
        return this.indexOf(pattern,0);
    }

    public synchronized MyStringBuffer StrReplaceAll( MyStringBuffer t, MyStringBuffer v){
        int i = this.indexOf(t);
        while(i!=-1)
        {
            this.delete(i, i + t.length());
        }
        return this;
    }

    public void delete(int start, int end) {
        if (start < 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        if (end > n) {
            return;
        }
        if (end < 0) {
            return;
        }
        System.arraycopy(value, end, value, start, n - end);
        n -= end - start;
    }
}
