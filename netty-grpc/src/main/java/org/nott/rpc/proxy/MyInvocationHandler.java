package org.nott.rpc.proxy;

import lombok.AllArgsConstructor;
import org.nott.rpc.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Nott
 * @date 2024-7-23
 */
@AllArgsConstructor
public class MyInvocationHandler implements InvocationHandler {

    private String address;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest(method.getClass().getName(), method.getName(), method.getParameters(), method.getParameterTypes());


        return null;
    }

    public <T> T proxy(Class clazz) {
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T) o;
    }
}
