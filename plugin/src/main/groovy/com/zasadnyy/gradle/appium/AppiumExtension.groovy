package com.zasadnyy.gradle.appium

class AppiumExtension {
	String address = '0.0.0.0'
	String port = '4723'

	void address(address) {
		this.address = address
	}

	void port(def port) {
		this.port = port.toString()
	}
}