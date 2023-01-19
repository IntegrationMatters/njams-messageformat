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
package com.faizsiegeln.njams.messageformat.v3.logmessage;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LogID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CorrelationLogID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ParentLogID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExternalLogID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="JobID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="DomainName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MachineName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EngineName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Deployment" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ProcessName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BusinessService" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BusinessObject" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BusinessStart" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BusinessEnd" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="JobStart"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="JobEnd" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="LastEventStatus" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{http://www.faizsiegeln.com/schema/njams/event/2011-04-21/}Events"/&gt;
 *           &lt;element ref="{http://www.faizsiegeln.com/schema/njams/attribute/2010-04-21/}Attributes"/&gt;
 *           &lt;element ref="{http://www.faizsiegeln.com/schema/njams/track/2011-04-21/}Track"/&gt;
 *           &lt;element ref="{http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/}Traces"/&gt;
 *           &lt;element ref="{http://www.faizsiegeln.com/schema/njams/plugindata/2013-09-15/}PluginData"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="logsource" type="{http://www.w3.org/2001/XMLSchema}string" default="bw" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "logID", "correlationLogID", "parentLogID", "externalLogID", "jobID", "domainName",
        "machineName", "engineName", "deployment", "processName", "businessService", "businessObject", "businessStart",
        "businessEnd", "jobStart", "jobEnd", "status", "lastEventStatus", "eventsOrAttributesOrTrack" })
@XmlRootElement(name = "LogMessage", namespace = "")
@Deprecated
public class LogMessage {

