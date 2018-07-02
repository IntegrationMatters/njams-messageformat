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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

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
 *         &lt;element name="Activity" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Timestamp" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Sequence" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="TrackSequence" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Direction" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Process" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",
        propOrder = { "activity", "timestamp", "sequence", "trackSequence", "data", "direction", "process" })
@XmlRootElement(name = "Trace")
public class Trace {

    @XmlElement(name = "Activity", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/",
            required = true)
    protected String activity;
    @XmlElement(name = "Timestamp", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/")
    protected Trace.Timestamp timestamp;
    @XmlElement(name = "Sequence", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/")
    protected long sequence;
    @XmlElement(name = "TrackSequence", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/")
    protected long trackSequence;
    @XmlElement(name = "Data", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/", required = true)
    protected String data;
    @XmlElement(name = "Direction", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/",
            required = true)
    protected String direction;
    @XmlElement(name = "Process", namespace = "http://www.faizsiegeln.com/schema/njams/trace/2011-04-21/",
            required = true)
    protected String process;

    /**
     * Gets the value of the activity property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Sets the value of the activity property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setActivity(String value) {
        this.activity = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return possible object is {@link Trace.Timestamp }
     * 
     */
    public Trace.Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *            allowed object is {@link Trace.Timestamp }
     * 
     */
    public void setTimestamp(Trace.Timestamp value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     */
    public long getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     */
    public void setSequence(long value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the trackSequence property.
     * 
     */
    public long getTrackSequence() {
        return trackSequence;
    }

    /**
     * Sets the value of the trackSequence property.
     * 
     */
    public void setTrackSequence(long value) {
        this.trackSequence = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the process property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setProcess(String value) {
        this.process = value;
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
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    public static class Timestamp {

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
            this.timestamp = value;
        }

    }

}
