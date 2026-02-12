package driver.config;

import java.util.Map;

public class BrowserStackYamlConfig {

    private Browserstack browserstack;
    private Map<String, Object> capabilities;
    private Map<String, Object> options;

    // ===== GETTERS & SETTERS =====

    public Browserstack getBrowserstack() {
        return browserstack;
    }

    public void setBrowserstack(Browserstack browserstack) {
        this.browserstack = browserstack;
    }

    public Map<String, Object> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Map<String, Object> capabilities) {
        this.capabilities = capabilities;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    // ===== Inner class =====

    public static class Browserstack {

        private String user;
        private String key;
        private String hub;

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getHub() {
            return hub;
        }

        public void setHub(String hub) {
            this.hub = hub;
        }
    }
}
