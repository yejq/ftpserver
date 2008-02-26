/*
 * Created on Aug 11, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.apache.ftpserver.remote;

import org.apache.ftpserver.RemoteHandlerMonitor;
import org.apache.ftpserver.core.AbstractFtpConfig;

import java.rmi.RemoteException;

/**
 * @author Vladimirov
 *         <p/>
 *         TODO To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Style - Code Templates
 */
public interface RemoteHandlerFactory {

    public final static String ROLE = RemoteHandlerFactory.class.getName();

    public RemoteHandler createRemoteHandler(AbstractFtpConfig ftpConfig,
                                             RemoteHandlerMonitor remoteHandlerMonitor)
            throws RemoteException;
}