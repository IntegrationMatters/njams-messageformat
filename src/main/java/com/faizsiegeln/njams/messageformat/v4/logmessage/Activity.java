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
package com.faizsiegeln.njams.messageformat.v4.logmessage;

import com.faizsiegeln.njams.messageformat.v4.common.LocalDateTimeAdapter;
import com.faizsiegeln.njams.messageformat.v4.common.SubProcess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Activities used by the new server. They aggregate Tracks, Events and Traces
 * known from the old server.
 *
 * @author pnientiedt
 */
@ApiModel(description = "A nJAMS Activity instance.")
public class Activity implements Serializable, Comparable<Activity>, com.faizsiegeln.njams.messageformat.v4.logmessage.interfaces.IActivity {

    private static final long serialVersionUID = 4678602259385954997L;

    @ApiModelProperty(value = "ID of the activity in the process", required = true)
    private String modelId;

    @ApiModelProperty(value = "Unique ID of the activity instance", required = true)
    private String instanceId;

    @ApiModelProperty(value = "Number of the iteration if activity is inside a group.", required = false)
    private Long iteration = 1L;

    @ApiModelProperty(value = "Number of iteration count if actvity represents a group.", required = false)
    private Long maxIterations;

    @ApiModelProperty(value = "If activity has a parent like a group, the ID of that parent instance.",
            required = false)
    private String parentInstanceId;

    @ApiModelProperty(value = "A unique increasing sequence number.", required = false)
    private Long sequence;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @ApiModelProperty(value = "Start timestamp of the activity instance.", required = false)
    private LocalDateTime execution = LocalDateTime.now(ZoneOffset.UTC);

    @ApiModelProperty(value = "Duration of the activity instance in milliseconds.", required = false)
    private long duration;

    @ApiModelProperty(value = "Time of CPU usage for this activity instance", required = false)
    private long cpuTime;

    @ApiModelProperty(value = "The state of the activity instance.", required = false)
    private ActivityStatus activityStatus;

    @ApiModelProperty(value = "Input data into this activity instance", required = false)
    private String input;

    @ApiModelProperty(value = "Output data from this activity instance", required = false)
    private String output;

    @ApiModelProperty(value = "Status of the event 0=INFO, 1=SUCCESS, 2=WARNING, 3=ERROR", required = false)
    private Integer eventStatus;
    @ApiModelProperty(value = "Message of event.", required = false)
    private String eventMessage;
    @ApiModelProperty(value = "Code of the event.", required = false)
    private String eventCode;
    @ApiModelProperty(value = "Event payload.", required = false)
    private String eventPayload;
    @ApiModelProperty(value = "A possible stack trace happened on an event.", required = false)
    private String stackTrace;

    @ApiModelProperty(value = "A map of attributes with name and value.", required = false)
    private Map<String, String> attributes;

    @ApiModelProperty(value = "Payload of the activity that starts the process instance.", required = false)
    private String startData;

    @ApiModelProperty(value = "Required if activity calls a subprocess.", required = false)
    private SubProcess subProcess;
    
    @ApiModelProperty(value = "A list of all predecessor transitions which leads to this activity.", required = false)
    private final List<Predecessor> predecessors;

    public Activity() {
        this.attributes = new HashMap<>();
        this.predecessors = new ArrayList<>();
    }

    @Override
    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    @Override
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public Long getIteration() {
        return iteration;
    }

    @Override
    public void setIteration(Long iteration) {
        this.iteration = iteration;
    }

    @Override
    public Long getMaxIterations() {
        return maxIterations;
    }

    @Override
    public void setMaxIterations(Long maxIterations) {
        this.maxIterations = maxIterations;
    }

    @Override
    public String getParentInstanceId() {
        return parentInstanceId;
    }

    @Override
    public void setParentInstanceId(String parentInstanceId) {
        this.parentInstanceId = parentInstanceId;
    }

    /**
     * @return the predecessors
     */
    public List<Predecessor> getPredecessors() {
        return predecessors;
    }

    @Override
    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @Override
    public LocalDateTime getExecution() {
        return execution;
    }

    @Override
    public void setExecution(LocalDateTime execution) {
        this.execution = execution;
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public long getCpuTime() {
        return cpuTime;
    }

    @Override
    public void setCpuTime(long cpuTime) {
        this.cpuTime = cpuTime;
    }

    @Override
    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    @Override
    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public Integer getEventStatus() {
        return eventStatus;
    }

    @Override
    public void setEventStatus(Integer eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Override
    public String getEventMessage() {
        return eventMessage;
    }

    @Override
    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    @Override
    public String getEventCode() {
        return eventCode;
    }

    @Override
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    @Override
    public String getEventPayload() {
        return eventPayload;
    }

    @Override
    public void setEventPayload(String eventPayload) {
        this.eventPayload = eventPayload;
    }

    @Override
    public String getStackTrace() {
        return stackTrace;
    }

    @Override
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getStartData() {
        return startData;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    @Override
    public int compareTo(Activity a) {
        if (sequence == a.getSequence()) {
            return 0;
        } else if (sequence == null) {
            return -1;
        } else if (a.getSequence() == null) {
            return 1;
        }
        return sequence.compareTo(a.getSequence());
    }

    /**
     * @return the subProcess
     */
    public SubProcess getSubProcess() {
        return subProcess;
    }

    /**
     * @param subProcess the subProcess to set
     */
    public void setSubProcess(SubProcess subProcess) {
        this.subProcess = subProcess;
    }
}
