package com.example.julesbackend.model;

import java.util.Objects;

public class Microservice {
    private Long serviceId;
    private String serviceName;
    private String serviceUrl;
    private String latestBuild;
    private String lastBuild;

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public void setLatestBuild(String latestBuild) {
        this.latestBuild = latestBuild;
    }

    public void setLastBuild(String lastBuild) {
        this.lastBuild = lastBuild;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getLatestBuild() {
        return latestBuild;
    }

    public String getLastBuild() {
        return lastBuild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Microservice that = (Microservice) o;
        return Objects.equals(serviceId, that.serviceId) &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(serviceUrl, that.serviceUrl) &&
                Objects.equals(latestBuild, that.latestBuild) &&
                Objects.equals(lastBuild, that.lastBuild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, serviceUrl, latestBuild, lastBuild);
    }
}
