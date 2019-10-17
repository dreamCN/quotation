package com.wlxk.quotation.manager;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @author: 鼠行止
 * @date: 2019/10/6
 */
@Component("stockListProcessor")
public class StockListProcessor implements PageProcessor {

    public static String STOCK_LIST_URL = "http://quote.eastmoney.com/stock_list.html";

    @Override
    public void process(Page page) {

        //解析返回的数据page，并且把解析的结果放到ResultItems中
        List<String> sh = page.getHtml().xpath("//*[@id='quotesearch']/ul[1]/li/a/text()").all();
        page.putField("sh", sh);
        List<String> sz = page.getHtml().xpath("//*[@id='quotesearch']/ul[2]/li/a/text()").all();
        page.putField("sz", sz);

    }

    private Site site = Site.me();

    @Override
    public Site getSite() {
        return site;
    }

    //主函数，执行爬虫
    public static void main(String[] args) {
        Spider.create(new StockListProcessor())
                //设置爬取数据的页面
                .addUrl(STOCK_LIST_URL)
                .addPipeline(new StockListPipeline())
                //执行爬虫
                .run();
    }
}
