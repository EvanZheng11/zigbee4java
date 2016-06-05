package org.bubblecloud.zigbee.network.zcl.protocol.command.general;

import org.bubblecloud.zigbee.network.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.network.zcl.ZclUtil;
import org.bubblecloud.zigbee.network.zcl.ZclCommand;
import org.bubblecloud.zigbee.network.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.network.zcl.protocol.ZclFieldType;
import org.bubblecloud.zigbee.network.zcl.type.*;
import org.bubblecloud.zigbee.network.packet.ZToolAddress64;

import java.util.List;

/**
 * Code generated Write Attributes Command value object class.
 */
public class WriteAttributesCommand extends ZclCommand {
    /**
     * Records command message field.
     */
    private Object records;

    /**
     * Default constructor setting the command type field.
     */
    public WriteAttributesCommand() {
        this.setType(ZclCommandType.WRITE_ATTRIBUTES_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public WriteAttributesCommand(final ZclCommandMessage message) {
        super(message);
        this.records = (Object) message.getFields().get(ZclFieldType.WRITE_ATTRIBUTES_COMMAND_RECORDS);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.WRITE_ATTRIBUTES_COMMAND_RECORDS,records);
        return message;
    }

    /**
     * Gets Records.
     * @return the Records
     */
    public Object getRecords() {
        return records;
    }

    /**
     * Sets Records.
     * @param records the Records
     */
    public void setRecords(final Object records) {
        this.records = records;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("records");
        builder.append('=');
        builder.append(records);
        return builder.toString();
    }

}
