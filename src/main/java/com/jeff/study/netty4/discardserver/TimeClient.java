/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeff.study.netty4.discardserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author winnie
 */
public class TimeClient implements Runnable {
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    ChannelFuture f;

    @Override
    public void run() {
        System.out.println("Time client started.");
        Thread t = null;
        t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    startClient();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TimeClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        t.start();
        
        long start = System.currentTimeMillis();
        while (!((System.currentTimeMillis() - start) > 3000)) {
        }
        System.out.println("Timeout!");
        try {
            f.channel().closeFuture().sync();
        } catch (InterruptedException ex) {
            Logger.getLogger(TimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        workerGroup.shutdownGracefully();
        System.out.println("Time client ended.");
    }

    private void startClient() throws InterruptedException {
        Bootstrap b = new Bootstrap();
        b.group(workerGroup)
         .channel(NioSocketChannel.class)
         .option(ChannelOption.SO_KEEPALIVE, true)
         .handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new TimeClientHandler());
                System.out.println("Client channel initiated.");
            }
             
         });
        
        f = b.connect("127.0.0.1", 8080).sync();
        System.out.println("Port binded");
    }
    
    
    
}
