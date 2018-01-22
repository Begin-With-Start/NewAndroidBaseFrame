package demo.minifly.com.newandroidframe.network.nohttp;

/**
 * HTTP访问用RequestData minifly
 */
public class ZHttpRequestData implements ZIRequestData{
    /**
     * content : {"id":"51885300000006948"}
     * notify_url :
     * format : json
     */

    protected String requestUrl;
    protected String notify_url = "";
    protected String format = "json";


    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


}
