package com.tatelucky.yduts.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author tangsheng
 * @since 2019-08-05
 */
public class HtmlUtil {
    public static String getKey(String html) {
        Document document = Jsoup.parse(html);

        Elements elements = document.select("iframe");
        if (elements.size() > 0) {
            Element element = elements.get(0);
            String url = element.attr("src");
            //处理 这种String  http://sso.dasouche.net/httpapi/setSsoCookie.json?key=_security_token_inc&sid=91565007170045247
            if (url.length() < 95) {
                return null;
            }
            return url.substring(78, url.length());
        }
        return null;
    }

    public static void main(String[] args) {
        String html = "<body>\n" +
                "跳转中...\n" +
                "<script src=\"//assets.souche.com/shop/lib/jquery/jquery-1.9.1.min.js\"></script>\n" +
                "<iframe id=\"ssoHideFrame\" src=\"http://sso.dasouche.net/httpapi/setSsoCookie.json?key=_security_token_inc&sid=91565007170045247\" style=\"display:none;\"></iframe>\n" +
                "\n" +
                "<script>\n" +
                "\t$('#ssoHideFrame').load(function(){\n" +
                "\t\twindow.location.href='http://www.dasouche-inc.net/index.html';\n" +
                "\t\tconsole.log('load success');\n" +
                "\t});\n" +
                "</script>\n" +
                "\n" +
                "</body>";

        System.out.println(getKey(html));
    }
}
