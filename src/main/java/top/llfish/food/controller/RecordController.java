package top.llfish.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.llfish.food.model.Record;
import top.llfish.food.repo.RecordRepo;
import top.llfish.food.vo.RecordDTO;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    @Autowired
    private RecordRepo recordRepo;

    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public RecordController(RecordRepo recordRepo) {
        super();
    }

    @GetMapping("/all")
    public List<Record> getAllRecord(){
        return this.recordRepo.findAllBy();
    }

    @GetMapping("allInCurrentMounth")
    public List<RecordDTO> getAllInCurrentMounth_DTO(){
        return recordRepo.findAll_DTO();
    }


    @GetMapping("/today_exist")
    public boolean isTodayExist(){
        List<Record> today = this.recordRepo.findAllByDate(new Date(System.currentTimeMillis()));
        if(0 == today.size()){
            return false;
        }

        return true;
    }

    @GetMapping("/daysInCurrentMonth")
    public int getDays(){
        Date current = new Date(System.currentTimeMillis());
        int mounth = current.getMonth();
        int result = RecordController.daysInMonth[mounth];
        //2月特殊判断,闰年加一
        if(mounth == 1){
            int year = current.getYear();
            //闰年判定
            if((year % 100 != 0 && year % 4 == 0) || year % 400 == 0){
                result += 1;
            }
        }

        return result;
    }

    @GetMapping("/daysBeforFirstDay")
    public int getDaysBefor(){
        return RecordDTO.getDaysBefor();
    }

    @GetMapping("/access_count")
    public int getAccessRecord(String name){
        int count = 0;
        return 0;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", path = "/record")
    public boolean addRecord(@RequestBody Record currentRecord){
        currentRecord.setDateToday();
        this.recordRepo.save(currentRecord);
        return true;
    }

}
