package cn.boommanpro.module.proxy_pool.type;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public enum AnonymityType {
    /**
     *
     */
    HIGH("HIGH", "高匿"),
    CLEAR("CLEAR","透明")
    ;
    private String value;
    private String description;

    AnonymityType(String value, String description) {
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
    }}
