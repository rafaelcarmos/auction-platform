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
                File f = new File("settings.xml");
                if (f.exists()) {
                    props = new Properties();
                    props.loadFromXML(new FileInputStream(f));
                } else {
                    f.createNewFile();
                    props = new Properties();
                    props.setProperty("bidsFile", "bids.data");
                    props.setProperty("itemsFile", "items.data");
                    props.setProperty("biddersFile", "bidders.data");
                    props.storeToXML(new FileOutputStream(f), "");
                }
            }
        } catch (Exception ex) {
        }
        return props;
    }
}
