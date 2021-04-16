def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/jabedhasan21/java-hello-world-with-maven.git"

        stage("Compile") {
            sh "mvn compile"
        }

        stage("Package") {
            sh "mvn package"
        }

        stage("Install") {
            if (config.deploy) {
                sh "mvn install"
            }
        }

        body()
    }
}
