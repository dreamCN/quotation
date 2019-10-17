package com.wlxk.quotation.manager;

import com.wlxk.quotation.constant.StockTypeEnum;
import com.wlxk.quotation.dao.StockDao;
import com.wlxk.quotation.model.domain.StockDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author: 鼠行止
 * @date: 2019/10/6
 */
@Slf4j
@Component("stockListPipeline")
public class StockListPipeline implements Pipeline {

    @Autowired
    private StockDao stockDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> sh = resultItems.get("sh");
        for (String stock : sh) {
            String[] split = stock.split("\\(");
            String name = split[0];
            String code = split[1].replace(")", "");
            saveStockList(StockTypeEnum.SH.toString(), code, name);
        }
        List<String> sz = resultItems.get("sz");
        for (String stock : sz) {
            String[] split = stock.split("\\(");
            String name = split[0];
            String code = split[1].replace(")", "");
            saveStockList(StockTypeEnum.SZ.toString(), code, name);
        }
    }

    private void saveStockList(String type, String code, String name) {
        StockDO stockDO = stockDao.selectByCode(code);
        if (stockDO == null) {
            stockDO = new StockDO();
            stockDO.setCode(code);
            stockDO.setType(type);
            stockDO.setName(name);
            stockDao.insert(stockDO);
        } else {
            stockDO.setType(type);
            stockDO.setName(name);
            stockDao.updateById(stockDO);
        }
    }
}
