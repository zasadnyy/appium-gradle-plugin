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

import com.github.genium_framework.appium.support.server.AppiumServer
import com.github.genium_framework.server.ServerArguments
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test

class AppiumPlugin implements Plugin<Project> {

	void apply(Project project) {
		addExtensions(project)
		addTasks(project)
		addTestTaskDependencies(project)
	}

	private void addExtensions(Project project) {
		project.extensions.create('appium', AppiumExtension)
	}

	private void addTasks(Project project) {
		def appiumServer = getAppiumServer(project)

		def startServerTask = project.task('startAppiumServer') {
			group 'Appium'
			description 'Start Appium server with provided configuration'
		}
		startServerTask.doLast {
			println("Starting Appium server at ${project.appium.address}:${project.appium.port}")
			appiumServer.startServer()
		}

		def stopServerTask = project.task('stopAppiumServer') {
			group 'Appium'
			description 'Stop Appium server with provided configuration'
		}
		stopServerTask.doLast {
			println("Stopping Appium server at ${project.appium.address}:${project.appium.port}")
			appiumServer.stopServer()
		}
	}

	private void addTestTaskDependencies(Project project) {
		project.tasks.matching {it instanceof Test}.all { testTask ->
			testTask.dependsOn(project.tasks['startAppiumServer'])
			testTask.finalizedBy(project.tasks['stopAppiumServer'])
		}
	}

	private AppiumServer getAppiumServer(Project project) {
		ServerArguments serverArguments = new ServerArguments()
		serverArguments.setArgument("--address", "${-> project.appium.address}")
		serverArguments.setArgument("--port", "${-> project.appium.port}");

		return new AppiumServer(new File("/usr/local/bin/node"), new File("/usr/local/bin/appium"), serverArguments)
	}
}