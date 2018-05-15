// Copyright (c) Microsoft. All rights reserved.

package com.microsoft.azure.iotsolutions.iothubmanager.webservice.v1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.azure.iotsolutions.iothubmanager.services.models.CacheValue;
import com.microsoft.azure.iotsolutions.iothubmanager.webservice.v1.Version;

import java.util.HashSet;
import java.util.Hashtable;

public class DevicePropertiesApiModel {
    private HashSet<String> tags;
    private HashSet<String> reported;
    private Hashtable<String, String> metadata;

    @JsonProperty("Tags")
    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("Reported")
    public HashSet<String> getReported() {
        return reported;
    }

    public void setReported(HashSet<String> reported) {
        this.reported = reported;
    }

    @JsonProperty("$metadata")
    public Hashtable<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Hashtable<String, String> metadata) {
        this.metadata = metadata;
    }

    public DevicePropertiesApiModel() {
    }

    public DevicePropertiesApiModel(CacheValue model) {
        this.tags = model.getTags();
        this.reported = model.getReported();
        metadata = new Hashtable<String, String>();
        metadata.put("$type", String.format("DeviceProperties;%s", Version.NUMBER));
        metadata.put("$url", String.format("/%s/deviceProperties", Version.PATH));
    }

    public CacheValue ToServiceModel() {
        return new CacheValue(tags, reported);
    }
}
