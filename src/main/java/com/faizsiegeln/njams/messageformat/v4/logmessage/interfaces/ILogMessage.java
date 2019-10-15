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

import com.faizsiegeln.njams.messageformat.v4.common.MessageVersion;
import java.time.LocalDateTime;

/**
 *
 * @author pnientiedt
 */
public interface ILogMessage {

    public String getClientVersion();

    public void setClientVersion(String clientVersion);

    public String getSdkVersion();

    public String getCategory();

    public String getPath();

    public LocalDateTime getBusinessEnd();

    public void setBusinessEnd(LocalDateTime businessEnd);

    public LocalDateTime getBusinessStart();

    public void setBusinessStart(LocalDateTime businessStart);

    public MessageVersion getMessageVersion();

    public Integer getMessageNo();

    public String getLogId();

    public String getCorrelationLogId();

    public void setCorrelationLogId(String correlationLogId);

    public String getParentLogId();

    public void setParentLogId(String parentLogId);

    public String getExternalLogId();

    public void setExternalLogId(String externalLogId);

    public String getJobId();

    public String getProcessName();

    public String getMachineName();

    public void setMachineName(String machineName);

    public LocalDateTime getSentAt();

    public String getServiceName();

    public void setServiceName(String businessService);

    public String getObjectName();

    public void setObjectName(String businessObject);

    public LocalDateTime getJobStart();

    public LocalDateTime getJobEnd();

    public Integer getStatus();

    public void setStatus(Integer status);

    public Integer getMaxSeverity();

    public void setMaxSeverity(Integer maxSeverity);
    
    public void addAtribute(String key, String value);
    
    public void addActivity(IActivity activity);

    public Boolean getTrace();

    public void setTrace(Boolean trace);

    public void addPluginDataItem(IPluginDataItem pluginDataItem);

    public Boolean getTruncated();

    public void setTruncated(Boolean truncated);

}
