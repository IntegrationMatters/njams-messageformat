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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="PluginDataItem" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="ts" type="{http://www.w3.org/2001/XMLSchema}long" default="0" /&gt;
 *                 &lt;attribute name="plugin" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *                 &lt;attribute name="data" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "", propOrder = { "pluginDataItem" })
@XmlRootElement(name = "PluginData", namespace = "http://www.faizsiegeln.com/schema/njams/plugindata/2013-09-15/")
@Deprecated
public class PluginData {

    @XmlElement(name = "PluginDataItem", namespace = "http://www.faizsiegeln.com/schema/njams/plugindata/2013-09-15/")
    protected List<PluginData.PluginDataItem> pluginDataItem;

    /**
     * Gets the value of the pluginDataItem property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the pluginDataItem property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getPluginDataItem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link PluginData.PluginDataItem }
     *
     *
     */
    public List<PluginData.PluginDataItem> getPluginDataItem() {
        if (pluginDataItem == null) {
            pluginDataItem = new ArrayList<>();
        }
        return pluginDataItem;
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
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="ts" type="{http://www.w3.org/2001/XMLSchema}long" default="0" /&gt;
     *       &lt;attribute name="plugin" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
     *       &lt;attribute name="data" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    @Deprecated
    public static class PluginDataItem {

        @XmlAttribute(name = "ts")
        protected Long ts;
        @XmlAttribute(name = "plugin")
        protected String plugin;
        @XmlAttribute(name = "data")
        protected String data;

        /**
         * Gets the value of the ts property.
         *
         * @return possible object is {@link Long }
         *
         */
        public long getTs() {
            if (ts == null) {
                return 0L;
            } else {
                return ts;
            }
        }

        /**
         * Sets the value of the ts property.
         *
         * @param value
         *            allowed object is {@link Long }
         *
         */
        public void setTs(Long value) {
            ts = value;
        }

        /**
         * Gets the value of the plugin property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getPlugin() {
            if (plugin == null) {
                return "";
            } else {
                return plugin;
            }
        }

        /**
         * Sets the value of the plugin property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setPlugin(String value) {
            plugin = value;
        }

        /**
         * Gets the value of the data property.
         *
         * @return possible object is {@link String }
         *
         */
        public String getData() {
            if (data == null) {
                return "";
            } else {
                return data;
            }
        }

        /**
         * Sets the value of the data property.
         *
         * @param value
         *            allowed object is {@link String }
         *
         */
        public void setData(String value) {
            data = value;
        }

    }

}
