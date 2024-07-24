package org.nott.rpc;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @author Nott
 * @date 2024-7-23
 */

@Data
public class RpcRequest implements Serializable {

    public RpcRequest() {
    }

    public RpcRequest(String proxyName, String method, Object[] param, Type[] argTypes) {
        this.proxyName = proxyName;
        this.method = method;
        this.param = param;
        this.argTypes = argTypes;
    }

    private String proxyName;

    private String method;

    private Object[] param;

    private Type[] argTypes;

    private String clientId;

    private String version = "1.0.0";

}
