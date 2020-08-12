package top.llfish.food.vo;

import top.llfish.food.model.Record;

import java.sql.Date;
import java.util.Calendar;

public class RecordDTO {
    private int x;
    private int y;
    private int value;

    public RecordDTO(Record record) {
        Date date = record.getDate();

        int weekday = date.getDay();
        this.x = weekday==0? 6 : weekday-1;

        int day = date.getDate() + this.getDaysBefor();

        //最后一天也是前面星期的，但是除下来为1，所以-1，防止-1为负
        if(date.getDate() != 1){
            day -= 1;
        }
        this.y = day / 7;

        this.value = record.getAssessment();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    /**
     * 计算本月一号对应星期之前有多少天（日历第一行前面空多少）
     * @return
     */
    static public int getDaysBefor(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return weekday==0?6:weekday-2;
    }
}
