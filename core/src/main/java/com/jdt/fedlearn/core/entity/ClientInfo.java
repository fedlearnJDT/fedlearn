/* Copyright 2020 The FedLearn Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.jdt.fedlearn.core.entity;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * <code>ClientInfo</code> 用来实现两个功能，
 * url链接调用和 通过生成id进行比较
 * //TODO 后续参数进一步细化，包括ip验证，端口数字验证，协议枚举
 * //TODO 初始化时生成client id，使用client id发送给客户端，或者进行比较等
 */
public class ClientInfo implements Serializable {
    private String ip;
    private int port;
    private String path;
    private String protocol;
    private int uniqueId;

    @Deprecated
    public ClientInfo() {
    }

    public ClientInfo(String ip, int port, String protocol) {
        this.ip = ip;
        this.port = port;
        this.protocol = protocol;
        uniqueId = generateToken();
    }

    public ClientInfo(String ip, int port, String protocol, String path) {
        this.ip = ip;
        this.port = port;
        this.protocol = protocol;
        this.path = path;
        uniqueId = generateToken();
    }

    public ClientInfo(String ip, int port, String protocol, int uniqueId) {
        this.ip = ip;
        this.port = port;
        this.protocol = protocol;
        this.uniqueId = uniqueId;
    }

    public ClientInfo(String ip, int port, String protocol, String path, int uniqueId) {
        this.ip = ip;
        this.port = port;
        this.protocol = protocol;
        this.path = path;
        this.uniqueId = uniqueId;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getPath() {
        return path;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    private int generateToken() {
        SecureRandom ran = new SecureRandom();
        return ran.nextInt();
    }


    public String url() {
        return this.protocol + "://" + this.ip + ":" + this.port;
    }

    public void parseUrl(String content) {
        String[] head = content.split("://");
        protocol = head[0];
        ip = head[1].split(":")[0];
        port = Integer.parseInt(head[1].split(":")[1]);
    }

    public String serialize() {
        return this.uniqueId + "";
    }

    public void deserialize(String content) {
        uniqueId = Integer.parseInt(content);
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", protocol='" + protocol + '\'' +
                ", uniqueId=" + uniqueId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClientInfo that = (ClientInfo) o;
        return uniqueId == that.uniqueId;
    }

    @Override
    public int hashCode() {
        return uniqueId;
    }
}