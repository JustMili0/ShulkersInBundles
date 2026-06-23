plugins {
	alias(libs.plugins.fabric.loom)
}

base {
	archivesName.set("${rootProject.property("archives_base_name")}-${rootProject.property("mod_version")}+mc26.2-FabricExperimental")
}

repositories {
	maven("https://maven.terraformersmc.com/") // Mod Menu
	//maven("https://maven.bawnorton.com/releases") // MixinSquared extension for MixinExtras
	//maven("https://maven.enjarai.dev/mirrors") // MixinSquared extension for MixinExtras
}

dependencies {
	minecraft(libs.minecraft.get())
	implementation(libs.fabric.loader.get())

	//implementation("com.terraformersmc:modmenu:${rootProject.property("mod_menu")}") // Mod menu
	// Don't ask, but it will be useful if you're doing heavy mixins
	//include(implementation(annotationProcessor("com.github.bawnorton.mixinsquared:mixinsquared-fabric:${libs.versions.mixinsquared.get()}")!!)!!)
}

tasks.processResources {
	filesMatching("fabric.mod.json") {
		expand(mapOf(
				"mod_id" to rootProject.property("mod_id"),
				"mod_name" to rootProject.property("mod_name"),
				"mod_version" to rootProject.property("mod_version"),
				"mod_description" to rootProject.property("mod_description"),
				"mod_authors" to rootProject.property("mod_authors"),
				"mod_license" to rootProject.property("mod_license"),
				"fabric_loader_version" to libs.versions.fabric.loader.get(),
				"minecraft_version_constraint" to rootProject.property("minecraft_version_constraint_fabric")
		))
	}
}

tasks.withType<JavaCompile>().configureEach {
	options.release = 25
}

java {
	sourceCompatibility = JavaVersion.VERSION_25
	targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
	from("LICENSE") {
		rename { "${it}" }
	}
}