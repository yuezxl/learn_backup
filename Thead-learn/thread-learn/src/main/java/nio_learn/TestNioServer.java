package nio_learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestNioServer {

    //线程安全
    private static List<SocketChannel> channels = Collections.synchronizedList( new ArrayList<SocketChannel>() );

    public static void main(String[] args) {

        HandlerSelectionKey handler = new HandlerHandlerSelectionKeyImpl();

        try {
            //创建 ServerSocketChannel
            ServerSocketChannel server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress("localhost", 12345));
            //创建 Selector
            Selector selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            //死循环，持续接收 客户端连接
            while(true) {
                //selector.select(); 是阻塞方法
                int keys = selector.select();
                if(keys > 0) {
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while(it.hasNext()) {
                        SelectionKey key = it.next();
                        it.remove();
                        //处理 SelectionKey
                        handler.handler(key, selector);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * SelectionKey 处理接口
     *
     */
    public static interface HandlerSelectionKey {

        public void handler(SelectionKey key, Selector selector) throws IOException;

    }

    /**
     * SelectionKey 接口 实现类
     *
     */
    public static class HandlerHandlerSelectionKeyImpl implements HandlerSelectionKey {

        @Override
        public void handler(SelectionKey key, Selector selector) throws IOException {
            int keyState = selectionKeyState(key);
            switch (keyState) {
            case SelectionKey.OP_ACCEPT:
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                accept(serverSocketChannel, selector);
                break;
            case SelectionKey.OP_READ:
                SocketChannel readSocketChannel = (SocketChannel) key.channel();
                read(readSocketChannel, selector);
                break;
            }
        }
        /**
         * 获取 SelectionKey 是什么事件
         * @param key
         * @return
         */
        private int selectionKeyState(SelectionKey key) {
            if(key.isAcceptable()) {
                return SelectionKey.OP_ACCEPT;
            } else if(key.isReadable()) {
                return SelectionKey.OP_READ;
            }
            return -1;
        }

        /**
         * 接口客户端请求
         * @param serverSocketChannel
         * @param selector
         * @throws IOException
         */
        private void accept(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            channels.add(socketChannel);
            //将 channel 注册到  Selector
            socketChannel.register(selector, SelectionKey.OP_READ);
        }

        /**
         * 读取客户端发送过来的信息
         * @param socketChannel
         * @param selector
         * @throws IOException
         */
        private void read(SocketChannel socketChannel, Selector selector) throws IOException {
            ByteBuffer readBuffer = ByteBuffer.allocate(8192);
            int readBytes = socketChannel.read(readBuffer);
            String msg = "";//客户端发送来的消息
            if(readBytes > 0) {
                 msg = new String(readBuffer.array(), 0, readBytes);
                System.out.println("客户端发送来的消息");
                System.out.println(msg);
            }
            write(socketChannel, msg);
        }

        /**
         * 响应客户端请求
         * @param socketChannel
         * @param selector
         * @throws IOException
         */
        private void write(SocketChannel socketChannel, String msg) throws IOException {
            msg = "游客" + socketChannel.hashCode()+ "\r\n    " + msg;
            //响应消息
            byte[] responseByte = msg.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(responseByte.length);
            writeBuffer.put(responseByte);
            writeBuffer.flip();
            //响应客户端
            for(int i=0; i<channels.size(); i++) {
                if(!socketChannel.equals(channels.get(i))) {
                    channels.get(i).write(writeBuffer);
                }
            }
        }

    }


}