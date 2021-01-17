* In multiple submodules  spring project , try to build the main application module in the last. So that all other class files are available before main class module build1

- The Spring Boot main application is in the core module, which does not have a dependency on the webgateway module. Therefore the class with the controller will 	not be present at runtime and can not be discovered by spring.

-  Fix: Add dependency to the webgateway to the core or move the launcher/main class to the webgateway module.

-  You can also use a third module that does the launching and has the dependencies to core and webgateway.