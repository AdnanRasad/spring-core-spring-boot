package runner.ver3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import runner.ver3.model.myusers2;

public interface database2 extends JpaRepository<myusers2, Integer> {

    //thats no need to write any code, all methods fpr queries will be automatically done
}
