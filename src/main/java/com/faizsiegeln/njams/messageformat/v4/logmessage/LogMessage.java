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

import com.faizsiegeln.njams.messageformat.v4.common.CommonMessage;
import com.faizsiegeln.njams.messageformat.v4.common.MessageVersion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A nJAMS Logmessage.
 *
 * @author bwand
 */
public class LogMessage extends CommonMessage
        implements Serializable, com.faizsiegeln.njams.messageformat.v4.logmessage.interfaces.ILogMessage {

    private static final long serialVersionUID = -6311723150758897052L;

    /**
     * The version of the nJAMS message. Defaults to V4.
     */
    private MessageVersion messageVersion = MessageVersion.V4;

    /**
     * If a process instance comes splitted in several messages, a message number has to be provided; required
     */
    private Integer messageNo;

    /**
     * The timestamp of the client at the time it will send the message; required
     */
    private LocalDateTime sentAt = LocalDateTime.now(ZoneOffset.UTC);

    /**
     * A unique ID for the process instance; rquired
     */
    private String logId;

    /**
     * An ID to correlate several process instances together in nJAMS
     */
    private String correlationLogId;

    /**
     * An ID of a parent process instance
     */
    private String parentLogId;

    /**
     * External customer process instance ID
     */
    private String externalLogId;

    /**
     * ID of the client job/process instance
     */
    private String jobId;

    /**
     * Name of the process
     */
    private String processName;

    /**
     * Name of the server machine where client runs on
     */
    private String machineName;

    /**
     * Business service name
     */
    private String serviceName;

    /**
     * Business object name.
     */
    private String objectName;

    /**
     * The start timestamp of the process instance; required
     */
    private LocalDateTime jobStart;

    /**
     * The end timestamp of the process instance
     */
    private LocalDateTime jobEnd;

    /**
     * The start timestamp of the business process instance
     */
    private LocalDateTime businessStart;

    /**
     * The end timestamp of the business process instance
     */
    private LocalDateTime businessEnd;

    /**
     * The state of the process instance: 0=RUNNING, 1=SUCCESS, 2=WARNING, 3=ERROR
     */
    private Integer status;

    /**
     * Highest status the process instance ever had
     */
    private Integer maxSeverity;

    /**
     * Set true if any activity contains trace data
     */
    private Boolean trace = Boolean.FALSE;

    /**
     * A map of attributes with name and value
     */
    private final Map<String, String> attributes;

    /**
     * A list of all activities in this instance
     */
    private final List<Activity> activities;

    /**
     * A list of additional data send by plugins
     */
    private final List<PluginDataItem> plugins;

    /**
     * Set true the client has stopped processing activities/transistions
     */
    private Boolean truncated = Boolean.FALSE;

    public LogMessage() {
        plugins = new ArrayList<>();
        activities = new ArrayList<>();
        attributes = new HashMap<>();
        messageNo = 1;
    }

    /**
     * @return the businessEnd
     */
    @Override
    public LocalDateTime getBusinessEnd() {
        return businessEnd;
    }

    /**
     * @param businessEnd the businessEnd to set
     */
    @Override
    public void setBusinessEnd(LocalDateTime businessEnd) {
        this.businessEnd = businessEnd;
    }

    /**
     * @return the businessStart
     */
    @Override
    public LocalDateTime getBusinessStart() {
        return businessStart;
    }

    /**
     * @param businessStart the businessStart to set
     */
    @Override
    public void setBusinessStart(LocalDateTime businessStart) {
        this.businessStart = businessStart;
    }

    @Override
    public MessageVersion getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(MessageVersion messageVersion) {
        this.messageVersion = messageVersion;
    }

    @Override
    public Integer getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(Integer messageNr) {
        messageNo = messageNr;
    }

    @Override
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Override
    public String getCorrelationLogId() {
        return correlationLogId;
    }

    @Override
    public void setCorrelationLogId(String correlationLogId) {
        this.correlationLogId = correlationLogId;
    }

    @Override
    public String getParentLogId() {
        return parentLogId;
    }

    @Override
    public void setParentLogId(String parentLogId) {
        this.parentLogId = parentLogId;
    }

    @Override
    public String getExternalLogId() {
        return externalLogId;
    }

    @Override
    public void setExternalLogId(String externalLogId) {
        this.externalLogId = externalLogId;
    }

    @Override
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    @Override
    public String getMachineName() {
        return machineName;
    }

    @Override
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    /**
     * @return the sentAt
     */
    @Override
    public LocalDateTime getSentAt() {
        return sentAt;
    }

    /**
     * @param sentAt the sentAt to set
     */
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public void setServiceName(String businessService) {
        serviceName = businessService;
    }

    @Override
    public String getObjectName() {
        return objectName;
    }

    @Override
    public void setObjectName(String businessObject) {
        objectName = businessObject;
    }

    @Override
    public LocalDateTime getJobStart() {
        return jobStart;
    }

    public void setJobStart(LocalDateTime jobStart) {
        this.jobStart = jobStart;
    }

    @Override
    public LocalDateTime getJobEnd() {
        return jobEnd;
    }

    public void setJobEnd(LocalDateTime jobEnd) {
        this.jobEnd = jobEnd;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getMaxSeverity() {
        return maxSeverity;
    }

    @Override
    public void setMaxSeverity(Integer maxSeverity) {
        this.maxSeverity = maxSeverity;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public void addAtribute(String key, String value) {
        attributes.put(key, value);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public void addActivity(com.faizsiegeln.njams.messageformat.v4.logmessage.interfaces.IActivity activity) {
        activities.add((Activity) activity);
    }

    /**
     * @return the trace
     */
    @Override
    public Boolean getTrace() {
        return trace;
    }

    /**
     * @param trace the trace to set
     */
    @Override
    public void setTrace(Boolean trace) {
        this.trace = trace;
    }

    public List<PluginDataItem> getPlugins() {
        return plugins;
    }

    @Override
    public void addPluginDataItem(
            com.faizsiegeln.njams.messageformat.v4.logmessage.interfaces.IPluginDataItem pluginDataItem) {
        plugins.add((PluginDataItem) pluginDataItem);
    }

    @Override
    public Boolean getTruncated() {
        return truncated;
    }

    @Override
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

}
