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
                withSonarQubeEnv(credentialsId: 'yash-token',installationName: 'sonarqube') {
                 sh '''/opt/apache-maven-3.9.6/bin/mvn sonar:sonar \\
                 -Dsonar.projectKey=studentapp-ui \
                 -Dsonar.host.url=http://35.180.197.33:9000 \
                 -Dsonar.login=c8a86f15cc1d6d3497e7c6e54a16b9da6a780f0d
                }
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