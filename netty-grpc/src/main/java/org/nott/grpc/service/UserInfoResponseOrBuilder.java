// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/Service.proto

// Protobuf Java Version: 4.26.1
package org.nott.grpc.service;

public interface UserInfoResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.nott.grpc.service.UserInfoResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 2;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>string address = 3;</code>
   * @return The address.
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 3;</code>
   * @return The bytes for address.
   */
  com.google.protobuf.ByteString
      getAddressBytes();
}