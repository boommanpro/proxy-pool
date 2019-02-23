package cn.boommanpro.module.proxy_pool.type;

import java.net.Proxy;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public enum HttpType {
    /**
     *
     */
    HTTP("HTTP", "HTTP类型"),
    HTTPS("HTTPS", "HTTPS类型"),
    SOCKS("SOCKS", "SOCKS类型"),
    ;
    private String value;
    private String description;


    HttpType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Proxy.Type convert2ProxyType() {
        switch (this) {
            case HTTP:
                return Proxy.Type.HTTP;
            case HTTPS:
                return Proxy.Type.HTTP;
            case SOCKS:
                return Proxy.Type.SOCKS;
            default:
                return Proxy.Type.HTTP;
        }
    }
}
