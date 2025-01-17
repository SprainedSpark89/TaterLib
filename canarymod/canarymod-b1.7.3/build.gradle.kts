base {
    archivesName = "${projectId}-canarymod-${minecraftVersion}"
}

repositories {
    flatDir {
        dirs("libs")
    }
}

dependencies {
    compileOnly(":CanaryMod-b1.7.3")
	compileOnly(":jarjar-b1.7.3")
	compileOnly(":minecraft_servero-b1.7.3")
	compileOnly(":mysql-connector-java-bin-b1.7.3")
    compileOnly(project(":api"))
    compileOnly(project(":common"))
    compileOnly(project(":loader"))
    //compileOnly(project(":bukkit:bukkit-utils"))
    compileOnly(libs.modapi.metadata)
}
