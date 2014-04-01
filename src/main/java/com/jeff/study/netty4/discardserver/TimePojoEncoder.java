/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.study.netty4.discardserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 *
 * @author winnie
 */
public class TimePojoEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        UnixTime unixTime = (UnixTime) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt(unixTime.value());
        ctx.write(encoded, promise);
        System.out.println("End of TimePojoEncoder");
    }
    
}
