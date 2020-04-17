import com.zwb.dao.WaterVideoDao;
import com.zwb.entity.WaterVideo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
@Component
public class UsersDaoImplTest {
    @Autowired
    public void setWaterVideoDao(WaterVideoDao waterVideoDao) {
        this.waterVideoDao = waterVideoDao;
    }


    private WaterVideoDao waterVideoDao;
    /**
     * 添加用户
     */
    @Test
    @Transactional// 在测试类对于事务提交方式默认的是回滚。
    @Rollback(false)//取消自动回滚

    public void testInsertUsers(){
        WaterVideo waterVideo = new WaterVideo();
        waterVideo.setCenterAddress("24");
        waterVideo.setDayRainfall("张三");
        this.waterVideoDao.save(waterVideo);
    }
}
