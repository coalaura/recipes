import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    java
}

group = "org.wiese2"
version = project.findProperty("pluginVersion") ?: "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.processResources {
    val props = mapOf("version" to project.version.toString())

    inputs.properties(props)

    filteringCharset = "UTF-8"

    filesMatching("plugin.yml") {
        filter(ReplaceTokens::class, "tokens" to props)
    }
}