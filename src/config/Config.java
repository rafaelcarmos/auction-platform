package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Config {

    private static Properties props;

    public static Properties getProperties() {
        try {
            if (props == null) {
                File f = new File("settings");
                if (f.exists()) {
                    props = new Properties();
                    props.loadFromXML(new FileInputStream(f));
                } else {
                    f.createNewFile();
                    props = new Properties();
                    props.setProperty("events-file", "events.data");
                    props.setProperty("items-file", "items.data");
                    props.setProperty("clients-file", "clients.data");
                    props.setProperty("ring-buffer-size", "65536");
                    props.setProperty("mongodb-host", "localhost");
                    props.setProperty("mongodb-database", "auction-platform");
                    props.storeToXML(new FileOutputStream(f), "");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
