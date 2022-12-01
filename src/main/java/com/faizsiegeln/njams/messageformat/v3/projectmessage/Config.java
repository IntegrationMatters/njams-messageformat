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
package com.faizsiegeln.njams.messageformat.v3.projectmessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}logging" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}tracing" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}extracts" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="lastdeploymenttime" type="{http://www.w3.org/2001/XMLSchema}long" default="0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "logging", "tracing", "extracts" })
@XmlRootElement(name = "config")
@Deprecated
public class Config {

    protected Logging logging;
    protected Tracing tracing;
    protected Extracts extracts;
    @XmlAttribute(name = "lastdeploymenttime")
    protected Long lastdeploymenttime;

    /**
     * Gets the value of the logging property.
     *
     * @return possible object is {@link Logging }
     *
     */
    public Logging getLogging() {
        return logging;
    }

    /**
     * Sets the value of the logging property.
     *
     * @param value
     *            allowed object is {@link Logging }
     *
     */
    public void setLogging(Logging value) {
        logging = value;
    }

    /**
     * Gets the value of the tracing property.
     *
     * @return possible object is {@link Tracing }
     *
     */
    public Tracing getTracing() {
        return tracing;
    }

    /**
     * Sets the value of the tracing property.
     *
     * @param value
     *            allowed object is {@link Tracing }
     *
     */
    public void setTracing(Tracing value) {
        tracing = value;
    }

    /**
     * Gets the value of the extracts property.
     *
     * @return possible object is {@link Extracts }
     *
     */
    public Extracts getExtracts() {
        return extracts;
    }

    /**
     * Sets the value of the extracts property.
     *
     * @param value
     *            allowed object is {@link Extracts }
     *
     */
    public void setExtracts(Extracts value) {
        extracts = value;
    }

    /**
     * Gets the value of the lastdeploymenttime property.
     *
     * @return possible object is {@link Long }
     *
     */
    public long getLastdeploymenttime() {
        if (lastdeploymenttime == null) {
            return 0L;
        } else {
            return lastdeploymenttime;
        }
    }

    /**
     * Sets the value of the lastdeploymenttime property.
     *
     * @param value
     *            allowed object is {@link Long }
     *
     */
    public void setLastdeploymenttime(Long value) {
        lastdeploymenttime = value;
    }

}
