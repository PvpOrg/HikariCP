/*
 * Copyright (C) 2015 Brett Wooldridge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zaxxer.hikari.proxy;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author brettw
 *
 */
public interface ConnectionState
{
   /**
    * Reset the connection to its original state.
    * @throws SQLException thrown if there is an error resetting the connection state
    */
   void resetConnectionState() throws SQLException;

   void returnPoolEntry(long lastAccess);

   int getNetworkTimeout();

   /**
    * @param networkTimeout the networkTimeout to set
    */
   void setNetworkTimeout(int networkTimeout);

   int getTransactionIsolation();

   /**
    * @param transactionIsolation the transactionIsolation to set
    */
   void setTransactionIsolation(int transactionIsolation);

   String getCatalog();

   /**
    * @param catalog the catalog to set
    */
   void setCatalog(String catalog);

   boolean isAutoCommit();

   /**
    * @param isAutoCommit the isAutoCommit to set
    */
   void setAutoCommit(boolean isAutoCommit);

   boolean isReadOnly();

   /**
    * @param isReadOnly the isReadOnly to set
    */
   void setReadOnly(boolean isReadOnly);

   String getPoolName();

   Connection getConnection();

   long getLastAccess();

   void setLastAccess(long timestamp);

   boolean isEvicted();

   void evict();
}