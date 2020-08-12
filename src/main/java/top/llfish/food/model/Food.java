package top.llfish.food.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "Food2Eat")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String creater;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;

    private String other_information;
    private char finished;

    public Food() {
    }

    public Food(String name, String other_information) {
        this.name = name;
        this.other_information = other_information;
        this.creater = "欢总";
        this.finished = '否';
        this.create_time = new Date(System.currentTimeMillis());
    }

    public void initInFirstTime(){
        this.creater = "欢总";
        this.finished = '否';
        this.create_time = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getOther_infomation() {
        return other_information;
    }

    public void setOther_infomation(String other_infomation) {
        this.other_information = other_infomation;
    }

    public char getFinished() {
        return finished;
    }

    public void setFinished(char finished) {
        this.finished = finished;
    }
}
