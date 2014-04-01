/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.study.netty4.discardserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * This is a simple version of @TimePojoEncoder, by extending @MessageToByteEncoder 
 * to simplify the code
 * @author winnie
 */
public class TimePojoEncoderPlus extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        UnixTime unixTime = (UnixTime) msg;
        out.writeInt(unixTime.value());
        System.out.println("End of TimePojoEncoderPlus");
    }
    
}
