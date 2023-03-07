<img src="logo.svg" alt="drawing" style="width:75px;"/>

[![DevOps By Rultor.com](https://www.rultor.com/b/yegor256/rultor)](https://www.rultor.com/p/yegor256/rultor)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

[![Java CI with Maven](https://github.com/h1alexbel/weeks/actions/workflows/maven.yml/badge.svg)](https://github.com/h1alexbel/weeks/actions/workflows/maven.yml)
[![Docker](https://img.shields.io/docker/v/abialiauski/weeks/latest)](https://hub.docker.com/repository/docker/abialiauski/weeks/general)
[![codecov](https://codecov.io/github/h1alexbel/weeks/branch/master/graph/badge.svg?token=H0DGTD88KX)](https://codecov.io/github/h1alexbel/weeks)
[![PDD status](http://www.0pdd.com/svg?name=h1alexbel/weeks)](http://www.0pdd.com/p?name=h1alexbel/weeks)

[![Hits-of-Code](https://hitsofcode.com/github/h1alexbel/weeks)](https://hitsofcode.com/view/github/h1alexbel/weeks)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/h1alexbel/weeks/blob/master/LICENSE)

Weeks is a Web Service that helps to plan things counting risks.

Read [this blogpost](https://www.yegor256.com/2021/09/09/simba.html) by [@yegor256](https://github.com/yegor256) about
Simplified Management By Artifacts (SIMBA).

# Quick Start

Run this script to start these containers: Weeks-API and [PostgreSQL](https://www.postgresql.org) locally.

```shell
$ sh up.sh
```

## How to Contribute

Fork repository, make changes, send us a [pull request](https://www.yegor256.com/2014/04/15/github-guidelines.html).
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:

```bash
$ mvn clean install
```

You will need Maven 3.3+ and Java 17+.

Our [rultor image](https://github.com/eo-cqrs/eo-kafka-rultor-image) for CI/CD.