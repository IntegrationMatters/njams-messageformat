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

import javax.xml.bind.annotation.XmlRegistry;

import com.faizsiegeln.njams.messageformat.v3.logmessage.Attributes.Attribute;
import com.faizsiegeln.njams.messageformat.v3.logmessage.Event.EventDateTime;
import com.faizsiegeln.njams.messageformat.v3.logmessage.LogMessage.BusinessEnd;
import com.faizsiegeln.njams.messageformat.v3.logmessage.LogMessage.BusinessStart;
import com.faizsiegeln.njams.messageformat.v3.logmessage.LogMessage.JobEnd;
import com.faizsiegeln.njams.messageformat.v3.logmessage.LogMessage.JobStart;
import com.faizsiegeln.njams.messageformat.v3.logmessage.PluginData.PluginDataItem;
import com.faizsiegeln.njams.messageformat.v3.logmessage.Track.Transition;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.faizsiegeln.njams.jaxb.IMAF package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 */
@XmlRegistry
@Deprecated
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * com.faizsiegeln.njams.jaxb.IMAF
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LogMessage }
     *
     */
    public LogMessage createLogMessage() {
        return new LogMessage();
    }

    /**
     * Create an instance of {@link Event }
     *
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link Attributes }
     *
     */
    public Attributes createAttributes() {
        return new Attributes();
    }

    /**
     * Create an instance of {@link Track }
     *
     */
    public Track createTrack() {
        return new Track();
    }

    /**
     * Create an instance of {@link Trace }
     *
     */
    public Trace createTrace() {
        return new Trace();
    }

    /**
     * Create an instance of {@link PluginData }
     *
     */
    public PluginData createPluginData() {
        return new PluginData();
    }

    /**
     * Create an instance of {@link Attributes.Attribute }
     *
     */
    public Attribute createAttributesAttribute() {
        return new Attributes.Attribute();
    }

    /**
     * Create an instance of {@link LogMessage.BusinessStart }
     *
     */
    public BusinessStart createLogMessageBusinessStart() {
        return new LogMessage.BusinessStart();
    }

    /**
     * Create an instance of {@link LogMessage.BusinessEnd }
     *
     */
    public BusinessEnd createLogMessageBusinessEnd() {
        return new LogMessage.BusinessEnd();
    }

    /**
     * Create an instance of {@link LogMessage.JobStart }
     *
     */
    public JobStart createLogMessageJobStart() {
        return new LogMessage.JobStart();
    }

    /**
     * Create an instance of {@link LogMessage.JobEnd }
     *
     */
    public JobEnd createLogMessageJobEnd() {
        return new LogMessage.JobEnd();
    }

    /**
     * Create an instance of {@link Events }
     *
     */
    public Events createEvents() {
        return new Events();
    }

    /**
     * Create an instance of {@link Event.EventDateTime }
     *
     */
    public EventDateTime createEventEventDateTime() {
        return new Event.EventDateTime();
    }

    /**
     * Create an instance of {@link Track.Transition }
     *
     */
    public Transition createTrackTransition() {
        return new Track.Transition();
    }

    /**
     * Create an instance of {@link Traces }
     *
     */
    public Traces createTraces() {
        return new Traces();
    }

    /**
     * Create an instance of {@link Trace.Timestamp }
     *
     */
    public com.faizsiegeln.njams.messageformat.v3.logmessage.Trace.Timestamp
            createTraceTimestamp() {
        return new Trace.Timestamp();
    }

    /**
     * Create an instance of {@link PluginData.PluginDataItem }
     *
     */
    public PluginDataItem createPluginDataPluginDataItem() {
        return new PluginData.PluginDataItem();
    }

    /**
     * Create an instance of {@link Attributes.Attribute.Timestamp }
     *
     */
    public Attributes.Attribute.Timestamp createAttributesAttributeTimestamp() {
        return new Attributes.Attribute.Timestamp();
    }

}
