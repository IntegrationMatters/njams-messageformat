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
package com.faizsiegeln.njams.messageformat.v4.command;

import java.util.Map;
import java.util.Map.Entry;

import com.faizsiegeln.njams.messageformat.common.BasicCommand;

/**
 *
 * @author pnientiedt
 */
public class Instruction implements BasicCommand {

    private Request request;
    private Response response;

    @Override
    public String getRequestParameterByName(String name) {
        if (name == null || getRequest() == null) {
            return null;
        }
        final Map<String, String> params = getRequest().getParameters();
        if (params == null) {
            return null;
        }
        return params.entrySet().stream().filter(e -> name.equalsIgnoreCase(e.getKey()))
                .map(Entry::getValue).findFirst().orElse(null);
    }

    @Override
    public String getResponseParameterByName(String name) {
        if (name == null || getResponse() == null) {
            return null;
        }
        final Map<String, String> params = getResponse().getParameters();
        if (params == null) {
            return null;
        }
        return params.entrySet().stream().filter(e -> name.equalsIgnoreCase(e.getKey()))
                .map(Entry::getValue).findFirst().orElse(null);
    }

    @Override
    public void setRequestParameter(String name, String value) {
        if (getRequest() == null) {
            setRequest(new Request());
        }
        getRequest().getParameters().put(name, value);
    }

    @Override
    public void setResponseParameter(String name, String value) {
        if (getResponse() == null) {
            setResponse(new Response());
        }
        getResponse().getParameters().put(name, value);
    }

    /**
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * @return the response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String getCommand() {
        if (request != null) {
            return request.getCommand();
        }
        return null;
    }

    public void setResponseResultCode(int resultCode) {
        if (getResponse() == null) {
            setResponse(new Response());
        }
        getResponse().setResultCode(resultCode);
    }

    public void setResponseResultMessage(String resultMessage) {
        if (getResponse() == null) {
            setResponse(new Response());
        }
        getResponse().setResultMessage(resultMessage);
    }
}
