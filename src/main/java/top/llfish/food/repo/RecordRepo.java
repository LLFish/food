package top.llfish.food.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import top.llfish.food.model.Record;
import top.llfish.food.vo.RecordDTO;

import java.util.Date;
import java.util.List;

public interface RecordRepo extends CrudRepository<Record, Integer> {
    List<Record> findAllBy();
    List<Record> findAllByDate(Date date);

    @Query(value = "select new  top.llfish.food.vo.RecordDTO(r) from DailyRecord r"
            + " where MONTH(CURRENT_DATE()) = MONTH(r.date)")
    List<RecordDTO> findAll_DTO();
}
