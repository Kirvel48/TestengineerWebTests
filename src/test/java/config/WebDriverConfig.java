package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)

@Config.Sources({
        "system:properties",
        "classpath:config/${env}.properties"

})

public interface WebDriverConfig extends Config {
    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @DefaultValue("1920x1080")
    @Key("browserSize")
    String browserSize();

    @DefaultValue("128.0")
    @Key("browserVersion")
    String browserVersion();

    @Key("remoteUrl")
    String remoteUrl();
}

