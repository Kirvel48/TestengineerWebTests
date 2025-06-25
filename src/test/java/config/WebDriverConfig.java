package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)

@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties"

})

public interface WebDriverConfig extends Config {
    @Key("browser_name")
    @DefaultValue("chrome")
    String browserName();

    @DefaultValue("1920x1080")
    @Key("browser_size")
    String browserSize();

    @DefaultValue("128.0")
    @Key("browser_version")
    String browserVersion();

    @Key("remote_browser")
    String remoteUrl();
}

