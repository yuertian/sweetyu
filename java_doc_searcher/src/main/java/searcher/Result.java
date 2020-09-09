package searcher;

// 表示一条搜索结果，是根据 docInfo 得到的
public class Result {
    private String title;
    // 当前这个场景中，这两个 URL 内容一样
    private String showUrl; // 展示URL
    private String clickUrl; // 点击URL
    private String desc; // 描述信息，网页正文的摘要信息，一般要包含查询词（查询词的相关部分）

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Result{" + '\n' +
                "title = " + title + '\n' +
                "showUrl = " + showUrl + '\n' +
                "clickUrl = " + clickUrl + '\n' +
                "desc = " + desc + '\n' +
                '}';
    }
}
