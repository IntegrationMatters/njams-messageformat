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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class provides static parsing and serializing functionality.
 *
 * @author krautenberg
 * @version 4.0.2
 */
@Deprecated(since = "5.0.0", forRemoval = true)
public class InstructionMapper {

    private InstructionMapper() {
        //No initializing
    }

    /**
     * Serializer nested class
     */
    @Deprecated(since = "5.0.0", forRemoval = true)
    public static class InstructionSerializer {

        private InstructionSerializer() {
            //No initializing
        }

        /**
         * Returns the serialized String to the given LogLevel.
         *
         * @param logLevel the LogLevel to serialize
         * @return the serialized LogLevel
         */
        public static String serializeLogLevel(LogLevel logLevel) {
            return serializeEnum(logLevel);
        }

        /**
         * Returns the serialized String to the given LogMode.
         *
         * @param logMode the LogMode to serialize
         * @return the serialized LogMode
         */
        public static String serializeLogMode(LogMode logMode) {
            return serializeEnum(logMode);
        }

        private static String serializeEnum(Enum enumParameter) {
            Objects.requireNonNull(enumParameter, "enumParameter must not be null");
            return enumParameter.name();
        }

        /**
         * Returns the serialized String to the given LocalDateTime.
         *
         * @param localDateTime the LocalDateTime to serialize
         * @return the serialized LocalDateTime
         */
        public static String serializeLocalDateTime(LocalDateTime localDateTime) {
            return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        /**
         * Returns the serialized String to the given boolean.
         *
         * @param bool the boolean to serialize
         * @return "true", if input is true, otherwise "false"
         */
        public static String serializeBoolean(boolean bool) {
            return String.valueOf(bool);
        }

        /**
         * Returns the serialized String to the given int.
         *
         * @param i the int to serialize
         * @return the serialized int
         */
        public static String serializeInteger(int i) {
            return String.valueOf(i);
        }
    }

    /**
     * Parser nested class
     */
    @Deprecated(since = "5.0.0", forRemoval = true)
    public static class InstructionParser {
        /**
         * Default prefix for parsing Exceptions.
         */
        private static final String UNABLE_TO_PARSE_OBJECT = "Unable to parse: ";

        private InstructionParser() {
            //No initializing
        }

        /**
         * Returns the LogLevel to the given String.
         *
         * @param logLevelToParse the LogLevel as String
         * @return the parsed LogLevel
         * @throws InstructionParsingException is thrown if no correlating LogLevel was found for the given String
         */
        public static LogLevel parseLogLevel(String logLevelToParse) throws InstructionParsingException {
            return parseEnumParameter(logLevelToParse, LogLevel.class);
        }

        /**
         * Returns the LogMode to the given String.
         *
         * @param logModeToParse the LogMode as String
         * @return the parsed LogMode
         * @throws InstructionParsingException is thrown if no correlating LogMode was found for the given String
         */
        public static LogMode parseLogMode(String logModeToParse) throws InstructionParsingException {
            return parseEnumParameter(logModeToParse, LogMode.class);
        }

        private static <T extends Enum<T>> T parseEnumParameter(final String enumParameterToParse,
            final Class<T> enumeration)
            throws InstructionParsingException {
            Objects.requireNonNull(enumParameterToParse, "enumParameterToParse must not be null");

            T foundEnumParameter = null;
            if (enumeration != null && enumeration.getEnumConstants() != null) {
                foundEnumParameter = Arrays.stream(enumeration.getEnumConstants())
                    .filter(c -> c.name().equalsIgnoreCase(enumParameterToParse)).findAny().orElse(null);
            }
            if (foundEnumParameter == null) {
                throw new InstructionParsingException(
                    UNABLE_TO_PARSE_OBJECT + "\"" + enumParameterToParse + "\"" + " to " +
                        enumeration.getSimpleName());
            }
            return foundEnumParameter;
        }

        /**
         * Returns the LocalDateTime to the given String.
         *
         * @param localDateTimeToParse the LocalDateTime as String
         * @return the parsed LocalDateTime
         * @throws InstructionParsingException is thrown if the given parameter couldn't be parsed to a LocalDateTime
         *                                     object.
         */
        public static LocalDateTime parseLocalDateTime(String localDateTimeToParse) throws InstructionParsingException {
            Objects.requireNonNull(localDateTimeToParse, "localDateTimeToParse must not be null");
            try {
                if (localDateTimeToParse.charAt(localDateTimeToParse.length() - 1) == 'Z') {
                    return LocalDateTime.parse(localDateTimeToParse.substring(0, localDateTimeToParse.length() - 1),
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                }
                return LocalDateTime.parse(localDateTimeToParse, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            } catch (RuntimeException parsingException) {
                throw new InstructionParsingException(UNABLE_TO_PARSE_OBJECT + localDateTimeToParse,
                    parsingException);
            }
        }

        /**
         * Returns the boolean to the given String.
         *
         * @param booleanToParse the boolean as String
         * @return true, if input is case insensitive "true", false, if input is case insensitive "false"
         * @throws InstructionParsingException is thrown if the given parameter is neither "true" nor "false" case
         * insensitive
         */
        public static boolean parseBoolean(String booleanToParse) throws InstructionParsingException {
            Objects.requireNonNull(booleanToParse, "booleanToParse must not be null");

            if (booleanToParse.equalsIgnoreCase("true") || (booleanToParse.equalsIgnoreCase("false"))) {
                return Boolean.parseBoolean(booleanToParse);
            } else {
                throw new InstructionParsingException(UNABLE_TO_PARSE_OBJECT + booleanToParse);
            }
        }

        /**
         * Returns the int to the given String.
         *
         * @param integerToParse the int as String
         * @return the parsed int
         * @throws InstructionParsingException is thrown if the given parameter couldn't be parsed to a int.
         */
        public static int parseInteger(String integerToParse) throws InstructionParsingException {
            Objects.requireNonNull(integerToParse, "integerToParse must not be null");

            try {
                return Integer.parseInt(integerToParse);
            } catch (NumberFormatException invalidIntegerException) {
                throw new InstructionParsingException(UNABLE_TO_PARSE_OBJECT + integerToParse,
                    invalidIntegerException);
            }
        }
    }
}
