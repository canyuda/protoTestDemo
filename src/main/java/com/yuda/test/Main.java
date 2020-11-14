package com.yuda.test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.yuda.test.proto.base.BaseProto;

/**
 * @author canyu
 */
public class Main {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        BaseProto.Person person = BaseProto.Person.newBuilder()
                .setName("canyuda")
                .setId(1)
                .setEmail("helloyuda95@gmail.com")
                .build();
        JsonFormat.Printer printer = JsonFormat.printer();
        String print = printer.print(person);
        System.out.println(print);


        JsonFormat.Parser parser = JsonFormat.parser();
        BaseProto.Person.Builder builder = BaseProto.Person.newBuilder();
        parser.merge(print, builder);
        builder.setId(2);
        BaseProto.Person build = builder.build();

        String print1 = printer.print(build);
        System.out.println(print1);
    }
}
