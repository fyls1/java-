package Collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ALStringBuffer  implements IStringBuffer
{
    public int length = 0;
    public int capacity = 10;
    public ArrayList<Character> value = new ArrayList<Character>();

    public ALStringBuffer(String s){
        if(null != s){
            if (s.length()>capacity){
                capacity = capacity*2;
            }
            for (int i = 0; i < s.length(); i++)
            {
                this.value.add((s.charAt(i)));
            }
            this.length = s.length();
            //this.capacity = this.length + 16;
        }
        else{
            this.value = null;
        }
    }

    public ALStringBuffer(){
        this.value = null;
    }

    @Override
    public void append(String str) throws Exception
    {
        insert(this.length,str);
    }

    @Override
    public void append(char c) throws Exception
    {
        append(String.valueOf(c));
    }

    @Override
    public void insert(int pos, char b) throws Exception
    {
        insert(pos,String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) throws Exception
    {
        if(pos<0 || pos>this.length)  {
            System.out.println("插入位置不合理");
            return;
        }
        if(null == b)       {
            System.out.println("插入的字符串为空");
            return;
        }
        while(length+b.length()>capacity){
            this.capacity = (int) (capacity*1.5f);
        }
        this.length += b.length();

        for (int i = pos,j = 0; i < b.length() + pos; i++,j++)
        {
            this.value.add(i,b.charAt(j));
        }
    }

    @Override
    public void delete(int start)
    {
        delete(start,this.length);
    }

    @Override
    public void delete(int start, int end)
    {
        if(start < 0 || start > this.length - 1 || end < 0)        System.out.println("删除位置不合理");
        this.length -= (end - start);
        //this.capacity = this.length + 16;

        for (int i = start; i < end; i++)
        {
            this.value.remove(start);
        }
    }

    @Override
    public void reverse()
    {
        char temp;
        for (int i = 0; i < value.size() / 2; i++)
        {
            temp = value.get(i);
            value.set(i, value.get(value.size()-i-1));
            value.set(value.size()-i-1, temp);
        }
    }

    @Override
    public int length()
    {
        return this.length;
    }

    public String toString(){
        Character[] ch = (Character[])this.value.toArray(new Character[]{});
        char[] c = new char[ch.length];
        for (int i = 0; i < c.length; i++)
        {
            c[i] = ch[i];
        }
        String s = new String(c);
        return s;
    }

    public static void main(String[] args) throws Exception
    {
//          MyStringBuffer msb = new MyStringBuffer();
        //  MyStringBuffer msb = new MyStringBuffer("");
        ALStringBuffer msb = new ALStringBuffer("1234abcd");
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        msb.reverse();
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        msb.insert(0, "zzz");
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        msb.append("nnn");
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        msb.append('0');
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        msb.insert(10, 'm');
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );
        msb.delete(0,3);
        System.out.format("字符串\"%s\"长度是： %d，容量是：%d%n",msb,msb.length(),msb.capacity );

    }
}
