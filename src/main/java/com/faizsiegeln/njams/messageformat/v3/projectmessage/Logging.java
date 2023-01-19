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

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

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
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}loglevel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}exclude" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}include" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "", propOrder = { "loglevel", "exclude", "include" })
@XmlRootElement(name = "logging")
@Deprecated
public class Logging {

    protected List<Loglevel> loglevel;
    protected List<Exclude> exclude;
    protected List<Include> include;

    /**
     * Gets the value of the loglevel property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the loglevel property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getLoglevel().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Loglevel }
     *
     *
     */
    public List<Loglevel> getLoglevel() {
        if (loglevel == null) {
            loglevel = new ArrayList<>();
        }
        return loglevel;
    }

    /**
     * Gets the value of the exclude property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the exclude property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getExclude().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Exclude }
     *
     *
     */
    public List<Exclude> getExclude() {
        if (exclude == null) {
            exclude = new ArrayList<>();
        }
        return exclude;
    }

    /**
     * Gets the value of the include property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the include property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     *
     * <pre>
     * getInclude().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Include }
     *
     *
     */
    public List<Include> getInclude() {
        if (include == null) {
            include = new ArrayList<>();
        }
        return include;
    }

}
