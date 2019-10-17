package com.wlxk.quotation.rest;

import com.wlxk.quotation.common.BaseResult;
import com.wlxk.quotation.service.StockSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 鼠行止
 * @date: 2019/10/7
 */
@RestController
@RequestMapping("/api/stock")
public class StockSyncController {

    @Autowired
    private StockSyncService stockSyncService;

    @GetMapping("/syncList")
    public BaseResult ok() {
        stockSyncService.syncStockList();
        return BaseResult.ok();
    }

}
