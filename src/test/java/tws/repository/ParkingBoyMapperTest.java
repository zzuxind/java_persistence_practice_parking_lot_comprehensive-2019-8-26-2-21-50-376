package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.ParkingBoy;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingBoyMapperTest {
    @Autowired
    ParkingBoyMapper parkingBoyMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    public void shouldFetchList(){
        List<ParkingBoy> employeeList=parkingBoyMapper.getParkingBoys();
        assertEquals(2,employeeList.size());
    }

    @Test
    public void shouldinsert(){
        ParkingBoy parkingBoy=new ParkingBoy("3");
        // jdbcTemplate.execute("insert into employee values ('0002','dingding',21)");
        parkingBoyMapper.creatParkingBoy(parkingBoy);
        int numbers=JdbcTestUtils.countRowsInTable(jdbcTemplate,"parking_boy");
        assertEquals(3,numbers);
    }
}
