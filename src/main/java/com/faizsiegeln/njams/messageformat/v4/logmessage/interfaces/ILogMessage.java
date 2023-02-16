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

    String getClientVersion();

    void setClientVersion(String clientVersion);

    String getSdkVersion();

    String getCategory();

    String getPath();

    LocalDateTime getBusinessEnd();

    void setBusinessEnd(LocalDateTime businessEnd);

    LocalDateTime getBusinessStart();

    void setBusinessStart(LocalDateTime businessStart);

    MessageVersion getMessageVersion();

    Integer getMessageNo();

    String getLogId();

    String getCorrelationLogId();

    void setCorrelationLogId(String correlationLogId);

    String getParentLogId();

    void setParentLogId(String parentLogId);

    String getExternalLogId();

    void setExternalLogId(String externalLogId);

    String getJobId();

    String getProcessName();

    String getMachineName();

    void setMachineName(String machineName);

    LocalDateTime getSentAt();

    String getServiceName();

    void setServiceName(String businessService);

    String getObjectName();

    void setObjectName(String businessObject);

    LocalDateTime getJobStart();

    LocalDateTime getJobEnd();

    Integer getStatus();

    void setStatus(Integer status);

    Integer getMaxSeverity();

    void setMaxSeverity(Integer maxSeverity);
    
    void addAtribute(String key, String value);
    
    void addActivity(IActivity activity);

    Boolean getTrace();

    void setTrace(Boolean trace);

    void addPluginDataItem(IPluginDataItem pluginDataItem);

    Boolean getTruncated();

    void setTruncated(Boolean truncated);

}
