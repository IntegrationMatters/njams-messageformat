/*
 * Copyright (c) 2019 Faiz & Siegeln Software GmbH
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
package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogLevel;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogMode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class InstructionMapperTest {

    private static final Logger LOG = LoggerFactory.getLogger(InstructionMapperTest.class);

//x = parse(serialize(x))

    @Test
    public void serializeAndParseLogLevelNull() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(null);
    }

    @Test
    public void serializeAndParseLogLevelInfo() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.INFO);
    }

    @Test
    public void serializeAndParseLogLevelSuccess() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.SUCCESS);
    }

    @Test
    public void serializeAndParseLogLevelWarning() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.WARNING);
    }

    @Test
    public void serializeAndParseLogLevelError() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.ERROR);
    }

    private void serializeAndParseLogLevel(LogLevel logLevelToCheck) throws NjamsMessageFormatException {
        String serializedLogLevel = InstructionMapper.InstructionSerializer.serializeLogLevel(logLevelToCheck);
        LOG.debug(serializedLogLevel);
        LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(serializedLogLevel);
        assertEquals(logLevelToCheck, parsedLogLevel);
    }

    @Test
    public void serializeAndParseLogModeNull() throws NjamsMessageFormatException {
        serializeAndParseLogMode(null);
    }

    @Test
    public void serializeAndParseLogModeNone() throws NjamsMessageFormatException {
        serializeAndParseLogMode(LogMode.NONE);
    }

    @Test
    public void serializeAndParseLogModeExclusive() throws NjamsMessageFormatException {
        serializeAndParseLogMode(LogMode.EXCLUSIVE);
    }

    @Test
    public void serializeAndParseLogModeComplete() throws NjamsMessageFormatException {
        serializeAndParseLogMode(LogMode.COMPLETE);
    }

    private void serializeAndParseLogMode(LogMode logModeToCheck) throws NjamsMessageFormatException {
        String serializedLogMode = InstructionMapper.InstructionSerializer.serializeLogMode(logModeToCheck);
        LOG.debug(serializedLogMode);
        LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(serializedLogMode);
        assertEquals(logModeToCheck, parsedLogMode);
    }

    @Test
    public void serializeAndParseLocalDateTimeNull() throws NjamsMessageFormatException {
        serializeAndParseLocalDateTime(null);
    }

    @Test
    public void serializeAndParseLocalDateTimeNormal() throws NjamsMessageFormatException {
        serializeAndParseLocalDateTime(LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    private void serializeAndParseLocalDateTime(LocalDateTime localDateTimeToCheck) throws NjamsMessageFormatException {
        String serializedLocalDateTime = InstructionMapper.InstructionSerializer
                .serializeLocalDateTime(localDateTimeToCheck);
        LOG.debug(serializedLocalDateTime);
        LocalDateTime parsedLocalDateTime = InstructionMapper.InstructionParser
                .parseLocalDateTime(serializedLocalDateTime);
        assertEquals(localDateTimeToCheck, parsedLocalDateTime);
    }

    @Test
    public void serializeAndParseBooleanTrue() {
        serializeAndParseBoolean(true);
    }

    @Test
    public void serializeAndParseBooleanFalse() {
        serializeAndParseBoolean(false);
    }

    private void serializeAndParseBoolean(boolean booleanToCheck) {
        String serializedBoolean = InstructionMapper.InstructionSerializer.serializeBoolean(booleanToCheck);
        LOG.debug(serializedBoolean);
        boolean parsedBoolean = InstructionMapper.InstructionParser.parseBoolean(serializedBoolean);
        assertEquals(booleanToCheck, parsedBoolean);
    }

    @Test
    public void serializeAndParseInteger() throws NjamsMessageFormatException {
        serializeAndParseInteger(1);
    }

    private void serializeAndParseInteger(int integerToCheck) throws NjamsMessageFormatException {
        String serializeInteger = InstructionMapper.InstructionSerializer.serializeInteger(integerToCheck);
        LOG.debug(serializeInteger);
        int parsedInteger = InstructionMapper.InstructionParser.parseInteger(serializeInteger);
        assertEquals(integerToCheck, parsedInteger);
    }

//LogLevel parsing

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullLogLevel() throws NjamsMessageFormatException {
        parseLogLevelString(null, LogLevel.INFO);
    }

    private void parseLogLevelString(String logLevelAsString, LogLevel expected) throws NjamsMessageFormatException {
        LOG.debug(logLevelAsString);
        LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(logLevelAsString);
        assertEquals(expected, parsedLogLevel);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseEmptyLogLevel() throws NjamsMessageFormatException {
        parseLogLevelString("", LogLevel.INFO);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullAsStringLogLevel() throws NjamsMessageFormatException {
        parseLogLevelString("null", LogLevel.INFO);
    }

    @Test
    public void parseInFoLogLevel() throws NjamsMessageFormatException {
        parseLogLevelString("InFo", LogLevel.INFO);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseInvalidLogLevel() throws NjamsMessageFormatException {
        parseLogLevelString("invalid", LogLevel.INFO);
    }

//LogMode parsing

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullLogMode() throws NjamsMessageFormatException {
        parseLogModeString(null, LogMode.NONE);
    }

    private void parseLogModeString(String logModeAsString, LogMode expected) throws NjamsMessageFormatException {
        LOG.debug(logModeAsString);
        LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(logModeAsString);
        assertEquals(expected, parsedLogMode);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseEmptyLogMode() throws NjamsMessageFormatException {
        parseLogModeString("", LogMode.NONE);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullAsStringLogMode() throws NjamsMessageFormatException {
        parseLogModeString("null", LogMode.NONE);
    }

    @Test
    public void parseNoNeLogMode() throws NjamsMessageFormatException {
        parseLogModeString("NoNe", LogMode.NONE);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseInvalidLogMode() throws NjamsMessageFormatException {
        parseLogModeString("invalid", LogMode.NONE);
    }

//LocalDateTime parsing

    @Test
    public void parseNullLocalDateTime() throws NjamsMessageFormatException {
        parseLocalDateTimeString(null, null);
    }

    private void parseLocalDateTimeString(String localDateTimeAsString, LocalDateTime expected)
            throws NjamsMessageFormatException {
        LOG.debug(localDateTimeAsString);
        LocalDateTime parseLocalDateTime = InstructionMapper.InstructionParser
                .parseLocalDateTime(localDateTimeAsString);
        assertEquals(expected, parseLocalDateTime);
    }

    @Test
    public void parseEmptyLocalDateTime() throws NjamsMessageFormatException {
        parseLocalDateTimeString("", null);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullAsStringLocalDateTime() throws NjamsMessageFormatException {
        parseLocalDateTimeString("null", null);
    }

    @Test
    public void parseWhiteSpaceStringLocalDateTime() throws NjamsMessageFormatException {
        parseLocalDateTimeString("   ", null);
    }

    @Test
    public void parseLocalDateTimeNormal() throws NjamsMessageFormatException {
        parseLocalDateTimeString("2019-09-10T07:32:48.559", LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    @Test
    public void parseLocalDateTimeWithAZAppended() throws NjamsMessageFormatException {
        parseLocalDateTimeString("2019-09-10T07:32:48.559Z", LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseInvalidLocalDateTime() throws NjamsMessageFormatException {
        parseLocalDateTimeString("invalid", null);
    }

//Boolean parsing

    @Test
    public void parseNullBoolean() throws NjamsMessageFormatException {
        parseBooleanString(null, false);
    }

    private void parseBooleanString(String booleanAsString, boolean expected) throws NjamsMessageFormatException {
        LOG.debug(booleanAsString);
        boolean parseBoolean = InstructionMapper.InstructionParser.parseBoolean(booleanAsString);
        assertEquals(expected, parseBoolean);
    }

    @Test
    public void parseEmptyBoolean() throws NjamsMessageFormatException {
        parseBooleanString("", false);
    }

    @Test
    public void parseNullAsStringBoolean() throws NjamsMessageFormatException {
        parseBooleanString("null", false);
    }

    @Test
    public void parseTrueBoolean() throws NjamsMessageFormatException {
        parseBooleanString("true", true);
    }

    @Test
    public void parseFalseBoolean() throws NjamsMessageFormatException {
        parseBooleanString("false", false);
    }

    @Test
    public void parseTrUeBoolean() throws NjamsMessageFormatException {
        parseBooleanString("TrUe", true);
    }

    @Test
    public void parseFaLsEBoolean() throws NjamsMessageFormatException {
        parseBooleanString("FaLsE", false);
    }

    @Test
    public void parseInvalidBoolean() throws NjamsMessageFormatException {
        parseBooleanString("invalid", false);
    }

//Integer parsing

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullInteger() throws NjamsMessageFormatException {
        parseIntegerString(null, -1);
    }

    private void parseIntegerString(String IntegerAsString, int expected) throws NjamsMessageFormatException {
        LOG.debug(IntegerAsString);
        int parseInteger = InstructionMapper.InstructionParser.parseInteger(IntegerAsString);
        assertEquals(expected, parseInteger);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseEmptyInteger() throws NjamsMessageFormatException {
        parseIntegerString("", -1);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseNullAsStringInteger() throws NjamsMessageFormatException {
        parseIntegerString("null", -1);
    }

    @Test
    public void parseNormalInteger() throws NjamsMessageFormatException {
        parseIntegerString("1", 1);
    }

    @Test
    public void parseMinInteger() throws NjamsMessageFormatException {
        parseIntegerString("-2147483648", Integer.MIN_VALUE);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseMinAsHexInteger() throws NjamsMessageFormatException {
        parseIntegerString("0x80000000", Integer.MIN_VALUE);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseIntegerThatIsLowerThanMinValue() throws NjamsMessageFormatException {
        parseIntegerString("-3000000000", -1);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void parseInvalidInteger() throws NjamsMessageFormatException {
        parseIntegerString("invalid", -1);
    }
}