/*
 * Copyright 2014 Realm Inc.
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

package io.realm.tests.api;

import android.test.AndroidTestCase;

import java.io.IOException;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.SharedGroup;
import io.realm.internal.Table;
import io.realm.tests.api.entities.AllColumns;
import io.realm.tests.api.entities.AllColumnsRealmProxy;
import io.realm.tests.api.entities.Dog;
import io.realm.tests.api.entities.NoAnnotationObject;


public class RealmCommitTest extends RealmSetupTests {

    //void commit()
    public void testCommit()
    {
        Realm realm = getTestRealm();

        realm.beginWrite();

        AllColumns allColumns = null;
        allColumns = getTestObject(realm, AllColumns.class);
        allColumns.setColumnBoolean(true);
        allColumns.setColumnBinary(new byte[]{1,2,3});
        allColumns.setColumnDate(new Date());
        allColumns.setColumnDouble(3.1415);
        allColumns.setColumnFloat(1.234567f);
        allColumns.setColumnString("test data");
        allColumns.setColumnLong(45);

        realm.commit();
    }
}