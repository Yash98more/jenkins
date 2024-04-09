pipeline {
    agent any
// #Performing mulitple stages for our application
    stages {
        stage("Pull") {
                steps {
                    echo "Pull Done"
                }
        }
        stage("Build") {
                steps {
                    echo "Build Done"
                }
        }
        stage("Test") {
			steps {
			    echo "Test Done"
			}
		}

        stage("Quality-Test") {
                steps {
                    echo "Quality-check Done"
                }
        }
        stage("Deploy") {
                steps {
                    echo "Deploy Done"
                }
        }
    }
}