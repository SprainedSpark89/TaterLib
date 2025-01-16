base {
    archivesName = "${projectId}-canarymod-${minecraftVersion}"
}

dependencies {
    compileOnly("net.canarymod:CanaryMod-b1.7.3")
	compileOnly("jar.jar:jarjar-b1.7.3")
	compileOnly("net.minecraft:minecraft_servero-b1.7.3")
	compileOnly("security.hell:mysql-connector-java-bin-b1.7.3")
    compileOnly(project(":api"))
    compileOnly(project(":common"))
    compileOnly(project(":loader"))
    //compileOnly(project(":bukkit:bukkit-utils"))
    compileOnly(libs.modapi.metadata)
}
