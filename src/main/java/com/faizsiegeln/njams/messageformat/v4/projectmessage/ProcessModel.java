/* 
 * Copyright (c) 2018 Faiz & Siegeln Software GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * The Software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.projectmessage;

import com.faizsiegeln.njams.messageformat.v4.common.LocalDateTimeAdapter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author pnientiedt
 */
public class ProcessModel {

    private String path;
    private String name;
    private String svg;
    private String svgStatus;
    private LogLevel logLevel = LogLevel.INFO;
    private boolean exclude = false;
    private final Map<String, String> globalVariables;
    private final List<Activity> activities;
    private final List<Transition> transitions;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime deploymentTime = LocalDateTime.now(ZoneOffset.UTC);

    public ProcessModel() {
        this.transitions = new ArrayList<>();
        this.activities = new ArrayList<>();
        this.globalVariables = new HashMap<>();
    }

    /**
     * @return the deployment
     */
    public LocalDateTime getDeploymentTime() {
        return deploymentTime;
    }

    /**
     * @param deploymentTime the deployment to set
     */
    public void setDeploymentTime(LocalDateTime deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String getSvgStatus() {
        return svgStatus;
    }

    public void setSvgStatus(String svgStatus) {
        this.svgStatus = svgStatus;
    }

    public Map<String, String> getGlobalVariables() {
        return globalVariables;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    /**
     * @return the logLevel
     */
    public LogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * @param logLevel the logLevel to set
     */
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * @return the exclude
     */
    public boolean isExclude() {
        return exclude;
    }

    /**
     * @param exclude the exclude to set
     */
    public void setExclude(boolean exclude) {
        this.exclude = exclude;
    }

}
