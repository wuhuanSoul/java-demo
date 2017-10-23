package com.systec.main.datagramSocket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * Created by wh on 10/20/2017.
 */
public class UDPServer {

    /**
     * 服务端，实现基于UDP的用户登录
     */

    @Test
    public void udpServer() {
        try {
            /**
             * 接收客户端发送的数据
             * */
            // 1、创建服务端DatagramSocket，指定端口
            DatagramSocket socket = new DatagramSocket(8800);
            //2、创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];
            //创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //3、接收客户端发送的数据
            System.out.println("****服务器端已经启动，等待客户端发送数据");
            socket.receive(packet);//此方法在接收到得数据报之前会一直阻塞
            //4、读取数据
            String info = new String(data, 0, packet.getLength());
            System.out.println("收到客户端信息：" + info);

            /**
             * 向客户端响应数据
             * */
            //1、定义客户端的地址、端口号、数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "服务端返回的信息".getBytes();
            //2、创建数据报，包含响应的数据信息
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            //3、响应客户端
            socket.send(packet2);
            //4、关闭资源
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void udpClient() {
        try {
            /**
             * 向服务端发送数据
             * */
            //1、定义服务器的地址、端口号、数据
            InetAddress address = InetAddress.getByName("localhost");
            int port = 8800;
            byte[] data = "用户名:admin;密码:123".getBytes();
            //2、创建数据报,包含发送的数据
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            //3、创建DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();
            //4、向服务端发送数据报
            socket.send(packet);

            /**
             * 接收服务端响应的数据
             * */
            //1、创建数据报，用于接收服务器端响应的数据
            byte[] data2 = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
            //2、接收服务器响应的数据
            socket.receive(packet2);
            //3、读取数据
            String reply = new String(data2, 0, packet2.getLength());
            System.out.println("收到服务端的信息：" + reply);
            //4、关闭资源
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
