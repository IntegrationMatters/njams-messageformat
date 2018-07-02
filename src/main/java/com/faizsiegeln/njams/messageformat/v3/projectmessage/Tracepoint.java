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
 *       &lt;attribute name="process" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="activity" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="starttime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="endtime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="iterations" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="deeptrace" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "tracepoint")
public class Tracepoint {

    @XmlAttribute(name = "process")
    protected String process;
    @XmlAttribute(name = "activity")
    protected String activity;
    @XmlAttribute(name = "starttime")
    protected Long starttime;
    @XmlAttribute(name = "endtime")
    protected Long endtime;
    @XmlAttribute(name = "iterations")
    protected Integer iterations;
    @XmlAttribute(name = "deeptrace")
    protected Boolean deeptrace;

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
     * Gets the value of the starttime property.
     * 
     * @return possible object is {@link Long }
     * 
     */
    public Long getStarttime() {
        return starttime;
    }

    /**
     * Sets the value of the starttime property.
     * 
     * @param value
     *            allowed object is {@link Long }
     * 
     */
    public void setStarttime(Long value) {
        this.starttime = value;
    }

    /**
     * Gets the value of the endtime property.
     * 
     * @return possible object is {@link Long }
     * 
     */
    public Long getEndtime() {
        return endtime;
    }

    /**
     * Sets the value of the endtime property.
     * 
     * @param value
     *            allowed object is {@link Long }
     * 
     */
    public void setEndtime(Long value) {
        this.endtime = value;
    }

    /**
     * Gets the value of the iterations property.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getIterations() {
        return iterations;
    }

    /**
     * Sets the value of the iterations property.
     * 
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setIterations(Integer value) {
        this.iterations = value;
    }

    /**
     * Gets the value of the deeptrace property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public boolean isDeeptrace() {
        if (deeptrace == null) {
            return false;
        } else {
            return deeptrace;
        }
    }

    /**
     * Sets the value of the deeptrace property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setDeeptrace(Boolean value) {
        this.deeptrace = value;
    }

}
