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

    public String getModelId();

    public String getInstanceId();

    public Long getIteration();

    public void setIteration(Long iteration);

    public Long getMaxIterations();

    public void setMaxIterations(Long maxIterations);

    public String getParentInstanceId();

    public void setParentInstanceId(String parentInstanceId);

    public Long getSequence();

    public LocalDateTime getExecution();

    public void setExecution(LocalDateTime execution);

    public long getDuration();

    public void setDuration(long duration);

    public long getCpuTime();

    public void setCpuTime(long cpuTime);

    public ActivityStatus getActivityStatus();

    public void setActivityStatus(ActivityStatus activityStatus);

    public Integer getEventStatus();

    public void setEventStatus(Integer eventStatus);

    public String getEventMessage();

    public void setEventMessage(String eventMessage);

    public String getEventCode();

    public void setEventCode(String eventCode);

    public String getEventPayload();

    public void setEventPayload(String eventPayload);

    public String getStackTrace();

    public void setStackTrace(String stackTrace);
    
    public void addAttribute(String key, String value);
}
