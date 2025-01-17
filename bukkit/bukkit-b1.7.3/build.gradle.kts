base {
    archivesName = "${projectId}-bukkit-${minecraftVersion}"
}

repositories {
    flatDir {
        dirs("libs")
    }
}

dependencies {
    compileOnly(":uberbukkit-2.0.2")
    compileOnly(project(":api"))
    compileOnly(project(":common"))
    compileOnly(project(":loader"))
    compileOnly(project(":bukkit:bukkit-utils"))
    compileOnly(libs.modapi.metadata)
}
