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

import com.faizsiegeln.njams.messageformat.v4.common.CommonMessage;
import com.faizsiegeln.njams.messageformat.v4.common.TreeElement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pnientiedt
 */
public class ProjectMessage extends CommonMessage {

    public static final String DEFAULT_EVENT = "deployment";

    private final List<TreeElement> treeElements;
    private List<String> features = new ArrayList<>();
    private String event = DEFAULT_EVENT;
    private LocalDateTime startTime;
    private LogMode logMode = LogMode.COMPLETE;
    private String machine;
    private String clientId;
    private Boolean recording;
    private final Map<String, String> globalVariables;
    private String globalVariablesPattern;
    private final Map<String, String> images;
    private final List<ProcessModel> processes;

    public ProjectMessage() {
        processes = new ArrayList<>();
        images = new HashMap<>();
        globalVariables = new HashMap<>();
        treeElements = new ArrayList<>();
    }

    public List<TreeElement> getTreeElements() {
        return treeElements;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Map<String, String> getGlobalVariables() {
        return globalVariables;
    }

    /**
     * Returns the regular expression that defines how global-variable references are detected and replaced in the
     * client's configurations. The pattern uses named groups: {@code full} and {@code name} are required, {@code
     * default} (a fallback value) and {@code optional} (any non-blank match marks the reference as optional) are
     * optional. When {@code null} or empty, the server applies its own default behavior. The message format only
     * transports this pattern; it does not interpret it.
     *
     * @return the global-variable matching pattern, or {@code null} if none was set
     */
    public String getGlobalVariablesPattern() {
        return globalVariablesPattern;
    }

    /**
     * Sets the regular expression that defines how global-variable references are detected and replaced in the
     * client's configurations. See {@link #getGlobalVariablesPattern()} for the expected group structure.
     *
     * @param globalVariablesPattern the global-variable matching pattern
     */
    public void setGlobalVariablesPattern(String globalVariablesPattern) {
        this.globalVariablesPattern = globalVariablesPattern;
    }

    public Map<String, String> getImages() {
        return images;
    }

    public List<ProcessModel> getProcesses() {
        return processes;
    }

    /**
     * @return the logMode
     */
    public LogMode getLogMode() {
        return logMode;
    }

    /**
     * @param logMode the logMode to set
     */
    public void setLogMode(LogMode logMode) {
        this.logMode = logMode;
    }

    /**
     * @return the machine
     */
    public String getMachine() {
        return machine;
    }

    /**
     * @param machine the machine to set
     */
    public void setMachine(String machine) {
        this.machine = machine;
    }

    /**
     * @return the unique client id (needed for container setups with replicas)
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the unique client id to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Boolean getRecording() {
        return recording;
    }

    public void setRecording(Boolean recording) {
        this.recording = recording;
    }

}
