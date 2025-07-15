# Model Context Protocol Server for Klingon Lorem Ipsum placeholder text

This Model Context Protocol(MCP) server enables Large Language Models (LLMs) to perform to generated amount of placeholder text.
A normal "REST"-like HTTP Endpoint with OpenAPI Spec, exists as a fallback.

## General Usage

1. Install [jbang](https://www.jbang.dev/download/)

Use the following command to start the server.

```shell
mvn install
jbang de.papenhagen:placeholder:1.0.0-SNAPSHOT:runner
```

or without jbang:

```shell
mvn package
java -jar target/quarkus-app/quarkus-run.jar
```

## Troubleshooting

**jbang not found**

* Make sure you have `jbang` installed and available in your PATH
* Alternatively, use a full path to jbang executable (e.g. `/Users/username/.jbang/jbang`)

**Get more logging**

To get more detailed logging, you can add the following parameters to the jbang command line:

```shell
-Dquarkus.log.file.enable=true -Dquarkus.log.file.path=${user.home}/placeholder-quarkus.log
```

### How was this made?

The MCP server uses Quarkus, the Supersonic Subatomic Java Framework, and its Model Context Protocol support.

If you want to learn more about Quarkus MCP Server support, please see this [blog post](https://quarkus.io/blog/mcp-server/)
and the Quarkus MCP Server [extension documentation](https://docs.quarkiverse.io/quarkus-mcp-server/dev/).

To launch the server it uses [jbang](https://jbang.dev/) to setup Java and run the .jar as transparently as possible. Very similar to how `uvx`, `pipx`, `npmx` and others works; just for Java.

## OpenApi
Once your application is started in dev/test modus, you can make a request to the default [endpoint](http://localhost:8080/q/openapi)
- [OpenAPI JSON](http://localhost:8080/q/openapi?format=json)
- [OpenAPI YAML](http://localhost:8080/q/openapi)
- [Swagger UI](http://localhost:8080/q/swagger-ui)

Starting in dev modus:

```shell
./mvnw quarkus:dev
```

## OpenTelemetry
http://localhost:4317
