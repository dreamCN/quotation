package com.wlxk.quotation.manager;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author: 鼠行止
 * @date: 2019/10/6
 */
public class JobProcessor implements PageProcessor {

    //解析页面
    @Override
    public void process(Page page) {

        //解析返回的数据page，并且把解析的结果放到ResultItems中
        page.putField("div", page.getHtml().css("div.unin_reason_dialog h3").all());

        //XPath
        page.putField("div2",page.getHtml().xpath("//div[@class=title]/h2/a"));

        //正则表达式
        page.putField("div3",page.getHtml().css("div.title h2 a").regex(".*数学.*").all());

        //获取链接
        page.addTargetRequests(page.getHtml().css("div.title").links().regex(".*9$").all());//以9结尾的
        page.putField("url",page.getHtml().css("div.article-title-box h1"));
    }

    private Site site = Site.me();
    @Override
    public Site getSite() {
        return site;
    }

    //主函数，执行爬虫
    public static void main(String[] args) {
        Spider.create(new JobProcessor())
                .addUrl("https://blog.csdn.net/nav/ai")  //设置爬取数据的页面
                .run();                                  //执行爬虫
    }
}
