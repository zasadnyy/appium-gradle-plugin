# Appium Gradle Plugin
Gradle plugin that start/stop Appium server on test task execution. Check it out on [Gralde Plugins repo](https://plugins.gradle.org/plugin/com.zasadnyy.appium).

## Features
* Automatically start and stop Appium server on each test task
* Start or stop Appium server manually
* Configure Appium server address and port

## Tasks
Plugin adds following tasks to gradle project

    Appium tasks
    ------------
    startAppiumServer - Start Appium server with provided configuration
    stopAppiumServer - Stop Appium server with provided configuration

## Usage
1. Apply appium plugin in `build.gradle`

    ```groovy
    plugins {
        id "com.zasadnyy.appium" version "1.0.1"
    }
    ```

1. Add Appium server configuration

    ```groovy
    appium {
        address "127.0.0.1"
        port 4723
        startTimeout 60000
        nodeBasePath "/usr/local/bin/node"
        appiumBasePath "/usr/local/bin/appium"
    }
    ```
1. Build. Test. Enjoy.


## Example project
Check the [demo project](https://github.com/zasadnyy/appium-gradle-plugin/tree/master/demo) folder for an example project.


## Changelog

#### v1.0.2 - March 9, 2017
  * Added server start timeout
  * Added node path config
  * Added appium path config

#### v1.0.1 - April 19, 2016
  * Added default Appium server config
  * Fixed crash on missing test task

#### v1.0.0 - April 9, 2016
  * Initial release


## License
The project is published under the [Apache 2](https://github.com/zasadnyy/appium-gradle-plugin/blob/master/LICENSE) license. Feel free to clone and modify repo as you want, but don't forget to add a reference to the author.
