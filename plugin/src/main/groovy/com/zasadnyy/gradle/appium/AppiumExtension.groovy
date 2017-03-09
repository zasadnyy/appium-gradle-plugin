/*
 * Copyright (c) 2016 Vitaliy Zasadnyy
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

package com.zasadnyy.gradle.appium

class AppiumExtension {
	String address = '0.0.0.0'
	String port = '4723'
	long startTimeout = 30000
	String nodeBasePath = "/usr/local/bin/node"
	String appiumBasePath = "/usr/local/bin/appium"

	void address(address) {
		this.address = address
	}

	void port(def port) {
		this.port = port.toString()
	}

	void startTimeout(def startTimeout){
		this.startTimeout = startTimeout
	}

	void nodeBasePath(nodeBasePath){
		this.nodeBasePath = nodeBasePath
	}

	void appiumBasePath(appiumBasePath){
		this.appiumBasePath = appiumBasePath
	}
}