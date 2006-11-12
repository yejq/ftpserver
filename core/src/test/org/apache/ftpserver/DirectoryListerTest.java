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

package org.apache.ftpserver;

import junit.framework.TestCase;

import org.apache.ftpserver.filesystem.NativeFileSystemView;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.usermanager.BaseUser;

public class DirectoryListerTest extends TestCase {

    private DirectoryLister directoryLister;

    private FileSystemView fileSystemView;

    protected void setUp() throws Exception {
        BaseUser baseUser = new BaseUser();
        baseUser.setHomeDirectory("/");
        fileSystemView = new NativeFileSystemView(baseUser) {

        };
        directoryLister = new DirectoryLister(fileSystemView);
    }

    /*
     * Test method for 'org.apache.ftpserver.DirectoryLister.parse(String)'
     */
    public void testParse() {
        assertEquals(true, directoryLister.parse("-ls /abcd"));
        assertEquals("/abcd", directoryLister.file);
        assertEquals(true, directoryLister.isDetailOption);
        assertEquals(false, directoryLister.isAllOption);

        assertEquals(true, directoryLister.parse("-ls /ab cd"));
        assertEquals("/ab cd", directoryLister.file);
        assertEquals(true, directoryLister.isDetailOption);
        assertEquals(false, directoryLister.isAllOption);
    }

}