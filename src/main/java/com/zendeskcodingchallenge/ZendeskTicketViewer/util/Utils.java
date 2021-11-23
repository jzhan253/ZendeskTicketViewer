package com.zendeskcodingchallenge.ZendeskTicketViewer.util;

import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static Properties get_properties() throws IOException{
        Properties p = new Properties();
        p.load(Utils.class.getResourceAsStream("/application.properties"));
        return p;
    }
}
