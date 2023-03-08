package com.example.eatrice;

import com.example.eatrice.common.engine.producer.basic.Select;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EatriceApplicationTests {

    @Test
    void contextLoads() {
//        String select = new Select("bs_table", "table").generateSQL();
//        System.out.println(select);
//        String select2 = new Select("bs_table2", "").generateSQL();
//        System.out.println(select2);
//        String select3 = new Select("bs_table3", "haha").generateSQL();
//        System.out.println(select3);
        System.out.println(new Select(new Select("bs_table4", "t4"), "a1").generateSQL());
        System.out.println(new Select(true, "select b2.haha from bs_table5", "a2").generateSQL());
        System.out.println(new Select("select b2.haha from bs_table51").generateSQL());
    }

}
