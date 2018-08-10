import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.repositories

object Dependencies {
    const val minecraftApiCore = ":minecraftapi-core"

    const val launchwrapper = "net.minecraft:launchwrapper:${Versions.launchwrapper}"
    const val mixin = "org.spongepowered:mixin:${Versions.mixin}"
}

fun Project.applyStandardDependencies() {

    dependencies {
        "implementation"(kotlin("stdlib-jdk8"))

        val minecraftApiCoreProject = project(Dependencies.minecraftApiCore)

        if (project != minecraftApiCoreProject) {
            "implementation"(minecraftApiCoreProject)
        }
    }
}

fun Project.applyTweakerDependencies() {

    applyStandardDependencies()

    repositories {
        maven {
            name = "sponge"
            setUrl("http://repo.spongepowered.org/maven")
        }

        maven {
            name = "minecraft"
            setUrl("https://libraries.minecraft.net/")
        }
    }

    dependencies {
        "implementation"(Dependencies.launchwrapper) {
            isTransitive = false
        }

        // Fixes an issue with Mixin"s transitive dependencies
        "compileOnly"(Dependencies.mixin)
        "implementation"(Dependencies.mixin) {
            isTransitive = false
        }
    }
}