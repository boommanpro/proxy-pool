package cn.boommanpro.module.proxy_pool.parse;

import lombok.Data;
import me.ghui.fruit.annotations.Pick;

import java.util.List;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Data
public class XiciModel {
    @Pick("#ip_list tr:gt(0)")
    private List<XiciRow> pageData;

    @Data
    public static class XiciRow{
        @Pick("td:eq(1)")
        private String ip;
        @Pick("td:eq(2)")
        private Integer port;
        @Pick("td:eq(3)")
        private String country;
        @Pick("td:eq(4)")
        private String anonymity;
        @Pick("td:eq(5)")
        private String type;
    }
}
