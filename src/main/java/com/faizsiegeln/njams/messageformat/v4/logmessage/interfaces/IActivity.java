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
package com.faizsiegeln.njams.messageformat.v4.logmessage.interfaces;

import com.faizsiegeln.njams.messageformat.v4.logmessage.ActivityStatus;

import java.time.LocalDateTime;

/**
 * Activities used by the new server. They aggregate Tracks, Events and Traces known from the old server.
 *
 * @author pnientiedt
 */
public interface IActivity {

    String getModelId();

    String getInstanceId();

    Long getIteration();

    void setIteration(Long iteration);

    Long getMaxIterations();

    void setMaxIterations(Long maxIterations);

    String getParentInstanceId();

    void setParentInstanceId(String parentInstanceId);

    Long getSequence();

    LocalDateTime getExecution();

    void setExecution(LocalDateTime execution);

    long getDuration();

    void setDuration(long duration);

    long getCpuTime();

    void setCpuTime(long cpuTime);

    ActivityStatus getActivityStatus();

    void setActivityStatus(ActivityStatus activityStatus);

    Integer getEventStatus();

    void setEventStatus(Integer eventStatus);

    String getEventMessage();

    void setEventMessage(String eventMessage);

    String getEventCode();

    void setEventCode(String eventCode);

    String getEventPayload();

    void setEventPayload(String eventPayload);

    String getStackTrace();

    void setStackTrace(String stackTrace);
    
    void addAttribute(String key, String value);
}
