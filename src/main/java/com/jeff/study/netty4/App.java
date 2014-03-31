package com.jeff.study.netty4;

import com.jeff.study.netty4.discardserver.SimpleServer;
import com.jeff.study.netty4.discardserver.TimeClient;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
//        new Thread(new TimeClient()).start();
        
        System.out.println("Netty Server starting.");
        SimpleServer.start();
    }
}
