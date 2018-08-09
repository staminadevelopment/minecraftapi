
import Dependencies.minecraftApiCore
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

object Dependencies {
    const val minecraftApiCore = ":minecraftapi-core"

    const val launchwrapper = "net.minecraft:launchwrapper:${Versions.launchwrapper}"
    const val mixin = "org.spongepowered:mixin:${Versions.mixin}"
}

fun Project.applyStandardDependencies() {

    dependencies {
        "implementation"(kotlin("stdlib-jdk8"))

        val minecraftApiCoreProject = project(minecraftApiCore)

        if (project != minecraftApiCoreProject) {
            "implementation"(minecraftApiCoreProject)
        }
    }
}