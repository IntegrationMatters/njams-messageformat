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
 *         &lt;element name="Transition" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="Sequence" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;attribute name="Stack" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="CalledSubprocess" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="CalledSubprocessId" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;attribute name="Iteration" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;attribute name="DomainObjectId" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;attribute name="ElapsedTime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;attribute name="ExecutionTime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="process" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "transition" })
@XmlRootElement(name = "Track", namespace = "http://www.faizsiegeln.com/schema/njams/track/2011-04-21/")
@Deprecated
public class Track {

    @XmlElement(name = "Transition", namespace = "http://www.faizsiegeln.com/schema/njams/track/2011-04-21/")
    protected List<Track.Transition> transition;
    @XmlAttribute(name = "process")
    protected String process;

    /**
     * Gets the value of the transition property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the transition property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getTransition().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Track.Transition }
     *
     *
     */
    public List<Track.Transition> getTransition() {
        if (transition == null) {
            transition = new ArrayList<>();
        }
        return transition;
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
        process = value;
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
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="Sequence" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *       &lt;attribute name="Stack" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="CalledSubprocess" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="CalledSubprocessId" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *       &lt;attribute name="Iteration" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *       &lt;attribute name="DomainObjectId" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *       &lt;attribute name="ElapsedTime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *       &lt;attribute name="ExecutionTime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
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
    public static class Transition {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "Name")
        protected String name;
        @XmlAttribute(name = "Sequence")
        protected Long sequence;
        @XmlAttribute(name = "Stack")
        protected String stack;
        @XmlAttribute(name = "CalledSubprocess")
        protected String calledSubprocess;
        @XmlAttribute(name = "CalledSubprocessId")
        protected Long calledSubprocessId;
        @XmlAttribute(name = "Iteration")
        protected Long iteration;
        @XmlAttribute(name = "DomainObjectId")
        protected Long domainObjectId;
        @XmlAttribute(name = "ElapsedTime")
        protected Long elapsedTime;
        @XmlAttribute(name = "ExecutionTime")
        protected Long executionTime;

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
         * Gets the value of the name property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setName(String value) {
            name = value;
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
         * Gets the value of the stack property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getStack() {
            return stack;
        }

        /**
         * Sets the value of the stack property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setStack(String value) {
            stack = value;
        }

        /**
         * Gets the value of the calledSubprocess property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getCalledSubprocess() {
            return calledSubprocess;
        }

        /**
         * Sets the value of the calledSubprocess property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setCalledSubprocess(String value) {
            calledSubprocess = value;
        }

        /**
         * Gets the value of the calledSubprocessId property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getCalledSubprocessId() {
            return calledSubprocessId;
        }

        /**
         * Sets the value of the calledSubprocessId property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setCalledSubprocessId(Long value) {
            calledSubprocessId = value;
        }

        /**
         * Gets the value of the iteration property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getIteration() {
            return iteration;
        }

        /**
         * Sets the value of the iteration property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setIteration(Long value) {
            iteration = value;
        }

        /**
         * Gets the value of the domainObjectId property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getDomainObjectId() {
            return domainObjectId;
        }

        /**
         * Sets the value of the domainObjectId property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setDomainObjectId(Long value) {
            domainObjectId = value;
        }

        /**
         * Gets the value of the elapsedTime property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getElapsedTime() {
            return elapsedTime;
        }

        /**
         * Sets the value of the elapsedTime property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setElapsedTime(Long value) {
            elapsedTime = value;
        }

        /**
         * Gets the value of the executionTime property.
         *
         * @return possible object is {@link Long }
         *
         */
        public Long getExecutionTime() {
            return executionTime;
        }

        /**
         * Sets the value of the executionTime property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setExecutionTime(Long value) {
            executionTime = value;
        }

    }

}
