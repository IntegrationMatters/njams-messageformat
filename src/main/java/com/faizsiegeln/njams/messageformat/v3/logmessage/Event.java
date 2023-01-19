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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="EventId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="Sequence" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="TrackSequence" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="EventDateTime" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ProcessName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ActivityName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EventMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EventMsgCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LogErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LogErrorMsgCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LogErrorSeverity" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Payload" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Stacktrace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/attribute/2010-04-21/}Attributes" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "eventId", "sequence", "trackSequence", "eventDateTime", "processName",
        "activityName", "eventMsg", "eventMsgCode", "logErrorMsg", "logErrorMsgCode", "logErrorSeverity", "status",
        "payload", "stacktrace", "attributes" })
@XmlRootElement(name = "Event", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
@Deprecated
public class Event {

    @XmlElement(name = "EventId", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected Long eventId;
    @XmlElement(name = "Sequence", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected Long sequence;
    @XmlElement(name = "TrackSequence", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected Long trackSequence;
    @XmlElement(name = "EventDateTime", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected Event.EventDateTime eventDateTime;
    @XmlElement(name = "ProcessName", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String processName;
    @XmlElement(name = "ActivityName", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String activityName;
    @XmlElement(name = "EventMsg", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String eventMsg;
    @XmlElement(name = "EventMsgCode", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String eventMsgCode;
    @XmlElement(name = "LogErrorMsg", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String logErrorMsg;
    @XmlElement(name = "LogErrorMsgCode", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String logErrorMsgCode;
    @XmlElement(name = "LogErrorSeverity", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected int logErrorSeverity;
    @XmlElement(name = "Status", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected int status;
    @XmlElement(name = "Payload", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/")
    protected String payload;
    @XmlElement(name = "Stacktrace", namespace = "http://www.faizsiegeln.com/schema/njams/event/2011-04-21/",
            required = true)
    protected String stacktrace;
    @XmlElement(name = "Attributes", namespace = "http://www.faizsiegeln.com/schema/njams/attribute/2010-04-21/")
    protected Attributes attributes;

    /**
     * Gets the value of the eventId property.
     *
     * @return possible object is {@link Long }
     *
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     *
     * @param value
     *            allowed object is {@link Long }
     *
     */
    public void setEventId(Long value) {
        eventId = value;
    }

    /**
     * Gets the value of the sequence property.
     *
     * @return possible object is {@link Long }
     *
     */
    public Long getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     *
     * @param value
     *            allowed object is {@link Long }
     *
     */
    public void setSequence(Long value) {
        sequence = value;
    }

    /**
     * Gets the value of the trackSequence property.
     *
     * @return possible object is {@link Long }
     *
     */
    public Long getTrackSequence() {
        return trackSequence;
    }

    /**
     * Sets the value of the sequence property.
     *
     * @param value
     *            allowed object is {@link Long }
     *
     */
    public void setTrackSequence(Long value) {
        trackSequence = value;
    }

    /**
     * Gets the value of the eventDateTime property.
     *
     * @return possible object is {@link Event.EventDateTime }
     *
     */
    public Event.EventDateTime getEventDateTime() {
        return eventDateTime;
    }

    /**
     * Sets the value of the eventDateTime property.
     *
     * @param value
     *            allowed object is {@link Event.EventDateTime }
     *
     */
    public void setEventDateTime(Event.EventDateTime value) {
        eventDateTime = value;
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
     * Gets the value of the activityName property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Sets the value of the activityName property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setActivityName(String value) {
        activityName = value;
    }

    /**
     * Gets the value of the eventMsg property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getEventMsg() {
        return eventMsg;
    }

    /**
     * Sets the value of the eventMsg property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setEventMsg(String value) {
        eventMsg = value;
    }

    /**
     * Gets the value of the eventMsgCode property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getEventMsgCode() {
        return eventMsgCode;
    }

    /**
     * Sets the value of the eventMsgCode property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setEventMsgCode(String value) {
        eventMsgCode = value;
    }

    /**
     * Gets the value of the logErrorMsg property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLogErrorMsg() {
        return logErrorMsg;
    }

    /**
     * Sets the value of the logErrorMsg property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setLogErrorMsg(String value) {
        logErrorMsg = value;
    }

    /**
     * Gets the value of the logErrorMsgCode property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getLogErrorMsgCode() {
        return logErrorMsgCode;
    }

    /**
     * Sets the value of the logErrorMsgCode property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setLogErrorMsgCode(String value) {
        logErrorMsgCode = value;
    }

    /**
     * Gets the value of the logErrorSeverity property.
     *
     */
    public int getLogErrorSeverity() {
        return logErrorSeverity;
    }

    /**
     * Sets the value of the logErrorSeverity property.
     *
     */
    public void setLogErrorSeverity(int value) {
        logErrorSeverity = value;
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
     * Gets the value of the payload property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getPayload() {
        return payload;
    }

    /**
     * Sets the value of the payload property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setPayload(String value) {
        payload = value;
    }

    /**
     * Gets the value of the stacktrace property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getStacktrace() {
        return stacktrace;
    }

    /**
     * Sets the value of the stacktrace property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    public void setStacktrace(String value) {
        stacktrace = value;
    }

    /**
     * Gets the value of the attributes property.
     *
     * @return possible object is {@link Attributes }
     *
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     *
     * @param value
     *            allowed object is {@link Attributes }
     *
     */
    public void setAttributes(Attributes value) {
        attributes = value;
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
    public static class EventDateTime {

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
