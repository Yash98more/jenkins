pipeline {
    agent any
// #Performing mulitple stages for our application
    stages {
        stage("Pull") {
                steps {
                    git changelog: false, poll: false, url: 'https://github.com/Yash98more/studentapp.ui'
                    echo "yes, Application repository pull is done ! "
                }
        }
        stage("Build") {
                steps {
                     sh '/opt/apache-maven-3.9.6/bin/mvn clean package'
                     echo "Build Done"
                }
        }
        stage("Test") {
			steps {
                sh '''/opt/apache-maven-3.9.6/bin/mvn sonar:sonar \\
                -Dsonar.projectKey=studentapp-ui \\
                -Dsonar.host.url=http://51.44.17.253:9000 \\
                -Dsonar.login=a86e575306b3d1ec6e04f55f47b72f574549855c'''
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