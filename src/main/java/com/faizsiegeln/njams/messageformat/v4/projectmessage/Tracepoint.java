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
package com.faizsiegeln.njams.messageformat.v4.projectmessage;

import com.faizsiegeln.njams.messageformat.v4.common.LocalDateTimeAdapter;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * A Tracepoint can be configured for an {@link Activity}.
 */
public class Tracepoint {

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime starttime;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime endtime;
    private Integer iterations;
    private Boolean deepTrace;

    /**
     * Get the startTime where the Tracepoint will get effective
     * 
     * @return the startTime as LocalDateTime
     */
    public LocalDateTime getStarttime() {
        return starttime;
    }

    /**
     * Set the startTime where the Tracepoint will get effective
     * 
     * @param starttime
     *            as LocalDateTime
     */
    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    /**
     * Get the endTime where the Tracepoint will be stopped.
     * 
     * @return the endTime as LocalDateTime
     */
    public LocalDateTime getEndtime() {
        return endtime;
    }

    /**
     * Set the endTime where the Tracepoint will be stopped.
     * 
     * @param endtime
     *            as LocalDateTime
     */
    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    /**
     * Get the count of Iterationes which will be traced.
     * 
     * @return the iterations count as Integer
     */
    public Integer getIterations() {
        return iterations;
    }

    /**
     * Set the count of Iterationes which will be traced.
     * 
     * @param iterations
     *            count as Integer
     */
    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    /**
     * Marks that a {@link ProcessModel} shall collect trace information for each activity (including sub processes).
     * 
     * @return the deeptrace state as Boolean
     */
    public Boolean isDeeptrace() {
        return deepTrace;
    }

    /**
     * Set that a {@link ProcessModel} shall collect trace information for each activity (including sub processes).
     * 
     * @param deeptrace
     *            config as Boolean
     */
    public void setDeeptrace(Boolean deeptrace) {
        this.deepTrace = deeptrace;
    }

}
