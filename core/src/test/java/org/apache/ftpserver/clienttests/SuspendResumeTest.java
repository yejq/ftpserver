/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ftpserver.clienttests;

import java.io.IOException;


/**
*
* @author The Apache MINA Project (dev@mina.apache.org)
* @version $Rev$, $Date$
*
*/
public class SuspendResumeTest extends ClientTestTemplate {

    @Override
    protected boolean isConnectClient() {
        return false;
    }

    public void testSuspendResumeServer() throws Exception {
        // connect should work as expected
        client.connect("localhost", port);
        client.disconnect();
        
        server.suspend();

        try {
            client.connect("localhost", port);
            fail("Must throw IOException");
        } catch(IOException e) {
            // OK
        } finally {
            client.disconnect();
        }
        
        server.resume();

        // connect should work again
        client.connect("localhost", port);
        client.disconnect();
    }

    public void testSuspendResumeListener() throws Exception {
        // connect should work as expected
        client.connect("localhost", port);
        client.disconnect();
        
        server.getListener("default").suspend();

        try {
            client.connect("localhost", port);
            fail("Must throw IOException");
        } catch(IOException e) {
            // OK
        } finally {
            client.disconnect();
        }
        
        server.getListener("default").resume();

        // connect should work again
        client.connect("localhost", port);
        client.disconnect();
    }
    
}
