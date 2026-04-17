plugins {
    alias(libs.plugins.fabric.loom)
}

base {
    archivesName.set("${archivesName.get()}")
}

dependencies {
    minecraft(libs.minecraft.get())
    implementation(libs.fabric.loader.get())
}
