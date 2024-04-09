pipeline {
    agent any
// #Performing mulitple stages for our application
    stages {
        stage("pull") {
                steps {
                    echo "pull Done"
                }
        }
        stage("Build") {
                step {
                    echo "Build Done"
                }
        }
        stage("Quality-Test") {
                step {
                    echo "Quality-check Done"
                }
        }
        stage("Deploy") {
                step {
                    echo "Deploy Done"
                }
        }
    }
}