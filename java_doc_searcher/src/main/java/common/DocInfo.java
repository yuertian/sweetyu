// common包 表示每个模块都可能用到的公共信息
package common;

// 表示一个文档对象（HTML对象）
// 根据这些内容，后面才能制作索引，完成搜索过程
public class DocInfo {
    // docId 文档的唯一标识（不能重复）
    private int docId;
    // title 该文档的标题，简单粗暴地使用文件名来表示
    // Collection.html => Collection
    private String title;
    //url 该文档对应的线上文档的URL，根据本地文件路径可以构造出线上文档的URL
    private String url;
    // content 该文档的正文，把html文件中的html标签去掉，留下的内容
    private String content;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DocInfo{" +
                "docId=" + docId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
