package org.scrum.psd.battleship.ascii;

import com.microsoft.applicationinsights.TelemetryClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Telemetry {
    private final TelemetryClient telemetryClient;

    public Telemetry() {
        telemetryClient = new TelemetryClient();
        telemetryClient.getContext().setInstrumentationKey("c764f176-19a5-4949-825d-9f30db2f14e8");
    }

    public void trackEvent(String name, String... customDimensions) {
        telemetryClient.trackEvent(name, readCustomDimensions(customDimensions), Collections.EMPTY_MAP);
    }

    private Map<String, String> readCustomDimensions(String... customDimensions) {
        Map<String, String> result = new HashMap<>();

        if(customDimensions.length % 2 == 0) {
            for(int i = 0; i < customDimensions.length; i += 2) {
                result.put(customDimensions[i], customDimensions[i+1]);
            }
        }

        return result;
    }
}
