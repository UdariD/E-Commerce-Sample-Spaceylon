package qa.leco.eapp.config;


import org.aeonbits.owner.ConfigCache;

/**
 * This class provides a singleton instance of the Configuration class.
 */
public class ConfigurationManager {
    private ConfigurationManager() {}

    public static Configuration config() {
        return ConfigCache.getOrCreate(Configuration.class);
    }

}