    @XmlElement(name = "LogID", required = true)
    protected String logID;
    @XmlElement(name = "CorrelationLogID")
    protected String correlationLogID;
    @XmlElement(name = "ParentLogID")
    protected String parentLogID;
    @XmlElement(name = "ExternalLogID")
    protected String externalLogID;
    @XmlElement(name = "JobID")
    protected long jobID;
    @XmlElement(name = "DomainName", required = true)
    protected String domainName;
    @XmlElement(name = "MachineName", required = true)
    protected String machineName;
    @XmlElement(name = "EngineName", required = true)
    protected String engineName;
    @XmlElement(name = "Deployment", required = true)
    protected String deployment;
    @XmlElement(name = "ProcessName", required = true)
    protected String processName;
    @XmlElement(name = "BusinessService", required = true)
    protected String businessService;
    @XmlElement(name = "BusinessObject", required = true)
    protected String businessObject;
    @XmlElement(name = "BusinessStart")
    protected LogMessage.BusinessStart businessStart;
    @XmlElement(name = "BusinessEnd")
    protected LogMessage.BusinessEnd businessEnd;
    @XmlElement(name = "JobStart", required = true)
    protected LogMessage.JobStart jobStart;
    @XmlElement(name = "JobEnd")
    protected LogMessage.JobEnd jobEnd;
    @XmlElement(name = "Status")
    protected int status;
    @XmlElement(name = "LastEventStatus")
    protected int lastEventStatus;
    @XmlElements({
            @XmlElement(name = "Track", namespace = "http://www.faizsiegeln.com/schema/njams/track/2011-04-21/",
                    type = Track.class),
            @XmlElement(name = "Events", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
                    type = Events.class),
            @XmlElement(name = "PluginData",
                    namespace = "http://www.faizsiegeln.com/schema/njams/plugindata/2013-09-15/",
                    type = PluginData.class),
            @XmlElement(name = "Traces", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/",
                    type = Traces.class),
            @XmlElement(name = "Attributes",
                    namespace = "http://www.faizsiegeln.com/schema/njams/attribute/2010-04-21/",
                    type = Attributes.class) })
    protected List<Object> eventsOrAttributesOrTrack;
    @XmlAttribute(name = "logsource")
    protected String logsource;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "clientVersion")
    private String clientVersion;
    @XmlAttribute(name = "sdkVersion")
    private String sdkVersion;
    @XmlAttribute(name = "timestamp")
    protected Long timestamp;
    @XmlAttribute(name = "messageNumber")
    private Long messageNumber;
    @XmlAttribute(name = "completed")
    private Boolean completed;

    /**
     * @return the clientVersion
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * @param clientVersion the clientVersion to set
     */
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    /**
     * @return the sdkVersion
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * @param sdkVersion the sdkVersion to set
     */
    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * @return the completed
     */
    public Boolean isCompleted() {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    /**
     * Gets the value of the logID property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLogID() {
        return logID;
    }

    /**
     * Sets the value of the logID property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setLogID(String value) {
        logID = value;
    }

    /**
     * Gets the value of the correlationLogID property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCorrelationLogID() {
        return correlationLogID;
    }

    /**
     * Sets the value of the correlationLogID property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setCorrelationLogID(String value) {
        correlationLogID = value;
    }

    /**
     * @return the messageNumber
     */
    public Long getMessageNumber() {
        return messageNumber;
    }

    /**
     * @param messageNumber the messageNumber to set
     */
    public void setMessageNumber(Long messageNumber) {
        this.messageNumber = messageNumber;
    }

    /**
     * Gets the value of the parentLogID property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getParentLogID() {
        return parentLogID;
    }

    /**
     * Sets the value of the parentLogID property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setParentLogID(String value) {
        parentLogID = value;
    }

    /**
     * Gets the value of the externalLogID property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getExternalLogID() {
        return externalLogID;
    }

    /**
     * Sets the value of the externalLogID property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setExternalLogID(String value) {
        externalLogID = value;
    }

    /**
     * Gets the value of the jobID property.
     *
     */
    public long getJobID() {
        return jobID;
    }

    /**
     * Sets the value of the jobID property.
     *
     */
    public void setJobID(long value) {
        jobID = value;
    }

    /**
     * Gets the value of the domainName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setDomainName(String value) {
        domainName = value;
    }

    /**
     * Gets the value of the machineName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     * Sets the value of the machineName property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setMachineName(String value) {
        machineName = value;
    }

    /**
     * Gets the value of the engineName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getEngineName() {
        return engineName;
    }

    /**
     * Sets the value of the engineName property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setEngineName(String value) {
        engineName = value;
    }

    /**
     * Gets the value of the deployment property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDeployment() {
        return deployment;
    }

    /**
     * Sets the value of the deployment property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setDeployment(String value) {
        deployment = value;
    }

    /**
     * Gets the value of the processName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * Sets the value of the processName property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setProcessName(String value) {
        processName = value;
    }

    /**
     * Gets the value of the businessService property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getBusinessService() {
        return businessService;
    }

    /**
     * Sets the value of the businessService property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setBusinessService(String value) {
        businessService = value;
    }

    /**
     * Gets the value of the businessObject property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getBusinessObject() {
        return businessObject;
    }

    /**
     * Sets the value of the businessObject property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setBusinessObject(String value) {
        businessObject = value;
    }

    /**
     * Gets the value of the businessStart property.
     *
     * @return possible object is {@link LogMessage.BusinessStart }
     *
     */
    public LogMessage.BusinessStart getBusinessStart() {
        return businessStart;
    }

    /**
     * Sets the value of the businessStart property.
     *
     * @param value
     *            allowed object is {@link LogMessage.BusinessStart }
     *
     */
    public void setBusinessStart(LogMessage.BusinessStart value) {
        businessStart = value;
    }

    /**
     * Gets the value of the businessEnd property.
     *
     * @return possible object is {@link LogMessage.BusinessEnd }
     *
     */
    public LogMessage.BusinessEnd getBusinessEnd() {
        return businessEnd;
    }

    /**
     * Sets the value of the businessEnd property.
     *
     * @param value
     *            allowed object is {@link LogMessage.BusinessEnd }
     *
     */
    public void setBusinessEnd(LogMessage.BusinessEnd value) {
        businessEnd = value;
    }

    /**
     * Gets the value of the jobStart property.
     *
     * @return possible object is {@link LogMessage.JobStart }
     *
     */
    public LogMessage.JobStart getJobStart() {
        return jobStart;
    }

    /**
     * Sets the value of the jobStart property.
     *
     * @param value
     *            allowed object is {@link LogMessage.JobStart }
     *
     */
    public void setJobStart(LogMessage.JobStart value) {
        jobStart = value;
    }

    /**
     * Gets the value of the jobEnd property.
     *
     * @return possible object is {@link LogMessage.JobEnd }
     *
     */
    public LogMessage.JobEnd getJobEnd() {
        return jobEnd;
    }

    /**
     * Sets the value of the jobEnd property.
     *
     * @param value
     *            allowed object is {@link LogMessage.JobEnd }
     *
     */
    public void setJobEnd(LogMessage.JobEnd value) {
        jobEnd = value;
    }

    /**
     * Gets the value of the status property.
     *
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     */
    public void setStatus(int value) {
        status = value;
    }

    /**
     * Gets the value of the lastEventStatus property.
     *
     */
    public int getLastEventStatus() {
        return lastEventStatus;
    }

    /**
     * Sets the value of the lastEventStatus property.
     *
     */
    public void setLastEventStatus(int value) {
        lastEventStatus = value;
    }

    /**
     * Gets the value of the eventsOrAttributesOrTrack property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the eventsOrAttributesOrTrack property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getEventsOrAttributesOrTrack().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Track } {@link Events } {@link PluginData }
     * {@link Traces } {@link Attributes }
     *
     *
     */
    public List<Object> getEventsOrAttributesOrTrack() {
        if (eventsOrAttributesOrTrack == null) {
            eventsOrAttributesOrTrack = new ArrayList<>();
        }
        return eventsOrAttributesOrTrack;
    }

    /**
     * Gets the value of the logsource property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLogsource() {
        if (logsource == null) {
            return "bw";
        } else {
            return logsource;
        }
    }

    /**
     * Sets the value of the logsource property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setLogsource(String value) {
        logsource = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setVersion(String value) {
        version = value;
    }

    /**
     * Gets the value of the timestamp property.
     *
     * @return possible object is {@link Long }
     *
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     *
     * @param value
     *            allowed object is {@link Long }
     *
     */
    public void setTimestamp(Long value) {
        timestamp = value;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    @Deprecated
    public static class BusinessEnd {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "timestamp")
        protected Long timestamp;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the timestamp property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setTimestamp(Long value) {
            timestamp = value;
        }

    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    @Deprecated
    public static class BusinessStart {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "timestamp")
        protected Long timestamp;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the timestamp property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setTimestamp(Long value) {
            timestamp = value;
        }

    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    @Deprecated
    public static class JobEnd {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "timestamp")
        protected Long timestamp;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the timestamp property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setTimestamp(Long value) {
            timestamp = value;
        }

    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    @Deprecated
    public static class JobStart {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "timestamp")
        protected Long timestamp;

        /**
         * Gets the value of the value property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the timestamp property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setTimestamp(Long value) {
            timestamp = value;
        }

    }

}
