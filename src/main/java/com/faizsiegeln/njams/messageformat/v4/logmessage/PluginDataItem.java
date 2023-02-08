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
package com.faizsiegeln.njams.messageformat.v4.logmessage;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data send by client plugins to client server, has to be handled by every pluginId for its own.
 *
 * @author pnientiedt
 */
@ApiModel(
        description = "Data send by client plugins to client server, has to be handled by every pluginId for its own.")
public class PluginDataItem
        implements Serializable, com.faizsiegeln.njams.messageformat.v4.logmessage.interfaces.IPluginDataItem {

    private static final long serialVersionUID = 6714752324092476472L;

    @ApiModelProperty(value = "Timestamp when the plugin sent the data.", required = true)
    private LocalDateTime timestamp;

    @ApiModelProperty(value = "ID of the plugin which sent the data.", required = true)
    private String pluginId;

    @ApiModelProperty(value = "The data sent.", required = true)
    private String pluginData;

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getPluginId() {
        return pluginId;
    }

    @Override
    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    @Override
    public String getPluginData() {
        return pluginData;
    }

    @Override
    public void setPluginData(String pluginData) {
        this.pluginData = pluginData;
    }

}
