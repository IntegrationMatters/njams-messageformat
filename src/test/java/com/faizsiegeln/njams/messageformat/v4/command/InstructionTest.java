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
