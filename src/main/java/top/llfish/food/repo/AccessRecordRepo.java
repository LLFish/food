package top.llfish.food.repo;

import org.springframework.data.repository.CrudRepository;
import top.llfish.food.model.AccessRecord;

public interface AccessRecordRepo extends CrudRepository<AccessRecord, Integer> {

//    int accessOnce(String web_name);
}
