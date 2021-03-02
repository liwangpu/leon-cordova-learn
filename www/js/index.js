/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Wait for the deviceready event before using any of Cordova's device APIs.
// See https://cordova.apache.org/docs/en/latest/cordova/events/events.html#deviceready



document.addEventListener('deviceready', onDeviceReady, false);
// window.addEventListener('load', onDeviceReady, false);// 仅html测试

function onDeviceReady() {
    var btnTestToast = document.getElementById('btnTestToast');
    btnTestToast.addEventListener('click', funTestToast);

    var btnTestDial = document.getElementById('btnTestDial');
    btnTestDial.addEventListener('click', funTestDial);
}

function funTestToast() {
    cordova.plugins.ToastPlugin.show("天天开心");
}

function funTestDial() {
    var phoneNumber = document.getElementById('phoneNumberIpt').value;
    if (!phoneNumber) {
        alert('号码不能为空');
        return;
    }
    cordova.plugins.DialerPlugin.dial(phoneNumber, function () {
        //
    }, function (err) {
        alert(JSON.stringify(err));
    });
}
