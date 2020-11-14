echo off
protoc.exe --proto_path=./protobuf --java_out=../java base.proto
