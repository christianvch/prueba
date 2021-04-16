def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/jabedhasan21/java-hello-world-with-maven.git"

        stage("Compile") {
            sh "/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn/bin/mvn compile"
        }

        stage("Package") {
            sh "/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn/bin/mvn package"
        }

        stage("Install") {
            if (config.deploy) {
                sh "/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/mvn/bin/mvn install"
            }
        }

        body()
    }
}
