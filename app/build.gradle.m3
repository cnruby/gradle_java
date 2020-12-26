plugins {
    id 'application'
}

dependencies {
    implementation project(':lib')
    // implementation files("${rootProject.projectDir}/libs/basic_118-0.118.1.jar")
    // implementation 'de.iotoi:basic_118:0.118.1'
    implementation files(System.getenv("HOME") + "/.m2/repository/de/iotoi/$project.libraryName/$project.version/${project.libraryName}-${project.version}.jar") 
}

application {
    mainClass = "de.iotoi.App"
}

test {}
