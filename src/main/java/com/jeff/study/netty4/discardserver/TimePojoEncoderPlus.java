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
public class TimePojoEncoderPlus extends MessageToByteEncoder<UnixTime> {

    @Override
    protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) throws Exception {
        out.writeInt(msg.value());
        System.out.println("End of TimePojoEncoderPlus");
    }
    
}
