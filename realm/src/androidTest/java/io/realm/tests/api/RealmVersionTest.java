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


public class RealmVersionTest extends RealmSetupTests {

    //int getVersion()
    public void testGetVersion()
    {
        Realm realm = getTestRealm();
        int version = -1;
        version = realm.getVersion();

        assertTrue("Realm.version returns invalid version number " + Integer.toString(version), version > 0);
    }

    //void setVersion(int version)setVersion(int version)
    public void testSetVersion()
    {
        Realm realm = getTestRealm();
        int version = 42;
        realm.setVersion(version);

        boolean versionOk = (version == realm.getVersion());
        assertTrue("Realm.version has not been set by setVersion", versionOk);
    }


}