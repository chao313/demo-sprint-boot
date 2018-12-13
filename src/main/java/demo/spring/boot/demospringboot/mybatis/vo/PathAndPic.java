package demo.spring.boot.demospringboot.mybatis.vo;

public class PathAndPic {
    private String url;
    private String path;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "PathAndPic{" +
                "url='" + url + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
