package com.jeff.study.netty4;

import com.jeff.study.netty4.discardserver.SimpleServer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        System.out.println("Netty Server starting.");
        SimpleServer.start();
    }
}
