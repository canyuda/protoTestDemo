package com.yuda.test;

import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import com.googlecode.protobuf.format.JsonFormat;
import com.yuda.test.proto.base.BaseProto;
import org.junit.Test;

import java.io.IOException;

/**
 * @author canyu
 * @create_date 2020/11/14 13:13
 */
public class MainTest {
    @Test
    public void test1() {
        System.out.println("Hello World");
        FieldMask.Builder fieldMask = FieldMask.newBuilder();
        FieldMask build = fieldMask.addPaths("1").addPaths("2").build();
        System.out.println(FieldMaskUtil.toJsonString(build));
    }

    @Test
    public void test2() {
        BaseProto.Person person = BaseProto.Person.newBuilder()
                .setName("canyuda")
                .setId(1)
                .setEmail("helloyuda95@gmail.com")
                .build();
        System.out.println(JsonFormat.printToString(person));
    }

    @Test
    public void test3() throws IOException {
        BaseProto.Person.Builder builder = BaseProto.Person.newBuilder();
        JsonFormat.merge("{\"name\": \"canyuda\",\"id\": 1,\"email\": \"helloyuda95@gmail.com\"}", builder);
        BaseProto.Person build = builder.build();
        StringBuffer output = new StringBuffer();
        JsonFormat.print(build, output);
        System.out.println(output.toString());
    }
}
