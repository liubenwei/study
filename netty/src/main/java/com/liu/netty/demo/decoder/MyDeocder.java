package com.liu.netty.demo.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author liu
 * @date 2020/11/22 19:57
 */
public class MyDeocder extends ByteToMessageDecoder {
    private final int BASE_LENGTH = 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < BASE_LENGTH) {
            return;
        }
        //记录包头的位置
        int beginIndex;
        while (true) {
            beginIndex = in.readerIndex();
            //标记 包头开始的index
            in.markReaderIndex();
            //如果读到了开始标志 结束循环
            if (in.readByte() == 0x02) {
                break;
            }
            //没有读到包头位置 略过当前字节
            in.resetReaderIndex();
            in.readByte();
            //当略过一个字节后，数据包的长度又不满足
            //此时应该结束。等待后面的数据到达
            if (in.readableBytes() < BASE_LENGTH) {
                return;
            }
        }
        //剩余长度不足可读取数量(没有结尾标志)
        int readableCount = in.readableBytes();
        if (readableCount <= 1) {
            in.readerIndex(beginIndex);
            return;
        }

        ByteBuf byteBuf = in.readBytes(1);
        String msgLengthString = byteBuf.toString(Charset.forName("UTF-8"));
        int msgLength = Integer.parseInt(msgLengthString);

        //剩余长度不足可读取数量[没有结束标志]
        readableCount = in.readableBytes();
        if (readableCount < msgLength + 1) {
            in.readerIndex(beginIndex);
            return;
        }
        ByteBuf msgCount = in.readBytes(msgLength);
        //如果没有结尾标志。还原指针位置
        byte end = in.readByte();
        if (end != 0x03) {
            in.readerIndex(beginIndex);
            return;
        }
        String string = msgCount.toString(Charset.forName("UTF-8"));
        System.out.println("d读取的数据：" + string);
        out.add(string);
    }
}
