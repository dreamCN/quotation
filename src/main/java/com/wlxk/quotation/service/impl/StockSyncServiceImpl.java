package com.wlxk.quotation.service.impl;

import com.wlxk.quotation.manager.StockListPipeline;
import com.wlxk.quotation.manager.StockListProcessor;
import com.wlxk.quotation.service.StockSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * @author: 鼠行止
 * @date: 2019/10/7
 */
@Service
public class StockSyncServiceImpl implements StockSyncService {

    @Autowired
    private StockListPipeline stockListPipeline;
    @Autowired
    private StockListProcessor stockListProcessor;

    @Override
    public void syncStockList() {
        Spider.create(stockListProcessor)
                //设置爬取数据的页面
                .addUrl(StockListProcessor.STOCK_LIST_URL)
                .addPipeline(stockListPipeline)
                //执行爬虫
                .run();
    }
}
