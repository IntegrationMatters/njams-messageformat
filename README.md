# nJAMS Message-Format

> [!WARNING]
> **Breaking change: new Maven coordinates starting with version 6.0.0.**
> The group id changed from `com.faizsiegeln` to `com.salesfive.njams`; the artifact id `njams-messageformat` is unchanged.
> Versions up to 5.x remain available under the old coordinates only. To use 6.0.0 or later, update your dependency's `groupId`.
> The Java packages are unchanged.

This project defines the message-format used for the communication between the nJAMS server and nJAMS clients.

## Docs

* [JavaDoc](https://integrationmatters.github.io/njams-messageformat/) - The JavaDocs of the latest release.

## Using the Maven artifact

Starting with version 6.0.0, releases of the message-format are published to the public nJAMS Maven repository.

Add the repository and the dependency to your project's `pom.xml`:

```xml
<repositories>
    <repository>
        <id>njams-repository-public</id>
        <name>nJAMS Repository</name>
        <url>https://maven.njams.com/public</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.salesfive.njams</groupId>
        <artifactId>njams-messageformat</artifactId>
        <version>6.0.0</version>
    </dependency>
</dependencies>
```

Available versions are listed in the
[repository metadata](https://maven.njams.com/public/com/salesfive/njams/njams-messageformat/maven-metadata.xml).

## License

Copyright (c) 2022 Salesfive Integration Services GmbH 

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

The Software shall be used for Good, not Evil.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
IN THE SOFTWARE.
