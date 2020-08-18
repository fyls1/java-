package charactor1;
//准备一个长度是9的日期数组
//使用1970年-2000年之间的随机日期初始化该数组
//按照这些日期的时间进行升序排序
//比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//0-9:48-57  A-Z:65-90 a-z:97-122
public class TestDate {
    public static long RandomTime(String starTime,String endTime){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startTimeMillis,endTimeMillis,randomTimeMillis=0;
        try {
            startTimeMillis=sdf.parse(starTime).getTime();
            endTimeMillis=sdf.parse(endTime).getTime();
            randomTimeMillis=(long)(Math.random()*(endTimeMillis-startTimeMillis))+startTimeMillis;
            return randomTimeMillis;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return randomTimeMillis;
    }
    public static void main(String[] args) throws ParseException {

        String starTime="1970-01-01 00:00:00";
        String endTime="1999-12-31 23:59:59";
//        String endTime="2000-00-00 00/00/00";
        long[] t=new long[9];
        long[] t1=new long[9];
        String aa;
        System.out.println("得到的随机日期数组:");
        for(int i=0;i<9;i++){
            t1[i]=RandomTime(starTime,endTime);
            System.out.printf("%s ",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t1[i])));
            aa=new SimpleDateFormat("HH:mm:ss").format(new Date(t1[i]));
            SimpleDateFormat sdf1= new SimpleDateFormat("HH:mm:ss");
            Date dt2 = sdf1.parse(aa);
            t[i] = dt2.getTime() / 1000;
            if((i+1)%3==0){
                System.out.printf("\n");
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<8-i;j++){
                if(t[j]>t[j+1]){
                    long temp=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp;
                    long temp1=t1[j];
                    t1[j]=t1[j+1];
                    t1[j+1]=temp1;
                }
            }
        }
        System.out.println("排序后的随机日期数组:");
//        System.out.printf("%s ",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(60)));
        for(int i=0;i<9;i++){
            System.out.printf("%s ",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t1[i])));
            if((i+1)%3==0){
                System.out.printf("\n");
            }
        }
    }
}
