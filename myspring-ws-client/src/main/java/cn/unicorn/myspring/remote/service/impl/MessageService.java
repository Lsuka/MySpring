/**
 * MessageService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.unicorn.myspring.remote.service.impl;

public interface MessageService extends javax.xml.rpc.Service {
    public java.lang.String getMessageServiceImplPortAddress();

    public cn.unicorn.myspring.remote.service.IMessageService getMessageServiceImplPort() throws javax.xml.rpc.ServiceException;

    public cn.unicorn.myspring.remote.service.IMessageService getMessageServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
