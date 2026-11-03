/*
 * Copyright (c) 2026 Salesfive Integration Services GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 *  FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

/**
 * MSG-10 Ignore case when reading parameters
 * @author cwinkler
 *
 */
public class InstructionTest {

    @Test
    public void testGetRequestParameterByName() {
        Instruction inst = new Instruction();
        inst.setRequestParameter("Hello", "world!");
        assertEquals("world!", inst.getRequestParameterByName("Hello"));
        assertEquals("world!", inst.getRequestParameterByName("hello"));
        assertEquals("world!", inst.getRequestParameterByName("HeLlO"));
        assertEquals("world!", inst.getRequestParameterByName("HELLO"));
        assertNull(inst.getRequestParameterByName(null));
        assertNull(inst.getRequestParameterByName("world!"));
    }

    @Test
    public void testGetResponseParameterByName() {
        Instruction inst = new Instruction();
        inst.setResponseParameter("Hello", "world!");
        assertEquals("world!", inst.getResponseParameterByName("Hello"));
        assertEquals("world!", inst.getResponseParameterByName("hello"));
        assertEquals("world!", inst.getResponseParameterByName("HeLlO"));
        assertEquals("world!", inst.getResponseParameterByName("HELLO"));
        assertNull(inst.getResponseParameterByName(null));
        assertNull(inst.getResponseParameterByName("world!"));
    }

    @Test
    public void testSetRequestParameter() {
        Instruction inst = new Instruction();
        inst.setRequestParameter("Hello", "world!");
        Map<String, String> params = inst.getRequest().getParameters();
        assertEquals("world!", params.get("Hello"));
        assertNull(params.get("hello"));
        assertNull(params.get("HeLlO"));
        assertNull(params.get("HELLO"));
        assertNull(params.get(null));
        assertNull(params.get("world!"));
    }

    @Test
    public void testSetResponseParameter() {
        Instruction inst = new Instruction();
        inst.setResponseParameter("Hello", "world!");
        Map<String, String> params = inst.getResponse().getParameters();
        assertEquals("world!", params.get("Hello"));
        assertNull(params.get("hello"));
        assertNull(params.get("HeLlO"));
        assertNull(params.get("HELLO"));
        assertNull(params.get(null));
        assertNull(params.get("world!"));
    }

    @Test
    public void tetCommand() {
        Instruction inst = new Instruction();
        Request request = new Request();
        inst.setRequest(request);

        request.setCommand(Command.SEND_PROJECTMESSAGE.commandString().toLowerCase());
        assertEquals(Command.SEND_PROJECTMESSAGE, Command.getFromInstruction(inst));

        request.setCommand(Command.DELETE_EXTRACT.commandString().toUpperCase());
        assertEquals(Command.DELETE_EXTRACT, Command.getFromInstruction(inst));
    }

}
